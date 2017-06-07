package bussiness.ies.impl;
import java.sql.Connection;
import java.util.ArrayList;
import java.util.List;

import javax.sql.DataSource;
import bussiness.ies.IIesBussiness;
import dao.ies.IIesDao;
import dao.ies.jdbc.IesDao;
import dto.Filter;
import dto.IesDTO;
import util.PersistUtil;

public class IesBussiness implements IIesBussiness {
	private IIesDao iesdao;
	private DataSource datasource;
	public IesBussiness() {
		datasource=PersistUtil.getDataSource();
		iesdao=new IesDao();
	}

	@Override
	public List<Filter> getIes() {
		Connection con =null;
		List<Filter> message= new ArrayList<>();
		try{
			con= datasource.getConnection();
			message= iesdao.getIes(con);
		}catch (Exception e){
			System.out.println(e.toString());
		}finally {
			PersistUtil.closeConnection(con);
		}
		return message;
	}

	@Override
	public List<IesDTO> getIesbyFilter(Filter filter) {
		Connection con =null;
		List<IesDTO> message= new ArrayList<>();
		try{
			con= datasource.getConnection();
			message= iesdao.getIesbyFilter(con,filter);
		}catch (Exception e){
			System.out.println(e.toString());
		}finally {
			PersistUtil.closeConnection(con);
		}
		return message;
	}

	@Override
	public List<IesDTO> findIES(String name) {
		Connection con =null;
		List<IesDTO> message= new ArrayList<>();
		try{
			con= datasource.getConnection();
			message= iesdao.findIES(con,name);
		}catch (Exception e){
			System.out.println(e.toString());
		}finally {
			PersistUtil.closeConnection(con);
		}
		return message;
	}

	@Override
	public IesDTO getInfo(int iesid) {
		Connection con =null;
		IesDTO message= new IesDTO();
		try{
			con= datasource.getConnection();
			message= iesdao.getInfo(con,iesid);
		}catch (Exception e){
			System.out.println(e.toString());
		}finally {
			PersistUtil.closeConnection(con);
		}
		return message;		
	}

}
