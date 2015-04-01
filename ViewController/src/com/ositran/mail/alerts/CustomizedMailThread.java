package com.ositran.mail.alerts;

import java.util.List;

import org.apache.log4j.Logger;

public class CustomizedMailThread extends Thread
{
    private final Logger logger = Logger.getLogger(CustomizedMailThread.class);
    
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
                
                
            }
            catch (Exception e)
            {
                logger.error("run() ");
            }
            //SenderMail mail = new SenderMail();
            
            
            
        }
        if (logger.isDebugEnabled()) {logger.debug("-run()");}
    } //run
    
} //CustomizedMailThread
