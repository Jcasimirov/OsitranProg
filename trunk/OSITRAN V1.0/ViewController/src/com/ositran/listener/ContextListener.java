package com.ositran.listener;

import com.ositran.mail.SenderMail;

import com.ositran.mail.alerts.CustomizedMailThread;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

import org.apache.log4j.Logger;

/**
 * This class represents the service listener to process the mail threads.
 * 
 * @author Jose Manuel Lucas Barrera (jose.lucas@asistp.com)
 */
public class ContextListener implements ServletContextListener
{
    private final Logger logger = Logger.getLogger(ContextListener.class);
    
    /* Defines sender mail to process the alerts */
    private SenderMail senderMail;
    
    /* Defines the mail threads */
    private CustomizedMailThread  customizedThread;
    
    
    @Override
    public void contextInitialized(ServletContextEvent servletContextEvent)
    {
        if (logger.isDebugEnabled()) {logger.debug("+contextInitialized()");}
        
        
        if (logger.isDebugEnabled()) {logger.debug("-contextInitialized()");}
    } //contextInitialized

    @Override
    public void contextDestroyed(ServletContextEvent servletContextEvent)
    {
        if (logger.isDebugEnabled()) {logger.debug("+contextDestroyed()");}
        
        
        if (logger.isDebugEnabled()) {logger.debug("-contextDestroyed()");}
    } //contextDestroyed
    
} //ContextListener
