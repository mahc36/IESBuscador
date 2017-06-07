package dao.program.jdbc;

public class ProgramSql {
	private static final String TABLE_NAME = "program";
	private static final String TABLE2_NAME = "campus";
	private static final String TABLE3_NAME = "ies";
	public static final String FILTER = "select * from ("
					+TABLE_NAME +" join "+ TABLE2_NAME +" on "+ TABLE_NAME +".cam_id = "+ TABLE2_NAME +".cam_id) as pc "
					+ " join "+ TABLE3_NAME +" on pc.ies_id = "+ TABLE3_NAME +".ies_id";
	
	public ProgramSql(){
		super();
	}
}
