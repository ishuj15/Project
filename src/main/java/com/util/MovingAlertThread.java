package com.util;

public class MovingAlertThread  implements Runnable{
<<<<<<< HEAD
=======

>>>>>>> ac87088cf150d40ca3353aac3d1ea1f36ac98ad6
	@Override
	public void run() {
		// TODO Auto-generated method stub
		try {
<<<<<<< HEAD
			String alert="Please open ALERTS !!!!!";
			int width= 120;
			while(!Thread.currentThread().isInterrupted())
			{
				for(int i=0;i<5*alert.length();i++)
				{
					 System.out.print("\r" + " ".repeat(i) + alert);
	                    Thread.sleep(100); // Delay for movement effect
=======
			
			String alert="Please open ALERTS Urgently!!!!!!!";
			
			int width= 120;
			while(!Thread.currentThread().isInterrupted())
			{
				for(int i=0;i<alert.length();i++)
				{
					 System.out.print("\r" + " ".repeat(i) + alert);
	                    Thread.sleep(300); // Delay for movement effect
>>>>>>> ac87088cf150d40ca3353aac3d1ea1f36ac98ad6
	                    System.out.print("\r" + " ".repeat(width)); // Clear the line
				}
			}
			
		}catch(InterruptedException e)
		{
            //System.out.println("\nAlerts display interrupted.");

		}
		
	}

}
