import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.lang.*;
import java.util.*;
import java.sql.*;
import javax.swing.table.*;
import java.io.*;
import javax.swing.filechooser.FileSystemView;


class AdminPatMod extends JFrame implements ActionListener
{
	
	private JPanel panel;
	private ImageIcon image;
	private JLabel LName,LId,LAge,LDet,LUid,LSearch,imgLabel;
	private JPasswordField Tpass;
	private JTextField TName,TId,TAge,TSex,TDet,txtSearch,b;
	private JButton deleteButton,clearButtion,showButton,Bback,Bexit;
	private JTable myTable;
	private JScrollPane tableScrollPane;
	private DefaultTableModel model;
	private JComboBox combo;
	public String value,pic;
	
	
	
	public AdminPatMod()
	{
		super("Patient Modification Page");
		this.setSize(550, 600);
		this.setLocationRelativeTo(null);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setResizable(false); 
		panel = new JPanel();
		panel.setLayout(null);
		panel.setBackground(Color.cyan);
		
		
		
		//Label------------------------
		LSearch=new JLabel("Search: ");
		LSearch.setBounds(30,160,70,30);
		panel.add(LSearch);
		
		LName=new JLabel("Name: ");
		LName.setBounds(30,200,70,30);
		panel.add(LName);
		
		LId=new JLabel("Id: ");
		LId.setBounds(30,240,70,30);
		panel.add(LId);
		
		LAge=new JLabel("Age: ");
		LAge.setBounds(30,280,70,30);
		panel.add(LAge);
		
		LDet=new JLabel("Sex: ");
		LDet.setBounds(30,320,70,30);
		panel.add(LDet);
		
		
		
		
		
		
		
		//TextFields-------------------------------------------
		
		txtSearch=new JTextField();
		txtSearch.setBounds(100,100,140,25);
		
		//image ------------------------------------
		
		
		
		//----------------------------------
		txtSearch.addKeyListener(new KeyAdapter() {
        public void keyReleased(KeyEvent e) {
        Connection con=null;//for connection
            Statement st = null;//for query execution
		    ResultSet rs = null;//to get row by row result from DB
			String query = "select * from patientdetails where `name` = '"+txtSearch.getText()+"'";
			String query1 = "select * from patientdetails where `Id` = '"+txtSearch.getText()+"'";
			
			
         try
		{
			Class.forName("com.mysql.jdbc.Driver");//load driver
			con = DriverManager.getConnection("jdbc:mysql://localhost:3306/h1.6", "root", "");
			st = con.createStatement();//create statement
			rs = st.executeQuery(query);
			
					
			if(rs.next())
			{
				TName.setText(rs.getString("name"));
                TId.setText(rs.getString("Id"));
                TAge.setText(rs.getString("age"));
                TSex.setText(rs.getString("sex"));
                TDet.setText(rs.getString("details"));
                
													
			}
			
		}
		catch(Exception ex)
		{
			System.out.println("Exception ff: " +ex.getMessage());
        }
		try
		{
			Class.forName("com.mysql.jdbc.Driver");//load driver
			con = DriverManager.getConnection("jdbc:mysql://localhost:3306/h1.6", "root", "");
			st = con.createStatement();//create statement
			rs = st.executeQuery(query1);
			
					
			if(rs.next())
			{
				TName.setText(rs.getString("name"));
                TId.setText(rs.getString("Id"));
                TAge.setText(rs.getString("age"));
                TSex.setText(rs.getString("sex"));
                TDet.setText(rs.getString("details"));
                
													
			}
			
		}
		catch(Exception ex)
		{
			System.out.println("Exception ff: " +ex.getMessage());
        }
      }
      //-------------------------------------------------------------------
      public void keyTyped(KeyEvent e) {
      }

      public void keyPressed(KeyEvent e) {
      }
	  });
	
  
		panel.add(txtSearch);
		
		TName=new JTextField();
		TName.setBounds(100,200,140,25);
		panel.add(TName);
		
		TId=new JTextField();
		TId.setBounds(100,240,140,25);
		panel.add(TId);
		
		
		
		
		TAge=new JTextField();
		TAge.setBounds(100,280,140,25);
		panel.add(TAge);
		
		TSex=new JTextField();
		TSex.setBounds(100,320,140,25);
		panel.add(TSex);
		
		
		
		
		
		
		//combobox----------
		
		combo=new JComboBox();
		combo.setBounds(400,200,100,30);
		
		
		try {  
			Class.forName("com.mysql.jdbc.Driver");  

			Connection conn= DriverManager.getConnection("jdbc:mysql://localhost:3306/h1.6", "root", "");  
			Statement st = conn.createStatement();

			ResultSet r=st.executeQuery("select * from patientdetails");

		while (r.next()) 
		{  

		combo.addItem(r.getString(2)); 
		
		}
		panel.add(combo);


		conn.close();
    } catch (Exception e) 
	{  
		JOptionPane.showMessageDialog(null,"Failed to Connect to Database","Error Connection", JOptionPane.WARNING_MESSAGE);  
		
	}  
		
		//Buttons--------------
		
		//Buttons--------------
		
		Bback=new JButton("Back");
		Bback.setBounds(280,520,100,30);
		Bback.addActionListener(this);
		panel.add(Bback);
		
		Bexit=new JButton("Exit");
		Bexit.setBounds(400,520,100,30);
		Bexit.addActionListener(this);
		panel.add(Bexit);
		
		showButton=new JButton("Show");
		showButton.setBounds(400,230,100,30);
		showButton.addActionListener(this);
		panel.add(showButton);
		
		clearButtion=new JButton("Clear");
		//clearButtion.setBounds(70,420,100,30);
		panel.add(clearButtion);
		
		
		
		
		deleteButton=new JButton("Delete");
		deleteButton.setBounds(30,450,100,30);
		deleteButton.addActionListener(this);
		panel.add(deleteButton);
		
		

		
		
		this.add(panel);
		
	}
	
	
	
	
	
	
	//show method-------------------------------------
	
