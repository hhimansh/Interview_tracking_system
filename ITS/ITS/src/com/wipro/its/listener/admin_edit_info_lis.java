package com.wipro.its.listener;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import javax.swing.JOptionPane;

import com.wipro.its.bean.CandidateBean;
import com.wipro.its.service.AdministratorClass;
import com.wipro.its.ui.admin_edit_info;
import com.wipro.its.util.DBUtil;

public class admin_edit_info_lis implements ActionListener {
	PreparedStatement pst;
	ResultSet rs;
	Connection con = DBUtil.getDBConnection("");
	
	admin_edit_info edit;
	public admin_edit_info_lis(admin_edit_info edit)
	{
		this.edit = edit;
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getSource()==edit.b1)
		{
			if(edit.t2.getText().length()==0)
				JOptionPane.showMessageDialog(edit, "Please enter the Primary Skills");
			else if(edit.t3.getText().length()==0)
				JOptionPane.showMessageDialog(edit, "Please enter the Secondary Skills");
			else if(edit.t4.getText().length()==0)
				JOptionPane.showMessageDialog(edit, "Please enter the Experience");
			else if(edit.t5.getText().length()==0)
				JOptionPane.showMessageDialog(edit, "Please enter the Qualification");
			else if(edit.t6.getText().length()==0)
				JOptionPane.showMessageDialog(edit, "Please enter the Designation");
			else if(edit.t7.getText().length()==0)
				JOptionPane.showMessageDialog(edit, "Please enter the Notice Period");
			else if(edit.t8.getText().length()==0)
				JOptionPane.showMessageDialog(edit, "Please enter the Location");
			else
			{
				AdministratorClass ac = new AdministratorClass();
				CandidateBean cb = new CandidateBean();
				cb.setCandidateID(edit.cb.getSelectedItem().toString());
				cb.setPrimarySkills(edit.t2.getText());
				cb.setSecondarySkills(edit.t3.getText());
				try
				{
					cb.setExperience(Double.parseDouble(edit.t4.getText()));
				}
				catch(Exception e1)
				{
					JOptionPane.showMessageDialog(edit, "Invalid experience");
				}

				cb.setQualification(edit.t5.getText());
				cb.setDesignation(edit.t6.getText());
				try
				{
					cb.setNoticePeriod(Integer.parseInt(edit.t7.getText()));
				}
				catch(Exception e1)
				{
					JOptionPane.showMessageDialog(edit, "Invalid Notice Period");
				}
				cb.setLocation(edit.t8.getText());
				if(edit.t9.getSelectedIndex()==0)
					cb.setShareDetails(0);
				else if(edit.t9.getSelectedIndex()==1)
					cb.setShareDetails(1);
				else if(edit.t9.getSelectedIndex()==2)
					cb.setShareDetails(2);
				else if(edit.t9.getSelectedIndex()==3)
					cb.setShareDetails(3);
				int result = ac.editInfo(cb);
				if(result>0)
				{
					JOptionPane.showMessageDialog(edit, "Details updated successfully");
					edit.dispose();
				}
				else JOptionPane.showMessageDialog(edit, "Details could not be updated");
			}
		}
		
		if(e.getSource()==edit.cb)
		{
			try
			{
				String cmd = "SELECT * FROM ITS_TBL_Candidate WHERE candidateID = ?";
				pst = con.prepareStatement(cmd);
				pst.setString(1, edit.cb.getSelectedItem().toString());
				rs = pst.executeQuery();
				rs.next();
				edit.t2.setText(rs.getString(2));
				edit.t3.setText(rs.getString(3));
				edit.t4.setText(rs.getString(4));
				edit.t5.setText(rs.getString(5));
				edit.t6.setText(rs.getString(6));
				edit.t7.setText(rs.getString(7));
				edit.t8.setText(rs.getString(8));
				if(rs.getString(9).equals("0"))
				{
					edit.t9.setSelectedIndex(0);
				}
				else if(rs.getString(9).equals("1"))
				{
					edit.t9.setSelectedIndex(1);
				}
				else if(rs.getString(9).equals("2"))
				{
					edit.t9.setSelectedIndex(2);
				}
				else if(rs.getString(9).equals("3"))
				{
					edit.t9.setSelectedIndex(3);
				}
			}
			catch(Exception e1)
			{
//				e1.printStackTrace();
			}
		}
	}
}