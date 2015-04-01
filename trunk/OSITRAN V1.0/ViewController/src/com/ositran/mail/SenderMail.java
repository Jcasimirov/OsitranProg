package com.ositran.mail;

import com.ositran.mail.alerts.CustomizedMailThread;
import com.ositran.mail.object.BasicMailObj;

import com.ositran.mail.object.CustomizedMailObj;

import org.apache.log4j.Logger;

public class SenderMail extends Thread
{
    private final Logger logger = Logger.getLogger(SenderMail.class);
    
    private BasicMailObj mailObj;
    private boolean runMe = false;
    
    
    /**
     * Constructor for SenderMail class.
     * 
     * @param mailObj
     *      This parameter represents the Mail object to consume it.
     */
    public SenderMail(BasicMailObj mailObj)
    {
        if (logger.isDebugEnabled()) {logger.debug("+SenderMail() constructor");}
        this.mailObj = mailObj;
        if (logger.isDebugEnabled()) {logger.debug("-SenderMail() constructor");}
    } //SenderMail
    
    /**
     * This method runs the thread.
     */
    public void run()
    {
        if (logger.isDebugEnabled()) {logger.debug("+run()");}
        if (mailObj instanceof CustomizedMailObj)
        {
            
        }
        
        if (logger.isDebugEnabled()) {logger.debug("-run()");}
    } //run
    
    public void sendCustomizedMail(CustomizedMailObj customizedObj)
    {
        if (logger.isDebugEnabled()) {logger.debug(");}
        
        
    } //sendCustomizedMail
    
} //SenderMail