	public void showw()
	{
		Connection con=null;//for connection
            Statement st = null;//for query execution
		   ResultSet rs = null;//to get row by row result from DB
			value=(String)combo.getSelectedItem();
			System.out.println(value);
			String query = "select * from patientdetails where `Id` = '"+(String)combo.getSelectedItem()+"'";
			
         try
		{
			Class.forName("com.mysql.jdbc.Driver");//load driver
			con = DriverManager.getConnection("jdbc:mysql://localhost:3306/h1.6", "root", "");
			st = con.createStatement();//create statement
			rs = st.executeQuery(query);//getting result
					
			while(rs.next())
			{
                
                TName.setText(rs.getString("name"));
                TId.setText(rs.getString("Id"));
                TAge.setText(rs.getString("age"));
                TSex.setText(rs.getString("sex"));
                TDet.setText(rs.getString("details"));
                
				
				
				
							
			}
			
		}
        catch(Exception ex)
		{
			System.out.println("Exception : " +ex.getMessage());
        }
	}
	
	
	
	
	
	public void deletee()
	{
		String query = "DELETE from patientdetails where Id='"+TId.getText()+"';";
		String query1 = "DELETE from login where id='"+TId.getText()+"';";
		System.out.println(query);
		
        try
		{
			Class.forName("com.mysql.jdbc.Driver");
			Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/h1.6", "root", "");
			Statement stm = con.createStatement();
			stm.execute(query);
			stm.execute(query1);
			stm.close();
			con.close();
					
		}
        catch(Exception ex)
		{
			System.out.println("Exception : " +ex.getMessage());
        }
		
		
		
	}
	
	
	
	
	public void actionPerformed(ActionEvent ae)
	{
		String elementText = ae.getActionCommand();
		
		if(elementText.equals(showButton.getText()))
		{
			showw();
			
			
		}
		
		
		
		else if(elementText.equals(clearButtion.getText()))
		{
			
			
			
		}
		
		else if(elementText.equals(deleteButton.getText()))
		{
			deletee();
			
			
			
		}
		
		if(elementText.equals(Bback.getText()))
		{
			Admin1 a1=new Admin1();
			this.setVisible(false);
			a1.setVisible(true);
		}
		else if(elementText.equals(Bexit.getText()))
		{
			int choice=JOptionPane.showConfirmDialog(null,"Do you want to exit?","Exit",JOptionPane.YES_NO_OPTION);
			if(choice== JOptionPane.YES_OPTION)
			{
			System.exit(0);
			}
			else{ 
			
		
			
			}
		}
		
		
		
		}
	
	
 }
