import java.sql.SQLException;


public class client {
	
    public static void main(String args[]) throws SQLException{  
    	Registration registration = new Registration();  
    	registration.reader.connect();
    	registration.go();  
    } 

}
