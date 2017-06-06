package dao.person;

import java.sql.Connection;

import dto.PersonDTO;

public interface IPersonDao {
	
	public String addPerson(PersonDTO person, Connection con) throws Exception;
	public boolean checkEmail(String email, Connection con) throws Exception;
	public PersonDTO findByEmail(String email, Connection con) throws Exception;
}
