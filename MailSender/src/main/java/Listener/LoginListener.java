package Listener;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.JOptionPane;
import com.data.UserData;

import Gui.GuiOfMail;
import Gui.Login;
import Gui.Register;
import database.DataIOFromDB;
import passwordAuthenticator.OTPSender;

public class LoginListener extends MouseAdapter implements ActionListener{
	Login login;
	String oTP;
	
	public LoginListener(Login login) {
		this.login=login;
	}
	public void mouseClicked(MouseEvent e) {
		if(e.getSource()==login.buttonForFPInLogin) {
			login.layeredPane.removeAll();
			login.layeredPane.add(login.fPPanel);
			login.layeredPane.repaint();
			login.layeredPane.revalidate();
		}else if(e.getSource()==login.buttonForCPInLogin) {
			login.layeredPane.removeAll();
			login.layeredPane.add(login.pCPanel);
			login.layeredPane.repaint();
			login.layeredPane.revalidate();
		}else if(e.getSource()==login.goTLoginInCP){
			login.layeredPane.removeAll();
			login.layeredPane.add(login.loginPanel);
			login.layeredPane.repaint();
			login.layeredPane.revalidate();
		}else if(e.getSource()==login.goTLoginInFP){
			login.layeredPane.removeAll();
			login.layeredPane.add(login.loginPanel);
			login.layeredPane.repaint();
			login.layeredPane.revalidate();
		}else if(e.getSource()==login.goTLoginInSP){
			login.layeredPane.removeAll();
			login.layeredPane.add(login.loginPanel);
			login.layeredPane.repaint();
			login.layeredPane.revalidate();
		}else if(e.getSource()==login.switchLable) {
		@SuppressWarnings("unused")
		Register register=new Register();
//		login.Root.dispose();
		login.Root().dispose();
		}
	}
	@SuppressWarnings("deprecation")
	public void actionPerformed(ActionEvent e) {
//		JOptionPane.showMessageDialog(null, "Enter Email or Password !");

		if(e.getSource()==login.loginButton) {
			if(login.mailField.getText().isBlank()||
					login.passwordField.getText().isBlank()) {
				JOptionPane.showMessageDialog(null, "Enter Email or Password !");
			}else {
			DataIOFromDB.getDataFromDB(login.mailField.getText(), login.passwordField.getText());
			}
			if((UserData.uEmail!=null)||(UserData.uPassword!=null)) {
			GuiOfMail myGui=new GuiOfMail();
			myGui.guiMail();
			login.Root().dispose();
			}
		}else if(e.getSource()==login.submitButtonForCP) {
			if(login.getCurrentPassFieldForCP().isBlank()||
					login.getEmailFieldForCP().isBlank()||
					login.getNewPassFieldForCP().isBlank()) {
				JOptionPane.showMessageDialog(null, "Please fill all the required details !");
			}
			String currentPass=login.getCurrentPassFieldForCP();
			String email=login.getEmailFieldForCP();
			String password=login.getNewPassFieldForCP();
			DataIOFromDB.getDataFromDB(email, currentPass);
			if((UserData.uEmail!=null)||(UserData.uPassword!=null)) {
				int n=DataIOFromDB.setPassword(password);
				if(n==1) {
					login.messageLableForCP.setText("Password successfuly updat !");
				}
			}else {
				login.messageLableForCP.setText("Invalid or Password not found !");
			}
		}else if(e.getSource()==login.sendOTPButton) {
			oTP=OTPSender.otpSend();
			String subject="Verification of BulkMailSender";
			String message="Hello "+"\n"+"Your OTP is "+oTP+
					"\n"+"Please do not shear your OTP to any one";
			String email=login.getEmailFieldforFP();
			boolean temp=DataIOFromDB.forgetPassword(email);
			if(temp==false) {
				login.messageLableForFP.setText("Invalid Email");
			}else {
				OTPSender.oTPSender(subject, message.toString(), UserData.uEmail, UserData.uPassword, UserData.uEmail);
				login.submitForFP.setEnabled(true);
			}
			
			
		}else if(e.getSource()==login.submitForFP) {
			String tempOTP=login.getoTPFieldForFP();
			if(tempOTP.isBlank()) {
				JOptionPane.showMessageDialog(null, "Enter OTP");
			}else if(tempOTP.equals(oTP)) {
				login.layeredPane.removeAll();
				login.layeredPane.add(login.fPChangePasswordPanel);
				login.layeredPane.repaint();
				login.layeredPane.revalidate();
			}else {
				login.messageLableForFP.setText("Enter a valid OTP");
			}
		}else if(e.getSource()==login.submitButtonForSP) {
			String pass=login.getNewPassFieldForSP();
			String comfirmPass=login.getcPassFieldForSP();
			if(pass.equals(comfirmPass)) {
				int n=DataIOFromDB.setPassword(comfirmPass);
				if(n==1) {
					login.messageLableForSP.setText("Password successfuly updat !");
				}
			}else {
				login.messageLableForSP.setText("New password or comfirm password shoult be match");
			}
		}
		
		
	}

}
