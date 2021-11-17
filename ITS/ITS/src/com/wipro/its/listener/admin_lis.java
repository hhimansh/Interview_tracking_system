package com.wipro.its.listener;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import com.wipro.its.dao.UserDAOClass;
import com.wipro.its.ui.admin;
import com.wipro.its.ui.admin_2;
import com.wipro.its.ui.change_pass;
import com.wipro.its.ui.dec_final_res;
import com.wipro.its.ui.logout;
import com.wipro.its.ui.schedule_HR;
import com.wipro.its.ui.schedule_tech;
import com.wipro.its.ui.share_info;
import com.wipro.its.ui.view_details;
import com.wipro.its.ui.view_ratings;
import com.wipro.its.util.UserClass;

public class admin_lis implements MouseListener{
	admin ad;
	UserClass uClass;
	change_pass cpass;
	view_details vvd;
	public admin_lis(admin ad)
	{
		this.ad=ad;

	}
	@Override
	public void mouseClicked(MouseEvent e) {
		if(e.getSource()==ad.l2)
		{
			String userId= ad.user.getText();
			UserDAOClass udao = new UserDAOClass();
			udao.checkLogout(userId);
			logout lp=new logout();
			ad.setVisible(false);
			lp.setVisible(true);
		}

		if(e.getSource()==ad.ab1)
		{
			admin_2 ad = new admin_2();
			ad.setVisible(true);
		}

		if(e.getSource()==ad.ab2)
		{
			vvd=new view_details();
			vvd.setVisible(true);
		}
		if(e.getSource()==ad.ab8)
		{
			cpass=new change_pass(admin.userId);
			cpass.setVisible(true);
		}
		if(e.getSource()==ad.ab6)
		{
			view_ratings vvd=new view_ratings();
			vvd.setVisible(true);
		}

		if(e.getSource()==ad.ab7)
		{
			dec_final_res vvd=new dec_final_res();
			vvd.setVisible(true); 
		}

		if(e.getSource()==ad.ab5)
		{
			share_info vvd=new share_info();
			vvd.setVisible(true);
		}
		if(e.getSource()==ad.ab3)
		{
			schedule_tech vvd=new schedule_tech();
			vvd.setVisible(true);
		}
		if(e.getSource()==ad.ab4)
		{
			schedule_HR vvd=new schedule_HR();
			vvd.setVisible(true);
		}

	}

	@Override
	public void mouseEntered(MouseEvent e) {

	}

	@Override
	public void mouseExited(MouseEvent e) {

	}

	@Override
	public void mousePressed(MouseEvent e) {

	}

	@Override
	public void mouseReleased(MouseEvent e) {

	}
	public static void main(String[] args) {
		new admin("");
	}
}