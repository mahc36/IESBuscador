package dao.ies.jdbc;

public class IesSql {
	private static final String TABLE_NAME="ies";
	public static final String GET_LIST_IES= "SELECT ies_id, ies_name, ies_slogan, ies_escudo FROM "+TABLE_NAME;
	public static final String GET_LIST_BY_FILTER="SELECT * from "+ TABLE_NAME +" where (select campus.ies_id from campus)=ies_id and (select campus.cam_city from campus)=? and ies_caracter=? and ies_accreditation=?";
	public static final String GET_LIST_BY_NAME = "SELECT * FROM "+ TABLE_NAME +" WHERE ies_name=?";
	public static final String GET_IES_INFO = "SELECT ies_id, ies_name, ies_slogan, ies_escudo FROM "+TABLE_NAME+" WHERE ies_id=?";
	public IesSql(){
		super();
	}
}
