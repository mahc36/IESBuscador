package rest;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import bussiness.person.IPersonBussiness;
import bussiness.person.impl.PersonBussiness;
import dto.PersonDTO;

@Path("/personServices")
public class PersonService {
	
	private IPersonBussiness personBussiness;
	
	public PersonService(){
		personBussiness = new PersonBussiness();
	}
	
	@PUT
	@Path("/addPerson")
	@Consumes (MediaType.APPLICATION_JSON)
	@Produces (MediaType.TEXT_PLAIN)
	public String addPerson(PersonDTO person){
		return personBussiness.addPerson(person);
	}
	
	@GET
	@Path("/findByEmail/{email}")
	@Produces(MediaType.APPLICATION_JSON)
	public PersonDTO findByEmail(@PathParam("email") String email) {
		return personBussiness.findByEmail(email);
	}
}
