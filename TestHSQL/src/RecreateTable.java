import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class RecreateTable
 */
public class RecreateTable extends HttpServlet {
	private static final long serialVersionUID = 1L;

	Connection con;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public RecreateTable() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException,
			IOException {

		try {
			Class.forName("org.hsqldb.jdbc.JDBCDriver");
		} catch (ClassNotFoundException e) {
			e.printStackTrace(System.out);
		}
		try {
			con = DriverManager.getConnection("jdbc:hsqldb:mydatabase", "SA", "");

			con.createStatement().executeUpdate("drop table contacts if exists");
			con.createStatement().executeUpdate(
					"create table contacts (name varchar(45),email varchar(45),phone varchar(45))");
		} catch (SQLException e) {
			e.printStackTrace(System.out);
		}

		System.out.println("********* Done creating table contacts ********");

	}

}
