package Gui;

import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.imageio.ImageIO;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import java.awt.Font;
import java.awt.Image;
import java.awt.image.BufferedImage;
import java.net.URL;

import javax.swing.JTextField;
import javax.swing.LayoutStyle.ComponentPlacement;

import com.mailSender.MailSendrApp;

import Listener.AppListener;
import java.awt.Color;
import javax.swing.ImageIcon;
import java.awt.Cursor;
	
public class GuiOfMail{
	
	MailSendrApp myMailSender;
	public JTextField subjectField;
	public JTextField ATextField;
	public JTextField csvTextField;
	public JTextArea contentArea;
	public JButton CBrowse,ABrowse,cancle,send;
	public JFileChooser file;	
	public JLabel speakerIcon;

	
	public void guiMail(){
		AppListener appListener=new AppListener(this);
		JFrame root=new JFrame();
		root.getContentPane().setBackground(new Color(180, 245, 197));
		file=new JFileChooser();
		root.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		root.setSize(876, 805);
		
		JLabel subjectLable = new JLabel("Subject");
		subjectLable.setFont(new Font("Tahoma", Font.BOLD, 30));
		contentArea=new JTextArea();
		contentArea.setFont(new Font("Calibri", Font.BOLD, 25));
		contentArea.setLineWrap(true);
		
		JScrollPane scrollPane=new JScrollPane(contentArea,JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED,JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
		subjectLable.setHorizontalAlignment(SwingConstants.LEFT);
		
		subjectField = new JTextField();
		subjectField.setFont(new Font("Calibri", Font.BOLD, 25));
		subjectField.setColumns(10);
		
		JLabel contentLable = new JLabel("Content");
		contentLable.setFont(new Font("Tahoma", Font.BOLD, 30));
		contentLable.setHorizontalAlignment(SwingConstants.LEFT);
		
		JLabel attchmentLable = new JLabel("File Attach");
		attchmentLable.setFont(new Font("Tahoma", Font.BOLD, 30));
		attchmentLable.setHorizontalAlignment(SwingConstants.LEFT);
		
		ATextField = new JTextField();
		ATextField.setFont(new Font("Tahoma", Font.BOLD, 18));
		ATextField.setColumns(10);
		
		JLabel csvLable = new JLabel("CSV File");
		csvLable.setFont(new Font("Tahoma", Font.BOLD, 30));
		csvLable.setHorizontalAlignment(SwingConstants.CENTER);
		
		cancle = new JButton("Cancle");
		cancle.setFont(new Font("Tahoma", Font.BOLD, 20));
		cancle.addActionListener(appListener);
		
		
		csvTextField = new JTextField();
		csvTextField.setFont(new Font("Tahoma", Font.BOLD, 18));
		csvTextField.setColumns(10);
		
		ABrowse = new JButton("Browse");
		ABrowse.setForeground(new Color(0, 0, 0));
		ABrowse.setBackground(new Color(255, 255, 255));
		ABrowse.setFont(new Font("Tahoma", Font.BOLD, 20));
		ABrowse.addActionListener(appListener);
		
		CBrowse = new JButton("Browse");
		CBrowse.setFont(new Font("Tahoma", Font.BOLD, 20));
		CBrowse.addActionListener(appListener);
		
		send = new JButton("Send");
		send.setFont(new Font("Tahoma", Font.BOLD, 20));
		send.addActionListener(appListener);
		
		speakerIcon = new JLabel("");
		speakerIcon.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		speakerIcon.setIcon(new ImageIcon(GuiOfMail.class.getResource("/Gui/icons8-voice-50.png")));
		speakerIcon.addMouseListener(appListener);
		
		GroupLayout groupLayout = new GroupLayout(root.getContentPane());
		groupLayout.setHorizontalGroup(
			groupLayout.createParallelGroup(Alignment.TRAILING)
				.addGroup(groupLayout.createSequentialGroup()
					.addContainerGap(580, Short.MAX_VALUE)
					.addComponent(send, GroupLayout.PREFERRED_SIZE, 105, GroupLayout.PREFERRED_SIZE)
					.addGap(37)
					.addComponent(cancle, GroupLayout.PREFERRED_SIZE, 103, GroupLayout.PREFERRED_SIZE)
					.addGap(37))
				.addGroup(groupLayout.createSequentialGroup()
					.addGap(20)
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addComponent(subjectLable, Alignment.TRAILING, GroupLayout.DEFAULT_SIZE, 832, Short.MAX_VALUE)
						.addComponent(subjectField, 832, 832, 832))
					.addContainerGap())
				.addGroup(Alignment.LEADING, groupLayout.createSequentialGroup()
					.addGap(23)
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addComponent(speakerIcon, GroupLayout.PREFERRED_SIZE, 51, GroupLayout.PREFERRED_SIZE)
						.addComponent(scrollPane, Alignment.TRAILING, GroupLayout.DEFAULT_SIZE, 829, Short.MAX_VALUE)
						.addComponent(contentLable, GroupLayout.DEFAULT_SIZE, 829, Short.MAX_VALUE)
						.addComponent(csvLable, GroupLayout.PREFERRED_SIZE, 130, GroupLayout.PREFERRED_SIZE)
						.addComponent(attchmentLable, GroupLayout.PREFERRED_SIZE, 231, GroupLayout.PREFERRED_SIZE)
						.addGroup(groupLayout.createSequentialGroup()
							.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
								.addComponent(csvTextField, GroupLayout.DEFAULT_SIZE, 644, Short.MAX_VALUE)
								.addComponent(ATextField, Alignment.TRAILING, GroupLayout.DEFAULT_SIZE, 644, Short.MAX_VALUE))
							.addGap(47)
							.addGroup(groupLayout.createParallelGroup(Alignment.LEADING, false)
								.addComponent(ABrowse, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
								.addComponent(CBrowse, GroupLayout.DEFAULT_SIZE, 138, Short.MAX_VALUE))))
					.addContainerGap())
		);
		groupLayout.setVerticalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addContainerGap()
					.addComponent(subjectLable, GroupLayout.PREFERRED_SIZE, 35, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addComponent(subjectField, GroupLayout.PREFERRED_SIZE, 35, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addComponent(contentLable, GroupLayout.PREFERRED_SIZE, 33, GroupLayout.PREFERRED_SIZE)
					.addGap(13)
					.addComponent(scrollPane, GroupLayout.PREFERRED_SIZE, 277, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(speakerIcon, GroupLayout.PREFERRED_SIZE, 43, Short.MAX_VALUE)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(attchmentLable, GroupLayout.PREFERRED_SIZE, 36, GroupLayout.PREFERRED_SIZE)
					.addGap(10)
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addComponent(ABrowse, GroupLayout.PREFERRED_SIZE, 35, GroupLayout.PREFERRED_SIZE)
						.addComponent(ATextField, GroupLayout.PREFERRED_SIZE, 42, GroupLayout.PREFERRED_SIZE))
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(csvLable)
					.addGap(18)
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addComponent(CBrowse, GroupLayout.PREFERRED_SIZE, 36, GroupLayout.PREFERRED_SIZE)
						.addComponent(csvTextField, GroupLayout.PREFERRED_SIZE, 37, GroupLayout.PREFERRED_SIZE))
					.addGap(45)
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(send)
						.addComponent(cancle, GroupLayout.PREFERRED_SIZE, 35, GroupLayout.PREFERRED_SIZE))
					.addGap(24))
		);
		root.getContentPane().setLayout(groupLayout);
		root.setVisible(true);
	}
}