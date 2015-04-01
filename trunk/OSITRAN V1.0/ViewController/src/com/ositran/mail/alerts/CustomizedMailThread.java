package com.ositran.mail.alerts;

import com.ositran.mail.SenderMail;

import java.util.List;

import org.apache.log4j.Logger;

public class CustomizedMailThread extends Thread
{
    private final Logger logger = Logger.getLogger(CustomizedMailThread.class);
    
    private final int THREAD_SLEEP = 500; //milliseconds
    private boolean runMe = true;
    
    
    /**
     * This method runs the Customized mail thread.
     */
    public void run()
    {
        if (logger.isDebugEnabled()) {logger.debug("+run()");}
        while (runMe)
        {
            try
            {
                if (true)
                {
                    
                    if (logger.isInfoEnabled()) {logger.info("");}
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
                logger.error("run() Exception(" + e.getClass().getName() + ") -->" + ExceptionUtils.get);
            }
        }
        if (logger.isDebugEnabled()) {logger.debug("-run()");}
    } //run
    
} //CustomizedMailThread
