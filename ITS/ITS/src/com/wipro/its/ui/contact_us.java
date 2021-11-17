package com.wipro.its.ui;
import java.awt.Color;
import java.awt.Font;

import javax.swing.*;

@SuppressWarnings("serial")
public class contact_us extends JFrame{

	JLabel l1,l2,l3,l4,l5,l6,l7,l8,l9,l10;
	JPanel pan;
	
	
	public contact_us()
	{
		setSize(300,300);
		setLayout(null);
		setLocation(0,240);
		setTitle("Contact Us");
		pan=new JPanel();
		pan.setLayout(null);
		pan.setBounds(0,0,300,400);
		
		l1=new JLabel("Contact us at:");
		pan.setBackground(Color.pink);
	
		l1.setFont(new Font("Times New Roman",Font.BOLD,20));
		
	
		
		l2=new JLabel("venus.garg@wipro.com");
		l6=new JLabel("9876546378");
		
		l3=new JLabel("punit.kaur@wipro.com");
		l7=new JLabel("8935647899");
		
		l4=new JLabel("malika.jindal@wipro.com");
		l9=new JLabel("9045789384");
				
		l5=new JLabel("shafia.asif@wipro.com");
		l8=new JLabel("9012345678");
		
		l1.setBounds(80,5,200,50);
		
		l2.setBounds(25,60,150,20);
		l6.setBounds(200,60,130,20);

		l3.setBounds(25,100,150,20);
		l7.setBounds(200,100,130,20);

		l5.setBounds(25,140,150,20);
		l8.setBounds(200,140,130,20);
		
		l4.setBounds(25,180,150,20);
		l9.setBounds(200,180,130,20);
		
		pan.add(l1);
		pan.add(l2);
		pan.add(l3);
		pan.add(l4);
		pan.add(l5);
		pan.add(l6);
		pan.add(l7);
		pan.add(l8);
		pan.add(l4);
		pan.add(l9);
		
		add(pan);
		setVisible(true);
        setResizable(false);
	}
	@SuppressWarnings("unused")
	public static void main(String []args)
	{
		contact_us a=new contact_us();
	}
}