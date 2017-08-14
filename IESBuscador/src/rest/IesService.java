package rest;
import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import bussiness.ies.IIesBussiness;
import bussiness.ies.impl.IesBussiness;
import dto.Filter;
import dto.IesDTO;

@Path("/iesServices")
public class IesService {
	private IIesBussiness iesbussiness;
	public IesService(){
		iesbussiness=new IesBussiness();
	}
	@GET
	@Path("/getIES")
	@Produces(MediaType.APPLICATION_JSON)
	public List<Filter> listIes(){
		return iesbussiness.getIes();
	}
	@GET
	@Path("/findIES/{nameSearch}")
	@Consumes(MediaType.TEXT_PLAIN)
	@Produces(MediaType.APPLICATION_JSON)
	public List<Filter> finIES(@PathParam("nameSearch") String nameSearch ){
		return iesbussiness.findIES(nameSearch);
	}
	@GET
	@Path("/getInfo/{iesid}")
	@Consumes(MediaType.TEXT_PLAIN)
	@Produces(MediaType.APPLICATION_JSON)
	public IesDTO getInfo(@PathParam("iesid") String iesid ){
		int iesId=Integer.parseInt(iesid);
		return iesbussiness.getInfo(iesId);
	}
}
