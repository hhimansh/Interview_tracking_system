package com.wipro.its.service;

import java.util.ArrayList;
import java.util.Date;

import com.wipro.its.bean.CandidateBean;
import com.wipro.its.bean.InterviewScheduleBean;

public interface HRPanel {
	ArrayList<CandidateBean> HRviewCandidates(String empHRID, Date empHRInterviewDate);
	boolean HRsubmitRatings(String interviewID, String empHRID, float rating);
	InterviewScheduleBean HRviewFinalResults(String interviewID);
	CandidateBean viewCandidateInfo(String candidateID);
}