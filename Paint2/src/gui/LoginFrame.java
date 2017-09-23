package gui;

import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

import dao.UserManager;

public class LoginFrame extends JFrame{

	private JLabel userNameLbl;
	private	JLabel passwordLbl;
	private JTextField userNameTxt;
	private JTextField passwordTxt;
	private JButton loginBtn;
	private JButton signupBtn;

	public LoginFrame(){
		
		
		super("Login");
		
		
		
		setBounds(1500,700,300,500);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setResizable(true);
		setLayout(new GridBagLayout());
		GridBagConstraints gc=new GridBagConstraints();

		//		userNameLbl-------------------------------------------------------
		userNameLbl=new JLabel("Username   : ");

		gc.gridx=0;
		gc.gridy=0;
		gc.weightx=1;
		gc.weighty=0.5;
		gc.anchor=GridBagConstraints.LINE_END;
		gc.insets=new Insets(50,0,0,10);
		add(userNameLbl,gc);

		//		userNameTxt-------------------------------------------------------

		userNameTxt=new JTextField(10);

		gc.gridx=1;
		gc.gridy=0;
		gc.weightx=1;
		gc.weighty=0.5;
		gc.anchor=GridBagConstraints.LINE_START;
		gc.insets=new Insets(50,0,0,0);
		add(userNameTxt,gc);

		//		passwordLbl-------------------------------------------------------
		passwordLbl=new JLabel("Password  : ");

		gc.gridx=0;
		gc.gridy=1;
		gc.weightx=1;
		gc.weighty=0.5;
		gc.anchor=GridBagConstraints.LINE_END;
		gc.insets=new Insets(0,0,0,10);
		add(passwordLbl,gc);

		//		passwordTxt-------------------------------------------------------

		passwordTxt=new JTextField(10);

		gc.gridx=1;
		gc.gridy=1;
		gc.weightx=1;
		gc.weighty=0.5;
		gc.anchor=GridBagConstraints.LINE_START;
		gc.insets=new Insets(0,0,0,0);
		add(passwordTxt,gc);

		//		loginBtn----------------------------------------------------------

		loginBtn=new JButton("login");

		gc.gridx=1;
		gc.gridy=2;
		gc.weightx=1;
		gc.weighty=0.5;
		gc.anchor=GridBagConstraints.FIRST_LINE_START;
		gc.insets=new Insets(50,0,0,0);
		add(loginBtn,gc);
		getRootPane().setDefaultButton(loginBtn);
		loginBtn.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e) {
				if(!userNameTxt.getText().equals("")&& !passwordTxt.getText().equals("")){
					UserManager.signIn(userNameTxt.getText(), passwordTxt.getText());
					if(UserManager.currentUser!=null){
						PaintFrame paintFrame=new PaintFrame();
						paintFrame.setVisible(true);
					}
					else{
						JOptionPane.showMessageDialog(null,"User Not Found","ERROR",2);
					}
				}
				else{
					JOptionPane.showMessageDialog(null,"empty fields","ERROR",2);
				}
			}
		});

		//		signupBtn----------------------------------------------------------
		signupBtn=new JButton("Signup");

		gc.gridx=1;
		gc.gridy=3;
		gc.weightx=1;
		gc.weighty=0.5;
		gc.anchor=GridBagConstraints.FIRST_LINE_START;
		gc.insets=new Insets(0,0,50,0);
		add(signupBtn,gc);

		signupBtn.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e) {
				if(!userNameTxt.getText().equals("")&& !passwordTxt.getText().equals("")){
					try{
						UserManager.signup(userNameTxt.getText(), passwordTxt.getText());
						JOptionPane.showMessageDialog(null, "Done!", "",1);
					}catch(Exception x){
						JOptionPane.showMessageDialog(null,x.getMessage(), "ERROR", 2);
					}
				}
				else{
					JOptionPane.showMessageDialog(null,"empty fields","ERROR",2);
				}
			}
		});


	}
}
