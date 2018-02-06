import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.lang.*;
import java.util.*;
import java.sql.*;

class Prescription extends JFrame implements ActionListener 
{
	private JPanel panel;
	private JButton Bback,Bexit;
	private JLabel Lpname,Ldname,Ldet,imgLabel;
	private JTextArea Tpres;
	public String name,id,dname,dpres;
	private ImageIcon image,image1;
	public String s1;
	
	
	
	public Prescription(String name,String id)
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
		this.id=id;
	
		
		
		
		//Labels------------------------------------------
		Lpname=new JLabel("Hey "+name);
		Lpname.setBounds(200,100,100,100);
		panel.add(Lpname);
		
		Ldname=new JLabel();
		Ldname.setBounds(200,120,300,100);
		panel.add(Ldname);
		
		
		Ldet=new JLabel("Details");
		Ldet.setBounds(225,230,70,30);
		panel.add(Ldet);
		
		
		
		
		
		
		
		//TextField-------------------
		Tpres=new JTextArea();
		JScrollPane scrool=new JScrollPane(Tpres);
		scrool.setBounds(225,260,270,250);
		
		
		
		//Buttions------------------------------------
		
		
		Bback=new JButton("Back");
		Bback.setBounds(280,520,100,30);
		Bback.addActionListener(this);
		panel.add(Bback);
		
		Bexit=new JButton("Exit");
		Bexit.setBounds(400,520,100,30);
		Bexit.addActionListener(this);
		panel.add(Bexit);
		
		
		
		//JComboBox----------------------------
		
		
		image = new ImageIcon(s1);
		imgLabel = new JLabel(image);
		imgLabel.setBounds(20,20,100,100);
		panel.add(imgLabel);
		
		
		
		
		try {  
			Class.forName("com.mysql.jdbc.Driver");  

			Connection conn= DriverManager.getConnection("jdbc:mysql://localhost:3306/h1.6", "root", "");  
			Statement st = conn.createStatement();

			ResultSet r=st.executeQuery("select * from prescription where `Pid`='"+id+"'");

		while (r.next()) 
		{  

		dname=r.getString("Dname");  
		dpres=r.getString("pres");
		s1=r.getString("picture");
		Ldname.setText(dname+" Has given you the prescription below");
		}
		Tpres.setText(dpres);
		panel.add(scrool);


		conn.close();
    } catch (Exception e) 
	{  
		JOptionPane.showMessageDialog(null,"Failed to Connect to Database","Error Connection", JOptionPane.WARNING_MESSAGE);  
		
	}  
		
		
		
		
		
	
		this.add(panel);
		
		
		
		
	}
	
	public void actionPerformed(ActionEvent ae)
	{
		String elementText = ae.getActionCommand();
		
		
		if(elementText.equals(Bback.getText()))
		{
			LoginForm lf=new LoginForm();
			this.setVisible(false);
			lf.setVisible(true);
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