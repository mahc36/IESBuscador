package dao.secuencia.jdbc;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import dao.secuencia.ISecuenciaDao;
import util.PersistUtil;

public class SecuenciaDao implements ISecuenciaDao {

	@Override
	public Integer getConsecutive(String nameOfSequence, Connection con) throws Exception {
		Integer consecutivo = 0;
        String query;
        PreparedStatement instruccion = null;
        ResultSet resultado = null;
        try {
            query = "SELECT nextval('"+nameOfSequence+"')";
            instruccion = con.prepareStatement(query);
            resultado = instruccion.executeQuery();
            while (resultado.next()) {
               consecutivo = resultado.getInt("nextval");
            }
        } finally {
            PersistUtil.closeResources(instruccion);
        }
        return consecutivo;
	}

}
