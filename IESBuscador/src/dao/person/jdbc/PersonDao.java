package dao.person.jdbc;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import bussiness.person.IPersonBussiness;
import bussiness.person.impl.PersonBussiness;
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
        IPersonBussiness personBussiness = new PersonBussiness();
        if (!personBussiness.checkEmail(person.getEmail())){
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
        }
        else{
        	message = "EMAILERROR";
        }
        return message;
	}

	@Override
	public boolean checkEmail(String email, Connection con) throws Exception {
		boolean result = false;
		String query;
		ResultSet resultset = null;
        PreparedStatement instruction = null;
        try {
        	query = PersonSql.CHECKEMAIL;
        	instruction = con.prepareStatement(query);
        	int index = 1;
        	instruction.setString(index, email);
        	resultset =instruction.executeQuery();
			if(resultset.next()) {
				result =true;
			}
		} catch (Exception sql) {
        	con.rollback();
            throw new Exception(sql.toString());
		}
        finally {
            PersistUtil.closeResources(instruction);
         } 
        return result;
	}
}
