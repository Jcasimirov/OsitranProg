package com.ositran.mail;

import com.ositran.mail.alerts.CustomizedMailThread;
import com.ositran.mail.object.BasicMailObj;

import com.ositran.mail.object.CustomizedMailObj;

public class SenderMail extends Thread
{    
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
        this.mailObj = mailObj;
    } //SenderMail
    
    /**
     * This method runs the thread.
     */
    public void run()
    {
        if (mailObj instanceof CustomizedMailObj)
        {
            
        }
        
    } //run
    
    public void processCustomizedMail(CustomizedMailObj customizedObj)
    {
        
        
    } //sendCustomizedMail
    
} //SenderMail
