package com.wipro.its.service;

import java.util.ArrayList;
import java.util.Date;

import com.wipro.its.bean.CandidateBean;
import com.wipro.its.bean.InterviewScheduleBean;
import com.wipro.its.dao.TechDAOClass;

public class TechPanelClass implements TechPanel 
{
	TechDAOClass techDAO;
	ArrayList<CandidateBean> cBeanlist;
	InterviewScheduleBean sBean;
	
	@Override
	public ArrayList<CandidateBean> viewCandidates(String techID, Date interviewDate) 
	{
		techDAO=new TechDAOClass();
		cBeanlist=new ArrayList<CandidateBean>();
		cBeanlist=techDAO.fetchCandidateDetails(techID, interviewDate);

		return cBeanlist;
		
	}

	@Override
	public boolean submitRatings(String interviewID, String techID, float rating)
	{	
		techDAO=new TechDAOClass();	
		boolean b=techDAO.setRatings(interviewID, techID, rating);
		return b;
	}

	@Override
	public InterviewScheduleBean viewFinalResults(String interviewID)
	{
		techDAO = new TechDAOClass();
		sBean=new InterviewScheduleBean();
		sBean=techDAO.fetchFinalResults(interviewID);
		return sBean;
	}
	@Override
	public CandidateBean viewCandidateInfo(String candidateID)
	{
		CandidateBean cb = new CandidateBean();
		techDAO = new TechDAOClass();
		cb = techDAO.viewCandidateInfo(candidateID);
		return cb;
	}
}