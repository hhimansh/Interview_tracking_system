package com.wipro.its.service;

import java.util.ArrayList;
import java.util.Date;

import com.wipro.its.bean.CandidateBean;
import com.wipro.its.bean.InterviewScheduleBean;
import com.wipro.its.dao.HRDAOClass;

public class HRPanelClass implements HRPanel
{
	HRDAOClass hrDAO;
	ArrayList<CandidateBean> cBeanlist;
	InterviewScheduleBean sBean;



	@Override
	public ArrayList<CandidateBean> HRviewCandidates(String empHRID, Date empHRInterviewDate) 
	{
		hrDAO=new HRDAOClass();
		cBeanlist=new ArrayList<CandidateBean>();
		
		cBeanlist=hrDAO.HRfetchCandidateDetails(empHRID, empHRInterviewDate);
		return cBeanlist;
	}

	@Override
	public boolean HRsubmitRatings(String interviewID, String empHRID, float rating) 
	{
		hrDAO=new HRDAOClass();
		boolean b=hrDAO.HRsetRatings(interviewID, empHRID, rating);
		return b;
	}

	@Override
	public InterviewScheduleBean HRviewFinalResults(String interviewID) {
		
		hrDAO=new HRDAOClass();
		sBean=new InterviewScheduleBean();
		
		sBean=hrDAO.HRfetchFinalResults(interviewID);
		return sBean;
		
	}
	@Override
	public CandidateBean viewCandidateInfo(String candidateID)
	{
		CandidateBean cb = new CandidateBean();
		hrDAO = new HRDAOClass();
		cb = hrDAO.viewCandidateInfo(candidateID);
		return cb;
	}
}