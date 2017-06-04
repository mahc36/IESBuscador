package bussiness.person;

import dto.PersonDTO;

public interface IPersonBussiness {
	
	public String addPerson(PersonDTO person); 
	public boolean checkEmail(String email);

}
