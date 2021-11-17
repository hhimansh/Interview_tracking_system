package com.wipro.its.listener;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import com.wipro.its.dao.UserDAOClass;
import com.wipro.its.ui.TechPanel;
import com.wipro.its.ui.SubmitRating;
import com.wipro.its.ui.ViewCandidate;
import com.wipro.its.ui.ViewInfo;
import com.wipro.its.ui.ViewResult;
import com.wipro.its.ui.change_pass1;
import com.wipro.its.ui.logout;
import com.wipro.its.util.UserClass;

public class TechPanel_lis implements MouseListener {
	TechPanel tp;
	UserClass uc;
	change_pass1 psw;
	public TechPanel_lis(TechPanel tp)
	{
		this.tp=tp;
	}
	
	@SuppressWarnings("unused")
	@Override
	public void mouseClicked(MouseEvent e)
	{
		if(e.getSource()==tp.ab4)
		{	
			psw= new change_pass1(TechPanel.userId1);
		}
		if(e.getSource()==tp.ab1)
		{
			ViewCandidate view=new ViewCandidate();
		}
		if(e.getSource()==tp.ab2)
		{
			SubmitRating rate=new SubmitRating();
		}
		if(e.getSource()==tp.ab3)
		{
			ViewResult result=new ViewResult();
		}
		if(e.getSource()==tp.l1)
		{
			String userId= tp.user.getText();
			UserDAOClass udao = new UserDAOClass();
			udao.checkLogout(userId);
			logout lp=new logout();
			tp.setVisible(false);
			lp.setVisible(true);

		}
		if(e.getSource()==tp.ab)
		{
			ViewInfo info=new ViewInfo();
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
