																			Bulk Email 
																			----------
Used Packages:
--------------
1) Activation.jar
2) Java Mail API(mail.jar)

Note: Download the above mentioned files and add into your classpath

Used Mail Server:
-----------------
1) Gmail

Used Class and Methods:
----------------------
1) SendEmail
------------
This class have two methods one is emailMessage other one is mailAuthentication
	i) mailAuthentication - Method
	------------------------------
		* This method only for Authentication user name and password is correct it will create a session. 
		
		* Using this session to send the email.
		
	ii) emailMessage - Method
	-------------------------
		* This method has two parameters one is for to email address other one is for name (This name splits form the email id).
		
		* Email message and Email subject given in side this method. if your want to change the message or subject of the email
		simply replace the text.
2) SetEmail
-----------
This class have main method and 3 other methods.
	
	i) splitEmails - Method
	-----------------------
		*This method split the email ID and store it into a Tree set(Tree set not allowing the duplicate).
		
		*While storing validate the email is this valid email or not using "isValidEmailAddress" method in the same class.
		
		*This method has only one parameter for receiving the bulk email string.
	ii)isValidEmailAddress
	----------------------
		*This method has only one parameter for receiving the email string.
		
		*Then validate it and return the boolean result.
		
	iii)excite() - Method
	---------------------
		*This method send the email from tree set one by one.
		
		*Retrieve the email ID from tree set using iterator and send the email

How to Send Email?
------------------
In main method give your email ID in the email_list sting variable one by one using comma.
	