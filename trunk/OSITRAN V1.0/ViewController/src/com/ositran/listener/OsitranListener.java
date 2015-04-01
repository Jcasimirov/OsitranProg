package com.ositran.listener;

import com.ositran.mail.SenderMail;
import com.ositran.mail.alerts.CustomizedMailThread;

import java.util.logging.Logger;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

/**
 * This class represents the service listener to process the mail threads.
 *
 * @author Jose Manuel Lucas Barrera (jose.lucas@asistp.com)
 */
public class OsitranListener implements ServletContextListener
{    
    /* Defines the mail threads */
    private CustomizedMailThread  customizedThread;
    
    
    
    @Override
    public void contextInitialized(ServletContextEvent servletContextEvent)
    {
        customizedThread = new CustomizedMailThread();
        customizedThread.start();
        
    } //contextInitialized

    @Override
    public void contextDestroyed(ServletContextEvent servletContextEvent)
    {
        
    } //contextDestroyed
    
} //OsitranListener
