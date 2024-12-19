package Gui;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import Listener.RegisterListener;

import javax.swing.JLabel;
import javax.swing.ButtonGroup;
import javax.swing.SwingConstants;
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JPasswordField;
import javax.swing.JRadioButton;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import java.awt.Color;
import java.awt.Cursor;
import javax.swing.JCheckBox;


public class Register {
	public static void main(String[] args) {
		Register r=new Register();
	}
	public RegisterListener registerListener;
	public JPanel contentPane;
	public JTextField nameField;
	public JTextField gmailField;
	public JPasswordField passwordOfEmailField;
	public JPasswordField passwordOfUserField;
	public JRadioButton radioMale,radioFemale,radioOthers;
	public JButton registerButton,sendButton;
	public ButtonGroup group;
	public JLabel goTOLogin;
	public JFrame rootOfRegister;
	public ImageIcon icon;
	JCheckBox chckbxNewCheckBox;
	
	public String getNameField() {
		return nameField.getText();
	}
	public String getGmailField() {
		return gmailField.getText();
	}
	@SuppressWarnings("deprecation")
	public String getPasswordOfEmailField() {
		return passwordOfEmailField.getText();
	}
	@SuppressWarnings("deprecation")
	public String getPasswordOfUserField() {
		return passwordOfUserField.getText();
	}
	public Register(RegisterListener registerListener){
		this.registerListener=registerListener;
	}

	public Register() {
		rootOfRegister=new JFrame();
		rootOfRegister.setTitle("Registration Form");
		rootOfRegister.setResizable(false);
		rootOfRegister.setLocationRelativeTo(null);
		rootOfRegister.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		rootOfRegister.setBounds(100, 100, 638, 609);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		rootOfRegister.setContentPane(contentPane);
		contentPane.setLayout(null);
		rootOfRegister.setVisible(true);
		
		JLabel name = new JLabel("Name");
		name.setFont(new Font("Tahoma", Font.BOLD, 20));
		name.setHorizontalAlignment(SwingConstants.LEFT);
		name.setBounds(31, 132, 69, 31);
		contentPane.add(name);
		
		JLabel gMailPassword = new JLabel(" Password of e-mail");
		gMailPassword.setFont(new Font("Tahoma", Font.BOLD, 20));
		gMailPassword.setHorizontalAlignment(SwingConstants.LEFT);
		gMailPassword.setBounds(25, 236, 204, 31);
		contentPane.add(gMailPassword);
		
		JLabel password = new JLabel("Password");
		password.setFont(new Font("Tahoma", Font.BOLD, 20));
		password.setHorizontalAlignment(SwingConstants.LEFT);
		password.setBounds(31, 305, 111, 31);
		contentPane.add(password);
		
		JLabel gender = new JLabel("Gender");
		gender.setFont(new Font("Tahoma", Font.BOLD, 20));
		gender.setHorizontalAlignment(SwingConstants.LEFT);
		gender.setBounds(31, 360, 96, 31);
		contentPane.add(gender);
		
		JLabel gmail = new JLabel("Gmail");
		gmail.setFont(new Font("Tahoma", Font.BOLD, 20));
		gmail.setHorizontalAlignment(SwingConstants.LEFT);
		gmail.setBounds(31, 181, 84, 31);
		contentPane.add(gmail);
		
		nameField = new JTextField();
		nameField.setFont(new Font("Tahoma", Font.BOLD, 15));
		nameField.setBounds(233, 132, 363, 31);
		contentPane.add(nameField);
		nameField.setColumns(10);
		
		gmailField = new JTextField();
		gmailField.setFont(new Font("Tahoma", Font.PLAIN, 15));
		gmailField.setColumns(10);
		gmailField.setBounds(233, 181, 363, 31);
		contentPane.add(gmailField);
		
		passwordOfEmailField = new JPasswordField();
		passwordOfEmailField.setToolTipText("NOTE : Enter your email less secure app password");
		passwordOfEmailField.setFont(new Font("Tahoma", Font.BOLD, 18));
		passwordOfEmailField.setBounds(233, 237, 363, 29);
		contentPane.add(passwordOfEmailField);
		
		passwordOfUserField = new JPasswordField();
		passwordOfUserField.setFont(new Font("Tahoma", Font.BOLD, 18));
		passwordOfUserField.setBounds(233, 307, 363, 29);
		contentPane.add(passwordOfUserField);
		
		radioMale = new JRadioButton("Male");
		radioMale.setFont(new Font("Tahoma", Font.BOLD, 20));
		radioMale.setBounds(233, 360, 103, 31);
		contentPane.add(radioMale);
		radioMale.setActionCommand("Male");
		
		radioFemale = new JRadioButton("Female");
		radioFemale.setFont(new Font("Tahoma", Font.BOLD, 20));
		radioFemale.setBounds(359, 360, 103, 31);
		contentPane.add(radioFemale);
		radioFemale.setActionCommand("Female");
		
		radioOthers = new JRadioButton("Others");
		radioOthers.setFont(new Font("Tahoma", Font.BOLD, 20));
		radioOthers.setBounds(493, 360, 103, 31);
		contentPane.add(radioOthers);
		radioOthers.setActionCommand("Others");
		group=new ButtonGroup();
		group.add(radioMale);
		group.add(radioFemale);
		group.add(radioOthers);
		
		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setIcon(new ImageIcon(Register.class.getResource("/Gui/icons8-writer-male-48.png")));
		lblNewLabel.setBounds(243, 10, 96, 84);
		contentPane.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Registrstion Form");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.BOLD, 25));
		lblNewLabel_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1.setBounds(185, 81, 235, 31);
		contentPane.add(lblNewLabel_1);
		
		registerButton = new JButton("Register");
		registerButton.setFont(new Font("Tahoma", Font.BOLD, 30));
		registerButton.setBounds(233, 490, 173, 45);
		contentPane.add(registerButton);
		registerListener=new RegisterListener(this);
		registerButton.addActionListener(registerListener);
		
		
		JLabel lblNewLabel_3 = new JLabel("Verify your email ");
		lblNewLabel_3.setFont(new Font("Microsoft YaHei Light", Font.BOLD, 30));
		lblNewLabel_3.setBounds(31, 424, 264, 45);
		contentPane.add(lblNewLabel_3);
		
		sendButton = new JButton("Send OTP");
		sendButton.setFont(new Font("Tahoma", Font.BOLD, 20));
		sendButton.setBounds(289, 432, 130, 39);
		contentPane.add(sendButton);
		sendButton.addActionListener(registerListener);
		
		JLabel lblNewLabel_2 = new JLabel("NOTE : Enter your email less secure app password");
		lblNewLabel_2.setFont(new Font("Tahoma", Font.ITALIC, 15));
		lblNewLabel_2.setBounds(233, 268, 363, 31);
		contentPane.add(lblNewLabel_2);
		
		goTOLogin = new JLabel("Go to Login Page");
		goTOLogin.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		goTOLogin.setForeground(new Color(0, 128, 255));
		goTOLogin.setFont(new Font("Tahoma", Font.ITALIC, 20));
		goTOLogin.setBounds(430, 539, 166, 23);
		contentPane.add(goTOLogin);
		
		chckbxNewCheckBox = new JCheckBox("");
		chckbxNewCheckBox.setBounds(425, 442, 21, 24);
		contentPane.add(chckbxNewCheckBox);
		
//		contentPane.add(iconLable);
		goTOLogin.addMouseListener(registerListener);
	}
}
