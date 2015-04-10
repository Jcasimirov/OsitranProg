package com.ositran.mail.alerts;

import com.ositran.mail.SenderMail;
import com.ositran.mail.object.Alert1MailObj;

import java.util.List;

import org.apache.commons.lang.exception.ExceptionUtils;
import org.apache.log4j.Logger;

public class Alert1MailThread extends Thread
{
    private final Logger logger = Logger.getLogger(Alert1MailThread.class);
    
    private final int THREAD_SLEEP = 24*3600*1000; // 1 day
    private boolean runMe = true;
    
    
    /**
     * Constructor for Alert1MailThread class.
     */
    public Alert1MailThread()
    {
        if (logger.isDebugEnabled()) {logger.debug("+-Alert1MailThread() constructor");}
    } //Alert1MailThread
    
    
    /**
     * This method runs the Alert 1 mail thread.
     */
    public void run()
    {
        if (logger.isDebugEnabled()) {logger.debug("+run() runMe=" + runMe);}
        while(runMe)
        {
            try
            {
                List<?> alert1MailList = null; //TODO: Implementar el método DAO para esto.
                
                if (null != alert1MailList && 0 < alert1MailList.size())
                {
                    for(Object alert1Mail : alert1MailList)
                    {
                        Alert1MailObj alert1Obj = prepareMailObj(alert1Mail);
                        
                        SenderMail senderMail = new SenderMail(alert1Obj);
                        senderMail.start();
                    }
                }
                else
                {
                    if (logger.isInfoEnabled()) {logger.info("run() Mail sleep for: " +  THREAD_SLEEP + " milliseconds.");}
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
    
    /**
     * This method prepares the mail information and converts an Alert1MailObj.
     * 
     * @param alert1Mail
     * @return
     *      Returns the Alert1MailObj.
     */
    private Alert1MailObj prepareMailObj(Object alert1Mail) //TODO: Cambiar el "Object" por Objeto bean de la db.
    {
        if (logger.isInfoEnabled())
        {
            logger.info("+prepareMailObj()"); //TODO: Colocar aqui la información importante de la alerta.
        }
        
        
        
        if (logger.isInfoEnabled()) {logger.info("-prepareMailObj()");}
        return null;
    } //prepareMailObj
    
} //Alert1MailThread
