package com.ositran.listener;

import com.ositran.mail.alerts.Alert1MailThread;
import com.ositran.mail.alerts.Alert2MailThread;
import com.ositran.mail.alerts.Alert3MailThread;
import com.ositran.mail.alerts.AlertErrorMailThread;
import com.ositran.mail.alerts.CustomizedMailThread;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

import org.apache.log4j.Logger;

/**
 * This class represents the service listener to process the mail threads for the alerts..
 *
 * @author Jose Manuel Lucas Barrera (jose.lucas@asistp.com)
 */
public class OsitranListener implements ServletContextListener
{    
    private final Logger logger = Logger.getLogger(OsitranListener.class);
    
    /* Defines the mail threads */
    private AlertErrorMailThread alertErrorMailThread;
    private Alert1MailThread alert1MailThread;
    private Alert2MailThread alert2MailThread;
    private Alert3MailThread alert3MailThread;
    private CustomizedMailThread customizedThread;
    
    
    @Override
    public void contextInitialized(ServletContextEvent servletContextEvent)
    {
        if (logger.isDebugEnabled()) {logger.debug("+contextInitialized() ****************************** INITIALIZE OSITRAN-LISTENER ******************************");}
        alertErrorMailThread = new AlertErrorMailThread();
        alertErrorMailThread.start();
        
        alert1MailThread = new Alert1MailThread();
        alert1MailThread.start();
        
        alert2MailThread = new Alert2MailThread();
        alert2MailThread.start();
        
        alert3MailThread = new Alert3MailThread();
        alert3MailThread.start();
        
        customizedThread = new CustomizedMailThread();
        customizedThread.start();
        if (logger.isDebugEnabled()) {logger.debug("-contextInitialized() *****************************************************************************************");}
    } //contextInitialized

    @Override
    public void contextDestroyed(ServletContextEvent servletContextEvent)
    {
        if (logger.isInfoEnabled()) {logger.info("+-contextDestroyed() This method is not implemented.");}
    } //contextDestroyed
    
} //OsitranListener
