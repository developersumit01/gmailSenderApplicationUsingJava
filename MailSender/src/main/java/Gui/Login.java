package Gui;

import javax.swing.JFrame;
import javax.swing.JPanel;
import Listener.LoginListener;

import javax.swing.JLabel;
import javax.swing.SwingConstants;

import java.awt.Cursor;
import java.awt.Font;
import java.awt.Image;
import java.awt.image.BufferedImage;
import java.net.URL;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JTextField;
import javax.swing.JPasswordField;
import javax.swing.JButton;
import java.awt.Color;
import javax.swing.JLayeredPane;
import java.awt.CardLayout;

public class Login {
	public JFrame root;
	/**
	 * loginPanel create for Login Page
	 * pCPanel create for changing the password
	 * fPanel create Forget Password
	 * fpChangePasswordPanel create for change password after forget
	 */
	public JPanel loginPanel,pCPanel,fPPanel,fPChangePasswordPanel;
	public JTextField mailField;
	public JPasswordField passwordField;
	public JButton loginButton,submitButtonForCP,sendOTPButton,submitForFP,submitButtonForSP;
	public JTextField otp;
	public JLabel buttonForCPInLogin,buttonForFPInLogin,switchLable;
	public JLabel messageLableForSP,messageLableForFP,messageLableForLogin,messageLableForCP;
	public JLabel goTLoginInSP,goTLoginInCP,goTLoginInFP;
	public JLayeredPane layeredPane;
	public JTextField emailFieldForCP;
	public JPasswordField currentPassFieldForCP;
	
	public String getEmailFieldForCP() {
		return emailFieldForCP.getText();
	}

	@SuppressWarnings("deprecation")
	public String getCurrentPassFieldForCP() {
		return currentPassFieldForCP.getText();
	}

	@SuppressWarnings("deprecation")
	public String getNewPassFieldForCP() {
		return newPassFieldForCP.getText();
	}

	public String getEmailFieldforFP() {
		return emailFieldforFP.getText();
	}

	public String getoTPFieldForFP() {
		return oTPFieldForFP.getText();
	}

	@SuppressWarnings("deprecation")
	public String getNewPassFieldForSP() {
		return newPassFieldForSP.getText();
	}

	@SuppressWarnings("deprecation")
	public String getcPassFieldForSP() {
		return cPassFieldForSP.getText();
	}
	
	public JFrame Root() {
		return root;
	}

	
	public JPasswordField newPassFieldForCP;
	public JTextField emailFieldforFP;
	public JTextField oTPFieldForFP;
	public JPasswordField newPassFieldForSP;
	public JPasswordField cPassFieldForSP;
	
	
	
