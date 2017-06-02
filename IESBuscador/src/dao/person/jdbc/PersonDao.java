package dao.person.jdbc;

import java.sql.Connection;
import java.sql.PreparedStatement;

import dao.person.IPersonDao;
import dao.secuencia.ISecuenciaDao;
import dao.secuencia.jdbc.SecuenciaDao;
import dto.PersonDTO;
import util.PersistUtil;

public class PersonDao implements IPersonDao {

	@Override
	public String addPerson(PersonDTO person, Connection con) throws Exception {
		String message ="";
		String query;
        PreparedStatement instruction = null;
        try {
        	query = PersonSql.INSERT;	
        	instruction = con.prepareStatement(query);
        	int index = 1;
        	ISecuenciaDao secuenciaDao = new SecuenciaDao();
        	int id = secuenciaDao.getConsecutive("personSequence", con);
        	person.setId(id);
        	instruction.setInt(index++, person.getId());
        	instruction.setString(index++, person.getName());
        	instruction.setString(index++, person.getEmail());
        	instruction.setString(index++, person.getPassword());
        	instruction.executeUpdate();
        	message="OK";
		} catch (Exception sql) {
			message ="ERROR";
        	con.rollback();
            throw new Exception(sql.toString());
		}
        finally {
            PersistUtil.closeResources(instruction);
         } 
        return message;
	}
}
