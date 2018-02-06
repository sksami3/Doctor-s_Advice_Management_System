import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.lang.*;
import java.util.*;
import java.sql.*;
import javax.swing.table.*;
import java.io.*;
import javax.swing.filechooser.FileSystemView;


class AdminPres extends JFrame implements ActionListener
{
	
	private JPanel panel;
	private ImageIcon image;
	private JLabel LPName,LDName,LPres,LSearch;
	private JTextArea Pres;
	private JTextField TPName,TDName,txtSearch;
	private JButton deleteButton,clearButtion,showButton,Bback,Bexit;
	private JTable myTable;
	private JScrollPane tableScrollPane;
	private DefaultTableModel model;
	private JComboBox combo;
	public String value,pic,ll;
	
	
	
	public AdminPres()
	{
		super("Prescription Modification Page");
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
		
		LPName=new JLabel("Patient's Name: ");
		LPName.setBounds(30,200,70,30);
		panel.add(LPName);
		
		LDName=new JLabel("Doctor's Name: ");
		LDName.setBounds(30,240,70,30);
		panel.add(LDName);
		
		LPres=new JLabel("Details: ");
		LPres.setBounds(30,280,70,30);
		panel.add(LPres);
		
		
		
		
		
		
		
		
		
		//TextFields-------------------------------------------
		
		txtSearch=new JTextField();
		txtSearch.setBounds(100,160,140,25);
		
		//image ------------------------------------
		
		
		
		//----------------------------------
		txtSearch.addKeyListener(new KeyAdapter() {
        public void keyReleased(KeyEvent e) {
        Connection con=null;//for connection
            Statement st = null;//for query execution
		    ResultSet rs = null;//to get row by row result from DB
			String query = "select * from prescription where `Pname` = '"+txtSearch.getText()+"'";
			String query1 = "select * from prescription where `Pid` = '"+txtSearch.getText()+"'";
			
			
         try
		{
			Class.forName("com.mysql.jdbc.Driver");//load driver
			con = DriverManager.getConnection("jdbc:mysql://localhost:3306/h1.6", "root", "");
			st = con.createStatement();//create statement
			rs = st.executeQuery(query);
			
					
			if(rs.next())
			{
				TPName.setText(rs.getString("Pname"));
                TDName.setText(rs.getString("Dname"));
                Pres.setText(rs.getString("pres"));
				
                
                
													
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
				TPName.setText(rs.getString("Pname"));
                TDName.setText(rs.getString("Dname"));
                Pres.setText(rs.getString("pres"));
                
													
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
		
		TPName=new JTextField();
		TPName.setBounds(100,200,140,25);
		panel.add(TPName);
		
		TDName=new JTextField();
		TDName.setBounds(100,240,140,25);
		panel.add(TDName);
		
		
		
		
		Pres=new JTextArea();
		Pres.setBounds(30,320,200,200);
		panel.add(Pres);
		
		
		
		
		
		
		
		//combobox----------
		
		combo=new JComboBox();
		combo.setBounds(400,200,100,30);
		
		
		try {  
			Class.forName("com.mysql.jdbc.Driver");  

			Connection conn= DriverManager.getConnection("jdbc:mysql://localhost:3306/h1.6", "root", "");  
			Statement st = conn.createStatement();

			ResultSet r=st.executeQuery("select * from prescription");

		while (r.next()) 
		{  

		combo.addItem(r.getString(3));
				
		
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
		
		showButton=new JButton("Show Details");
		showButton.setBounds(400,230,70,30);
		showButton.addActionListener(this);
		panel.add(showButton);
		
		clearButtion=new JButton("Clear");
		//clearButtion.setBounds(70,420,100,30);
		panel.add(clearButtion);
		
		
		
		
		deleteButton=new JButton("Delete");
		deleteButton.setBounds(30,530,100,30);
		deleteButton.addActionListener(this);
		panel.add(deleteButton);
		
		//Experiment suru
		//table-----------------
		
		/*myTable = new JTable();
		tableScrollPane = new JScrollPane(myTable);
		tableScrollPane.setBounds(30,25,470,140);
		panel.add(tableScrollPane);
	*/


		
		
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
			String query = "select * from prescription where `Pid` = '"+(String)combo.getSelectedItem()+"'";
			
         try
		{
			Class.forName("com.mysql.jdbc.Driver");//load driver
			con = DriverManager.getConnection("jdbc:mysql://localhost:3306/h1.6", "root", "");
			st = con.createStatement();//create statement
			rs = st.executeQuery(query);//getting result
					
			while(rs.next())
			{
                
                TPName.setText(rs.getString("Pname"));
                TDName.setText(rs.getString("Dname"));
                Pres.setText(rs.getString("pres"));
                
				
				
				
							
			}
			
		}
        catch(Exception ex)
		{
			System.out.println("Exception : " +ex.getMessage());
        }
	}
	
	
	
	
	
	public void deletee()
	{
		String query = "DELETE from prescription where Pid='"+combo.getSelectedItem()+"';";
		System.out.println(query);
        try
		{
			Class.forName("com.mysql.jdbc.Driver");
			Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/h1.6", "root", "");
			Statement stm = con.createStatement();
			stm.execute(query);
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
			/*try
			{
			JFileChooser chooser = new JFileChooser();
            chooser.showOpenDialog(null);
			File f=chooser.getSelectedFile();
			String filename=f.getAbsolutePath();
			b.setText(filename);
			image=new ImageIcon(filename);
			}
			catch(Exception ex)
			{
				System.out.println("Exception : " +ex.getMessage());
			}*/
			
			
		}
		
		else if(elementText.equals(deleteButton.getText()))
		{
			deletee();
			
			
			
		}
		
		if(elementText.equals(Bback.getText()))
		{
			AdminPat a1=new AdminPat();
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
