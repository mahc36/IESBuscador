package dao.ies.jdbc;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
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
	public List<IesDTO> getIesbyFilter(Connection con,Filter filter) throws Exception {
		PreparedStatement instruction = null;
		ResultSet result = null;
		String query;
		IesDTO iesDTO= null;
		List<IesDTO> listOfIes=new ArrayList<>();
//		try {
//			query = IesSql.GET_LIST_BY_FILTER;
//			instruction = con.prepareStatement(query);
//			int index = 1;
//			instruction.setString(index++, filter.getCity());
//			String caracter="";
//			if(filter.isPubl())
//				caracter="publica";
//			else
//				caracter="privada";
//			instruction.setString(index++,caracter);
//			instruction.setBoolean(index++, filter.isAcred());
//			result = instruction.executeQuery();
//			while (result.next()) {
//				iesDTO = new IesDTO();
//				setInfoIes(result, iesDTO);
//				listOfIes.add(iesDTO);
//			}
//		} finally {
//			PersistUtil.closeResources(instruction, result);
//		}
		return listOfIes;
	}
	@Override
	public List<IesDTO> findIES(Connection con, String name) throws Exception {
		PreparedStatement instruction = null;
		ResultSet result = null;
		String query;
		IesDTO iesDTO= null;
		List<IesDTO> listOfIes=new ArrayList<>();
//		try {
//			query = IesSql.GET_LIST_BY_NAME;
//			instruction = con.prepareStatement(query);
//			int index = 1;
//			instruction.setString(index++, name);			
//			result = instruction.executeQuery();
//			while (result.next()) {
//				iesDTO = new IesDTO();
//				setInfoIes(result, iesDTO);
//				listOfIes.add(iesDTO);
//			}
//		} finally {
//			PersistUtil.closeResources(instruction, result);
//		}
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
