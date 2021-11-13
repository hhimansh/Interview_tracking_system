package com.wipro.its.dao;

import java.util.ArrayList;
import java.util.Date;

import com.wipro.its.bean.CandidateBean;
import com.wipro.its.bean.InterviewScheduleBean;

public interface TechDAO 
{
	public ArrayList<CandidateBean> fetchCandidateDetails(String techID, Date interviewDate);
	public boolean setRatings(String interviewID, String techID, float rating);
	public InterviewScheduleBean fetchFinalResults(String interviewID);
	CandidateBean viewCandidateInfo(String candidateID);
}
