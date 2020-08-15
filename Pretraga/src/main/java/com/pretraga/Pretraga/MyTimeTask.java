package com.pretraga.Pretraga;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Timer;
import java.util.TimerTask;

//The task which you want to execute
class MyTimeTask extends TimerTask
{

    public void run()
    {
        System.out.println("ispis na svakih 10 sec");
    }


public  void timer ()  {

    //the Date and time at which you want to execute
    DateFormat dateFormatter = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
    Date date = null;
	try {
		date = dateFormatter .parse("2020-08-15 21:05:45");
	} catch (ParseException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}

    //Now create the time and schedule it
    Timer timer = new Timer();

    //Use this if you want to execute it once
   // timer.schedule(new MyTimeTask(), date);

    //Use this if you want to execute it repeatedly
    int period = 10000;//10secs
    timer.schedule(new MyTimeTask(), date, period );
    
    run();
}
}