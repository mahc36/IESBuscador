package dao.ies.jdbc;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import dao.ies.IIesDao;
import dto.Filter;
import dto.IesDTO;
import util.PersistUtil;

public class IesDao implements IIesDao {
	private void setInfoIes(ResultSet result, Filter filter) throws Exception {
		filter.setId(result.getInt("ies_id"));
		filter.setName(result.getString("ies_name"));
		filter.setSlogan(result.getString("ies_slogan"));
		filter.setEscudo(result.getString("ies_escudo"));
		filter.setAccreditation(result.getBoolean("ies_accreditation"));
		filter.setCaracter(result.getString("ies_caracter"));
		filter.setCity(result.getString("cam_city"));
	}
	@Override
	public List<Filter> getIes(Connection con) throws Exception {
		PreparedStatement instruction=null;
		ResultSet result=null;
		String query;
		Filter filter = null;
		List<Filter> listOfIes=new ArrayList<>();
		try{
			query= IesSql.GET_LIST_IES;
			instruction=con.prepareStatement(query);
			result=instruction.executeQuery();
			while(result.next()){
				filter = new Filter();
				setInfoIes(result, filter);
				listOfIes.add(filter);
			}
		}finally{
			PersistUtil.closeResources(instruction, result);
		}
		return listOfIes;
	}

	@Override
	public List<Filter> findIES(Connection con, String name) throws Exception {
		PreparedStatement instruction = null;
		ResultSet result = null;
		String query;
		Filter ies= null;
		List<Filter> listOfIes=new ArrayList<>();
		try {
			query = IesSql.GET_LIST_BY_NAME;
			instruction = con.prepareStatement(query);
			int index = 1;
			instruction.setString(index++, name);			
			result = instruction.executeQuery();
			while (result.next()) {
				ies = new Filter();
				setInfoIes(result, ies);
				listOfIes.add(ies);
			}
		} finally {
			PersistUtil.closeResources(instruction, result);
		}
		return listOfIes;		
	}
	@Override
	public IesDTO getInfo(Connection con,int iesid) throws Exception { 
		PreparedStatement instruction=null;
		ResultSet result=null;
		String query;
		IesDTO iesDTO= null;		
//		try{
//			query= IesSql.GET_IES_INFO;
//			instruction=con.prepareStatement(query);
//			int index = 1;
//			instruction.setInt(index++,iesid);
//			result=instruction.executeQuery();
//			while(result.next()){
//				iesDTO=new IesDTO();
//				setInfoIes(result, iesDTO);				
//			}
//		}finally{
//			PersistUtil.closeResources(instruction, result);
//		}
		return iesDTO;
	}
}
