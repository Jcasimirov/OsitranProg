package com.ositran.mail;

import com.ositran.mail.object.Alert1MailObj;
import com.ositran.mail.object.Alert2MailObj;
import com.ositran.mail.object.Alert3MailObj;
import com.ositran.mail.object.CustomizedMailObj;
import com.ositran.mail.object.basic.BasicMailObj;

import com.sun.mail.smtp.SMTPMessage;

import java.util.Date;
import java.util.Properties;

import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeBodyPart;
import javax.mail.internet.MimeMultipart;

import org.apache.commons.lang.exception.ExceptionUtils;
import org.apache.log4j.Logger;

/**
 * This class is a thread, and manages the information to process an alert.
 *
 * @author Jose Manuel Lucas Barrera (jose.lucas@asistp.com)
 */
public class SenderMail extends Thread
{
    private final Logger logger = Logger.getLogger(SenderMail.class);
    
    private Object mailObj;
    private boolean runMe = false;
    
    
    /**
     * Constructor for SenderMail class.
     * 
     * @param mailObj
     *      This parameter represents the Mail object to consume it.
     */
    public SenderMail(Object mailObj)
    {
        if (logger.isDebugEnabled()) {logger.debug("+-SenderMail() constructor");}
        this.mailObj = mailObj;
    } //SenderMail
    
    
    /**
     * This method runs the thread.
     */
    public void run()
    {
        if (logger.isDebugEnabled()) {logger.debug("+run()");}
        try 
        {
            if (mailObj instanceof Alert1MailObj)
            {
                if (logger.isInfoEnabled()) {logger.info("run() ################ SEND ALERT 1.");}
                processAlert1Mail((Alert1MailObj) mailObj);
            }
            else if (mailObj instanceof Alert2MailObj)
            {
                if (logger.isInfoEnabled()) {logger.info("run() ################ SEND ALERT 2.");}
                processAlert2Mail((Alert2MailObj) mailObj);
            }
            else if (mailObj instanceof Alert3MailObj)
            {
                if (logger.isInfoEnabled()) {logger.info("run() ################ SEND ALERT 3.");}
                processAlert3Mail((Alert3MailObj) mailObj);
            }
            else if (mailObj instanceof CustomizedMailObj)
            {
                if (logger.isInfoEnabled()) {logger.info("run() ################ SEND CUSTOMIZED ALERT.");}
                processCustomizedMail((CustomizedMailObj) mailObj);
            }
            else
            {
                logger.error("run() The mail object specified is not valid.");
                throw new ClassNotFoundException("The mail object specified is not valid.");
            }
        }
        catch (Exception e)
        {
            logger.error("run() Exception(" + e.getClass().getName() + ")  ERROR: " + e.getMessage());
            logger.error("run() Exception(" + e.getClass().getName() + ") -->" + ExceptionUtils.getStackTrace(e));
        }
        if (logger.isDebugEnabled()) {logger.debug("-run()");}
    } //run
    
    /**
     * This method transforms and processes an alert of type 1.
     *
     * @param alert1Obj
     *      The alert object of type 1.
     */
    private void processAlert1Mail(Alert1MailObj alert1Obj)
    {
        if (logger.isDebugEnabled()) {logger.debug("+processAlert1Mail()");}
        
        
        
        if (logger.isDebugEnabled()) {logger.debug("-processAlert1Mail()");}
    } //processAlert1Mail
    
    /**
     * This method transforms and processes an alert of type 2.
     * 
     * @param alert2Obj
     *      The alert object of type 2.
     */
    private void processAlert2Mail(Alert2MailObj alert2Obj)
    {
        if (logger.isDebugEnabled()) {logger.debug("+processAlert2Mail()");}
        
        
        
        if (logger.isDebugEnabled()) {logger.debug("-processAlert2Mail()");}
    } //processAlert2Mail
    
    /**
     * This method transforms and processes an alert of type 3.
     * 
     * @param alert3Obj
     *      The alert object of type 3.
     */
    private void processAlert3Mail(Alert3MailObj alert3Obj)
    {
        if (logger.isDebugEnabled()) {logger.debug("+processAlert3Mail()");}
        
        
        
        if (logger.isDebugEnabled()) {logger.debug("-processAlert3Mail()");}
    } //processAlert3Mail
    
    /**
     * This method transforms and processes an customized alert.
     * 
     * @param customizedObj
     *      The customized alert object.
     */
    private void processCustomizedMail(CustomizedMailObj customizedObj)
    {
        if (logger.isDebugEnabled()) {logger.debug("+processCustomizedMail()");}
        
        
        
        if (logger.isDebugEnabled()) {logger.debug("-processCustomizedMail()");}
    } //sendCustomizedMail
    
    /**
     * This method sent a mail as alert.
     */
    private void processMail(String htmlSt, String subjectSt, String recipient, Object entityDB) throws MessagingException
    {   
        if (logger.isInfoEnabled()) {logger.info("+processMail() at: " + new Date());}
        final String username = "alertas.ositran@asistp.com";
        final String password = "Alertas2015";
        String from = username;
        
        Properties mailProperties = new Properties();
        mailProperties.put("mail.smtp.host", "correo.asistp.com");
        mailProperties.put("mail.smtp.port", "465");
        mailProperties.put("mail.smtp.auth", "true");
        mailProperties.put("mail.smtp.socketFactory.port", "465");
        mailProperties.put("mail.smtp.socketFactory.class", "javax.net.ssl.SSLSocketFactory");
        
        Session session = Session.getInstance(mailProperties, new javax.mail.Authenticator() 
        {
            protected PasswordAuthentication getPasswordAuthentication()
            {
                return new PasswordAuthentication(username, password);
            }
        });
        session.setDebug(true);
        if (logger.isDebugEnabled()) {logger.debug("processMail() Mail-session is OK.");}
        
        /* Instantiate the SMTP message */
        SMTPMessage message = new SMTPMessage(session);
        
        /* Put the FROM and RECIPIENT for mail */
        message.setFrom(new InternetAddress(from));
        message.addRecipient(javax.mail.Message.RecipientType.TO, new InternetAddress(recipient));
        
        /* Put the subject of mail */
        message.setSubject(subjectSt);
        
        /* Creating the mail body and putting in message */
        MimeMultipart multiPart = null; 
        {
            multiPart = new MimeMultipart();
            
            MimeBodyPart htmlPart = new MimeBodyPart();
            htmlPart.setContent(htmlSt, "text/html; charset=UTF-8");
            multiPart.addBodyPart(htmlPart);
        }
           
        message.setContent(multiPart);
        Transport.send(message);
        if (logger.isInfoEnabled()) {logger.info("processMail() Alert successfully, at: " + new Date());}
        
        /* If all Ok, then update the record. */
        //TODO: Actualizar el estado del registro de la alerta para que no vuelva a ser llamado.
        if (logger.isInfoEnabled()) {logger.info("-processMail()");}
    } //processMail
    
} //SenderMail
