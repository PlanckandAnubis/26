package Student;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class Link extends Test {
	Connection connection = null;
	public Link() throws SQLException {
		try {
			Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
		} catch (ClassNotFoundException e1) {
			System.out.println(e1.getMessage());
		}
		// ��������DriverManager��ͼ����ע���JDBC����������ѡ��һ���ʵ�����������
		// sqlserver ���ݿ� url
		String urlSqlServer = "jdbc:sqlserver://localhost:1433;integratedSecurity=true;DatabaseName=Student";
		// sqlserver ���ݿ�
		@SuppressWarnings("unused")
		Connection connection = null;
		try {
			connection = DriverManager.getConnection(urlSqlServer, "sa", "wu123456");
		} catch (SQLException e) {
			System.out.println(e.getMessage());
		}
		System.out.println("sqlserver ���ݿ��������سɹ�");
	

		

	}
	public String insert(String ID) throws SQLException {
		String val1 = null;
		Statement stmt = connection.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
		ResultSet rsst = stmt.executeQuery("select * from Student where ѧ��='ID'"); // lect����*��ʾ�����ֶΣ�Ҳ����ָ��������ֶ�
		while (rsst.next()) {
			val1 = rsst.getString(1);
			System.out.println(val1);
		}
		rsst.close();
		stmt.close();
		return val1;
	}
}

