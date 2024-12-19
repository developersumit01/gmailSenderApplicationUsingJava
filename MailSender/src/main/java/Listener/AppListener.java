package Listener;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.JOptionPane;

import Gui.GuiOfMail;

import com.data.UserData;
import com.mailSender.MailSendrApp;
import com.mailSender.TextToSpeech;

public class AppListener extends MouseAdapter implements ActionListener{
	MailSendrApp myMailSender;
	GuiOfMail guiOfMail;
	public AppListener(GuiOfMail guiOfMail) {
		this.guiOfMail=guiOfMail;
	}
	@SuppressWarnings("static-access")
	public void actionPerformed(ActionEvent e) {
		myMailSender=new MailSendrApp();
//		When user press the send button
		if(e.getSource()==guiOfMail.send)
		try {
			UserData.uSubject=guiOfMail.subjectField.getText();
			UserData.uMessage=guiOfMail.contentArea.getText();
			System.out.println(UserData.uCSV+"," +UserData.uAttchment+"," +UserData.uMessage+","+ UserData.uSubject+","+UserData.uEmail+","+UserData.uPassword);
			myMailSender.mailSender(UserData.uCSV, UserData.uAttchment, UserData.uMessage, UserData.uSubject, UserData.uEmail,UserData.uPassword);
		} catch (Exception e1) {
			e1.printStackTrace();
		}
//		When user press the cancle button
		else if(e.getSource()==guiOfMail.cancle) {
			System.exit(0);
//			When user press the browse button of attchment file
 		}else if(e.getSource()==guiOfMail.ABrowse) {
			int select=guiOfMail.file.showDialog(null, "Select");
			if(select==guiOfMail.file.APPROVE_OPTION) {
				guiOfMail.ATextField.setText(guiOfMail.file.getSelectedFile().getAbsolutePath());
				UserData.uAttchment=guiOfMail.ATextField.getText();
			}
//			When user press the browse button of CSV file
		}else if(e.getSource()==guiOfMail.CBrowse) {
			int select=guiOfMail.file.showDialog(null, "Select");
			if(select==guiOfMail.file.APPROVE_OPTION) {
				guiOfMail.csvTextField.setText(guiOfMail.file.getSelectedFile().getAbsolutePath());
				UserData.uCSV=guiOfMail.csvTextField.getText();
			}
		}
		
	}
	public void mouseClicked(MouseEvent e) {
		String text=guiOfMail.contentArea.getText();
		if(text.isBlank()) {
			JOptionPane.showMessageDialog(null, "Your text area is empty !");
		}else {
			TextToSpeech.textToSpeech(text);
		}
		
	}

}
