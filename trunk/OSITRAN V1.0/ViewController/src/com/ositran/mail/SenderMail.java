package com.ositran.mail;

import com.ositran.mail.object.BasicMailObj;

import org.apache.log4j.Logger;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class SenderMail extends Thread
{
    private final Logger logger = Logger.getLogger(SenderMail.class);
    
    private boolean runMe = false;
    
    
    public SenderMail(BasicMailObj mailObj)
    {
        if (logger.isDebugEnabled()) {logger.debug("+SenderMail() constructor");}
        
        if (logger.isDebugEnabled()) {logger.debug("-SenderMail() constructor");}
    } //SenderMail
    
    /**
     * This method runs the thread.
     */
    public void run()
    {
        if (logger.isDebugEnabled()) {logger.debug("+run()");}
        
        
        
        if (logger.isDebugEnabled()) {logger.debug("-run()");}
    } //run                         
    
} //SenderMail
