package dao.person.jdbc;

public class PersonSql {
	private static final String TABLE_NAME="person";
	public static final String INSERT="INSERT INTO "+TABLE_NAME+" ( per_id, per_name, per_email, per_password)  VALUES (?, ?, ?, ?)";

}
