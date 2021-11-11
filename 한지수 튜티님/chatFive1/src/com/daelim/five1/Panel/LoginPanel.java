package com.daelim.five1.Panel;

import javax.swing.*;

import com.daelim.five1.Main;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class LoginPanel extends JPanel {
	public String line = "";
	
	private JTextField idField;
	private JPasswordField pwField;
	
	//기본생성자
	public LoginPanel() {
		setBackground(Color.ORANGE);
		setSize(500,500);
		setLayout(null);
		setVisible(true);
		setView();
	}
	
	private void setView() {
		
		JLabel label_id = new JLabel("아이디 : ");
		label_id.setBounds(100, 100, 50, 30);
		add(label_id);
		
		idField = new JTextField();
		idField.setBounds(150,100,200,30);
		add(idField);
		
		JLabel label_pw = new JLabel("비밀번호 : ");
		label_pw.setBounds(80, 150, 200, 30);
		add(label_pw);
		
		pwField = new JPasswordField();
		pwField.setBounds(150,150,200,30);
		add(pwField);
		
		JButton bt_login = new JButton("로그인");
        bt_login.setBounds(120, 250, 260, 30);
        bt_login.addActionListener(new ActionListener() {
        	
            @Override
            public void actionPerformed(ActionEvent e) {
            	//이벤트 기능
            	Main.movePage(3);
                
            }

         });
        add(bt_login);
        
        JButton bt_join = new JButton("회원가입");
        bt_join.setBounds(120, 300, 260, 30);
        bt_join.addActionListener(new ActionListener() {
        	
            @Override
            public void actionPerformed(ActionEvent e) {
            	//이벤트 기능
            	Main.movePage(2);
                
            }

         });
        
        JButton bt_preferences = new JButton("환경설정");
        bt_preferences.setBounds(120, 350, 260, 30);
        bt_preferences.addActionListener(new ActionListener() {
        	
            @Override
            public void actionPerformed(ActionEvent e) {
            	//이벤트 기능
                Main.movePage(4);
            }

         });
        add(bt_login);
        add(bt_join);
        add(bt_preferences);
	}

}
