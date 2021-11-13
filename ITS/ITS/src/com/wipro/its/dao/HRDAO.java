package com.wipro.its.dao;

import java.util.ArrayList;
import java.util.Date;

import com.wipro.its.bean.CandidateBean;
import com.wipro.its.bean.InterviewScheduleBean;

public interface HRDAO 
{
	public ArrayList<CandidateBean> HRfetchCandidateDetails(String empHRID,Date empHRinterviewDate);
	public boolean HRsetRatings(String interviewID, String empHRID, float empHRrating);
	public InterviewScheduleBean HRfetchFinalResults(String interviewID);
	CandidateBean viewCandidateInfo(String candidateID);
}