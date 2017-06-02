package util;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.SimpleTimeZone;

import javax.naming.InitialContext;
import javax.sql.DataSource;

import com.sun.media.sound.SimpleSoundbank;

public class PersistUtil {
	
	
	private static DataSource dataSource;
	
	public static DataSource getDataSource(){  	
    	try {
			InitialContext ic = new InitialContext();
			System.out.println("Ya casi va a conectar");
			dataSource = (DataSource) ic.lookup("java:/IESBuscador");
			System.out.println("Acá debió haber conectado");
		} catch (Exception e) {
			e.toString();
		}
    	return dataSource;	
    }

	public static void closeConnection(Connection con) {
		try {
			con.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
	}

	public static void closeResources(PreparedStatement instruccion, ResultSet resultado) throws Exception{
		instruccion.close();
		resultado.close();
		
	}

	public static void closeResources(PreparedStatement instruccion) throws Exception {
		instruccion.close();
	}

}
