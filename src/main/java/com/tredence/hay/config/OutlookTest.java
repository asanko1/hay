package com.tredence.hay.config;

import java.awt.Desktop;
import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;

public class OutlookTest {
	
	public static void main(String s[]) {
		String command="\"C:\\Program Files\\Microsoft Office\\root\\Office16\\OUTLOOK.EXE\"" + " "+"/c ipm.appointment /m"+" "+ "\"info@xxx.com&cc=admin@xxx.com&subject=Hello World&body=Hi\"";
		System.out.print(command);		
		try {
			
			//Desktop.getDesktop().mail(new java.net.URI("mailto:YourEmailAddress@gmail.com?subject=TEST"));
			Runtime.getRuntime().exec(command);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} 
		
	}

}
