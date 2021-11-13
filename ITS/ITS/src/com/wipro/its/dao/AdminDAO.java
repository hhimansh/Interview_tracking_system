package com.wipro.its.dao;

import java.util.ArrayList;

import com.wipro.its.bean.CandidateBean;
import com.wipro.its.bean.InterviewScheduleBean;
import com.wipro.its.bean.ProfileBean;

public interface AdminDAO {
	public String addCandidate(ProfileBean profileBean, CandidateBean candidateBean);
	public String techSchedule(InterviewScheduleBean interBean);
	public boolean HRSchedule(InterviewScheduleBean interBean);
	public boolean selectionDecision(String interviewID, int share);
	public boolean shareDetails(String candidateID, String panel);
	InterviewScheduleBean viewRatings(String interviewID);
	ArrayList<CandidateBean> viewCandidate(String skills, float experience, String qualification);
	int deleteInfo(String candidateID);
	int editInfo(CandidateBean cb);
}
