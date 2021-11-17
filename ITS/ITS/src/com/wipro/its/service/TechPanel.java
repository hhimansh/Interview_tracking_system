package com.wipro.its.service;

import java.util.ArrayList;
import java.util.Date;

import com.wipro.its.bean.CandidateBean;
import com.wipro.its.bean.InterviewScheduleBean;

public interface TechPanel {
	ArrayList<CandidateBean> viewCandidates(String techID, Date interviewDate);
	boolean submitRatings(String interviewID, String techID, float rating);
	InterviewScheduleBean viewFinalResults(String interviewID);
	CandidateBean viewCandidateInfo(String candidateID);
}