import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.Statement;

public class Buyer extends User {

	//public Buyer(String id, String name, String password, String email) {
		//super(id,name,password,email);
	//}

	public void buy() {
		//buy a product
		String pr_id,buyer_email;
		int quantity;
		String url = "jdbc:sqlserver://LAPTOP-1GASM60P\\SQLEXPRESS;databaseName = online_shopping";
		String username = "Bishoy";
		String password = "123456789"; //sql authentication
		try {
			
			Connection connection = DriverManager.getConnection(url, username, password); 
			System.out.println("connected\n");
			String sql = "Insert into buyed_pr(pr_id, buyer_email, quantity) Values(?,?,"
			+ "?)";
			PreparedStatement stat = connection.prepareStatement(sql);
			stat.setString(1, pr_id);
			stat.setString(2, buyer_email);
			stat.setInt(3, quantity);
			int rows = stat.executeUpdate();//note that here it gets no arguments
			if (rows>0)
			{
				System.out.println(rows + " added");
			}
			connection.close();
		}catch(Exception e) {System.out.println(e);}
	}
	
}