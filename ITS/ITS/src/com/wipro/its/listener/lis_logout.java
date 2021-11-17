package com.wipro.its.listener;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import com.wipro.its.ui.LoginPage;
import com.wipro.its.ui.logout;

public class lis_logout implements MouseListener{
logout l;

   public lis_logout(logout l)
   {
   this.l=l;	
   }	
	
	@Override
	public void mouseClicked(MouseEvent e) {
		
		if(e.getSource()==l.label3)
		{
			LoginPage lp=new LoginPage();
			lp.setVisible(true);
			l.setVisible(false);
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
