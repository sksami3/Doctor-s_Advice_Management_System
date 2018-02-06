import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.lang.*;
import java.util.*;
import java.sql.*;
import javax.swing.table.*;
import java.io.*;
import javax.swing.filechooser.FileSystemView;


class AdminDoc extends JFrame implements ActionListener
{
	
	private JPanel panel;
	private ImageIcon image;
	private JLabel LName,LId,LPass,LAoE,LDet,LUid,LSearch,imgLabel;
	private JPasswordField Tpass;
	private JTextField TName,TId,TPass,TAoE,TDet,TUid,txtSearch,b;
	private JButton insertButton,updateButton,deleteButton,clearButtion,showButton,picButton,Bback,Bexit;
	private JTable myTable;
	private JScrollPane tableScrollPane;
	private DefaultTableModel model;
	private JComboBox combo;
	public String value,pic;
	
	
	
	public AdminDoc()
	{
		super("Doctor Modification Page");
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
		LPass=new JLabel("Password: ");
		LPass.setBounds(30,280,70,30);
		panel.add(LPass);
		LAoE=new JLabel("Area Od Expertiece: ");
		LAoE.setBounds(30,320,70,30);
		panel.add(LAoE);
		LDet=new JLabel("Details: ");
		LDet.setBounds(30,360,70,30);
		panel.add(LDet);
		
		
		
		
		
		
		//TextFields-------------------------------------------
		
		txtSearch=new JTextField();
		txtSearch.setBounds(100,160,140,25);
		
		//image ------------------------------------
		
		image = new ImageIcon(pic);
				imgLabel = new JLabel(image);
				imgLabel.setBounds(0,0,100,100);
				panel.add(imgLabel);
		
		
		
		
		//----------------------------------
		txtSearch.addKeyListener(new KeyAdapter() {
        public void keyReleased(KeyEvent e) {
        Connection con=null;//for connection
            Statement st = null;//for query execution
		    ResultSet rs = null;//to get row by row result from DB
			String query = "select * from doctorinfo where `name` = '"+txtSearch.getText()+"'";
			String query1 = "select * from doctorinfo where `Id` = '"+txtSearch.getText()+"'";
			
			
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
                TPass.setText(rs.getString("password"));
                TAoE.setText(rs.getString("areaOfExp"));
                TDet.setText(rs.getString("details"));
                TUid.setText(rs.getString("uid"));
													
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
                TPass.setText(rs.getString("password"));
                TAoE.setText(rs.getString("areaOfExp"));
                TDet.setText(rs.getString("details"));
                TUid.setText(rs.getString("uid"));
													
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
		
		b=new JTextField();
		b.setBounds(0,0,140,25);
		b.setVisible(false);
		panel.add(b);
		
		
		TPass=new JPasswordField();
		TPass.setBounds(100,280,140,25);
		panel.add(TPass);
		
		TAoE=new JTextField();
		TAoE.setBounds(100,320,140,25);
		panel.add(TAoE);
		
		TDet=new JTextField();
		TDet.setBounds(100,360,140,25);
		panel.add(TDet);
		
		
		
		
		//combobox----------
		
		combo=new JComboBox();
		combo.setBounds(400,200,100,30);
		
		
		try {  
			Class.forName("com.mysql.jdbc.Driver");  

			Connection conn= DriverManager.getConnection("jdbc:mysql://localhost:3306/h1.6", "root", "");  
			Statement st = conn.createStatement();

			ResultSet r=st.executeQuery("select * from doctorinfo");

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
		picButton=new JButton("Insert");
		picButton.setBounds(410,140,70,30);
		picButton.addActionListener(new ActionListener() 
		{
        public void actionPerformed(ActionEvent ae) 
		{
            picChooser();
        }
		});
		panel.add(picButton);
		
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
		
		
		insertButton=new JButton("Insert");
		insertButton.setBounds(30,450,100,30);
		insertButton.addActionListener(this);
		panel.add(insertButton);
		
		updateButton=new JButton("Update");
		updateButton.setBounds(150,450,100,30);
		updateButton.addActionListener(this);
		panel.add(updateButton);
		
		deleteButton=new JButton("Delete");
		deleteButton.setBounds(270,450,100,30);
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
	
	public void picChooser()
	{
		
		try
			{
			JFileChooser chooser = new JFileChooser();
            chooser.showOpenDialog(null);
			File f=chooser.getSelectedFile();
			String filename=f.getAbsolutePath().substring(f.getAbsolutePath().lastIndexOf("\\")+1);
			
			
			b.setText(filename);
			pic=filename;
			//image=new ImageIcon(filename);
			
			}
			catch(Exception ex)
			{
				System.out.println("Exception : " +ex.getMessage());
			}
			finally
			{
				/*image = new ImageIcon("imran");
				imgLabel = new JLabel(image);
				imgLabel.setBounds(400,20,100,100);
				panel.add(imgLabel);*/
				
			}
	}
	
	
	//Insert method--------------------------------------
	public void insertt()
	{
		int x=2;
		String query1 = "INSERT INTO doctorinfo (name,Id,password,areaOfExp,details,picture,uid) VALUES ('"+TName.getText()+"','"+TId.getText()+"','"+TPass.getText()+"','"+TAoE.getText()+"','"+TDet.getText()+"','"+pic+"',"+x+");";
			String query2 = "INSERT INTO login (name,id,password,AreaOfExp,picture,uid) VALUES ('"+TName.getText()+"','"+TId.getText()+"','"+TPass.getText()+"','"+TAoE.getText()+"','"+pic+"',"+x+");";
			System.out.println("Added on db");
        try
		{
			Class.forName("com.mysql.jdbc.Driver");
			Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/h1.6", "root", "");
			Statement stm = con.createStatement();
			stm.execute(query1);
			stm.execute(query2);
			stm.close();
			con.close();
			System.out.println("Inserted");		
		}
        catch(Exception ex)
		{
			System.out.println("Exception : " +ex.getMessage());
        }
	}
	
	//show method-------------------------------------
	
	public void showw()
	{
		Connection con=null;//for connection
            Statement st = null;//for query execution
		   ResultSet rs = null;//to get row by row result from DB
			value=(String)combo.getSelectedItem();
			System.out.println(value);
			String query = "select * from doctorinfo where `name` = '"+(String)combo.getSelectedItem()+"'";
			
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
                TPass.setText(rs.getString("password"));
                TAoE.setText(rs.getString("areaOfExp"));
                TDet.setText(rs.getString("details"));
                TUid.setText(rs.getString("uid"));
				String s1=rs.getString("picture");
				
				System.out.println(s1);
				
							
			}
			
		}
        catch(Exception ex)
		{
			System.out.println("Exception : " +ex.getMessage());
        }
	}
	
	
	//update ------------------------------------
	
	public void updatee()
	{
		String name =TName.getText();
		String id =TId.getText();
		String pass =TPass.getText();
		String aoe =TAoE.getText();
		String details =TDet.getText();
		//String name =TName.getText();
		
		
		
		
		Connection con=null;//for connection
            Statement st = null;//for query execution
		   ResultSet rs = null;//to get row by row result from DB
			value=(String)combo.getSelectedItem();
			System.out.println(value);
			String query = "UPDATE doctorinfo SET `name`='"+name+"',`password`='"+pass+"',`areaOfExp`='"+aoe+"',`picture`='"+pic+"',`details`='"+details+"' where `Id`='"+id+"'";     
			String query1 = "UPDATE login SET `name`='"+name+"',`password`='"+pass+"',`areaOfExp`='"+aoe+"',`picture`='"+pic+"' where `id`='"+id+"'";
			
         try
		{
			Class.forName("com.mysql.jdbc.Driver");//load driver
			con = DriverManager.getConnection("jdbc:mysql://localhost:3306/h1.6", "root", "");
			st = con.createStatement();//create statement
			//rs = st.executeQuery(query);//getting result
			st.executeUpdate(query);
			st.executeUpdate(query1);
			
			
			
		}
        catch(Exception ex)
		{
			System.out.println("Exception : " +ex.getMessage());
        }
		
	}
	
	public void deletee()
	{
		String query = "DELETE from doctorinfo where Id='"+TId.getText()+"';";
		String query1 = "DELETE from login where id='"+TId.getText()+"';";
		//System.out.println(query);
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
		
		
		else if(elementText.equals(insertButton.getText()))
		{
			int choice=JOptionPane.showConfirmDialog(null,"Do you want to Insert?","Insert",JOptionPane.YES_NO_OPTION);
			if(choice== JOptionPane.YES_OPTION)
			{
			    insertt();
				JOptionPane.showMessageDialog(null,"Inserted","show",JOptionPane.PLAIN_MESSAGE);
			}
		  else
		   { 
			
		   }
			
			//showw();
			
			
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
		else if(elementText.equals(updateButton.getText()))
		{
			int choice=JOptionPane.showConfirmDialog(null,"Do you want to update?","Update",JOptionPane.YES_NO_OPTION);
			if(choice== JOptionPane.YES_OPTION)
			{
			    updatee();
				JOptionPane.showMessageDialog(null,"Updated","show",JOptionPane.PLAIN_MESSAGE);
			}
		  else
		   { 
			
		   }
			
			
			
		}
		else if(elementText.equals(deleteButton.getText()))
		{
			deletee();
			
			int choice=JOptionPane.showConfirmDialog(null,"Do you want to delete?","Delete",JOptionPane.YES_NO_OPTION);
			if(choice== JOptionPane.YES_OPTION)
			{
			    deletee();
				JOptionPane.showMessageDialog(null,"Deleted","show",JOptionPane.PLAIN_MESSAGE);
			}
		  else
		   { 
			
		   }
			
		}
		
		if(elementText.equals(Bback.getText()))
		{
			Admin1 a1=new Admin1();
			this.setVisible(false);
			a1.setVisible(true);
		}
		else if(elementText.equals(Bexit.getText()))
		{
			System.exit(0);
		}
		
		
		
		}
	
	
 }
