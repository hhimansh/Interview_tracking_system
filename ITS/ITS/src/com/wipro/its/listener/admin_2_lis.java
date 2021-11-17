package com.wipro.its.listener;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import com.wipro.its.ui.add_details;
import com.wipro.its.ui.admin_2;
import com.wipro.its.ui.admin_delete_info;
import com.wipro.its.ui.admin_edit_info;

public class admin_2_lis implements MouseListener{

	admin_2 a;
	
	public admin_2_lis(admin_2 a)
	{
		this.a=a;
	}
	@Override
	public void mouseClicked(MouseEvent e) {
		if(e.getSource()==a.l1)
		{
			add_details ad=new add_details();
			ad.setVisible(true);
			a.setVisible(false);
		}
		if(e.getSource()==a.l2)
		{
			admin_edit_info ad=new admin_edit_info();
			ad.setVisible(true);
			a.setVisible(false);
		}
		
		if(e.getSource()==a.l3)
		{
			admin_delete_info ad=new admin_delete_info();
			ad.setVisible(true);
			a.setVisible(false);
		}
		
	}

	@Override
	public void mouseEntered(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseExited(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mousePressed(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseReleased(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

}
