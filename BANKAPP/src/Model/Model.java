package Model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class Model 
{
	String name=null;
	String accountno=null;
	String balance=null;
	String customerid=null;
	String password=null;
	String emailid=null;
	
	String url="jdbc:oracle:thin:@//localhost:1521/XE";
	String uname="SYSTEM";
	String pwd="system";
	Connection con=null;
	PreparedStatement pstmt=null;
	ResultSet res=null;
		
		
		public Model()
		{
			try 
			{
				Class.forName("oracle.jdbc.driver.OracleDriver");
				con=DriverManager.getConnection(url, uname, pwd);
			} 
			catch (Exception e) 
			{
				System.out.println("Loaded and Connected ");
			}
		}
		
		
		public boolean getLogin()
		{
			try 
			{
				pstmt=con.prepareStatement("SELECT * FROM BANKAPP WHERE CUSTOMERID=? AND PASSWORD=?");
				pstmt.setString(1,customerid);
				pstmt.setString(2,password);
				res=pstmt.executeQuery();
				System.out.println("querry executed");
				
				if(res.next()==false)
				{
					
					return false;
					
				}
				else
				{
					accountno=res.getString(2);
					return true;
				}
			} 
			catch (SQLException e) 
			{
				System.out.println("if part not executed");
			}
			return false;
		}
		
		
		public boolean Balance()
		{
			try 
			{
				pstmt=con.prepareStatement("SELECT * FROM BANKAPP WHERE ACCOUNTNO=?");
				pstmt.setString(1,accountno);
			
				res=pstmt.executeQuery();
				System.out.println("querry executed");
				
				if(res.next()==false)
				{
					
					return false;
					
				}
				else
				{
					balance=res.getString(3);
					return true;
				}
			} 
			catch (SQLException e) 
			{
				System.out.println("if part not executed");
			}
			return false;
		}
		
		public boolean chPaswword()
		{
			try 
			{
				pstmt=con.prepareStatement("UPDATE BANKAPP SET PASSWORD=? WHERE ACCOUNTNO=?");
				pstmt.setString(1,password);
				pstmt.setString(2,accountno);
			
				int num=pstmt.executeUpdate();
				System.out.println("querry executed");
				
				if(num==0)
				{
					
					return false;
					
				}
				else
				{
					return true;
				}
			} 
			catch (SQLException e) 
			{
				System.out.println("if part not executed");
			}
			return false;
			
		}
		
		public void setRes(ResultSet res) {
			this.res = res;
		}
		public String geRes() {
			return name;
		}
		
		

		public void setName(String name) {
			this.name = name;
		}
		

		public void setAccountno(String accountno) {
			this.accountno = accountno;
		}


		public void setBalance(String balance) {
			this.balance = balance;
		}


		public void setCustomerid(String customerid) {
			this.customerid = customerid;
		}


		public void setPassword(String password) {
			this.password = password;
		}


		public void setEmailid(String emailid) {
			this.emailid = emailid;
		}
		

		public String getName() {
			return name;
		}


		public String getAccountno() {
			return accountno;
		}


		public String getBalance() {
			return balance;
		}


		public String getCustomerid() {
			return customerid;
		}


		public String getPassword() {
			return password;
		}


		public String getEmailid() {
			return emailid;
		}



		


		

}
