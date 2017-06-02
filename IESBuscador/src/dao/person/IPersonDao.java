package dao.person;

import java.sql.Connection;

import dto.PersonDTO;

public interface IPersonDao {
	
	public String addPerson(PersonDTO person, Connection con) throws Exception;

}
