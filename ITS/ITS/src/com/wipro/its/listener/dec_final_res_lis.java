package com.wipro.its.listener;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import javax.swing.JOptionPane;

import com.wipro.its.service.AdministratorClass;
import com.wipro.its.ui.dec_final_res;
import com.wipro.its.util.DBUtil;

public class dec_final_res_lis implements ActionListener {
	dec_final_res res;
	public static String minRating="1.0";
	
	PreparedStatement pst;
	ResultSet rs;
	Connection con = DBUtil.getDBConnection("");
	
	public dec_final_res_lis(dec_final_res res)
	{
		this.res = res;
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getSource()==res.b1)
		{
			AdministratorClass ad = new AdministratorClass();
			minRating = res.overallCombo.getSelectedItem().toString();
			String choice = res.shareChoice.getSelectedItem().toString();
			int a = 0;
			if(choice.equals("Yes"))
				a = 1;
			boolean value = ad.declareResults(res.t1.getSelectedItem().toString(), a);
			if(value==true)
			{
				JOptionPane.showMessageDialog(res, "Result Declared");
				res.dispose();
			}
			else JOptionPane.showMessageDialog(res, "Result could not be declared");
		}
		
		if(e.getSource()==res.b2)
		{
			res.dispose();
		}
	}
}