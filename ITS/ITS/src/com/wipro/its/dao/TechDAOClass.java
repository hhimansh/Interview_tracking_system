package com.wipro.its.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.Date;

import com.wipro.its.bean.CandidateBean;
import com.wipro.its.bean.InterviewScheduleBean;
import com.wipro.its.util.DBUtil;

public class TechDAOClass implements TechDAO
{
	PreparedStatement ps;
	ResultSet rs;
	Connection con = DBUtil.getDBConnection("");
	CandidateBean candBean;
	InterviewScheduleBean scheduleBean;

	@Override
	public ArrayList<CandidateBean> fetchCandidateDetails(String techID,Date interviewDate) 
	{

		try
		{
			candBean=new CandidateBean();
			ArrayList<CandidateBean> list=new ArrayList<CandidateBean>();

			String str="select c.candidateid,c.primaryskills,c.secondaryskills,c.experience,c.qualification,c.designation from its_tbl_candidate c join its_tbl_interview_schedule s on(c.candidateid=s.candidateid) where techid=? and interviewDate=?";
			ps=con.prepareStatement(str);
			ps.setString(1, techID);
			ps.setDate(2, (java.sql.Date) interviewDate);
			rs=ps.executeQuery();
			while(rs.next())
			{
				candBean.setCandidateID(rs.getString(1));
				candBean.setPrimarySkills(rs.getString(2));
				candBean.setSecondarySkills(rs.getString(3));
				candBean.setExperience(rs.getDouble(4));
				candBean.setQualification(rs.getString(5));
				candBean.setDesignation(rs.getString(6));

				list.add(candBean);
			}
			return list;
		}
		catch(Exception e)
		{
//			e.printStackTrace();
			return null;
		}
	}

	@Override
	public boolean setRatings(String interviewID, String techID, float rating)
	{
		try
		{
			int row=0;
			String str="update its_tbl_interview_schedule set techrating=? where interviewID=? and techID=?";
			ps=con.prepareStatement(str);
			ps.setFloat(1,rating);
			ps.setString(2,interviewID);
			ps.setString(3,techID);
			row=ps.executeUpdate();
			if(row==1)
			{
				return true;
			}
			else
			{
				return false;
			}
		}
		catch(Exception e)
		{
//			e.printStackTrace();
			return false;
		}
	}

	@Override
	public InterviewScheduleBean fetchFinalResults(String interviewID)
	{
		try
		{
			String str="select candidateid, result from its_tbl_interview_schedule where interviewid=? and (SHARERESULT=1)";
			ps=con.prepareStatement(str);

			ps.setString(1,interviewID);
			rs=ps.executeQuery();

			if(rs.next())
			{
				scheduleBean=new InterviewScheduleBean();
				scheduleBean.setCandidateID(rs.getString(1));
				scheduleBean.setResult(rs.getString(2));

				return scheduleBean;
			}
			else return null;
		}
		catch(Exception e)
		{
//			e.printStackTrace();
			return null;
		}
	}
	
	@Override
	public CandidateBean viewCandidateInfo(String candidateID)
	{
		try
		{
			CandidateBean cb = new CandidateBean();
			String cmd = "SELECT * FROM ITS_TBL_Candidate WHERE CandidateID = ? AND Sharedetails IN (1,3)";
			ps = con.prepareStatement(cmd);
			ps.setString(1, candidateID);
			rs = ps.executeQuery();
			if(rs.next())
			{
				cb.setPrimarySkills(rs.getString(2));
				cb.setSecondarySkills(rs.getString(3));
				cb.setExperience(rs.getDouble(4));
				cb.setQualification(rs.getString(5));
				cb.setDesignation(rs.getString(6));
				cb.setNoticePeriod(rs.getInt(7));
				cb.setLocation(rs.getString(8));
				return cb;
			}
			else return null;
		}
		catch(Exception e)
		{
//			e.printStackTrace();
			return null;
		}
	}
}