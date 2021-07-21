package bulkemail;


import java.util.Properties;

import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

public class SendEmail {	
	Session session;    
    private final String from = "ganapathy8974@gmail.com";
    private final String password = "************";
    //Authentication Method this is create a session once successfully authenticated 
    public void MailAuthentication() {
    	
        String host = "smtp.gmail.com";    
        Properties properties = System.getProperties();

        // Setup mail server
        properties.put("mail.smtp.host", host);
        properties.put("mail.smtp.port", "465");
        properties.put("mail.smtp.ssl.enable", "true");
        properties.put("mail.smtp.auth", "true");

        // Get the Session object.// and pass username and password
       this.session = Session.getInstance(properties, new javax.mail.Authenticator() {

            protected PasswordAuthentication getPasswordAuthentication() {

                return new PasswordAuthentication(from, password);

            }

        });
       
        session.setDebug(false);
    }
    //This Method Contain Email Messages
    public void EmailMessage(String to, String name) {

        try {            
            MimeMessage message = new MimeMessage(session);            
            message.setFrom(new InternetAddress(from));           
            message.addRecipient(Message.RecipientType.TO, new InternetAddress(to));
           
            message.setSubject("This is Test Mail");    
          
            message.setText("Dear "+name+"\n\nGreetings for showing interest!!! \n"
            		+ "This is My Git Hub URL - https://github.com/ganapathy8974\n"
            		+ "Follow me in Git then you can easily get my codes(Free Licence).\n\n"
            		+ "Thanks & Regards, \r\n"
            		+ "S.Ganapathy Ramasubramanian,\r\n"
            		+ "Mobile: 1123456789,");

            System.out.print("Email Sending to "+to);
            // Send message
            Transport.send(message);            
        } catch (MessagingException mex) {
            mex.printStackTrace();
        }

    } 

}