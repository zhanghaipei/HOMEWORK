import java.sql.*;   
public class JDBCTest {   
	String driver = "com.mysql.jdbc.Driver";
	String url = "jdbc:mysql://127.0.0.1:3306/car_registration";
	// MySQL配置时的用户名
	String user = "root";
	// Java连接MySQL配置时的密码
	String password = "root";
	Object[][] manager = new Object[100][4];
	Connection conn;
	
public void connect() throws SQLException{
	conn = DriverManager.getConnection(url, user, password);
	//return conn;
	}
	
public Object[][] getObject(){  

try {

// 加载驱动程序

Class.forName(driver);

// 连续数据库


if(!conn.isClosed())

System.out.println("Succeeded connecting to the Database!");

// statement用来执行SQL语句

Statement statement = conn.createStatement();

// 要执行的SQL语句

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

	// 加载驱动程序

	Class.forName(driver);

	// 连续数据库

	if(!conn.isClosed())

	System.out.println("Succeeded connecting to the Database!");

	// statement用来执行SQL语句

	Statement statement = conn.createStatement();

	// 要执行的SQL语句

	String sql = "insert into car_list values('" + type+"',NULL,'" + number+"','" + status+"')";
	try {   
		statement = conn.createStatement();   
} catch (SQLException e) {   
        e.printStackTrace();   
}   
//4、执行语句   
try {   
	statement.executeUpdate(sql);   
} catch (SQLException e) {   
        e.printStackTrace();   
}   
//5、关闭操作，步骤相反
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