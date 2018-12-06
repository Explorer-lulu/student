package StudentManagementSystem;
 
import java.sql.*; 
 
public class Query {
	 Object a[][]=null;  
	    String b[]=null;  
	    String tableName="";  
	    int 字段个数;  
	    public Query(){  
	        try{  
	            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");  
	        }  
	        catch(ClassNotFoundException e){  
	            System.out.println(e);  
	        }  
	    }  
	    public Object[][] getRecord(){//求表格的内容  
	        a=null;  
	        b=null;  
	        Connection con;  
	        Statement sql;  
	        ResultSet rs;  
	        try{  
	            String url,userName,userPwd;  
	            url="jdbc:sqlserver://localhost:1433;DatabaseName=student";  
	            userName="sa";  
	            userPwd="123456";  
	            con=DriverManager.getConnection(url,userName,userPwd);  
	            int 字段个数=getZiDuan();  
	            int n=getAmount();  
	            a=new Object[n][字段个数];  
	            sql=con.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE,ResultSet.CONCUR_READ_ONLY);  
	            rs=sql.executeQuery("select * from "+tableName);  
	            int m=0;  
	            while(rs.next()){  
	                for(int k=1;k<=字段个数;k++){  
	                    a[m][k-1]=rs.getString(k);  
	                }  
	                System.out.println();  
	                m++;  
	            }  
	            con.close();  
	        }  
	        catch(SQLException e){  
	            System.out.println("请输入正确的表名"+e);  
	        }  
	        return a;  
	    }  
	    public int getAmount(){//求表内容有多少行  
	        Connection con;  
	        Statement sql;  
	        ResultSet rs;  
	        try{  
	            String url,userName,userPwd;  
	            url="jdbc:sqlserver://localhost:1433;DatabaseName=Student";  
	            userName="sa";  
	            userPwd="自己数据库密码";  
	            con=DriverManager.getConnection(url,userName,userPwd);  
	            sql=con.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE,ResultSet.CONCUR_READ_ONLY);  
	            rs=sql.executeQuery("select * from "+tableName);  
	            rs.last();  
	            int rows=rs.getRow();  
	            return rows;  
	        }  
	        catch(SQLException exp){  
	            System.out.println(""+exp);  
	            return 0;  
	        }  
	    }  
	    public String[] getField(){//求字段名称  
	        Connection con;  
	        try{  
	            String url,userName,userPwd;  
	            url="jdbc:sqlserver://localhost:1433;DatabaseName=Student";  
	            userName="sa";  
	            userPwd="自己数据库密码";  
	            con=DriverManager.getConnection(url,userName,userPwd);  
	            DatabaseMetaData metadata=con.getMetaData();  
	            ResultSet rs1=metadata.getColumns(null, null, tableName, null);  
	            int 字段个数=getZiDuan();  
	            b=new String[字段个数];  
	            int k=0;  
	            while(rs1.next()){  
	                b[k]=rs1.getString(4);  
	                k++;  
	            }  
	            con.close();          
	        }  
	        catch(SQLException e){  
	            System.out.println(e);  
	        }  
	        return b;  
	    }  
	    public void setTableName(String s){//初试表名  
	        tableName=s.trim();  
	    }  
	    public int getZiDuan(){//求字段个数  
	        Connection con;  
	        PreparedStatement sql;  
	        ResultSet rs;  
	        try{  
	            String url,userName,userPwd;  
	            url="jdbc:sqlserver://localhost:1433;DatabaseName=Student";  
	            userName="sa";  
	            userPwd="自己数据库密码";  
	            con=DriverManager.getConnection(url,userName,userPwd);  
	            DatabaseMetaData metadata=con.getMetaData();  
	            ResultSet rs1=metadata.getColumns(null, null, tableName, null);  
	            字段个数=0;  
	            while(rs1.next())  
	                字段个数++;  
	        }  
	        catch(SQLException e){  
	            System.out.println(e);  
	        }  
	        return 字段个数;  
	    }  
}