	public Login() {
		LoginListener loginListener=new LoginListener(this);
		// TODO Auto-generated constructor stub
		root=new JFrame();
		root.setTitle("Mass Mail Dispatcher Login Form");
		root.setResizable(false);
		root.setLocationRelativeTo(null);
		root.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		root.setBounds(100, 100, 605, 478);
		root.getContentPane().setLayout(null);
		
		layeredPane = new JLayeredPane();
		layeredPane.setBounds(0, 0, 591, 441);
		root.getContentPane().add(layeredPane);
		layeredPane.setLayout(new CardLayout(0, 0));
		
		loginPanel = new JPanel();
		layeredPane.add(loginPanel, "name_1024229570208600");
		loginPanel.setLayout(null);
		
		pCPanel = new JPanel();
		layeredPane.add(pCPanel, "name_1024229595290000");
		pCPanel.setLayout(null);
		
		JLabel emailLableOfPC = new JLabel("Email");
		emailLableOfPC.setFont(new Font("Tahoma", Font.BOLD, 22));
		emailLableOfPC.setBounds(31, 124, 76, 36);
		pCPanel.add(emailLableOfPC);
		
		JLabel bannerForPC = new JLabel("Change Password");
		bannerForPC.setFont(new Font("Myanmar Text", Font.BOLD, 25));
		bannerForPC.setBounds(190, 50, 226, 36);
		pCPanel.add(bannerForPC);
		
		JLabel currentPassLableForCP = new JLabel("Current Password");
		currentPassLableForCP.setFont(new Font("Tahoma", Font.BOLD, 22));
		currentPassLableForCP.setBounds(26, 198, 208, 36);
		pCPanel.add(currentPassLableForCP);
		
		JLabel newPassLableForCP = new JLabel("New Password");
		newPassLableForCP.setFont(new Font("Tahoma", Font.BOLD, 22));
		newPassLableForCP.setBounds(31, 280, 177, 36);
		pCPanel.add(newPassLableForCP);
		
		emailFieldForCP = new JTextField();
		emailFieldForCP.setBounds(245, 127, 313, 33);
		pCPanel.add(emailFieldForCP);
		emailFieldForCP.setColumns(10);
		
		currentPassFieldForCP = new JPasswordField();
		currentPassFieldForCP.setBounds(244, 198, 314, 36);
		pCPanel.add(currentPassFieldForCP);
		
		newPassFieldForCP = new JPasswordField();
		newPassFieldForCP.setBounds(244, 280, 314, 36);
		pCPanel.add(newPassFieldForCP);
		
		submitButtonForCP = new JButton("Submit");
		submitButtonForCP.setFont(new Font("Tahoma", Font.BOLD, 25));
		submitButtonForCP.setBounds(245, 340, 131, 33);
		submitButtonForCP.addActionListener(loginListener);
		pCPanel.add(submitButtonForCP);
		
		messageLableForCP = new JLabel("");
		messageLableForCP.setForeground(new Color(255, 128, 128));
		messageLableForCP.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 15));
		messageLableForCP.setBounds(31, 385, 422, 46);
		pCPanel.add(messageLableForCP);
		
		goTLoginInCP = new JLabel("Go To Login");
		goTLoginInCP.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		goTLoginInCP.setForeground(new Color(0, 128, 255));
		goTLoginInCP.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 15));
		goTLoginInCP.setBounds(463, 398, 95, 25);
		goTLoginInCP.addMouseListener(loginListener);
		pCPanel.add(goTLoginInCP);
		
		fPPanel = new JPanel();
		layeredPane.add(fPPanel, "name_1024229617377400");
		fPPanel.setLayout(null);
		
		JLabel bannerLableForFP = new JLabel("Forget Password");
		bannerLableForFP.setFont(new Font("Tahoma", Font.BOLD, 25));
		bannerLableForFP.setBounds(190, 50, 214, 31);
		fPPanel.add(bannerLableForFP);
		
		JLabel emailForFP = new JLabel("Email");
		emailForFP.setFont(new Font("Tahoma", Font.BOLD, 25));
		emailForFP.setBounds(29, 144, 148, 31);
		fPPanel.add(emailForFP);
		
		emailFieldforFP = new JTextField();
		emailFieldforFP.setBounds(176, 144, 382, 31);
		fPPanel.add(emailFieldforFP);
		emailFieldforFP.setColumns(10);
		
		JLabel oTPLableForFP = new JLabel("Enter OTP");
		oTPLableForFP.setFont(new Font("Tahoma", Font.BOLD, 25));
		oTPLableForFP.setBounds(29, 261, 148, 31);
		fPPanel.add(oTPLableForFP);
		
		oTPFieldForFP = new JTextField();
		oTPFieldForFP.setColumns(10);
		oTPFieldForFP.setBounds(176, 261, 382, 31);
		fPPanel.add(oTPFieldForFP);
		
		sendOTPButton = new JButton("Send OTP");
		sendOTPButton.setHorizontalAlignment(SwingConstants.LEFT);
		sendOTPButton.setFont(new Font("Tahoma", Font.BOLD, 15));
		sendOTPButton.setBounds(233, 205, 118, 31);
		sendOTPButton.addActionListener(loginListener);
		fPPanel.add(sendOTPButton);
		
		submitForFP = new JButton("Submit");
		submitForFP.setFont(new Font("Tahoma", Font.BOLD, 18));
		submitForFP.setBounds(233, 321, 118, 31);
		submitForFP.addActionListener(loginListener);
		submitForFP.setEnabled(false);
		fPPanel.add(submitForFP);
		
		
		messageLableForFP = new JLabel("");
		messageLableForFP.setForeground(new Color(255, 128, 128));
		messageLableForFP.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 15));
		messageLableForFP.setBounds(29, 374, 432, 57);
		fPPanel.add(messageLableForFP);
		
		goTLoginInFP = new JLabel("Go To Login");
		goTLoginInFP.setForeground(new Color(0, 128, 255));
		goTLoginInFP.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		goTLoginInFP.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 15));
		goTLoginInFP.setBounds(479, 405, 102, 26);
		goTLoginInFP.addMouseListener(loginListener);
		fPPanel.add(goTLoginInFP);
		
