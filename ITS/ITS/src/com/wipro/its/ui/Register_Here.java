package com.wipro.its.ui;
import javax.swing.*;

import com.wipro.its.listener.Register_Here_lis;

import java.awt.*;

@SuppressWarnings("serial")
public class Register_Here extends JFrame{

	JLabel label0,label1,label2,label3,label4;	
	public JTextField t1;
	public JPasswordField password, confirmPassword;
	public JComboBox<String> userType;
	public JButton submit,reset;
	JPanel pan;
	public JLabel last1,last2,last3;
	Register_Here_lis reglis = new Register_Here_lis(this);

	public Register_Here()
	{
		setLayout(null);
		setSize(450,400);
		setLocation(230,240);
		setTitle("Register Here");

		pan=new JPanel();
		pan.setLayout(null);
		pan.setBounds(0,0,450,370);


		label0=new JLabel("Register Here");
		label0.setFont(new Font("Times New Roman",Font.BOLD,30));
		label0.setForeground(Color.BLACK);



		label1=new JLabel("Enter Username ");
		t1=new JTextField();

		label2=new JLabel("Enter Password");
		password=new JPasswordField();

		label3=new JLabel("Re-enter Password");
		confirmPassword = new JPasswordField();

		label4=new JLabel("Enter Usertype");
		userType=new JComboBox<>();
		userType.addItem("Admin");
		userType.addItem("Tech");
		userType.addItem("HR");
		
		last1= new JLabel();
		last2= new JLabel();
		last3= new JLabel();
	

		submit=new JButton("Submit");
		reset=new JButton("Reset");

		pan.setBackground(Color.PINK);
		label0.setBounds(120,5,200,50);
		
		label4.setBounds(40,60,130,20);
		userType.setBounds(180,60,130,20);
		
		label1.setBounds(40,100,130,20);
		t1.setBounds(180,100,130,20);

		label2.setBounds(40,140,130,20);
		password.setBounds(180,140,130,20);

		label3.setBounds(40,180,130,20);
		confirmPassword.setBounds(180,180,130,20);

		last1.setForeground(Color.RED);
		last2.setForeground(Color.RED);
		last3.setForeground(Color.RED);
		
		last1.setBounds(40, 210,440, 20);
		last2.setBounds(40, 230,440, 20);
		last3.setBounds(40, 250,440, 20);
		
		submit.setBounds(80,300,80,20);
		reset.setBounds(180,300,80,20);    

		pan.add(label0);
		pan.add(label1);
		pan.add(t1);
		pan.add(label2);
		pan.add(password);
		pan.add(label3);
		pan.add(confirmPassword);
		pan.add(label4);
		pan.add(userType);
		pan.add(last1);
		pan.add(last2);
		pan.add(last3);
	
		pan.add(submit);
		pan.add(reset);


		add(pan);

		setVisible(true);
		setResizable(false);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		
		submit.addActionListener(reglis);
		reset.addActionListener(reglis);
	}

	@SuppressWarnings("unused")
	public static void main(String []args)
	{
		Register_Here h=new Register_Here();
	}
}