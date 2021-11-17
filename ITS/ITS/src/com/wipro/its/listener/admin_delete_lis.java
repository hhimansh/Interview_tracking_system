package com.wipro.its.listener;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JOptionPane;

import com.wipro.its.service.AdministratorClass;
import com.wipro.its.ui.admin_delete_info;

public class admin_delete_lis implements ActionListener{

	admin_delete_info info;
	
	
	public admin_delete_lis(admin_delete_info info)
	{
		this.info=info;
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		
		if(e.getSource()==info.b)
		{
			AdministratorClass ac=new AdministratorClass();
			int res=ac.deleteInfo(info.cb.getSelectedItem().toString());
			
			if(res==0)
			{
				JOptionPane.showMessageDialog(info,"Candidate Info not available");
			}
			if(res==1)
			{
				JOptionPane.showMessageDialog(info,"Candidate Info Deleted");	
			}
		}
		
	}

}
