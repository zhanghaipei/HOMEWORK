import java.awt.*;  
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;

import javax.swing.*;  
import javax.swing.table.DefaultTableModel;
   
 public class Registration{  
	 
	 	private JFrame frame;  
	    private JButton btn_submit;  
	    private JButton btn_update;  
		private JTextField txt_type;
		private JTextField txt_number;
		private JTextField txt_status;
		private JLabel lbl_type;
		private JLabel lbl_number;
		private JLabel lbl_status;
		private JLabel lbl_type_note;
		private JLabel lbl_status_note;
		Object[][] customer;
		JTable table;
		private JScrollPane scrollPane;
		static JDBCTest reader = new JDBCTest();
	    
	    void go(){  
	        frame = new JFrame("�����Ǽ�ϵͳ");  
	        Container contentPane = frame.getContentPane();   
	        contentPane.setLayout(null);  
	   
	        btn_submit = new JButton("�ύ");
	        btn_submit.setBounds(300,125,110,25);
	        btn_submit.addActionListener(   
	        new ActionListener(){
	        	public void actionPerformed(ActionEvent e){
	    			String type = txt_type.getText();
	    			String number = txt_number.getText();
	    			String status = txt_status.getText();
	    			try {
	    				reader.connect();
	    			} catch (SQLException e1) {
	    				// TODO Auto-generated catch block
	    				e1.printStackTrace();
	    			}
	    			reader.save(type, number, status);
	        		
	        		}
	        	}
	        		
	        );
	        
	        btn_update = new JButton("����");
	        btn_update.setBounds(300,400,110,25);
	        btn_update.addActionListener(   
	    	        new ActionListener(){
	    	        	public void actionPerformed(ActionEvent e){
	    	        		try {
								reader.connect();
							} catch (SQLException e1) {
								// TODO Auto-generated catch block
								e1.printStackTrace();
							}
	    	    			customer= reader.getObject();
	    	    			table=new JTable();
	    	    			table.setModel(new DefaultTableModel(customer,
	    	    	  				new String[] {
	    	    					"   ����", "ʱ��", "   ���ƺ�", "  ״̬"}) );
	    	    			scrollPane.setViewportView(table);
	    	        		}
	    	        	}
	    	        		
	    	        );
	        
			txt_type = new JTextField();
			txt_type.setText("С����");
			txt_type.setColumns(15);
			txt_type.setBounds(150,15,110,25);  			
			
			txt_number = new JTextField(); 
			txt_number.setText("³AQW123");
			txt_number.setColumns(15);
			txt_number.setBounds(150,55,110,25); 
						
			txt_status = new JTextField();
			txt_status.setText("����");
			txt_status.setColumns(15);
			txt_status.setBounds(150,95,110,25); 
			
			lbl_type = new JLabel("�����복�����ͣ�");
			lbl_type.setBounds(30,15,110,20);
			lbl_type_note = new JLabel("��С���������ͻ��������Ϳͳ���");
			lbl_type_note.setBounds(260,18,200,20);
			
			lbl_number = new JLabel("�����복�ƺ��룺");
			lbl_number.setBounds(30,55,110,20);
			
			lbl_status = new JLabel("�����복��״̬��");
			lbl_status.setBounds(30,95,110,20);
			lbl_status_note = new JLabel("���뿪����룩");
			lbl_status_note.setBounds(260,95,110,20);
			
			
			customer= reader.getObject();
			table=new JTable();
			table.setModel(new DefaultTableModel(customer,
	  				new String[] {
					"   ����", "ʱ��", "   ���ƺ�", "  ״̬"}) );
			scrollPane = new JScrollPane();
			scrollPane.setViewportView(table);
			scrollPane.setBounds(15,180,400,200);
			
	        contentPane.add(btn_submit);  
	        contentPane.add(btn_update); 
	        contentPane.add(txt_type);
	        contentPane.add(txt_number);
	        contentPane.add(txt_status);
	        contentPane.add(lbl_type);
	        contentPane.add(lbl_number);
	        contentPane.add(lbl_status);
	        contentPane.add(lbl_status_note);
	        contentPane.add(lbl_type_note);
	        contentPane.add(scrollPane);
	        
	        
	        frame.setSize(500,510);  
	        frame.setVisible(true);  
	        
	    }

}  