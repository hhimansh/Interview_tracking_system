package com.wipro.its.listener;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import com.wipro.its.ui.admin_delete_info;
import com.wipro.its.ui.admin_edit_info;
import com.wipro.its.ui.view_button;

public class view_button_lis implements MouseListener{

	view_button v;
	
	public view_button_lis(view_button v)
	{
		this.v=v;
	}

	@Override
	public void mouseClicked(MouseEvent e) {
		
		if(e.getSource()==v.l2)
		{
			admin_delete_info d=new admin_delete_info();
			d.setVisible(true);
			v.setVisible(false);
		}
		
		if(e.getSource()==v.l1)
		{
			admin_edit_info d = new admin_edit_info();
			d.setVisible(true);
			v.setVisible(false);
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