//		code for design
		JLabel emailLable = new JLabel("Email");
		emailLable.setFont(new Font("Tahoma", Font.BOLD, 30));
		emailLable.setHorizontalAlignment(SwingConstants.CENTER);
		emailLable.setBounds(10, 107, 117, 31);
		loginPanel.add(emailLable);
		
		JLabel passwordLable = new JLabel("Password");
		passwordLable.setFont(new Font("Tahoma", Font.BOLD, 30));
		passwordLable.setHorizontalAlignment(SwingConstants.CENTER);
		passwordLable.setBounds(21, 182, 158, 37);
		loginPanel.add(passwordLable);
		
		JLabel iconLable = new JLabel("");
		iconLable.setHorizontalTextPosition(SwingConstants.CENTER);
		iconLable.setHorizontalAlignment(SwingConstants.CENTER);
		iconLable.setBounds(258, 26, 55, 48);
		try {
			BufferedImage img=null;
			URL url=getClass().getResource("/Gui/user.png");
			img=ImageIO.read(url);
			Image img1=img.getScaledInstance(iconLable.getWidth(), iconLable.getHeight(), Image.SCALE_SMOOTH);
			iconLable.setIcon(new ImageIcon(img1));
		} catch (Exception e) {
			e.printStackTrace();
		}
		loginPanel.add(iconLable);
		
		mailField = new JTextField();
		mailField.setFont(new Font("Tahoma", Font.BOLD, 15));
		mailField.setBounds(221, 107, 343, 31);
		loginPanel.add(mailField);
		mailField.setColumns(10);
		
		passwordField = new JPasswordField();
		passwordField.setFont(new Font("Tahoma", Font.BOLD, 15));
		passwordField.setBounds(221, 182, 343, 31);
		loginPanel.add(passwordField);
		
		loginButton = new JButton("LOGIN");
		loginButton.setFont(new Font("Tahoma", Font.BOLD, 20));
		loginButton.setBounds(243, 250, 105, 37);
		loginPanel.add(loginButton);
		loginButton.addActionListener(loginListener);
		
		JLabel lblNewLabel = new JLabel("If you are new user click here to register yourself");
		lblNewLabel.setFont(new Font("Tahoma", Font.ITALIC, 13));
		lblNewLabel.setBounds(10, 392, 292, 19);
		loginPanel.add(lblNewLabel);
		
		switchLable = new JLabel("Click Here");
		switchLable.setForeground(new Color(0, 128, 255));
		switchLable.setFont(new Font("Tahoma", Font.ITALIC, 15));
		switchLable.setToolTipText("Click Here");
		switchLable.setHorizontalAlignment(SwingConstants.LEFT);
		switchLable.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		switchLable.addMouseListener(loginListener);
		switchLable.setBounds(312, 392, 78, 16);
		loginPanel.add(switchLable);
		
		messageLableForLogin = new JLabel("");
		messageLableForLogin.setForeground(new Color(255, 128, 128));
		messageLableForLogin.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 15));
		messageLableForLogin.setBounds(22, 329, 542, 53);
		loginPanel.add(messageLableForLogin);
		
		buttonForFPInLogin = new JLabel("Forget Password");
		buttonForFPInLogin.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		buttonForFPInLogin.setForeground(new Color(0, 128, 255));
		buttonForFPInLogin.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 15));
		buttonForFPInLogin.setBounds(51, 291, 146, 28);
		buttonForFPInLogin.addMouseListener(loginListener);
		loginPanel.add(buttonForFPInLogin);
		
		buttonForCPInLogin = new JLabel("Change Password");
		buttonForCPInLogin.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		buttonForCPInLogin.setForeground(new Color(0, 128, 255));
		buttonForCPInLogin.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 15));
		buttonForCPInLogin.setBounds(378, 291, 146, 28);
		buttonForCPInLogin.addMouseListener(loginListener);
		loginPanel.add(buttonForCPInLogin);
		
		fPChangePasswordPanel = new JPanel();
		layeredPane.add(fPChangePasswordPanel, "name_1025135223217900");
		fPChangePasswordPanel.setLayout(null);
		
		JLabel confirmPasswordForSP = new JLabel("Confirm Password");
		confirmPasswordForSP.setFont(new Font("Tahoma", Font.BOLD, 22));
		confirmPasswordForSP.setBounds(33, 220, 208, 36);
		fPChangePasswordPanel.add(confirmPasswordForSP);
		
		JLabel newPassLableForSP = new JLabel("New Password");
		newPassLableForSP.setFont(new Font("Tahoma", Font.BOLD, 22));
		newPassLableForSP.setBounds(33, 133, 177, 36);
		fPChangePasswordPanel.add(newPassLableForSP);
		
		newPassFieldForSP = new JPasswordField();
		newPassFieldForSP.setBounds(248, 133, 314, 36);
		fPChangePasswordPanel.add(newPassFieldForSP);
		
		cPassFieldForSP = new JPasswordField();
		cPassFieldForSP.setBounds(248, 220, 314, 36);
		fPChangePasswordPanel.add(cPassFieldForSP);
		
		submitButtonForSP = new JButton("Submit");
		submitButtonForSP.setFont(new Font("Tahoma", Font.BOLD, 25));
		submitButtonForSP.setBounds(226, 306, 123, 36);
		submitButtonForSP.addActionListener(loginListener);
		fPChangePasswordPanel.add(submitButtonForSP);
		
		JLabel bannerLableForSP = new JLabel("Set Password");
		bannerLableForSP.setHorizontalAlignment(SwingConstants.CENTER);
		bannerLableForSP.setFont(new Font("Tahoma", Font.BOLD, 25));
		bannerLableForSP.setBounds(190, 50, 194, 31);
		fPChangePasswordPanel.add(bannerLableForSP);
		
		messageLableForSP = new JLabel("");
		messageLableForSP.setForeground(new Color(255, 128, 128));
		messageLableForSP.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 15));
		messageLableForSP.setBounds(34, 362, 426, 69);
		fPChangePasswordPanel.add(messageLableForSP);
		
		goTLoginInSP = new JLabel("Go To Login");
		goTLoginInSP.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		goTLoginInSP.setForeground(new Color(0, 128, 255));
		goTLoginInSP.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 15));
		goTLoginInSP.setBounds(470, 395, 92, 25);
		goTLoginInSP.addMouseListener(loginListener);
		fPChangePasswordPanel.add(goTLoginInSP);
		root.setVisible(true);
		

	}
}
