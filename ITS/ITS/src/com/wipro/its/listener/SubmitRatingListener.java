package com.wipro.its.listener;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JOptionPane;

import com.wipro.its.service.TechPanelClass;
import com.wipro.its.ui.SubmitRating;


public class SubmitRatingListener implements ActionListener
{
	SubmitRating rate;
	TechPanelClass t;
	
	public SubmitRatingListener(SubmitRating rate) 
	{
		this.rate=rate;
	}

	@Override
	public void actionPerformed(ActionEvent e)
	{
		t=new TechPanelClass();
		
		if(e.getSource()==rate.b1)  
		{
			
			
			boolean b=t.submitRatings(rate.t1.getSelectedItem()+"",rate.t2.getSelectedItem()+"",Float.parseFloat(rate.t3.getSelectedItem().toString()));
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
		
		if(e.getSource()==rate.b2)
		{
			rate.dispose();
		}
		
	}
	
}
