package StudentManagementSystem;
 
import java.awt.*;  
import java.awt.event.*;  
  
import javax.swing.*;  
import javax.swing.table.DefaultTableModel;  
  
 
 
public class Search_stu extends JPanel implements ActionListener{
	Box box[],baseBox;  
    Query query;  
    JButton button;  
    JTextField field[]=null;  
    String a[]=null;  
    int n,mark,m;  
    Search search;  
    String tableName;  
    DefaultTableModel search_table;  
    Object object[][];  
    String b[];  
    Search_stu(){  
        setLayout(new FlowLayout());  
        query=new Query();  
        setBackground(Color.orange);  
        query.setTableName("stu");  
        a=query.getField();  
        n=a.length;  
        box=new Box [n+1];  
        field =new JTextField[n];  
        for(int i=0;i<n;i++){  
            box[i]=Box.createHorizontalBox();  
            field[i]=new JTextField(10);  
            if(a[i].equals("学号")==true){  
                box[i].add(new JLabel("  "+a[i]));  
                box[i].add(Box.createHorizontalStrut(8));  
                box[i].add(field[i]);  
            }  
            else{  
                box[i].add(new JLabel("  "+a[i]));  
                box[i].add(Box.createHorizontalStrut(8));  
                box[i].add(field[i]);  
            }  
        }  
        object =new Object[0][0];  
        search_table=new DefaultTableModel(object, a);  
        JTable table=new JTable(search_table);  
        button=new JButton("查找");  
        button.addActionListener(this);  
        box[n-1].add(new JLabel("  单击查找"));  
        box[n-1].add(Box.createHorizontalStrut(8));  
        box[n-1].add(button);  
        baseBox=Box.createVerticalBox();  
        for(int i=0;i<n;i++){  
        baseBox.add(box[i]);  
        baseBox.add(Box.createVerticalStrut(8));  
        }  
        JScrollPane scrollPane=new JScrollPane(table);  
        scrollPane.setBounds(0,0,550,380);  
        table.setPreferredSize(new Dimension(scrollPane.getWidth() - 50, scrollPane.getHeight()*2));  
        baseBox.add(scrollPane);   
        add(baseBox);  
        table.revalidate();  
          
    }  
    public void actionPerformed(ActionEvent e){  
        int i,sum=0;  
        for(i=0;i<n;i++){  
            if(field[i].getText().toString().equals("")==true)  
                sum++;  
        }  
        System.out.println(sum);  
        if(sum==n)  
            JOptionPane.showMessageDialog(this, "你未输入任何内容,请重新输入！","消息对话框",JOptionPane.WARNING_MESSAGE);  
        else{  
            Search search=new Search();  
            search.setTableName("stu");  
            search.setField(field);  
            search.setA(a);  
            search.Execute_Search();      
            object=null;b=null;  
            query=new Query();  
            query.setTableName("stu");  
            object=search.getRecord();  
            search_table.setDataVector(object, a);  
        }  
    }  
}