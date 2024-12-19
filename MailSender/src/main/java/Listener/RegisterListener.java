package Listener;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.JOptionPane;

import Gui.Login;
import Gui.Register;
import database.DataIOFromDB;
import passwordAuthenticator.OTPSender;

public class RegisterListener extends MouseAdapter implements ActionListener{
	
	Register register;
	Login login;
	
	public RegisterListener(Register register) {
		this.register=register;
	}
	public void mouseClicked(MouseEvent e) {
		@SuppressWarnings("unused")
		Login login=new Login();
		register.rootOfRegister.dispose();
	}
	public void actionPerformed(ActionEvent e) {
		if(e.getSource()==register.registerButton) {
			String name=register.getNameField();
			String gmail=register.getGmailField();
			String uPassword=register.getPasswordOfUserField();
			String gPassword=register.getPasswordOfEmailField();
			String gender=register.group.getSelection().getActionCommand();
			if(register.getNameField().isBlank()||
					register.getGmailField().isBlank()||
					register.getPasswordOfUserField().isBlank()||
					register.getPasswordOfEmailField().isBlank()||
					register.group.getSelection().getActionCommand().isBlank()) {
				JOptionPane.showMessageDialog(null, "Please fill all the details !");
			}else {
			DataIOFromDB.setDataIntoDB(name, gmail, gPassword, uPassword, gender);
			}
		}else if(e.getSource()==register.sendButton) {
			String oTP=OTPSender.otpSend();
			String subject="Verification of BulkMailSender";
			String message="Hello "+register.getNameField()+"\n"+"Your OTP is "+oTP+
					"\n"+"Please do not shear your OTP to any one";
			String gmail=register.getGmailField();
			String gPassword=register.getPasswordOfEmailField();
			if(register.getGmailField().isBlank()||register.getPasswordOfEmailField().isBlank()) {
				JOptionPane.showMessageDialog(null, "Enter Email or Password !");
			}else {
			OTPSender.oTPSender(subject, message.toString(), gmail, gPassword, gmail);
			}
			String newOTP=JOptionPane.showInputDialog(null,"Enter Your OTP");
			if(newOTP.equals(oTP)) {
				JOptionPane.showMessageDialog(null, "Your G-Mail is successfully verifyed !");
			}else {
				JOptionPane.showMessageDialog(null, "Invalid OTP !");
				System.exit(0);
			}
			
		}
	}

}
