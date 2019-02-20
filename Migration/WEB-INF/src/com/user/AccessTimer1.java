package com.user;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.SimpleDateFormat;
import java.util.Calendar;

public class AccessTimer1 implements ActionListener 
{
	 int time=getTime();
	 
	 int i=0;
	 int live_time;
	 String tim="";
	 int seconds1;
	 AccessTimer1(String time1)
	 {
		 
		tim= time1;
		System.out.println(tim);
		 //live_time = Integer.parseInt(tim);
		 
		 String time2[]=tim.split(":");
		 int hour=Integer.parseInt(time2[0]);
		 int min=Integer.parseInt(time2[1]);
		 int sec=Integer.parseInt(time2[2]);
		  seconds1=hour*3600+min*60+sec;
		 
		 System.out.println(seconds1);
	 }
   	public void actionPerformed(ActionEvent e) 
   	{
   		
   		 if(i==0)
   		 {
   			 time=time+seconds1;
   			 //i=5;
   			System.out.println("Time Interval :"+time);
   		 }
   		 
   		System.out.println("Current Time  :"+getTime());
   	           if(time==getTime())
   	           {
   	        	   
   	        	//javax.swing.Timer access_timer=new javax.swing.Timer(0, new AccessTimer(val));
				//access_timer.stop();
   	        	  // LS3_DAO dao=new LS3_DAOImpl();
   	        	   //dao.uploadAccess(userid);
   	        	   
   	        	   System.out.println(" Timer event is working :"+time);
   	        	  // time=time+(60*1);
   	        	   //JOptionPane.showMessageDialog(null, "Automatic Replication Happened");
   	     	   
   	           }
   	}
	
   	public int getTime()
	{
		String timeformat = "HH:mm:ss";
		SimpleDateFormat obDateFormat = new SimpleDateFormat(timeformat);
		Calendar cal = Calendar.getInstance();
		String time= obDateFormat.format(cal.getTime());
		
		 String time1[]=time.split(":");
		 int hour=Integer.parseInt(time1[0]);
		 int min=Integer.parseInt(time1[1]);
		 int sec=Integer.parseInt(time1[2]);
		 int seconds=hour*3600+min*60+sec;
		
		  return seconds;
	}
   	public static void main(String[] args)
   	{
   		
   		AccessTimer1 i = new AccessTimer1("10");
   		
	}

 }
