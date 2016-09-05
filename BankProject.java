//insertion in table
 import java.sql.*;
import java.io.*;

class Combined
  {
       int c1=2004;
    void InsertEmployee()
      {
         BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
         Connection con=null; 
         PreparedStatement pmt=null;
          String query=null;

   try
     {
  	 Class.forName("sun.jdbc.odbc.JdbcOdbcDriver");
   	con=DriverManager.getConnection("Jdbc:Odbc:customerdsn","root","root");
  	query="insert into customerdb values(?,?,?,?,?)";
    	pmt=con.prepareStatement(query);
        
        int Acc_no=c1++;
  	int en=Integer.parseInt(System.console().readLine("PIN No. ="));
   	String name=System.console().readLine("CUSTOMER NAME =");
	int s=Integer.parseInt(System.console().readLine("ACCOUNT BALANCE ="));
  	String c=System.console().readLine("PASSWORD =");
        
  	//setting values to placeholders
      
	pmt.setInt(1,en);
      	pmt.setString(2,name);
       	pmt.setInt(3,s);
        pmt.setString(4,c);
      	pmt.setInt(5,c1);
     
   
               //execute query
  
   	int r=pmt.executeUpdate();
 	 if(r>0)
   		System.out.println("RECORD INSERTED SUCCESSFULLY");
  	 else
  		System.out.println("ERROR IN INSERTION!!!");
 	 }
   catch(ClassNotFoundException ce)
 	 {
 		  ce.printStackTrace();
 	 }

  catch(SQLException se)
  	{
   		se.printStackTrace();
	  }
   }


 void Deleteaccount()
{
          BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
          Connection con=null;
         PreparedStatement pmt=null;
        String query=null;

try
 {
   Class.forName("sun.jdbc.odbc.JdbcOdbcDriver");
   con=DriverManager.getConnection("Jdbc:Odbc:customerdsn","root","root");
 
    query= "delete from customerdb where pin=? and password=?";   
    pmt=con.prepareStatement(query);
 
    int en=Integer.parseInt(System.console().readLine("TO DELETE CUSTOMER ACCOUNT, ENTER PIN No. ="));
    String p=System.console().readLine("PASSWORD =");

 	//setting values to placeholders
      pmt.setInt(1,en);
      pmt.setString(2,p);
      
             //execute query
  
       int r=pmt.executeUpdate();
      if(r>0)
   	System.out.println("RECORD DELETED SUCCESSFULLY");
      else
  	System.out.println("ERROR IN DELETION!!!");

 
 }
   	catch(ClassNotFoundException ce)
  	{
   		ce.printStackTrace();
  	}

  	catch(SQLException se)
  	{
 		  se.printStackTrace();
 	 }
 }



void UpdateEmployee()
{
   Connection con = null;
   PreparedStatement pmt = null;
  String query = null;
   BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

try
   {

	Class.forName("sun.jdbc.odbc.JdbcOdbcDriver");
	con = DriverManager.getConnection("Jdbc:Odbc:customerdsn","root","root");
	query = "update customerdb set balance=balance+? where pin= ?";// here ? is to putany value
	pmt=con.prepareStatement(query);

	int en=Integer.parseInt(System.console().readLine("PIN No. ="));
	int m=Integer.parseInt(System.console().readLine("ENTER AMOUNT TO DEPOSIT ="));

	//setting values to place holders

	pmt.setInt(1,m);
	pmt.setInt(2,en);
     //execute query

	int r=pmt.executeUpdate();
	if(r>0)
	System.out.println("RECORD UPDATED SUCCESSFULLY");
	else
	System.out.println("ERROR IN UPDATION!!!");
       }
	catch(ClassNotFoundException ce)
	{
 		System.out.println("CLASS NOT FOUND!!!");
		ce.printStackTrace();
	}

	catch(SQLException se)
	{
		se.printStackTrace();
	}
    } 


void passchange()
{
   Connection con = null;
   PreparedStatement pmt = null;
  String query = null;
   BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

try
   {
        
	Class.forName("sun.jdbc.odbc.JdbcOdbcDriver");
	con = DriverManager.getConnection("Jdbc:Odbc:customerdsn","root","root");
	query = "update customerdb set password=? where password= ?";// here ? is to putany value
	pmt=con.prepareStatement(query);

	
	String p=System.console().readLine("OLD PASSWORD=");
        String pa=System.console().readLine("NEW PASSWORD=");

	//setting values to place holders

	pmt.setString(2,p);
	pmt.setString(1,pa);
     //execute query

	int r=pmt.executeUpdate();
	if(r>0)
	System.out.println("PASSWORD UPDATED SUCCESSFULLY");
	else
	System.out.println("ERROR IN UPDATION!!!");
       }
	catch(ClassNotFoundException ce)
	{
 		System.out.println("CLASS NOT FOUND!!!");
		ce.printStackTrace();
	}

	catch(SQLException se)
	{
		se.printStackTrace();
	}
    }
   void withdraw()
{
   Connection con = null;
   PreparedStatement pmt = null;
  String query = null;
   BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

try
   {

	Class.forName("sun.jdbc.odbc.JdbcOdbcDriver");
	con = DriverManager.getConnection("Jdbc:Odbc:customerdsn","root","root");
	query = "update customerdb set balance=balance-? where pin= ? and password =?";// here ? is to putany value
	pmt=con.prepareStatement(query);

	int en=Integer.parseInt(System.console().readLine("PIN No. ="));
	String p=System.console().readLine("PASSWORD =");
	int m=Integer.parseInt(System.console().readLine("ENTER AMOUNT TO WITHDRAW="));
	//setting values to place holders

	pmt.setInt(1,m);
	pmt.setInt(2,en);
  	pmt.setString(3,p);
     //execute query

	int r=pmt.executeUpdate();
	if(r>0)
	System.out.println("AMOUNT WITHDRAWN SUCCESSFULLY");
	else
	System.out.println("ERROR IN WITHDRAW!!!");
       }
	catch(ClassNotFoundException ce)
	{
 		System.out.println("CLASS NOT FOUND!!!");
		ce.printStackTrace();
	}

	catch(SQLException se)
	{
		se.printStackTrace();
	}
    }

    void display()
{

   Connection con=null;
   Statement stmt=null;
   ResultSet rs=null;
   String query=null;

try
 {
   Class.forName("sun.jdbc.odbc.JdbcOdbcDriver");
   con=DriverManager.getConnection("Jdbc:Odbc:customerdsn","root","root");
   stmt=con.createStatement();
   query="select * from customerdb";
   rs=stmt.executeQuery(query);
   
   System.out.println("-------------------------------------------CUSTOMER RECORDS------------------------------------------\n\n    PIN                NAME                 BALANCE                  PASSWORD               ACCOUNT NO.\n");
   System.out.println("====================================================================================================="); 
while(rs.next())
        {
   	int pin=rs.getInt(1);
   	String name=rs.getString(2);
        int bal=rs.getInt(3); 
        String pass=rs.getString(4);
        int Acc_no=rs.getInt(5);
                   System.out.printf("%8d   |%18s   |%18d   |%20s  |%17d\n",pin,name,bal,pass,Acc_no);
   System.out.println("------------------------------------------------------------------------------------------------------");
        }
 }
   catch(ClassNotFoundException ce)
  {
   	ce.printStackTrace();
  }

  catch(SQLException se)
  {
   se.printStackTrace();
  }
}



void aboutus()
{
  System.out.println("\t\tSHUBHRANSHU BANK IS INDIA'S LARGEST PRIVATE SECTOR BANK WITH\n\t\tTOTAL ASSETS OF RS. 6,461.29 BILLION (US$ 103 BILLION AT ");
  System.out.println("\t\tMARCH 31, 2015. SHUBHRANSHU BANK CURRENTLY HAS A NETWORK OF\n\t\t4,050 BRANCHES AND 12,817 ATM's ACROSS INDIA.");
  System.out.println("\n\n\t\tBOARD MEMBERS\n\t\t-------------\n\t\tSHUBHRANSHU DWIVEDI\n\t\tPRATYUSH KAUSHIK\n\t\tPIYUSH MISHRA\n\n");
}




void contact()
{ System.out.println("\t\tCONTACT NO.- 9717486303, 7503781868\n\t\tEMAIL ID.- shubhranshukumar12@ymail.com\n\t\tADDRESS- IMS ENGINEERING COLLEGE,GHAZIABAD,UP");

}
}




 class BankProject
{  
      public static void main(String args[])throws IOException
        { 
 	int chc=1;
   	Combined c=new Combined();
 	while (chc==1)
	{        System.out.println("\n\t =* = * = * = * = * = * = * =* = * = * = * = * = * = * =* = * = * =* = * =* = * ");
                 System.out.println("\t||                                                                           ||");
                 System.out.println("\t||-------------------------WELCOME TO SHUBHRANSHU BANK-----------------------||");
                 System.out.println("\t||                                                                           ||");
                 System.out.println("\t =* = * = * = * = * = * = * =* = * = * = * = * = * = * =* = * = * = * = * =* = *\n\n\n\n");



                System.out.println("                        *+*+*+*+*+*+*+*+*+*+*+*+*+*+*+*+*");
                System.out.println("     \t\t\t*                               *");
                System.out.println("     \t\t\t*              MENU             *");
                System.out.println("     \t\t\t*같같같같같같같같같같같같같같같�*");
                System.out.println("     \t\t\t*                               *");
  		System.out.println("     \t\t\t*\t1. NEW ACCOUNT          *\n     \t\t\t*\t2. DELETE ACCOUNT       *\n     \t\t\t*\t3. DEPOSIT AMOUNT       *");
                System.out.println("     \t\t\t*\t4. WITHDRAW             *\n     \t\t\t*\t5. DISPLAY INFO         *\n    \t\t\t*\t6. CHANGE PASSWORD      *\n    \t\t\t*\t7. ABOUT US             *\n    \t\t\t*\t8. CONTACT US           *");
  		System.out.println("     \t\t\t*                               *");
                System.out.println("                        *+*+*+*+*+*+*+*+*+*+*+*+*+*+*+*+*\n\n");
		int ch=Integer.parseInt(System.console().readLine("\t\tENTER YOUR CHOICE: ="));
  		System.out.println();
		  switch(ch)
		{ 
  			 case 1:  
 			 c.InsertEmployee();
  			 break;
  			 case 2:
  			 c.Deleteaccount();
 	        	 break;		
			
			case 3:
  			c.UpdateEmployee();
 			 break;
			
			case 4:
  			c.withdraw();
 			 break;

			  case 5:
 			  c.display();
  			 break;
                          case 6:
                          c.passchange();
                          break;
                          case 7:
                          c.aboutus();
                          break;
                          case 8:
                          c.contact();
                          break;
  			default:
               			System.out.println("wrong choice!!!!!");
		}
    	System.out.println("\n\nENTER 1 TO REPEAT PROCEDURE ELSE ENTER 0\n\nTHANK YOU! FOR CHOOSING SHUBHRANSHU BANK\n");
   
  	chc=Integer.parseInt(System.console().readLine("choice ="));
 
	}
       }
}








