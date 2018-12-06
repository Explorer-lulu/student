package StudentManagementSystem;
 
import java.awt.*;  
import java.awt.event.*;  
import javax.swing.*;  
 
 
public class Update_stu extends JPanel implements ActionListener{
	Box box1,box2,baseBox;  
    Query query;  
    JButton button;  
    JTextField field[]=null;  
    String a[]=null;  
    int n,mark;  
    Update update;  
    String tableName;  
    Update_stu(){  
        query=new Query();  
        setBackground(Color.orange);  
        query.setTableName("stu");  
        a=query.getField();  
        box1=Box.createVerticalBox();  
        box2=Box.createVerticalBox();  
        n = a.length;  
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
        box1.add(new JLabel("  单击修改"));  
        button=new JButton("修改");  
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
            if(a[i].equals("学号")==true&&field[i].getText().toString().equals("")==true){  
                mark=i;  
                JOptionPane.showMessageDialog(this, "带*必须填写！！！","消息对话框",JOptionPane.WARNING_MESSAGE);  
                break;  
            }  
        }  
        if(i==n){  
            int choose=JOptionPane.showConfirmDialog(this, "请确保你的学号是正确的,否则会更新失败！！！如果学号错误"  
                    + "请先删除再添加","消息对话框",JOptionPane.WARNING_MESSAGE);  
            if(choose==JOptionPane.YES_OPTION){  
                Update update=new Update();  
                update.setTableName("stu");  
                update.setField(field);  
                update.setA(a);  
                update.Execute_Update(mark);  
                JOptionPane.showMessageDialog(this, "更新成功！！！","消息对话框",JOptionPane.WARNING_MESSAGE);  
            }  
        }  
    }  
  
}