package com.ositran.mail.alerts;

import com.ositran.mail.SenderMail;
import com.ositran.mail.object.Alert3MailObj;

import java.util.List;

import org.apache.commons.lang.exception.ExceptionUtils;
import org.apache.log4j.Logger;

public class Alert3MailThread extends Thread
{
    private final Logger logger = Logger.getLogger(Alert3MailThread.class);
    
    //private final int THREAD_SLEEP = 1000*1800; //half hour
    private final int THREAD_SLEEP = 5000;
    private boolean runMe = true;
    
    
    /**
     * Constructor for Alert3MailThread class.
     */
    public Alert3MailThread()
    {
        if (logger.isDebugEnabled()) {logger.debug("+-Alert3MailThread() constructor");}
    } //Alert3MailThread
    
    
    /**
     * This method runs the Alert 3 mail thread.
     */
    public void run()
    {
        if (logger.isDebugEnabled()) {logger.debug("+run() runMe=" + runMe);}
        while(runMe)
        {
            try
            {
                List<?> alert3MailList = null; //TODO: Implementar el método DAO para esto.
                
                if (null != alert3MailList && 0 < alert3MailList.size())
                {
                    for(Object alert3Mail : alert3MailList)
                    {
                        Alert3MailObj alert3Obj = prepareMailObj(alert3Mail);
                        
                        SenderMail senderMail = new SenderMail(alert3Obj);
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
     * This method prepares the mail information and converts an Alert3MailObj.
     * 
     * @param alert3Mail
     * @return
     *      Returns the Alert3MailObj.
     */
    private Alert3MailObj prepareMailObj(Object alert3Mail) //TODO: Cambiar el "Object" por Objeto bean de la db.
    {
        if (logger.isInfoEnabled())
        {
            logger.info("+prepareMailObj()"); //TODO: Colocar aqui la información importante de la alerta.
        }
        
        
        
        if (logger.isInfoEnabled()) {logger.info("-prepareMailObj()");}
        return null;
    } //prepareMailObj
    
} //Alert3MailThread
