package com.wipro.its.listener;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.JOptionPane;

import com.wipro.its.bean.CandidateBean;
import com.wipro.its.dao.AdministratorDAO;
import com.wipro.its.service.AdministratorClass;
import com.wipro.its.ui.view_button;
import com.wipro.its.ui.view_details;

public class view_det_lis implements ActionListener
{
	view_details vd;
	AdministratorDAO adao;
	AdministratorClass ad;
	String digits = "^[0-9]*$";
	public ArrayList<CandidateBean> al = new ArrayList<CandidateBean>();

	public view_det_lis(view_details vd)
	{
		this.vd=vd;
	}
	@Override
	public void actionPerformed(ActionEvent e) {

		if(e.getSource()==vd.b1)
		{
			if(vd.t2.getText().length()==0)
				JOptionPane.showMessageDialog(vd, "Please enter Experience");
			else if(!(vd.t2.getText().matches(digits)))
			{
				JOptionPane.showMessageDialog(vd, "Invalid experience value");
			}
			else
			{
				try
				{
					ad=new AdministratorClass();
					al=ad.viewCandidate(vd.t1.getSelectedItem().toString(), Float.parseFloat(vd.t2.getText()), vd.t3.getSelectedItem().toString());
				}
				catch(Exception e1)
				{
					JOptionPane.showMessageDialog(vd, "Invalid details");
				}
//				Iterator<CandidateBean> it=al.iterator();
//				while(it.hasNext())
//				{
//					CandidateBean al1 = it.next();
//				}

				if(al!=null)
				{
					view_button vb=new view_button(al);
					vb.setVisible(true);
				}
				if(al==null)
					JOptionPane.showMessageDialog(vd,"null value");
			}
		}

		if(e.getSource()==vd.b2)
		{
			vd.dispose();
		}
	}
}