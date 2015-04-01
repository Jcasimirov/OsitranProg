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
public class OsitranListener implements ServletContextListener
{
    private final Logger logger = Logger.getLogger(OsitranListener.class);
    
    /* Defines the mail threads */
    private CustomizedMailThread  customizedThread;
    
    
    
    @Override
    public void contextInitialized(ServletContextEvent servletContextEvent)
    {
        if (logger.isDebugEnabled()) {logger.debug("+contextInitialized()");}
        
        if (logger.isInfoEnabled()) {logger.info("contextInitialized() Initialize Customized Mail Thread.");}    
        customizedThread = new CustomizedMailThread();
        customizedThread.start();
        
        if (logger.isInfoEnabled()) {logger.info("contextInitialized() Initialize  ");}
        
        
        
        
        if (logger.isDebugEnabled()) {logger.debug("-contextInitialized()");}
    } //contextInitialized

    @Override
    public void contextDestroyed(ServletContextEvent servletContextEvent)
    {
        if (logger.isDebugEnabled()) {logger.debug("+contextDestroyed()");}
        
        
        if (logger.isDebugEnabled()) {logger.debug("-contextDestroyed()");}
    } //contextDestroyed
    
} //OsitranListener
