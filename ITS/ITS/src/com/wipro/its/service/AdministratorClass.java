package com.wipro.its.service;

import java.util.ArrayList;

import com.wipro.its.bean.CandidateBean;
import com.wipro.its.bean.InterviewScheduleBean;
import com.wipro.its.bean.ProfileBean;
import com.wipro.its.dao.AdministratorDAO;

public class AdministratorClass implements Administrator {
	AdministratorDAO adao = new AdministratorDAO();
	ArrayList<CandidateBean>a=new ArrayList<>();
	
	@Override
	public String addCandidate(ProfileBean profileBean, CandidateBean candidateBean) {
		if(profileBean==null)
			return null;
		if(profileBean.getFirstName()==null || profileBean.getFirstName().isEmpty())
			return null;
		if(profileBean.getLastName()==null || profileBean.getLastName().isEmpty())
			return null;
		if(profileBean.getGender()==null || profileBean.getGender().isEmpty())
			return null;
		if(profileBean.getStreet()==null || profileBean.getStreet().isEmpty())
			return null;
		if(profileBean.getLocation()==null || profileBean.getLocation().isEmpty())
			return null;
		if(profileBean.getCity()==null || profileBean.getCity().isEmpty())
			return null;
		if(profileBean.getState()==null || profileBean.getState().isEmpty())
			return null;
		if(profileBean.getPincode()==null || profileBean.getPincode().isEmpty())
			return null;
		if(profileBean.getMobileNo()==null || profileBean.getMobileNo().isEmpty())
			return null;
		if(profileBean.getMobileNo().length()!=10)
			return null;
		if(profileBean.getEmailID()==null || profileBean.getEmailID().isEmpty())
			return null;
		
		if(candidateBean==null)
			return null;
		if(candidateBean.getLocation()==null || candidateBean.getLocation().isEmpty())
			return null;
		String s = adao.addCandidate(profileBean, candidateBean);
		return s;
	}

	@Override
	public ArrayList<CandidateBean> viewCandidate(String skills, float experience, String qualification) {
		if(experience==0)
			return null;
		 a=adao.viewCandidate(skills, experience, qualification);
		  return a;
	}

	@Override
	public boolean shareCandidateDetails(String candidateID, String panel) 
	{
		boolean b=adao.shareDetails(candidateID, panel);
		return b;
	}

	@Override
	public String scheduleInterviewForTech(InterviewScheduleBean interviewBean) {
		String s = adao.techSchedule(interviewBean);
		return s;
	}

	@Override
	public boolean scheduleInterviewForHR(InterviewScheduleBean interviewBean) {
		boolean a = adao.HRSchedule(interviewBean);
		return a;
	}

	@Override
	public InterviewScheduleBean viewRatings(String interviewID) {
		InterviewScheduleBean is=adao.viewRatings(interviewID);
		return is;
		
	}

	@Override
	public boolean declareResults(String interviewID, int share) {
		boolean value = adao.selectionDecision(interviewID, share);
		return value;
	}
	@Override
	public int deleteInfo(String candidateID)
	{
		int res=adao.deleteInfo(candidateID);
	    return res;
	}
	@Override
	public int editInfo(CandidateBean candidateBean)
	{
		if(candidateBean==null)
			return 0;
		if(candidateBean.getPrimarySkills()==null || candidateBean.getPrimarySkills().isEmpty())
			return 0;
		if(candidateBean.getSecondarySkills()==null || candidateBean.getSecondarySkills().isEmpty())
			return 0;
		if(candidateBean.getQualification()==null || candidateBean.getQualification().isEmpty())
			return 0;
		if(candidateBean.getDesignation()==null || candidateBean.getDesignation().isEmpty())
			return 0;
		if(candidateBean.getLocation()==null || candidateBean.getLocation().isEmpty())
			return 0;
		adao = new AdministratorDAO();
		int result = adao.editInfo(candidateBean);
		return result;
	}
}