package StudentManagementSystem;
 
import javax.swing.*;  
 
import java.sql.*;  
 
 
public class Update extends JFrame{
	String tableName;  
    JTextField field[]=null;  
    String a[]=null;  
    public void setTableName(String s){  
        tableName=s.trim();  
    }  
    public void setField(JTextField s[]){  
        field=s;  
    }  
    public void setA(String e[]){  
        a=e;  
    }  
    public Update(){  
          
    }  
    public void  Execute_Update(int mark){  
        String SQL[]=new String [a.length];  
        Connection con;  
        Statement sql;  
        for(int i=0;i<a.length;i++)  
        {  
            if(i!=mark)  
            SQL[i]="update "+tableName+" set "+a[i]+" ='"+field[i].getText().toString()+"' where "+a[mark]+" ='"+field[mark].getText().toString()+"'";  
        }  
        try{  
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");  
        }  
        catch(ClassNotFoundException exp){  
            System.out.println(exp);  
        }  
        try{  
            String url,userName,userPwd;  
            url="jdbc:sqlserver://localhost:1433;DatabaseName=student";  
            userName="sa";  
            userPwd="123456";  
            con=DriverManager.getConnection(url,userName,userPwd);  
            sql=con.createStatement();  
            for(int i=0;i<field.length;i++)  
                if(i!=mark&&field[i].getText().toString().equals("")==false)  
                    sql.executeUpdate(SQL[i]);  
            con.close();  
            for(int i=0;i<field.length;i++)  
                field[i].setText(null);  
        }  
        catch(SQLException ex){  
            System.out.println(ex);  
        }  
    }  
}