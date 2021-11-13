package com.wipro.its.dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.Calendar;

import com.wipro.its.bean.CandidateBean;
import com.wipro.its.bean.InterviewScheduleBean;
import com.wipro.its.bean.ProfileBean;
import com.wipro.its.listener.dec_final_res_lis;
import com.wipro.its.util.DBUtil;

public class AdministratorDAO implements AdminDAO {
	SequenceDAO sdao;
	PreparedStatement pst;
	ResultSet rs;
	Connection con = DBUtil.getDBConnection("");
	@Override
	public String addCandidate(ProfileBean profileBean, CandidateBean candidateBean) {
		try
		{
			sdao = new SequenceDAO();
			int ID = sdao.getCandidateID();
			String firstName = profileBean.getFirstName();
			String candidateID = firstName.substring(0, 2).toUpperCase() + ID;
			
			String cmd = "INSERT INTO ITS_TBL_CANDIDATE VALUES (?,?,?,?,?,?,?,?,?)";
			pst = con.prepareStatement(cmd);
			pst.setString(1, candidateID);
			pst.setString(2, candidateBean.getPrimarySkills());
			pst.setString(3, candidateBean.getSecondarySkills());
			pst.setDouble(4, candidateBean.getExperience());
			pst.setString(5, candidateBean.getQualification());
			pst.setString(6, candidateBean.getDesignation());
			pst.setInt(7, candidateBean.getNoticePeriod());
			pst.setString(8, candidateBean.getLocation());
			pst.setInt(9, candidateBean.getShareDetails());
			
			int n = pst.executeUpdate();
			
			cmd = "INSERT INTO ITS_TBL_USER_PROFILE VALUES (?,?,?,?,?,?,?,?,?,?,?,?)";
			pst = con.prepareStatement(cmd);
			pst.setString(1, candidateID);
			pst.setString(2, profileBean.getFirstName());
			pst.setString(3, profileBean.getLastName());
			
			java.util.Date udate = profileBean.getDateOfBirth();
			java.sql.Date sdate = new Date(udate.getTime());
			pst.setDate(4, sdate);
			
			pst.setString(5, profileBean.getGender());
			pst.setString(6, profileBean.getStreet());
			pst.setString(7, profileBean.getLocation());
			pst.setString(8, profileBean.getCity());
			pst.setString(9, profileBean.getState());
			pst.setString(10, profileBean.getPincode());
			pst.setString(11, profileBean.getMobileNo());
			pst.setString(12, profileBean.getEmailID());
			int m = pst.executeUpdate();
			
			if(n>0 && m>0)
				return "SUCCESS";
			else return "FAIL";
		}
		catch(Exception e)
		{
//			e.printStackTrace();
			return null;
		}
	}

	@Override
	public String techSchedule(InterviewScheduleBean interBean) {
		try
		{
			java.util.Date dt = interBean.getInterviewDate();
			java.util.Date date = Calendar.getInstance().getTime();
			if(date.after(dt))
			{
				return "FAIL";
			}
			
			sdao = new SequenceDAO();
			int id = sdao.getInterviewID();
			String interviewId = interBean.getSubject().substring(0, 2).toUpperCase() + id;
			
			String cmd = "SELECT InterviewDate, InterviewTime FROM ITS_TBL_Interview_Schedule WHERE TechId = ?";
			pst = con.prepareStatement(cmd);
			pst.setString(1, interBean.getTechID());
			rs = pst.executeQuery();
			while(rs.next())
			{
				java.sql.Date sdate = rs.getDate(1);
				java.util.Date udate = new java.util.Date(sdate.getTime());
				if(udate.equals(interBean.getInterviewDate()))
				{
					if(rs.getString(2).equals(interBean.getInterviewTime()))
						return "FAIL";
				}
			}
			
			cmd = "INSERT INTO ITS_TBL_Interview_Schedule (InterviewID, CandidateID, Subject, TechID, InterviewDate, InterviewTime) VALUES (?,?,?,?,?,?)";
			pst = con.prepareStatement(cmd);
			
			pst.setString(1, interviewId);
			pst.setString(2, interBean.getCandidateID());
			pst.setString(3, interBean.getSubject());
			pst.setString(4, interBean.getTechID());
			
			java.util.Date udate = interBean.getInterviewDate();
			java.sql.Date sdate = new Date(udate.getTime());
			pst.setDate(5, sdate);
			
			pst.setString(6, interBean.getInterviewTime());
			int n = pst.executeUpdate();
			con.commit();
			if(n>0)
			{
				return "SUCCESS";
			}
			else return "FAIL";
		}
		catch(Exception e)
		{
//			e.printStackTrace();
			return null;
		}
	}

