package SchoolDairy;

import java.sql.SQLException;

public class Launch {

	public static void main(String[] args) throws SQLException, ClassNotFoundException {
		
		WorkDB.connect();
		WorkDB.CreateUserList();
		WorkDB.AddUser();
	}
}
