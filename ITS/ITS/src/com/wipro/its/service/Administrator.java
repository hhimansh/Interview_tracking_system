package com.wipro.its.service;

import java.util.ArrayList;

import com.wipro.its.bean.CandidateBean;
import com.wipro.its.bean.InterviewScheduleBean;
import com.wipro.its.bean.ProfileBean;

public interface Administrator {
	String addCandidate(ProfileBean profileBean, CandidateBean candidateBean);
	ArrayList<CandidateBean> viewCandidate(String skills, float experience, String qualification);
	boolean shareCandidateDetails(String candidateID, String panel);
	String scheduleInterviewForTech(InterviewScheduleBean interviewBean);
	boolean scheduleInterviewForHR(InterviewScheduleBean interviewBean);
	InterviewScheduleBean viewRatings(String interviewID);
	boolean declareResults(String interviewID, int share);
	int deleteInfo(String candidateID);
	int editInfo(CandidateBean candidateBean);
}