	@Override
	public boolean HRSchedule(InterviewScheduleBean interBean) {
		try
		{
			String cmd = "SELECT empHRInterviewDate, empHRInterviewTime FROM ITS_TBL_Interview_Schedule WHERE empHRID = ?";
			pst = con.prepareStatement(cmd);
			pst.setString(1, interBean.getEmpHRID());
			rs = pst.executeQuery();
			while(rs.next())
			{
				if(rs.getDate(1) != null)
				{
					java.sql.Date sdate = rs.getDate(1);
					java.util.Date udate = new java.util.Date(sdate.getTime());
					if(udate.equals(interBean.getEmpHRInterviewDate()))
					{
						if(rs.getString(2).equals(interBean.getEmpHRInterviewTime()))
							return false;
					}
				}
			}
			
			cmd = "SELECT interviewDate, interviewTime FROM ITS_TBL_Interview_Schedule WHERE candidateID=?";
			pst = con.prepareStatement(cmd);
			pst.setString(1, interBean.getCandidateID());
			rs = pst.executeQuery();
			if(rs.next())
			{
				if(rs.getDate(1) != null)
				{
					java.sql.Date sdate = rs.getDate(1);
					java.util.Date udate = new java.util.Date(sdate.getTime());
					if(udate.after(interBean.getEmpHRInterviewDate()))
					{
						return false;
					}
					else if(udate.equals(interBean.getEmpHRInterviewDate()))
					{
						String []tech = rs.getString(2).split(":");
						String []hr = interBean.getEmpHRInterviewTime().split(":");
						int techhrs = Integer.parseInt(tech[0]);
						int techmins = Integer.parseInt(tech[1]);
						int hrhrs = Integer.parseInt(hr[0]);
						int hrmins = Integer.parseInt(hr[1]);
						if(techhrs>hrhrs)
						{
							return false;
						}
						else if((techhrs==hrhrs)&&(techmins>=hrmins))
						{
							return false;
						}
						else if((techhrs==hrhrs)&&(hrmins-techmins<=0))
						{
							return false;
						}
					}
				}
			}
			
			cmd = "UPDATE ITS_TBL_Interview_Schedule SET empHRID = ?, empHRInterviewDate = ?, empHRInterviewTime = ? WHERE CandidateID = ?";
			pst = con.prepareStatement(cmd);
			
			pst.setString(1, interBean.getEmpHRID());
			
			java.util.Date udate = interBean.getEmpHRInterviewDate();
			java.sql.Date sdate = new Date(udate.getTime());
			pst.setDate(2, sdate);
			
			pst.setString(3, interBean.getEmpHRInterviewTime());
			pst.setString(4, interBean.getCandidateID());
			int n = pst.executeUpdate();
			con.commit();
			if(n>0)
			{
				return true;
			}
			else return false;
		}
		catch(Exception e)
		{
//			e.printStackTrace();
			return false;
		}
	}

	@Override
	public boolean selectionDecision(String interviewID, int share) {
		try
		{
			String cmd = "UPDATE ITS_TBL_Interview_Schedule SET ShareResult = ? WHERE InterviewID = ?";
			pst = con.prepareStatement(cmd);
			pst.setInt(1, share);
			pst.setString(2, interviewID);
			pst.executeUpdate();
			con.commit();
			
			cmd = "SELECT TechRating, empHRRating FROM ITS_TBL_Interview_Schedule WHERE InterviewID = ?";
			pst = con.prepareStatement(cmd);
			pst.setString(1, interviewID);
			rs = pst.executeQuery();
			if(rs.next())
			{
				double overall = rs.getDouble(1) + rs.getDouble(2);
				
				if(overall>(Double.parseDouble(dec_final_res_lis.minRating)))
				{
					cmd = "UPDATE ITS_TBL_Interview_Schedule SET Result = ? WHERE InterviewID = ?";
					pst = con.prepareStatement(cmd);
					pst.setString(1, "Selected");
					pst.setString(2, interviewID);
					int a = pst.executeUpdate();
					
					if(a>0)
					{
						return true;
					}
					else return false;
				}
				else
				{
					cmd = "UPDATE ITS_TBL_Interview_Schedule SET Result = ? WHERE InterviewID = ?";
					pst = con.prepareStatement(cmd);
					pst.setString(1, "Not Selected");
					pst.setString(2, interviewID);
					int a = pst.executeUpdate();
					if(a>0)
					{
						return true;
					}
					else return false;
				}
			}
			else return false;
		}
		catch(Exception e)
		{
//			e.printStackTrace();
			return false;
		}
	}
	
