package com.wipro.its.bean;

import java.util.Date;

public class InterviewScheduleBean {
	String interviewID;
	String candidateID;
	String Subject;
	String techID;
	Date interviewDate;
	String interviewTime;
	float techRating;
	String empHRID;
	Date empHRInterviewDate;
	String empHRInterviewTime;
	float empHRRating;
	String result;
	int shareResult;
	
	public String getInterviewID() {
		return interviewID;
	}
	public void setInterviewID(String interviewID) {
		this.interviewID = interviewID;
	}
	public String getCandidateID() {
		return candidateID;
	}
	public void setCandidateID(String candidateID) {
		this.candidateID = candidateID;
	}
	public String getSubject() {
		return Subject;
	}
	public void setSubject(String subject) {
		Subject = subject;
	}
	public String getTechID() {
		return techID;
	}
	public void setTechID(String techID) {
		this.techID = techID;
	}
	public Date getInterviewDate() {
		return interviewDate;
	}
	public void setInterviewDate(Date interviewDate) {
		this.interviewDate = interviewDate;
	}
	public String getInterviewTime() {
		return interviewTime;
	}
	public void setInterviewTime(String interviewTime) {
		this.interviewTime = interviewTime;
	}
	public float getTechRating() {
		return techRating;
	}
	public void setTechRating(float techRating) {
		this.techRating = techRating;
	}
	public String getEmpHRID() {
		return empHRID;
	}
	public void setEmpHRID(String empHRID) {
		this.empHRID = empHRID;
	}
	public Date getEmpHRInterviewDate() {
		return empHRInterviewDate;
	}
	public void setEmpHRInterviewDate(Date empHRInterviewDate) {
		this.empHRInterviewDate = empHRInterviewDate;
	}
	public String getEmpHRInterviewTime() {
		return empHRInterviewTime;
	}
	public void setEmpHRInterviewTime(String empHRInterviewTime) {
		this.empHRInterviewTime = empHRInterviewTime;
	}
	public float getEmpHRRating() {
		return empHRRating;
	}
	public void setEmpHRRating(float empHRRating) {
		this.empHRRating = empHRRating;
	}
	public String getResult() {
		return result;
	}
	public void setResult(String result) {
		this.result = result;
	}
	public int getShareResult() {
		return shareResult;
	}
	public void setShareResult(int shareResult) {
		this.shareResult = shareResult;
	}
}