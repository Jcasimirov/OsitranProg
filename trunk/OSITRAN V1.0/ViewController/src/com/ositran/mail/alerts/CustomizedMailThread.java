package com.ositran.mail.alerts;

import com.ositran.mail.SenderMail;

import java.util.List;

import org.apache.log4j.Logger;
import org.apache.commons.lang.exception.ExceptionUtils;

import com.ositran.mail.object.CustomizedMailObj;

public class CustomizedMailThread extends Thread
{
    private final Logger logger = Logger.getLogger(CustomizedMailThread.class);
    
    //private final int THREAD_SLEEP = 1000*1800; //half hour
    private final int THREAD_SLEEP = 5000;
    private boolean runMe = true;
    
    
    /**
     * Constructor for CustomizedMailThread class.
     */
    public CustomizedMailThread()
    {
        if (logger.isDebugEnabled()) {logger.debug("+-CustomizedMailThread() constructor");}
    } //CustomizedMailThread
    
    
    /**
     * This method runs the Customized mail thread.
     */
    public void run()
    {
        if (logger.isDebugEnabled()) {logger.debug("+run() runMe=" + runMe);}
        while (runMe)
        {
            try
            {
                List<?> cuztomizedMailList = null; //TODO: Implementar el método DAO para esto.
                
                if (null != cuztomizedMailList && 0 < cuztomizedMailList.size())
                {
                    for(Object customizedMail : cuztomizedMailList)
                    {
                        CustomizedMailObj customizedObj = prepareMailObj(customizedMail);
                        
                        SenderMail senderMail = new SenderMail(customizedObj);
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
     * This method prepares the mail information and converts a CustomizedMailObj.
     * 
     * @param customizedMail
     * @return
     *      Returns the CustomizedMailObj.
     */
    private CustomizedMailObj prepareMailObj(Object customizedMail) //TODO: Cambiar el "Object" por Objeto bean de la db.
    {
        if (logger.isInfoEnabled())
        {
            logger.info("+prepareMailObj()"); //TODO: Colocar aqui la información importante de la alerta.
        }
        
        
        
        if (logger.isInfoEnabled()) {logger.info("-prepareMailObj()");}
        return null;
    } //prepareMailObj
    
} //CustomizedMailThread
