package com.ositran.mail.alerts;

import java.util.List;

import org.apache.commons.lang.exception.ExceptionUtils;
import org.apache.log4j.Logger;

public class AlertErrorMailThread extends Thread
{
    private final Logger logger = Logger.getLogger(AlertErrorMailThread.class);
    
    private final int THREAD_SLEEP = 1800*1000; // half hour
    private boolean runMe = true;
    
    
    /**
     * Constructor for AlertErrorMailThread class.
     */
    public AlertErrorMailThread()
    {
        if (logger.isDebugEnabled()) {logger.debug("+-AlertErrorMailThread() constructor");}
    } //AlertErrorMailThread
    
    
    /**
     * This method runs the Alert Error mail thread.
     */
    public void run()
    {
        if (logger.isDebugEnabled()) {logger.debug("+run()");}
        while(runMe)
        {
            try 
            {
                List<?> alertaList = null;
                
                if (null != alertaList && 0 < alertaList.size())
                {
                    
                    
                }
                else
                {
                    if (logger.isInfoEnabled()) {logger.info("run() Mail sleep for: " + THREAD_SLEEP + " milliseconds.");}
                    Thread.sleep(THREAD_SLEEP);
                }    
            }
            catch (Exception e)
            {
                logger.error("run() Exception(" + e.getClass().getName() + ")  -->" + ExceptionUtils.getStackTrace(e));
            }
        }
        if (logger.isDebugEnabled()) {logger.debug("-run()");}
    } //run
    
} //AlertErrorMailThread
