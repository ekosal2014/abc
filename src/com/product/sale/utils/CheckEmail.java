package com.product.sale.utils;

import java.util.Arrays;
import java.util.Properties;

import javax.mail.Folder;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.NoSuchProviderException;
import javax.mail.Session;
import javax.mail.Store;

public class CheckEmail {
	public static Message[] check(String host, String storeType, String user,
		      String password) 
		   {
		      try {

		      //create properties field
		      Properties properties = new Properties();

		      properties.put("mail.pop3.host", host);
		      properties.put("mail.pop3.port", "995");
		      properties.put("mail.pop3.starttls.enable", "true");
		      Session emailSession = Session.getDefaultInstance(properties);
		  
		      //create the POP3 store object and connect with the pop server
		      Store store = emailSession.getStore("pop3s");

		      store.connect(host, user, password);
		    
		      //create the folder object and open it
		      Folder emailFolder = store.getFolder("INBOX");
		      emailFolder.open(Folder.READ_ONLY);
		     

		      // retrieve the messages from the folder in an array and print it
		      Message[] messages = emailFolder.getMessages();
		      System.out.println("messages.length---" + messages.length);
		      Arrays.sort( messages, ( m1, m2 ) -> {
		          try {
		            return m2.getSentDate().compareTo( m1.getSentDate() );
		          } catch ( MessagingException e ) {
		            throw new RuntimeException( e );
		          }
		        } );
		     
		      for (int i = 0, n = messages.length; i < n; i++) {
		         Message message = messages[i];
		         System.out.println("---------------------------------");
		         System.out.println("Email Number " + (i + 1));
		         System.out.println("Subject: " + message.getSentDate());
		         System.out.println("Subject: " + message.getSubject());
		         System.out.println("From: " + message.getFrom()[0]);
		         System.out.println("Text: " + message.getContent().toString());

		      }
		     
		      //close the store and folder objects
		      emailFolder.close(false);
		      store.close();
              return messages;
		      } catch (NoSuchProviderException e) {
		         e.printStackTrace();
		      } catch (MessagingException e) {
		         e.printStackTrace();
		      } catch (Exception e) {
		         e.printStackTrace();
		      }
		      return null;
		   }
}