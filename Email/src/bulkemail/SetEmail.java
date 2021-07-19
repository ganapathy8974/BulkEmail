package bulkemail;

import java.util.Iterator;
import java.util.Set;
import java.util.TreeSet;
import javax.mail.internet.AddressException;
import javax.mail.internet.InternetAddress;

public class SetEmail {	
	
	//-------------------------------Main method------------------------------------------------------------------
		public static void main(String[] args) {		
			SendEmail send  = new SendEmail();
			SetEmail set = new SetEmail(send);		
			String email_list =  "ganapathy8974.v2@gmail.com,barathdhoni851@gmail.com,barathdhoni851@gmail.com";
			set.splitEmails(email_list);
			set.excite();
		}		
	//-------------------------------Main method------------------------------------------------------------------
		
	SendEmail send;
	public SetEmail(SendEmail send) {
		this.send = send;
	}
	Set<String> emails = new TreeSet<String>();
	int valid_email_count;
	public void splitEmails(String email_list) {
		int invalid_address = 0;
		String []emails = email_list.split(",");
		for(String str : emails) {
			if(isValidEmailAddress(str)) {
				this.emails.add(str);
			}else {
				System.out.println("Invalid Email Address - " + str);
				invalid_address++;
			}
		}	
		valid_email_count = this.emails.size();
		System.out.println((emails.length - valid_email_count)-invalid_address + " Duplicate Email Given \n" + invalid_address + " Invalid Email Given");	
		System.out.println(valid_email_count + " Valid Email Address Given");
		System.out.println("Email Sent these valid Email addresses only. \n");
	}
	
	public void excite() {
		Iterator<String> iter = emails.iterator();
		String []name;
		String email;
		int i=1;
		send.MailAuthentication();
		while(iter.hasNext()) {			
			email = iter.next();
			name = email.split("@");
			send.EmailMessage(email,name[0]);
			System.out.println(" = Done("+ i +"/"+valid_email_count+")");
			i++;
		}
		System.out.println(valid_email_count + " mails successfully sent.");
	}
	
	
public boolean isValidEmailAddress(String email) {
		   boolean result = true;
		   try {
		      InternetAddress emailAddr = new InternetAddress(email);
		      emailAddr.validate();
		   } catch (AddressException ex) {
		      result = false;
		   }
		   return result;
	} 
}
