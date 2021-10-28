package com.daelim.five1.Panel;

import java.awt.Color;

import javax.swing.*;

import com.daelim.five1.Main;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class JoinPanel extends JPanel{
	private JTextField nameField;
	private JTextField emailField;
	
	//기본 생성자
	public JoinPanel() {
        setView();
		setBackground(Color.LIGHT_GRAY);
		setSize(500,500);
        setLayout(null);
	}
	
	private void setView() {
		JLabel label_name = new JLabel("이름");
		label_name.setBounds(120, 50, 60, 30);
	    add(label_name);
	    
	    nameField = new JTextField();
	    nameField.setBounds(180, 50, 200, 30);
	    add(nameField);
	    
	    JLabel label_email = new JLabel("이메일");
		label_email.setBounds(120, 100, 60, 30);
	    add(label_email);
	    
	    emailField = new JTextField();
	    emailField.setBounds(180, 100, 200, 30);
	    add(emailField);
	    
	    JButton bt_join = new JButton("가입하기");
	    bt_join.setBounds(120, 350, 260, 30);
	    bt_join.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
			System.out.println("회원가입을 요청했습니다");
			}
	    });
	    add(bt_join);
	    
	    JButton bt_back = new JButton("<"); //로그인 화면으로 이동
	    bt_back.setBounds(10,10,50,30);
	    bt_back.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
			Main.movePage(1);
			}
	    });
	    add(bt_back);

	}
}
