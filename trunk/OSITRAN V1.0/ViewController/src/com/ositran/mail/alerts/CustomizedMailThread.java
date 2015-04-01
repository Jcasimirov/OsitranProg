package com.ositran.mail.alerts;

import com.ositran.mail.SenderMail;

import java.util.logging.Logger;

public class CustomizedMailThread extends Thread
{
    private final int THREAD_SLEEP = 500; //milliseconds
    private boolean runMe = true;
    
    
    /**
     * This method runs the Customized mail thread.
     */
    public void run()
    {
        while (runMe)
        {
            try
            {
                if (true)
                {
                    
                    SenderMail senderMail = new SenderMail(null);
                    senderMail.start();
                }
                else
                {
                    Thread.sleep(THREAD_SLEEP);   
                }
            }
            catch (Exception e)
            {
                
            }
        }
    } //run
    
} //CustomizedMailThread
