package StudentManagementSystem;
 
import java.awt.*;  
import java.awt.event.*;  
import javax.swing.*;  
 
 
public class Insert_stu  extends JPanel implements ActionListener{
	Box box1,box2,baseBox;  
    Query query;  
    JButton button;  
    JTextField field[]=null;  
    String a[]=null;  
    int n,mark;  
    Insert insert;  
    String tableName;  
    Insert_stu(){  
        query=new Query();  
        setBackground(Color.orange);  
        query.setTableName("stu");  
        a=query.getField();  
        box1=Box.createVerticalBox();  
        box2=Box.createVerticalBox();  
        n=a.length;  
        field =new JTextField[n];  
        for(int i=0;i<n;i++){  
            field[i]=new JTextField(10);  
            if(a[i].equals("学号")==true)  
                box1.add(new JLabel("* "+a[i]));  
            else  
            box1.add(new JLabel("  "+a[i]));  
            box1.add(Box.createVerticalStrut(8));  
            box2.add(field[i]);  
            box2.add(Box.createVerticalStrut(8));  
        }  
        box1.add(new JLabel("  单击添加"));  
        button=new JButton("添加");  
        button.addActionListener(this);  
        box2.add(button);  
        baseBox=Box.createHorizontalBox();  
        baseBox.add(box1);  
        baseBox.add(Box.createHorizontalStrut(8));  
        baseBox.add(box2);  
        add(baseBox);  
    }  
    public void actionPerformed(ActionEvent e){  
        int i;  
        for(i=0;i<n;i++){  
            if(field[i].getText().toString().equals("")==true){  
                JOptionPane.showMessageDialog(this, "必须全部填写","消息对话框",JOptionPane.WARNING_MESSAGE);  
                break;  
            }  
            if(a[i].equals("学号")==true){   
                mark=i;  
            }  
        }  
        if(i==n){  
                Insert insert=new Insert();  
                insert.setTableName("stu");  
                insert.setField(field);  
                insert.setA(a);  
                insert.Execute_Insert(mark);  
            }  
        }  
  
}