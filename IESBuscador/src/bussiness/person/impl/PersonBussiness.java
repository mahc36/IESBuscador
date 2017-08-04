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

	@Override
	public boolean checkEmail(String email) {
		Connection con = null;
		boolean result = false;
		try {
			con = dataSource.getConnection();
			result=personDAO.checkEmail(email, con);
		} catch (Exception e) {
			System.out.println(e.toString());
		} finally {
			PersistUtil.closeConnection(con);
		}
		return result;
	}

	@Override
	public PersonDTO findByEmail(String email) {
		Connection con = null;
		PersonDTO personResult = new PersonDTO();
		try {
			con=dataSource.getConnection();
			personResult = personDAO.findByEmail(email,con);
		} catch (Exception e) {
			System.out.println(e.toString());
		}
		finally {
			PersistUtil.closeConnection(con);
		}
		return personResult;
	}
	
	
}
