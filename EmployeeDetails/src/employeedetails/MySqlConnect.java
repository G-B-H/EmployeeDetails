package employeedetails;

import java.sql.*;
import java.util.ArrayList;

public class MySqlConnect 
{
    public static boolean connectDB()
    {
        Connection conn = null;
        java.sql.Statement stmt = null;
	try
        {
	    System.out.println("Connection to the database...");
  
	    conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/emp?"
                + "useUnicode=true&useJDBCCompliantTimezoneShift="
                + "true&useLegacyDatetimeCode="
                + "false&serverTimezone=UTC","root","");
            System.out.println("Creating statement...");
            stmt = conn.createStatement();
            System.out.println("Connection Succes");
              
	    stmt.close();
	    conn.close();
            return true;	    
	}
        catch(SQLException se)
        {
	    return false;
	}
    }
    
    public static boolean connectlogin(String username, String password) throws SQLException
    {
        Connection conn = null;
        java.sql.Statement stmt = null;
  
	conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/emp?"
        + "useUnicode=true&useJDBCCompliantTimezoneShift="
        + "true&useLegacyDatetimeCode="
        + "false&serverTimezone=UTC","root","");
        stmt = conn.createStatement();

        String sql;
	sql = "SELECT * FROM login WHERE Login='"+username+"' and Password= '"+password+"'";
              
	ResultSet rs = stmt.executeQuery(sql);

	if(rs.next())
        {
            System.out.println("Login Succes");
            rs.close();
            stmt.close();
            conn.close();
	    return true;
	}
        else
        {
            System.out.println("Login Failed");
            rs.close();
            stmt.close();
            conn.close();
            return false;
        }
    }
    
    public static int create(Employee emp) throws SQLException
    {
        Connection conn = null;
        int id =0;
  
	conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/emp?"
        + "useUnicode=true&useJDBCCompliantTimezoneShift="
        + "true&useLegacyDatetimeCode="
        + "false&serverTimezone=UTC","root","");
        
        PreparedStatement stmt = conn.prepareStatement("INSERT INTO `employee` (`EmployeeID`, `Name`,"
        +"`Gender`, `Age`, `BloodGroup`, `ContactNbr`, `Qualification`, `DOJ`, `Address`, `PathImg`) "
        +"VALUES (NULL, ?, ?, ?, ?, ?, ?, ?, ?, ?)", Statement.RETURN_GENERATED_KEYS);
        stmt.setString(1, emp.employeeName);
        stmt.setString(2, emp.employeeGender);
        stmt.setInt(3, emp.employeeAge);
        stmt.setString(4, emp.employeeBloodGroup);
        stmt.setString(5, emp.employeeContactNbr);
        stmt.setString(6, emp.employeeQualification);
        stmt.setString(7, emp.employeeDOJ);
        stmt.setString(8, emp.employeeAddress);
        stmt.setString(9, emp.employeePicturesPath);
        stmt.executeUpdate();
        
        ResultSet rs=stmt.getGeneratedKeys();
        
        if(rs.next())
        {
            id =-1;
            id=rs.getInt(1);
            System.out.println("Add Succes");
            stmt.close();
            conn.close();
	    return id;
	}
        else
        {
            System.out.println("Add Failed");
            stmt.close();
            conn.close();
            return id;
        }
    }
    
    public static Employee read(int id) throws SQLException
    {
        Connection conn = null;
	java.sql.Statement stmt = null;
     
        conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/emp?"
        + "useUnicode=true&useJDBCCompliantTimezoneShift="
        + "true&useLegacyDatetimeCode="
        + "false&serverTimezone=UTC","root","");
        
	stmt = conn.createStatement();
	String sql = "SELECT * FROM Employee WHERE EmployeeID = "+id;
        ResultSet rs = stmt.executeQuery(sql);
        
        Employee emp = new Employee();
        while(rs.next())
        {
            emp.employeeID = rs.getInt("EmployeeID");
            emp.employeeName = rs.getString("Name");
            emp.employeeGender = rs.getString("Gender");
            emp.employeeAge = rs.getInt("Age");
            emp.employeeBloodGroup = rs.getString("BloodGroup");
            emp.employeeContactNbr = rs.getString("ContactNbr");
            emp.employeeQualification = rs.getString("Qualification");
            emp.employeeDOJ = rs.getString("DOJ");
            emp.employeeAddress = rs.getString("Address");
            emp.employeePicturesPath = rs.getString("PathImg");
        }
        
        rs.close();
	stmt.close();
	conn.close();
        
        return emp;
    }
    
    public static ArrayList<Employee> readAll() throws SQLException
    {
        Connection conn = null;
	java.sql.Statement stmt = null;
     
        conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/emp?"
        + "useUnicode=true&useJDBCCompliantTimezoneShift="
        + "true&useLegacyDatetimeCode="
        + "false&serverTimezone=UTC","root","");
        
	stmt = conn.createStatement();
	String sql = "SELECT * FROM Employee";
        ResultSet rs = stmt.executeQuery(sql);
        ArrayList<Employee> Employees =  new ArrayList<Employee>();
        
        while(rs.next())
        {
            Employee emp = new Employee();
            emp.employeeID = rs.getInt("EmployeeID");
            emp.employeeName = rs.getString("Name");
            emp.employeeGender = rs.getString("Gender");
            emp.employeeAge = rs.getInt("Age");
            emp.employeeBloodGroup = rs.getString("BloodGroup");
            emp.employeeContactNbr = rs.getString("ContactNbr");
            emp.employeeQualification = rs.getString("Qualification");
            emp.employeeDOJ = rs.getString("DOJ");
            emp.employeeAddress = rs.getString("Address");
            emp.employeePicturesPath = rs.getString("PathImg");
            Employees.add(emp);
        }
        
        return Employees;
    }
    
    public static boolean update(Employee emp) throws SQLException
    {
        Connection conn = null;
	java.sql.Statement stmt = null;
            
        conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/emp?"
        + "useUnicode=true&useJDBCCompliantTimezoneShift="
        + "true&useLegacyDatetimeCode="
        + "false&serverTimezone=UTC","root","");
        
	stmt = conn.createStatement();
	String sql = "UPDATE `Employee` SET `Name`='"+emp.employeeName+"',`Gender`='"+emp.employeeGender+"',"
        +"`Age`='"+emp.employeeAge+"',`BloodGroup`='"+emp.employeeBloodGroup+"',`ContactNbr`='"+emp.employeeContactNbr+"',"
        +"`Qualification`='"+emp.employeeQualification+"',`DOJ`='"+emp.employeeDOJ+"',`Address`='"+emp.employeeAddress+"',"
        +"`PathImg`='"+emp.employeeName+"'WHERE EmployeeID ="+emp.employeeID;
        int rs = stmt.executeUpdate(sql);
        
        if(rs != 0)
        {
            System.out.println("Update Succes");
            stmt.close();
            conn.close();
	    return true;
	}
        else
        {
            System.out.println("Update Failed");
            stmt.close();
            conn.close();
            return false;
        }
    }
    
    public static boolean delete(Employee emp) throws SQLException
    {
        //Supprime employe
        //return True sa ça à fonctionné
        //else return false
        Connection conn = null;
	java.sql.Statement stmt = null;
              
        conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/emp?"
        + "useUnicode=true&useJDBCCompliantTimezoneShift="
        + "true&useLegacyDatetimeCode="
        + "false&serverTimezone=UTC","root","");
        
	stmt = conn.createStatement();
        String sql = "DELETE FROM `employee` WHERE `EmployeeID` = "+emp.employeeID;
        
        int rs = stmt.executeUpdate(sql);
        
        if(rs != 0)
        {
            System.out.println("Delete Succes");
            stmt.close();
            conn.close();
	    return true;
	}
        else
        {
            System.out.println("Delete Failed");
            stmt.close();
            conn.close();
            return false;
        }
    }
}
