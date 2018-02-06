import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.lang.*;
import java.util.*;
import java.sql.*;

class Admin1 extends JFrame implements ActionListener,MouseListener
{
	
	private JPanel panel;
	private JLabel LWelcome,LWelcome2;
	private JCheckBox c1,c2;
	private ButtonGroup bg1;
	private JButton okButton,Bback,Bexit;
	public Admin1()
	{
		super("Welcome Admin");
		this.setSize(550, 600);
		this.setLocationRelativeTo(null);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setResizable(false); 
		panel = new JPanel();
		panel.setLayout(null);
		panel.setBackground(Color.cyan);
		
		//Label------------------------
		
		LWelcome=new JLabel("Welcome Admin!!!");
		LWelcome.setBounds(180,200,250,30);
		LWelcome.setFont(new Font("Comic Sans MS", Font.ITALIC+Font.BOLD, 25));
		LWelcome.setOpaque(true);
		LWelcome.setBackground(null);
		panel.add(LWelcome);
		
		
		LWelcome2=new JLabel("Choose your option and click Ok buttion.");
		LWelcome2.setBounds(150,300,250,30);
		panel.add(LWelcome2);
		
		c1 = new JCheckBox("Doctor");
		c1.setBounds(180,330,80,30);
		panel.add(c1);
		c1.setBackground(null);
		
		
		c2 = new JCheckBox("Patient");
		c2.setBounds(260,330,80,30);
		c2.setBackground(null);
		panel.add(c2);
		
		bg1=new ButtonGroup();
		bg1.add(c1);
		bg1.add(c2);
		
		
		okButton=new JButton("Ok");
		okButton.setBounds(220,450,80,30);
		okButton.addActionListener(this);
		okButton.addMouseListener(this);
		panel.add(okButton);
		
		Bback=new JButton("Back");
		Bback.setBounds(280,520,100,30);
		Bback.addActionListener(this);
		Bback.addMouseListener(this);
		panel.add(Bback);
		
		Bexit=new JButton("Exit");
		Bexit.setBounds(400,520,100,30);
		Bexit.addActionListener(this);
		Bexit.addMouseListener(this);
		panel.add(Bexit);
		
		
		this.add(panel);
	}
	
	public void actionPerformed(ActionEvent ae)
	{
		String elementText = ae.getActionCommand();
		
		if(elementText.equals(okButton.getText()))
		{
			try{
			if(c1.isSelected())
			{
				AdminDoc ad=new AdminDoc();
				ad.setVisible(true);
				this.setVisible(false);
			}
			else if(c2.isSelected())
			{
				AdminPat adp=new AdminPat();
				adp.setVisible(true);
				this.setVisible(false);
			}
			}
			catch(Exception ex)
			{
			System.out.println("Exception : " +ex.getMessage());
			}
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
	
	public void mouseEntered(MouseEvent me)
	{
		if(me.getSource().equals(okButton))
		{
			okButton.setBackground(Color.GREEN);
		}
		else if(me.getSource().equals(Bback))
		{
			Bback.setBackground(Color.YELLOW);
		}
		if(me.getSource().equals(Bexit))
		{
			Bexit.setBackground(Color.RED);
		}
	}
	public void mouseExited(MouseEvent me)
	{
		if(me.getSource().equals(okButton))
		{
			okButton.setBackground(null);
		}
		else if(me.getSource().equals(Bback))
		{
			Bback.setBackground(null);
		}
		else if(me.getSource().equals(Bback))
		{
			Bback.setBackground(null);
		}
		if(me.getSource().equals(Bexit))
		{
			
			Bexit.setBackground(null);
		}
	}
	public void mouseReleased(MouseEvent me){	}
	public void mousePressed(MouseEvent me){	}
	public void mouseClicked(MouseEvent me){	}
	

}
	
	
