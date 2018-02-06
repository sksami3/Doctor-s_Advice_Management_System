import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.lang.*;
import java.util.*;
import java.sql.*;
import java.io.*;
import javax.swing.filechooser.FileSystemView;

class PatientsDetails extends JFrame implements ActionListener 
{
	private JPanel panel;
	private ImageIcon image;
	private JLabel LName,LAge,Lprec,Lextra,imgLabel;
	private JTextField TAge;
	private JTextArea TAprobDetails;
	private JButton submitButton,backButton,exitButton,presButton;
	private JComboBox cdc;
	public String name,sex,email,id,password,picture;
	public int uid;
	
	public PatientsDetails(String name,String sex,String email,String id,String password,String picture,int uid)
	{
		super("Patient's Information");
		this.setSize(550, 600);
		this.setLocationRelativeTo(null);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setResizable(false); 
		panel = new JPanel();
		panel.setLayout(null);
		panel.setBackground(Color.cyan);
		
		//value assign------------------------
		
		this.name=name;
		this.sex=sex;
		this.email=email;
		this.id=id;
		this.password=password;
		this.picture=picture;
		this.uid=uid;
		
		
		
		//Labels------------------------------------------
		
		LName=new JLabel("Hello "+name+"!!!");
		LName.setBounds(225,130,250,30);
		LName.setFont(new Font("Comic Sans MS", Font.ITALIC+Font.BOLD, 23));
		LName.setOpaque(true);
		LName.setBackground(null);
		panel.add(LName);
		Lextra=new JLabel("We are ready to help you.");
		Lextra.setBounds(225,160,150,30);
		panel.add(Lextra);
		
		LAge=new JLabel("Age: ");
		LAge.setBounds(225,200,50,30);
		panel.add(LAge);
		
		Lprec=new JLabel("Write your problem here: ");
		Lprec.setBounds(225,230,150,30);
		panel.add(Lprec);
		
		
		
		
		//Image-----------------------------
		
		
		image = new ImageIcon(picture);
		imgLabel = new JLabel(image);
		imgLabel.setBounds(400,20,100,100);
		panel.add(imgLabel);
		
		//TextField-------------------
		
		TAge=new JTextField();
		TAge.setBounds(260,202,50,25);
		panel.add(TAge);
		
		TAprobDetails=new JTextArea();
		TAprobDetails.setBounds(225,260,270,250);
		panel.add(TAprobDetails);
		
		//Buttions------------------------------------
		
		submitButton=new JButton("Submit");
		submitButton.setBounds(225,515,80,30);
		submitButton.addActionListener(this);
		panel.add(submitButton);
		
		backButton=new JButton("Back");
		backButton.setBounds(325,515,80,30);
		backButton.addActionListener(this);
		panel.add(backButton);
		
		exitButton=new JButton("Exit");
		exitButton.setBounds(425,515,80,30);
		exitButton.addActionListener(this);
		panel.add(exitButton);
		
		presButton=new JButton("Prescription");
		presButton.setBounds(20,400,150,150);
		presButton.addActionListener(this);
		panel.add(presButton);
		
		//JComboBox----------------------------
		
		cdc=new JComboBox();
		cdc.setBounds(50,140,100,20);
		
		
		try {  
			Class.forName("com.mysql.jdbc.Driver");  

			Connection conn= DriverManager.getConnection("jdbc:mysql://localhost:3306/h1.6", "root", "");  
			Statement st = conn.createStatement();

			ResultSet r=st.executeQuery("select * from doctorinfo");

		while (r.next()) 
		{  

		cdc.addItem(r.getString(5));  
		}
		panel.add(cdc);


		conn.close();
    } catch (Exception e) 
	{  
		JOptionPane.showMessageDialog(null,"Failed to Connect to Database","Error Connection", JOptionPane.WARNING_MESSAGE);  
		
	}  
		
		
		
	try {  
			Class.forName("com.mysql.jdbc.Driver");  

			Connection conn= DriverManager.getConnection("jdbc:mysql://localhost:3306/h1.6", "root", "");  
			Statement st = conn.createStatement();

			ResultSet r=st.executeQuery("select * from prescription where `Pid`='"+id+"' ");

		if (r.next()==false) 
		{  

		    //p= r.getString("pres"); 
			
				presButton.setVisible(false);
				
			
		}
		else
		{
			
		}
		


		conn.close();
    } 
	catch (Exception e) 
	{  
		JOptionPane.showMessageDialog(null,"Failed to Connect to Database","Error Connection", JOptionPane.WARNING_MESSAGE);  
		
	}
	finally{
	panel.add(presButton);
	}

			
		this.add(panel);
		
	}
		
		
		
		
	
	
	public void actionPerformed(ActionEvent ae)
	{
		String elementText = ae.getActionCommand();
		
		if(elementText.equals(exitButton.getText()))
		{
			int choice=JOptionPane.showConfirmDialog(null,"Do you want to exit?","Exit",JOptionPane.YES_NO_OPTION);
			if(choice== JOptionPane.YES_OPTION)
			{
			System.exit(0);
			}
			else{ 
			
		
			
			}
		}
		if(elementText.equals(backButton.getText()))
		{
			LoginForm lf=new LoginForm();
			this.setVisible(false);
			lf.setVisible(true);
		}
		else if(elementText.equals(submitButton.getText()))
		{
			int choice=JOptionPane.showConfirmDialog(null,"Do you want to submit?","Submit",JOptionPane.YES_NO_OPTION);
			if(choice== JOptionPane.YES_OPTION)
			{
			String query = "INSERT INTO patientdetails (Id,name,age,sex,details,docType,uid,picture ) VALUES ('"+id+"','"+name+"',"+Integer.parseInt(TAge.getText())+",'"+sex+"','"+TAprobDetails.getText()+"','"+cdc.getSelectedItem()+"','"+id+"','"+picture+"');";
			System.out.println("Added on db");
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
			JOptionPane.showMessageDialog(null,"Cannot give another problem at this moment","Error", JOptionPane.WARNING_MESSAGE);
			
			System.out.println("Exception : " +ex.getMessage());
        }
			
			
			
		    }
		else{ }
			
			
		}
		else if(elementText.equals(presButton.getText()))
		{
			Prescription pres=new Prescription(name,id);
			pres.setVisible(true);
			this.setVisible(false);
		}
	}
	
	
}