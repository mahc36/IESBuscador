package dao.ies;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

import dto.Filter;
import dto.IesDTO;

public interface IIesDao {

	List<Filter> getIes(Connection con)throws Exception;	

	List<Filter> findIES(Connection con, String name) throws Exception;

	IesDTO getInfo(Connection con, int iesid) throws Exception;

}
