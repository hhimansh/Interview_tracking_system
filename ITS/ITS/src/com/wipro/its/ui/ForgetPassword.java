package com.wipro.its.ui;

import java.awt.Color;
import java.awt.Font;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

import com.wipro.its.listener.Forget_password_lis;

@SuppressWarnings("serial")
public class ForgetPassword extends JFrame
{
	public JLabel label0,label1,label2, label3, label4;	
	public JTextField t1;

	public JComboBox<String> userType;
	public JButton submit, cancel;
	JPanel pan;

	Forget_password_lis fpl=new Forget_password_lis(this);
	public ForgetPassword()
	{
		setLayout(null);
		setSize(450,400);
		setLocation(230,240);
		setTitle("Forgot Your Password");

		pan=new JPanel();
		pan.setLayout(null);
		pan.setBounds(0,0,450,370);


		label0=new JLabel("Get Your Password");
		label0.setFont(new Font("Times New Roman",Font.BOLD,30));
		label0.setForeground(Color.BLACK);



		label1=new JLabel("Enter UserID ");
		t1=new JTextField();



		label2=new JLabel("Enter Usertype");
		userType=new JComboBox<>();
		userType.addItem("Admin");
		userType.addItem("Tech");
		userType.addItem("HR");

		label3 = new JLabel("Password:");
		label3.setFont(new Font("Times New Roman",Font.PLAIN,30));
		label3.setVisible(false);
		label3.setForeground(Color.BLUE);
		
		label4 = new JLabel();
		label4.setFont(new Font("Times New Roman",Font.PLAIN,30));
		label4.setForeground(Color.BLUE);

		submit=new JButton("Submit");
		cancel = new JButton("Cancel");

		pan.setBackground(Color.PINK);
		label0.setBounds(120,5,380,50);

		label1.setBounds(40,60,130,20);
		t1.setBounds(180,60,130,20);

		label2.setBounds(40,100,130,20);
		userType.setBounds(180,100,130,20);

		submit.setBounds(120,150,80,20);
		cancel.setBounds(220,150,80,20);
		
		label3.setBounds(80, 220, 130, 30);
		label4.setBounds(220, 220, 130, 30);

		pan.add(label0);
		pan.add(label1);
		pan.add(t1);
		pan.add(label2);

		pan.add(userType);


		pan.add(submit);
		pan.add(cancel);
		
		pan.add(label3);
		pan.add(label4);


		add(pan);

		setVisible(true);
		setResizable(false);
		setDefaultCloseOperation(EXIT_ON_CLOSE);

		submit.addActionListener(fpl);
		cancel.addActionListener(fpl);
	}
	@SuppressWarnings("unused")
	public static void main(String args[])
	{
		ForgetPassword f= new ForgetPassword();
	}		
}