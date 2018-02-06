import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.lang.*;
import java.util.*;
import java.sql.*;

class AdminPat extends JFrame implements ActionListener,MouseListener
{
	
	private JPanel panel;
	private JLabel LWelcome,LWelcome2;
	private JCheckBox c1,c2;
	private ButtonGroup bg1;
	private JButton okButton,Bback,Bexit;
	public AdminPat()
	{
		super("Selection Page");
		this.setSize(550, 600);
		this.setLocationRelativeTo(null);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setResizable(false); 
		panel = new JPanel();
		panel.setLayout(null);
		panel.setBackground(Color.cyan);
		
		//Label------------------------
		
		
		
		
		LWelcome2=new JLabel("Choose your option and click Ok buttion.");
		LWelcome2.setBounds(150,300,250,30);
		panel.add(LWelcome2);
		
		c1 = new JCheckBox("Patent");
		c1.setBounds(180,330,80,30);
		c1.setBackground(null);
		panel.add(c1);
		
		
		c2 = new JCheckBox("Prescription");
		c2.setBounds(260,330,150,30);
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
				AdminPatMod apm=new AdminPatMod();
				this.setVisible(false);
				apm.setVisible(true);
			}
			else if(c2.isSelected())
			{
				AdminPres ap=new AdminPres();
				this.setVisible(false);
				ap.setVisible(true);
			}
			}
			catch(Exception ex)
			{
			System.out.println("Exception : " +ex.getMessage());
			}
		}
		else if(elementText.equals(Bback.getText()))
		{
			Admin1 ad=new Admin1();
			this.setVisible(false);
			ad.setVisible(true);
		}
		else if(elementText.equals(Bexit.getText()))
		{
			System.exit(0);
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
		if(me.getSource().equals(Bexit))
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
	public void mouseReleased(MouseEvent me){	}
	public void mousePressed(MouseEvent me){	}
	public void mouseClicked(MouseEvent me){	}
	

}
	
	
