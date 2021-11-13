package com.wipro.its.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import com.wipro.its.util.DBUtil;

public class SequenceDAO {
	PreparedStatement pst;
	ResultSet rs;
	Connection con = DBUtil.getDBConnection("");
	public int getCandidateID()
	{
		try
		{
			pst = con.prepareStatement("SELECT its_seq_candidateID.NEXTVAL FROM dual");
			rs = pst.executeQuery();
			rs.next();
			int candidateID = rs.getInt(1);
			return candidateID;
		}
		catch(Exception e)
		{
//			e.printStackTrace();
			return 0;
		}
	}
	
	public int getInterviewID()
	{
		try
		{
			pst = con.prepareStatement("SELECT its_seq_interviewID.NEXTVAL FROM dual");
			rs = pst.executeQuery();
			rs.next();
			int interviewID = rs.getInt(1);
			return interviewID;
		}
		catch(Exception e)
		{
//			e.printStackTrace();
			return 0;
		}
	}
}