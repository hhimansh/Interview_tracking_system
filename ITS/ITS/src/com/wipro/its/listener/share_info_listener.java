package com.wipro.its.listener;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JOptionPane;

import com.wipro.its.service.AdministratorClass;
import com.wipro.its.ui.share_info;

public class share_info_listener implements ActionListener
{
	share_info info;
	AdministratorClass aUtil = new AdministratorClass();
	public share_info_listener(share_info info) 
	{
		this.info=info;
	}

	@Override
	public void actionPerformed(ActionEvent e) 
	{
		if(e.getSource()==info.b1)
		{
			boolean b=aUtil.shareCandidateDetails(info.t2.getSelectedItem()+"", "1");
			if(b==true)
			{
				JOptionPane.showMessageDialog(info,"Shared with Tech");
				info.dispose();
			}
			else
			{
				JOptionPane.showMessageDialog(info,"CandidateId does not exist");
			}
			
		}
		
		if(e.getSource()==info.b2)
		{
			boolean b=aUtil.shareCandidateDetails(info.t2.getSelectedItem()+"", "2");
			if(b==true)
			{
				JOptionPane.showMessageDialog(info,"Shared with HR");
			}
			else
			{
				JOptionPane.showMessageDialog(info,"CandidateId does not exist");
			}
			
		}
		
		if(e.getSource()==info.b3)
		{
			boolean b=aUtil.shareCandidateDetails(info.t2.getSelectedItem()+"", "3");
			if(b==true)
			{
				JOptionPane.showMessageDialog(info,"Shared with Both Tech and HR");
			}
			else
			{
				JOptionPane.showMessageDialog(info,"CandidateId does not exist");
			}
			
		}
		
		if(e.getSource()==info.b4)
		{
			boolean b=aUtil.shareCandidateDetails(info.t2.getSelectedItem()+"", "0");
			if(b==true)
			{
				JOptionPane.showMessageDialog(info,"Not Shared");
			}
			else
			{
				JOptionPane.showMessageDialog(info,"CandidateId does not exist");
			}
			
		}
		
		
	}
	
}