package dao.secuencia;

import java.sql.Connection;

public interface ISecuenciaDao {
	
	public Integer getConsecutive(String nameOfSequence,Connection con) throws Exception;
	
}
