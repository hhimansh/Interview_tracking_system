package com.wipro.its.listener;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import javax.swing.JOptionPane;

import com.wipro.its.service.HRPanelClass;
import com.wipro.its.ui.HRSubmitRating;
import com.wipro.its.util.DBUtil;

public class HRSubmitRatingListener implements ActionListener
{
	HRSubmitRating rate;
	HRPanelClass t;
	PreparedStatement pst;
	ResultSet rs;
	Connection con = DBUtil.getDBConnection("");
	
	public HRSubmitRatingListener(HRSubmitRating rate) 
	{
		this.rate=rate;
	}

	@Override
	public void actionPerformed(ActionEvent e)
	{
		t=new HRPanelClass();
		
		if(e.getSource()==rate.b1)  
		{	
			try
			{
				String interviewID = rate.t1.getSelectedItem()+"";
				String cmd = "SELECT empHRID FROM ITS_TBL_Interview_Schedule WHERE InterviewID = ?";
				pst = con.prepareStatement(cmd);
				pst.setString(1, interviewID);
				rs = pst.executeQuery();
				if(rs.next())
				{
					if(rs.getString(1)==null)
					{
						JOptionPane.showMessageDialog(null, "The candidate was not in HR interview");
						rate.dispose();
					}
					else
					{
						boolean b=t.HRsubmitRatings(rate.t1.getSelectedItem()+"",rate.t2.getSelectedItem()+"",Float.parseFloat(rate.t3.getSelectedItem().toString()));
						if(b==true)
						{
							JOptionPane.showMessageDialog(rate, "Successfully updated");
							rate.dispose();
						}
						else if(b==false)
						{
							JOptionPane.showMessageDialog(rate, "Not updated");
						}
					}
				}
			}
			catch(Exception e1)
			{
//				e1.printStackTrace();
			}
		}
		
		if(e.getSource()==rate.b2)
		{
			rate.dispose();
		}
	}
	
}
