import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.lang.*;
import java.util.*;
import java.sql.*;

class DoctorPrescription extends JFrame implements ActionListener 
{
	private JPanel panel;
	private JComboBox compat;
	private JLabel Lhead,LName,LAge,LSex,LDet,Ladv;
	private JLabel nName,nAge,nSex,nDet,imgLabel,imgLabel1;
	private JTextArea Tdet,TDadv;
	private JButton Bshow,Bsubmil,Bupdate,Bback,Bexit;
	private ImageIcon image,image1;
	public  String aoe,pid,pname,did,dname,pic,pic1;
	
	
	public DoctorPrescription(String name,String sex,String email,String id,String password,String picture,int uid,String aoe)
	{
		super("Advice");
		this.setSize(550, 600);
		this.setLocationRelativeTo(null);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setResizable(false); 
		panel = new JPanel();
		panel.setLayout(null);
		panel.setBackground(Color.cyan);
		this.aoe=aoe;
		this.dname=name;
		this.did=id;
		
		//value assign------------------------
		
		pic=picture;
		
		
		
		//Labels------------------------------------------]
		
		Ladv=new JLabel("Give your advice here:");
		Ladv.setBounds(20,250,150,50);
		panel.add(Ladv);
		
		Lhead=new JLabel("Patient's Details");
		Lhead.setBounds(300,100,150,50);
		panel.add(Lhead);
		
		LName=new JLabel("Name: ");
		LName.setBounds(300,180,50,50);
		panel.add(LName);
		
		
		LAge=new JLabel("Age: ");
		LAge.setBounds(300,220,50,50);
		panel.add(LAge);
		
		LSex=new JLabel("Sex: ");
		LSex.setBounds(300,260,50,50);
		panel.add(LSex);
		
		LDet=new JLabel("Patient's Problem: ");
		LDet.setBounds(300,300,250,50);
		panel.add(LDet);
		
		//Label From Database
        nName=new JLabel("n/a");
		nName.setBounds(350,180,150,50);
		panel.add(nName);
		
		
		nAge=new JLabel("n/a");
		nAge.setBounds(350,220,150,50);
		panel.add(nAge);
		
		nSex=new JLabel("n/a");
		nSex.setBounds(350,260,150,50);
		panel.add(nSex);
		
		
		//pic--------------
		
		image = new ImageIcon(pic);
		imgLabel = new JLabel(image);
		imgLabel.setBounds(20,20,100,100);
		panel.add(imgLabel);
		
		
		
		
		
		//TextField-------------------
		
		Tdet=new JTextArea();
		Tdet.setBounds(300,340,200,200);
		panel.add(Tdet);
		
		
		TDadv=new JTextArea();
		TDadv.setBounds(20,290,200,200);
		panel.add(TDadv);
		
		
		
		//Buttions------------------------------------
		
		Bback=new JButton("Back");
		Bback.setBounds(20,520,100,30);
		Bback.addActionListener(this);
		panel.add(Bback);
		
		Bexit=new JButton("Exit");
		Bexit.setBounds(140,520,100,30);
		Bexit.addActionListener(this);
		panel.add(Bexit);
		
		
		Bshow=new JButton("Show");
		Bshow.setBounds(400,150,100,30);
		Bshow.addActionListener(this);
		panel.add(Bshow);
		
		Bsubmil=new JButton("Submit");
		Bsubmil.setBounds(20,490,100,25);
		Bsubmil.addActionListener(this);
		panel.add(Bsubmil);
		
		
		
		//JComboBox----------------------------
		compat=new JComboBox();
		compat.setBounds(300,150,80,25);
		
		
		//Combo fill
		
		try {  
			Class.forName("com.mysql.jdbc.Driver");  

			Connection conn= DriverManager.getConnection("jdbc:mysql://localhost:3306/h1.6", "root", "");  
			Statement st = conn.createStatement();

			ResultSet r=st.executeQuery("select * from patientdetails where `docType`='"+aoe+"'");

		while (r.next()) 
		{  

		compat.addItem(r.getString(2));  
		}
		


		conn.close();
    } catch (Exception e) 
	{  
		JOptionPane.showMessageDialog(null,"Failed to Connect to Database","Error Connection", JOptionPane.WARNING_MESSAGE);  
		
	}  
		
		panel.add(compat);
		
		//---------------------------------------------
		 
		 try {  
			Class.forName("com.mysql.jdbc.Driver");  

			Connection conn= DriverManager.getConnection("jdbc:mysql://localhost:3306/h1.6", "root", "");  
			Statement st = conn.createStatement();

			ResultSet r=st.executeQuery("select * from patientdetails where `Id`='"+compat.getSelectedItem()+"'");

		while (r.next()) 
		{  

		image1 = new ImageIcon(pic1);
		imgLabel1 = new JLabel(image1);
		imgLabel1.setBounds(0,20,100,100);
		
		}
		panel.add(imgLabel1);  


		conn.close();
    } catch (Exception e) 
	{  
		JOptionPane.showMessageDialog(null,"Failed to Connect to Database","Error Connection", JOptionPane.WARNING_MESSAGE);  
		
	}  
		image1 = new ImageIcon(pic1);
		imgLabel1 = new JLabel(image1);
		imgLabel1.setBounds(0,20,100,100);
		panel.add(imgLabel1);
		
		

		this.add(panel);
		
	}
	
	
	//show button method 
	
	public void showw()
	{
		Connection con=null;//for connection
            Statement st = null;//for query execution
		   ResultSet rs = null;//to get row by row result from DB
			
			String query = "select * from patientdetails where `Id` = '"+(String)compat.getSelectedItem()+"'";
			
         try
		{
			Class.forName("com.mysql.jdbc.Driver");//load driver
			con = DriverManager.getConnection("jdbc:mysql://localhost:3306/h1.6", "root", "");
			st = con.createStatement();//create statement
			rs = st.executeQuery(query);//getting result
					
			while(rs.next())
			{
				pname=rs.getString("name");
				pid=rs.getString("id");
                
                nName.setText(rs.getString("name"));
                nAge.setText(rs.getString("age"));
                nSex.setText(rs.getString("sex"));

                Tdet.setText(rs.getString("details"));
				pic1=rs.getString("picture");
				
				System.out.println(pic1);
				
				
                
				
						
			}
			
		}
		catch(Exception ex)
		{
			System.out.println("Exception : " +ex.getMessage());
        }
		
        
		
	}
	
	
	// submit method------------------
	
	
	public void submitt()
	{
		
        String query = "INSERT INTO prescription (pres,Pid,Pname,Did,Dname,picture ) VALUES ('"+TDadv.getText()+"','"+pid+"','"+pname+"','"+did+"','"+dname+"','"+pic+"');";
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
			System.out.println("Exception : " +ex.getMessage());
        }
	}
	
	public void actionPerformed(ActionEvent ae)
	{
		String elementText = ae.getActionCommand();
		
		if(elementText.equals(Bshow.getText()))
		{
			showw();
		}
		else if(elementText.equals(Bsubmil.getText()))
		{
			submitt();
		}
		else if(elementText.equals(Bback.getText()))
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