	@Override
	public InterviewScheduleBean viewRatings(String interviewID)
	{

		try
		{
			InterviewScheduleBean isBean=new InterviewScheduleBean();
			float techRating,empHRRating;
			String str="select TECHRATING,EMPHRRATING from ITS_TBL_INTERVIEW_SCHEDULE where INTERVIEWID=?";
			pst=con.prepareStatement(str);
			pst.setString(1,interviewID);
			rs = pst.executeQuery();
			
			while(rs.next())
			{
			
				techRating=rs.getFloat(1);
				empHRRating=rs.getFloat(2);

				isBean.setTechRating(techRating);
				isBean.setEmpHRRating(empHRRating);

				
			}
			return isBean;
		}
		catch(Exception e)
		{
//			e.printStackTrace();
			return null;
		}
	}
	
	@Override
	public ArrayList<CandidateBean> viewCandidate(String skills,float experience,String qualification)
	{
		CandidateBean cb;
		ArrayList<CandidateBean> al=new ArrayList<CandidateBean>();
		String candid,ps,ss,qua;
		double exp;
		try{
			String str="select CANDIDATEID,PRIMARYSKILLS,SECONDARYSKILLS,EXPERIENCE,QUALIFICATION from ITS_TBL_CANDIDATE where PRIMARYSKILLS=? AND EXPERIENCE=? AND QUALIFICATION=?";
			pst=con.prepareStatement(str);
			pst.setString(1,skills);
			pst.setDouble(2,experience);
			pst.setString(3,qualification);

			rs=pst.executeQuery();

			while(rs.next())
			{
				cb = new CandidateBean();

				candid=rs.getString(1);
				ps=rs.getString(2);
				ss=rs.getString(3);
				exp=rs.getFloat(4);
				qua=rs.getString(5);

				cb.setCandidateID(candid);
				cb.setPrimarySkills(ps);
				cb.setSecondarySkills(ss);
				cb.setExperience(exp);
				cb.setQualification(qua);

				al.add(cb);
			}
			return al;
		}
		catch(Exception e) 
		{ 
//			e.printStackTrace();
			return null; 
		}

	}
	
	@Override
	public boolean shareDetails(String candidateID, String panel) 
	{
		try
		{
			String str="update its_tbl_candidate set sharedetails=? where candidateid=?";
			pst = con.prepareStatement(str);
			pst.setInt(1,Integer.parseInt(panel));
			pst.setString(2,candidateID);
			int row=pst.executeUpdate();
			if(row>0)
			{
				return true;
			}
			else
				return false;
		}
		catch(Exception e)
		{
//			e.printStackTrace();
			return false;
		}
		
	}
	
	@Override
	public int deleteInfo(String candidateID)
	{
		try
		{  String str="delete from ITS_TBL_CANDIDATE where CANDIDATEID=?";
		pst=con.prepareStatement(str);
		pst.setString(1,candidateID);
		int r=pst.executeUpdate();


		if(r==1)
			return 1;

		else
			return 0;
		}
		catch(Exception e)
		{
			return 0;
		}	
	}
	
	@Override
	public int editInfo(CandidateBean cb)
	{
		try
		{
			String cmd = "UPDATE ITS_TBL_Candidate SET PrimarySkills=? , Secondaryskills=?, Experience=?, Qualification=?, Designation=?, NoticePeriod=?, Location=?, ShareDetails=? WHERE candidateID=?";
			pst = con.prepareStatement(cmd);
			pst.setString(1, cb.getPrimarySkills());
			pst.setString(2, cb.getSecondarySkills());
			pst.setDouble(3, cb.getExperience());
			pst.setString(4, cb.getQualification());
			pst.setString(5, cb.getDesignation());
			pst.setInt(6, cb.getNoticePeriod());
			pst.setString(7, cb.getLocation());
			pst.setInt(8, cb.getShareDetails());
			pst.setString(9, cb.getCandidateID());
			
			int result = pst.executeUpdate();
			if(result>0)
				return 1;
			else return 0;
		}
		catch(Exception e)
		{
//			e.printStackTrace();
			return 0;
		}
	}
}