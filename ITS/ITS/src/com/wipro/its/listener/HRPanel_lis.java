package com.wipro.its.listener;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import com.wipro.its.dao.UserDAOClass;
import com.wipro.its.ui.HRPanel;
import com.wipro.its.ui.HRSubmitRating;
import com.wipro.its.ui.HRViewCandidate;
import com.wipro.its.ui.HRViewInfo;
import com.wipro.its.ui.change_pass2;
import com.wipro.its.ui.logout;
import com.wipro.its.ui.viewResults_HR;

public class HRPanel_lis implements MouseListener{

	HRPanel hp;
	change_pass2 psw;
	
	public HRPanel_lis(HRPanel hp)
	{
		this.hp=hp;
	}

	@SuppressWarnings("unused")
	@Override
	public void mouseClicked(MouseEvent e)
	{
		if(e.getSource()==hp.ab4)
		{
			 psw= new change_pass2(HRPanel.userId2);
		}
		
		if(e.getSource()==hp.ab1)
		{
			HRViewCandidate view=new HRViewCandidate();
		}
		if(e.getSource()==hp.ab2)
		{
			HRSubmitRating rate=new HRSubmitRating();
		}
		if(e.getSource()==hp.ab3)
		{
			viewResults_HR result=new viewResults_HR();
		}
		if(e.getSource()==hp.l1)
		{
			String userId= hp.user.getText();
			UserDAOClass udao = new UserDAOClass();
			udao.checkLogout(userId);
		    logout lp=new logout();
			hp.setVisible(false);
			lp.setVisible(true);
		}
		if(e.getSource()==hp.ab)
		{
			HRViewInfo info=new HRViewInfo();
		}
	}

	@Override
	public void mouseEntered(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseExited(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mousePressed(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseReleased(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	
}
