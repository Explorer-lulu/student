package StudentManagementSystem;
 
import javax.swing.*;  
 
 
import java.awt.*;  
import java.awt.event.*; 
 
public class CommFrame extends JFrame implements ActionListener {
 
	    JMenuBar bar; 
	    JMenu menu,menu1;  
	    JMenuItem scanItem,deleteItem,updateItem,insertItem,searchItem;
	    JMenuItem scanItem1,deleteItem1,updateItem1,insertItem1,searchItem1; 
	    Scan_stu scan;    //�鿴����ѧ����Ϣ  
	    Delete_stu delete;//ɾ��ѧ����Ϣ  
	    Update_stu update;//����ѧ����Ϣ  
	    Insert_stu insert;//����ѧ����Ϣ  
	    Search_stu search;//����ѧ����Ϣ  
	    
	    Scan_grade scan_grade;    //�鿴����ѧ���ɼ�
	    Delete_grade delete_grade;//ɾ��ѧ���ɼ�
	    Update_grade update_grade;//����ѧ���ɼ�  
	    Insert_grade insert_grade;//����ѧ���ɼ�  
	    Search_grade search_grade;//����ѧ���ɼ�  
	    
	    CardLayout card=null;  
	    
	    JPanel pCenter;  
	    CommFrame(){  
	        setLayout(new FlowLayout());  
	        scanItem=new JMenuItem("���");  
	        deleteItem=new JMenuItem("ɾ��");  
	        updateItem=new JMenuItem("�޸�");  
	        insertItem=new JMenuItem("���");  
	        searchItem=new JMenuItem("����");  
	        
	        scanItem1=new JMenuItem("���");  
	        deleteItem1=new JMenuItem("ɾ��");  
	        updateItem1=new JMenuItem("�޸�");  
	        insertItem1=new JMenuItem("���");  
	        searchItem1=new JMenuItem("����");  
	        
	        bar=new JMenuBar();  
	        menu=new JMenu("��Ϣ����˵�");     
	        menu1=new JMenu("�ɼ�����˵�");     
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
	        setTitle("ѧ����Ϣ����ϵͳ");  
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