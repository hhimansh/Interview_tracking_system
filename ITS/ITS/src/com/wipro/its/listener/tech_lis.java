package com.wipro.its.listener;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
import java.text.SimpleDateFormat;

import javax.swing.JOptionPane;

import com.wipro.its.bean.InterviewScheduleBean;
import com.wipro.its.dao.ScheduleDAO;
import com.wipro.its.service.AdministratorClass;
import com.wipro.its.ui.schedule_tech;

public class tech_lis implements ActionListener, FocusListener {

	schedule_tech st;
	
	public tech_lis(schedule_tech st)
	{
		this.st=st;
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		
			if(e.getSource()==st.b1)
			{
				AdministratorClass ad = new AdministratorClass();
				InterviewScheduleBean isb = new InterviewScheduleBean();
				isb.setCandidateID(st.t1.getSelectedItem().toString());
				
				isb.setTechID(st.t2.getSelectedItem().toString());
				
				isb.setSubject(st.t3.getSelectedItem().toString());
				
				try
				{
					String dob = st.d.getSelectedItem().toString() +"/"+ st.m.getSelectedItem().toString() +"/"+ st.yr.getSelectedItem().toString();
					SimpleDateFormat sd = new SimpleDateFormat("dd/MM/yyyy");
					java.util.Date date = sd.parse(dob);
					isb.setInterviewDate(date);
				}
				catch(Exception e1)
				{
//					e1.printStackTrace();
				}
				
				isb.setInterviewTime(st.hrs.getSelectedItem().toString()+":"+st.mins.getSelectedItem().toString());
				
				String result = ad.scheduleInterviewForTech(isb);
				if(result.equals("SUCCESS"))
				{
					JOptionPane.showMessageDialog(st,"Technical Interview Scheduled Successfully");
					st.dispose();
				}
				if(result.equals("FAIL"))
				{
					JOptionPane.showMessageDialog(st,"Interview could not be scheduled");
				}
			}
			
			if(e.getSource()==st.b2)
			{
				st.dispose();
			}
		}

	@Override
	public void focusGained(FocusEvent e) {
		if(e.getSource()==st.t3)
		{
			ScheduleDAO sdao = new ScheduleDAO(st);
			sdao.subjects();
		}
	}

	@Override
	public void focusLost(FocusEvent e) {
		
	}
}