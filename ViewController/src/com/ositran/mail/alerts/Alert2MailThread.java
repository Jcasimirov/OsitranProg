package com.ositran.mail.alerts;

import com.ositran.mail.SenderMail;
import com.ositran.mail.object.Alert2MailObj;

import java.util.List;

import org.apache.commons.lang.exception.ExceptionUtils;
import org.apache.log4j.Logger;

public class Alert2MailThread extends Thread
{
    private final Logger logger = Logger.getLogger(Alert2MailThread.class);
    
    //private final int THREAD_SLEEP = 1000*1800; //half hour
    private final int THREAD_SLEEP = 5000;
    private boolean runMe = true;
    
    
    /**
     * Constructor for Alert2MailThread class.
     */
    public Alert2MailThread()
    {
        if (logger.isDebugEnabled()) {logger.debug("+-Alert2MailThread() constructor");}
    } //Alert2MailThread
    
    
    /**
     * This method runs the Alert 2 mail thread.
     */
    public void run()
    {
        if (logger.isDebugEnabled()) {logger.debug("+run() runMe=" + runMe);}
        while(runMe)
        {
            try
            {
                List<?> alert2MailList = null; //TODO: Implementar el método DAO para esto.
                
                if (null != alert2MailList && 0 < alert2MailList.size())
                {
                    for(Object alert2Mail : alert2MailList)
                    {
                        Alert2MailObj alert2Obj = prepareMailObj(alert2Mail);
                        
                        SenderMail senderMail = new SenderMail(alert2Obj);
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
     * This method prepares the mail information and converts an Alert2MailObj.
     * 
     * @param alert2Mail
     * @return
     *      Returns the Alert2MailObj.
     */
    private Alert2MailObj prepareMailObj(Object alert2Mail) //TODO: Cambiar el "Object" por Objeto bean de la db.
    {
        if (logger.isInfoEnabled())
        {
            logger.info("+prepareMailObj()"); //TODO: Colocar aqui la información importante de la alerta.
        }
        
        
        
        if (logger.isInfoEnabled()) {logger.info("-prepareMailObj()");}
        return null;
    } //prepareMailObj
    
} //Alert2MailThread
