import java.sql.*;   
public class JDBCTest {   
	String driver = "com.mysql.jdbc.Driver";
	String url = "jdbc:mysql://127.0.0.1:3306/car_registration";
	// MySQL����ʱ���û���
	String user = "root";
	// Java����MySQL����ʱ������
	String password = "root";
	Object[][] manager = new Object[100][4];
	Connection conn;
	
public void connect() throws SQLException{
	conn = DriverManager.getConnection(url, user, password);
	//return conn;
	}
	
public Object[][] getObject(){  

try {

// ������������

Class.forName(driver);

// �������ݿ�


if(!conn.isClosed())

System.out.println("Succeeded connecting to the Database!");

// statement����ִ��SQL���

Statement statement = conn.createStatement();

// Ҫִ�е�SQL���

String sql = "select * from car_list";
ResultSet rs = statement.executeQuery(sql);  
int i =0;
while(rs.next()) {  
manager[i][0]=rs.getString("type");
manager[i][1]=rs.getString("time");
manager[i][2]=rs.getString("number");
manager[i][3]=rs.getString("status");
i++;

}  
rs.close();  
conn.close();   
} catch(ClassNotFoundException e) {   
System.out.println("Sorry,can`t find the Driver!");   
e.printStackTrace();   
} catch(SQLException e) {   
e.printStackTrace();   
} catch(Exception e) {   
e.printStackTrace();   
}   
	return manager;
	}   

public void save(String type,String number,String status){

	try {

	// ������������

	Class.forName(driver);

	// �������ݿ�

	if(!conn.isClosed())

	System.out.println("Succeeded connecting to the Database!");

	// statement����ִ��SQL���

	Statement statement = conn.createStatement();

	// Ҫִ�е�SQL���

	String sql = "insert into car_list values('" + type+"',NULL,'" + number+"','" + status+"')";
	try {   
		statement = conn.createStatement();   
} catch (SQLException e) {   
        e.printStackTrace();   
}   
//4��ִ�����   
try {   
	statement.executeUpdate(sql);   
} catch (SQLException e) {   
        e.printStackTrace();   
}   
//5���رղ����������෴
try {   
	statement.close();   
} catch (SQLException e) {   
        e.printStackTrace();   
}   

	conn.close();   
	} catch(ClassNotFoundException e) {   
	System.out.println("Sorry,can`t find the Driver!");   
	e.printStackTrace();   
	} catch(SQLException e) {   
	e.printStackTrace();   
	} catch(Exception e) {   
	e.printStackTrace();   
	}   

	
}
//public void update(){}

}  