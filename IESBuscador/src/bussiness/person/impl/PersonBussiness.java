package bussiness.person.impl;
import java.sql.Connection;

import javax.sql.DataSource;

import bussiness.person.IPersonBussiness;
import dao.person.IPersonDao;
import dao.person.jdbc.PersonDao;
import dto.PersonDTO;
import util.PersistUtil;

public class PersonBussiness implements IPersonBussiness {
	
	private IPersonDao personDAO;
	private DataSource dataSource;
	
	public PersonBussiness(){
		dataSource = PersistUtil.getDataSource();
		personDAO = new PersonDao();
	}
	
	@Override
	public String addPerson(PersonDTO person) {
		Connection con = null;
		String message="";
		try {
			con = dataSource.getConnection();
			message = personDAO.addPerson(person, con);
		} catch (Exception e) {
			System.out.println(e.toString());
		} finally {
			PersistUtil.closeConnection(con);
		}
		return message;
	}
}
