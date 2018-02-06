import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;

class LoginForm extends JFrame implements ActionListener ,MouseListener
{
	JButton loginButton,exitButton,signUpButton;
	JPanel panel;
	JLabel Lid,Lpass,Ldia;
	JPasswordField Tpass;
	JTextField Tid;
	
	public LoginForm()
	{
		super("Login");
		this.setSize(650, 300);
		this.setLocationRelativeTo(null);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setResizable(false); 
		
		panel = new JPanel();
		panel.setLayout(null);
		panel.setBackground(Color.cyan);
		Lid=new JLabel("ID: ");
		Lid.setBounds(70,30,100,50);
		panel.add(Lid);
		Lpass=new JLabel("Password: ");
		Lpass.setBounds(70,70,100,70);
		panel.add(Lpass);
		Ldia=new JLabel("<html>Click here if you are</br> not a member</html>", SwingConstants.CENTER);
		Ldia.setBounds(500,30,110,70);
		panel.add(Ldia);
		Tid=new JTextField();
		Tid.setBounds(200,40,150,30);
		panel.add(Tid);
		Tpass=new JPasswordField();
		Tpass.setBounds(200,80,150,30);
		panel.add(Tpass);
		loginButton=new JButton("Login");
		loginButton.setBounds(70,200,100,30);
		loginButton.addActionListener(this);
		loginButton.addMouseListener(this);
		panel.add(loginButton);
		exitButton=new JButton("Exit");
		exitButton.setBounds(200,200,100,30);
		exitButton.addMouseListener(this);
		exitButton.addActionListener(this);
		panel.add(exitButton);
		signUpButton=new JButton("Sign Up");
		signUpButton.setBounds(500,110,100,100);
		signUpButton.addActionListener(this);
		signUpButton.addMouseListener(this);
		panel.add(signUpButton);
		
		
		this.add(panel);
		
	}
	
	public void check()
	{
		String sid=Tid.getText();
		String query = "SELECT `name`, `sex`, `email`, `id`, `password` ,`AreaOfExp`, `picture` , `uid` FROM `login`;";
		System.out.println("Somossa nai");
        Connection con=null;//for connection
        Statement st = null;//for query execution
		ResultSet rs = null;//to get row by row result from DB
        try
		{
			Class.forName("com.mysql.jdbc.Driver");//load driver
			con = DriverManager.getConnection("jdbc:mysql://localhost:3306/h1.6", "root", "");
			st = con.createStatement();//create statement
			rs = st.executeQuery(query);//getting result
					
			while(rs.next())
			{
                String name = rs.getString("name");
                String sex = rs.getString("sex");
				String email = rs.getString("email");
				String id = rs.getString("id");
				String password = rs.getString("password");
				String picture = rs.getString("picture");
				String aoe = rs.getString("AreaOfExp");
				//String pic = rs.getString("picture");
				
				
				int uid = rs.getInt("uid");
				
				if(id.equals(Tid.getText()) && password.equals(Tpass.getText()) && uid==3)
				{
					        
							PatientsDetails pd = new PatientsDetails(name,sex,email,id,password,picture,uid);
							this.setVisible(false);
							pd.setVisible(true);
							
						
					
				}
				else if(id.equals(Tid.getText()) && password.equals(Tpass.getText()) && uid==0)
				{
							
							Admin1 dp = new Admin1();
							this.setVisible(false);
							dp.setVisible(true);
							
						
					
				}
				else if(id.equals(Tid.getText()) && password.equals(Tpass.getText()) && uid==2)
				{
					
							DoctorPrescription dp = new DoctorPrescription(name,sex,email,id,password,picture,uid,aoe);
							this.setVisible(false);
							dp.setVisible(true);
							
						
					
				}
				else
				{
					
					
					
				}
									
			}
			
		}
        catch(Exception ex)
		{
			System.out.println("Exception : " +ex.getMessage());
        }
        finally
		{
            try
			{
                if(rs!=null)
					rs.close();

                if(st!=null)
					st.close();

                if(con!=null)
					con.close();
            }
            catch(Exception ex){}
        }
	}
	
	
	public void actionPerformed(ActionEvent ae)
	{
		String elementText = ae.getActionCommand();
		
		if(elementText.equals(signUpButton.getText()))
		{
			PatientInfo p=new PatientInfo();
			p.setVisible(true);
			this.setVisible(false);
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
		else if(elementText.equals(loginButton.getText()))
		{
			check();
		}
	}
	
	public void mouseEntered(MouseEvent me)
	{
		if(me.getSource().equals(loginButton))
		{
			loginButton.setBackground(Color.GREEN);
		}
		else if(me.getSource().equals(signUpButton))
		{
			signUpButton.setBackground(Color.BLUE);
		}
		if(me.getSource().equals(exitButton))
		{
			exitButton.setBackground(Color.RED);
		}
	}
	public void mouseExited(MouseEvent me)
	{
		if(me.getSource().equals(loginButton))
		{
			loginButton.setBackground(null);
		}
		else if(me.getSource().equals(signUpButton))
		{
			signUpButton.setBackground(null);
		}
		if(me.getSource().equals(exitButton))
		{
			exitButton.setBackground(null);
		}
	}
	public void mouseReleased(MouseEvent me){	}
	public void mousePressed(MouseEvent me){	}
	public void mouseClicked(MouseEvent me){	}
	
	
}