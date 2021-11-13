package com.wipro.its.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import com.wipro.its.ui.schedule_tech;
import com.wipro.its.util.DBUtil;

public class ScheduleDAO {
	PreparedStatement pst;
	ResultSet rs;
	Connection con = DBUtil.getDBConnection("");
	schedule_tech st;
	
	public ScheduleDAO(schedule_tech st)
	{
		this.st = st;
	}
	
	public void candId()
	{
		try
		{
			pst = con.prepareStatement("SELECT candidateID FROM ITS_TBL_Candidate");
			rs = pst.executeQuery();
			while(rs.next())
			{
				st.t1.addItem(rs.getString(1));
			}
		}
		catch(Exception e)
		{
//			e.printStackTrace();
		}
	}
	
	public void techId()
	{
		try
		{
			pst = con.prepareStatement("SELECT techId FROM ITS_TBL_TechPanel");
			rs = pst.executeQuery();
			while(rs.next())
			{
				st.t2.addItem(rs.getString(1));
			}
		}
		catch(Exception e)
		{
//			e.printStackTrace();
		}
	}
	
	public void subjects()
	{
		try
		{
			pst = con.prepareStatement("SELECT Subjects FROM ITS_TBL_TechPanel WHERE techId = ?");
			pst.setString(1, st.t2.getSelectedItem().toString());
			rs = pst.executeQuery();
			
			st.t3.removeAllItems();
			
			while(rs.next())	
			{
				st.t3.addItem(rs.getString(1));
			}
		}
		catch(Exception e)
		{
//			e.printStackTrace();
		}
	}
}