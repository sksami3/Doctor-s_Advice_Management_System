import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.lang.*;
import java.util.*;
import java.sql.*;
import java.io.*;
import javax.swing.filechooser.FileSystemView;

class PatientInfo extends JFrame implements ActionListener 
{
	private JButton insertButton,exitButton,backButton,clearButtion,idGenButton,picButton;
	private JPanel panel;
	private JLabel LName,LSex,LEmail,LId,LPass,imgLabel;
	private JPasswordField Tpass;
	private JTextField TName,TEmail,TId,TPass;
	private JComboBox sc;
	private ImageIcon image;
	
	public String pic;
	
	
	public PatientInfo()
	{
		super("Patient's Information");
		this.setSize(550, 600);
		this.setLocationRelativeTo(null);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setResizable(false); 
		panel = new JPanel();
		panel.setLayout(null);
		panel.setBackground(Color.cyan);
		String[] s={"Male","Female"};
		
		
		//Labels------------------------------------------
		
		LName=new JLabel("Name: ");
		LName.setBounds(70,200,70,30);
		panel.add(LName);
		LSex=new JLabel("Sex: ");
		LSex.setBounds(70,240,70,30);
		panel.add(LSex);
		LEmail=new JLabel("Email: ");
		LEmail.setBounds(70,280,70,30);
		panel.add(LEmail);
		LId=new JLabel("ID: ");
		LId.setBounds(70,320,70,30);
		panel.add(LId);
		LPass=new JLabel("Password: ");
		LPass.setBounds(70,360,70,30);
		panel.add(LPass);
		
		//TextFields-------------------------------------------
		
		TName=new JTextField();
		TName.setBounds(140,200,170,25);
		panel.add(TName);
		
		sc=new JComboBox(s);
		sc.setBounds(140,240,70,25);
		panel.add(sc);
		
		
		TEmail=new JTextField();
		TEmail.setBounds(140,280,170,25);
		panel.add(TEmail);
		
		TId=new JTextField();
		TId.setBounds(140,320,170,25);
		TId.setEditable(false);
		panel.add(TId);
		
		TPass=new JTextField();
		TPass.setBounds(140,360,170,25);
		panel.add(TPass);
		
		//Buttons--------------
		
		clearButtion=new JButton("Clear");
		clearButtion.setBounds(70,420,100,30);
		clearButtion.addActionListener(this);
		panel.add(clearButtion);
		
		idGenButton=new JButton("ID Generate");
		idGenButton.setBounds(310,322,100,20);
		idGenButton.addActionListener(this);
		panel.add(idGenButton);
		
		insertButton=new JButton("Done");
		insertButton.setBounds(170,500,100,30);
		insertButton.addActionListener(this);
		panel.add(insertButton);
		
		backButton=new JButton("Back");
		backButton.setBounds(290,500,100,30);
		backButton.addActionListener(this);
		panel.add(backButton);
		
		exitButton=new JButton("Exit");
		exitButton.setBounds(410,500,100,30);
		exitButton.addActionListener(this);
		panel.add(exitButton);
		
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
		
		
		this.add(panel);
		
	}
	
	//pic-----------------------
	
	public void picChooser()
	{
		
		try
			{
			JFileChooser chooser = new JFileChooser();
            chooser.showOpenDialog(null);
			File f=chooser.getSelectedFile();
			String filename=f.getAbsolutePath().substring(f.getAbsolutePath().lastIndexOf("\\")+1);
			
			
			
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
	
	//-----------------------------------------------------
	
	public void clearr()
	{
		TName.setText("");
		TId.setText("");
		TPass.setText("");
		TEmail.setText("");
		
	}
	
	
	
	
	
	public void insertPD()
	{
		
		String s1="null";
		int i=3;
        String query = "INSERT INTO login (name,sex,email,id,password,uid,picture) VALUES ('"+TName.getText()+"','"+sc.getSelectedItem()+"','"+TEmail.getText()+"','"+TId.getText()+"','"+TPass.getText()+"',"+i+",'"+pic+"');";
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
		
		if(elementText.equals(idGenButton.getText()))
		{
			Random r=new Random();
			int x1=r.nextInt(9);
			int x2=r.nextInt(99);
			int x7=r.nextInt(9999999);
			String s=""+x1+"-"+x7+"-"+x2;
			
			TId.setText(s);
		}
		else if(elementText.equals(insertButton.getText()))
		{
			int choice=JOptionPane.showConfirmDialog(null,"Do you want to insert","Insert",JOptionPane.YES_NO_OPTION);
			if(choice== JOptionPane.YES_OPTION)
			{
			    insertPD();
				JOptionPane.showMessageDialog(null,"Your Id is: "+TId.getText(),"show",JOptionPane.PLAIN_MESSAGE);
			}
		  else
		   { 
			
		   }
			
		}
		else if(elementText.equals(backButton.getText()))
		{
			LoginForm lf=new LoginForm();
			this.setVisible(false);
			lf.setVisible(true);
		}
		else if(elementText.equals(exitButton.getText()))
		{
			int choice=JOptionPane.showConfirmDialog(null,"Do you want to exit?","Exit",JOptionPane.YES_NO_OPTION);
			if(choice== JOptionPane.YES_OPTION)
			{
			System.exit(0);
			}
			else{ 
			
		
			
			}
		}
		else if(elementText.equals(clearButtion.getText()))
		{
			clearr();
		}
	}
	
	
}