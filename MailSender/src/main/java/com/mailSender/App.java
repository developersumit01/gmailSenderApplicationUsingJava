package com.mailSender;

import java.net.URL;
import java.net.URLConnection;

import javax.swing.JOptionPane;

import Gui.Login;


public class App 
{
	public static void main(String[] args) {
		try {
			URL url=new URL("http://www.google.com");
			URLConnection con=url.openConnection();
			con.connect();
			con.getInputStream().close();
		} catch (Exception e) {
			JOptionPane.showMessageDialog(null,"Internet not found !");
			int i=JOptionPane.OK_OPTION;
			if(i==0) {
				System.exit(0); 
			}
		}
		@SuppressWarnings("unused")
		Login login=new Login();

	}
}
