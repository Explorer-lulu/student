package StudentManagementSystem;
 
import javax.swing.*;  
 
 
import java.awt.*;  
import java.awt.event.*; 
 
public class CommFrame extends JFrame implements ActionListener {
 
	    JMenuBar bar; 
	    JMenu menu,menu1;  
	    JMenuItem scanItem,deleteItem,updateItem,insertItem,searchItem;
	    JMenuItem scanItem1,deleteItem1,updateItem1,insertItem1,searchItem1; 
	    Scan_stu scan;    //查看所有学生信息  
	    Delete_stu delete;//删除学生信息  
	    Update_stu update;//更新学生信息  
	    Insert_stu insert;//插入学生信息  
	    Search_stu search;//查找学生信息  
	    
	    Scan_grade scan_grade;    //查看所有学生成绩
	    Delete_grade delete_grade;//删除学生成绩
	    Update_grade update_grade;//更新学生成绩  
	    Insert_grade insert_grade;//插入学生成绩  
	    Search_grade search_grade;//查找学生成绩  
	    
	    CardLayout card=null;  
	    
	    JPanel pCenter;  
	    CommFrame(){  
	        setLayout(new FlowLayout());  
	        scanItem=new JMenuItem("浏览");  
	        deleteItem=new JMenuItem("删除");  
	        updateItem=new JMenuItem("修改");  
	        insertItem=new JMenuItem("添加");  
	        searchItem=new JMenuItem("查找");  
	        
	        scanItem1=new JMenuItem("浏览");  
	        deleteItem1=new JMenuItem("删除");  
	        updateItem1=new JMenuItem("修改");  
	        insertItem1=new JMenuItem("添加");  
	        searchItem1=new JMenuItem("查找");  
	        
	        bar=new JMenuBar();  
	        menu=new JMenu("信息管理菜单");     
	        menu1=new JMenu("成绩管理菜单");     
	        menu.add(scanItem);  
	        menu.add(deleteItem);  
	        menu.add(updateItem);  
	        menu.add(insertItem);  
	        menu.add(searchItem);  
	        
	        menu1.add(scanItem1);  
	        menu1.add(deleteItem1);  
	        menu1.add(updateItem1);  
	        menu1.add(insertItem1);  
	        menu1.add(searchItem1);  
	        
	        bar.add(menu);  
	        bar.add(menu1);  
	        setJMenuBar(bar);  
	        scanItem.addActionListener(this);  
	        deleteItem.addActionListener(this);  
	        updateItem.addActionListener(this);  
	        insertItem.addActionListener(this);  
	        searchItem.addActionListener(this);  
	        
	        scanItem1.addActionListener(this);  
	        deleteItem1.addActionListener(this);  
	        updateItem1.addActionListener(this);  
	        insertItem1.addActionListener(this);  
	        searchItem1.addActionListener(this);  
	        
	        scan=new Scan_stu();  
	        update=new Update_stu();  
	        delete=new Delete_stu();  
	        insert=new Insert_stu();  
	        search=new Search_stu();  
	        card=new CardLayout();  
	        
	        scan_grade=new Scan_grade();  
	        update_grade=new Update_grade();  
	        delete_grade=new Delete_grade();  
	        insert_grade=new Insert_grade();  
	        search_grade=new Search_grade();  
	        card=new CardLayout();  
	        
	        pCenter=new JPanel();  
	        pCenter.setLayout(card);  
	        pCenter.add("scanItem", scan);  
	        pCenter.add("deleteItem",delete);  
	        pCenter.add("updateItem",update);  
	        pCenter.add("insertItem",insert);  
	        pCenter.add("searchItem",search);  
	 
	        pCenter.add("scanItem1", scan_grade);  
	        pCenter.add("deleteItem1",delete_grade);  
	        pCenter.add("updateItem1",update_grade);  
	        pCenter.add("insertItem1",insert_grade);  
	        pCenter.add("searchItem1",search_grade); 
	        
	        
	        add(pCenter,BorderLayout.SOUTH);
	        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);  
	        setVisible(true);  
	        setBounds(400,150,550,400);  
	        setTitle("学生信息管理系统");  
	        validate();  
	    }  
	    
 
	    
	    public void actionPerformed(ActionEvent e){  
	        if(e.getSource()==scanItem)  
	            card.show(pCenter, "scanItem");  
	        else if(e.getSource()==deleteItem)  
	            card.show(pCenter, "deleteItem");     
	        else if(e.getSource()==updateItem)  
	            card.show(pCenter, "updateItem");  
	        else if(e.getSource()==insertItem)  
	            card.show(pCenter, "insertItem");  
	        else if(e.getSource()==searchItem)  
	            card.show(pCenter, "searchItem");  
	        
	        if(e.getSource()==scanItem1)  
	            card.show(pCenter, "scanItem1");  
	        else if(e.getSource()==deleteItem1)  
	            card.show(pCenter, "deleteItem1");     
	        else if(e.getSource()==updateItem1)  
	            card.show(pCenter, "updateItem1");  
	        else if(e.getSource()==insertItem1)  
	            card.show(pCenter, "insertItem1");  
	        else if(e.getSource()==searchItem1)  
	            card.show(pCenter, "searchItem1"); 
	    }  
	  
}