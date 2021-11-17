package com.wipro.its.listener;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JOptionPane;

import com.wipro.its.bean.CandidateBean;
import com.wipro.its.service.TechPanelClass;
import com.wipro.its.ui.ViewInfo;

public class ViewInfoListener implements ActionListener
{
	ViewInfo info;
	public ViewInfoListener(ViewInfo info)
	{
		this.info=info;
	}
	
	
	@Override
	public void actionPerformed(ActionEvent e) 
	{
		if(e.getSource()==info.button)
		{
			String candidateID = info.t1.getSelectedItem().toString();
			TechPanelClass tpc = new TechPanelClass();
			CandidateBean cb = tpc.viewCandidateInfo(candidateID);
			if(cb==null)
			{
				info.primarySkills.setVisible(false);
				info.l1.setVisible(false);
				
				info.secondarySkills.setVisible(false);
				info.l2.setVisible(false);
				
				info.experience.setVisible(false);
				info.l3.setVisible(false);
				
				info.qualification.setVisible(false);
				info.l4.setVisible(false);
				
				info.designation.setVisible(false);
				info.l5.setVisible(false);
				
				info.noticePeriod.setVisible(false);
				info.l6.setVisible(false);
				
				info.location.setVisible(false);
				info.l7.setVisible(false);
				JOptionPane.showMessageDialog(info, "Sorry! The details are not shared by admin");
			}
			else
			{
				info.l1.setText(cb.getPrimarySkills());
				info.primarySkills.setVisible(true);
				info.l1.setVisible(true);

				info.l2.setText(cb.getSecondarySkills());
				info.secondarySkills.setVisible(true);
				info.l2.setVisible(true);

				info.l3.setText(""+cb.getExperience());
				info.experience.setVisible(true);
				info.l3.setVisible(true);

				info.l4.setText(cb.getQualification());
				info.qualification.setVisible(true);
				info.l4.setVisible(true);

				info.l5.setText(cb.getDesignation());
				info.designation.setVisible(true);
				info.l5.setVisible(true);

				info.l6.setText(""+cb.getNoticePeriod());
				info.noticePeriod.setVisible(true);
				info.l6.setVisible(true);

				info.l7.setText(cb.getLocation());
				info.location.setVisible(true);
				info.l7.setVisible(true);
			}
		}	
	}
}