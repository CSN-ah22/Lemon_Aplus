package com.daelim.five1.Panel;

import java.awt.Color;

import javax.swing.*;

import com.daelim.five1.Main;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class JoinPanel extends JPanel{
	private JTextField nameField;
	private JTextField emailField;
	private JTextField idField;
	private JPasswordField pwField;
	private JPasswordField pw2Field;
	
	
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
	    
	    JLabel label_id = new JLabel("아이디");
		label_id.setBounds(120, 150, 60, 30);
	    add(label_id);
	    
	    idField = new JTextField();
	    idField.setBounds(180, 150, 200, 30);
	    add(idField);
	    
	    JLabel label_pw = new JLabel("비밀번호");
		label_pw.setBounds(120, 200, 60, 30);
	    add(label_pw);
	    
	    pwField = new JPasswordField();
	    pwField.setBounds(180, 200, 200, 30);
	    add(pwField);
	    
	    JLabel label_pw2 = new JLabel("비밀번호 확인");
		label_pw2.setBounds(120, 250, 80, 30);
	    add(label_pw2);
	    
	    pw2Field = new JPasswordField();
	    pw2Field.setBounds(200, 250, 180, 30);
	    add(pw2Field);
	    
	    /*비교문구 FAIL*/
	    JLabel check_pw_FAIL = new JLabel("비밀번호를 다시 확인해주세요");
	    check_pw_FAIL.setBounds(200,290,200,30);
	    check_pw_FAIL.setForeground(new Color(102,0,153));
	    add(check_pw_FAIL);
	    check_pw_FAIL.setVisible(false);
	    /*비교문구 FAIL*/
	    
	    /*비교 문구 OK*/
	    JLabel check_pw_OK = new JLabel("등록되었습니다 로그인 창으로 돌아가주십시오");
	    check_pw_OK.setBounds(130,300,600,30);
	    check_pw_OK.setForeground(new Color(0,128,0));
	    add(check_pw_OK);
	    check_pw_OK.setVisible(false);
	    /*비교 문구 OK*/
	    
	    JButton bt_join = new JButton("가입하기");
	    bt_join.setBounds(120, 350, 260, 30);
	    bt_join.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				String myPass = pwField.getText();
				String myPass2 = pw2Field.getText();
				
				if (myPass.equals("")||myPass2.equals("")) {
					//null값이 들어있을때
					check_pw_OK.setVisible(false);
					check_pw_FAIL.setVisible(true);
		        }
				else if (myPass.equals(myPass2)) {
					//비밀번호가 비밀번호확인과 같을때
					check_pw_FAIL.setVisible(false);
					check_pw_OK.setVisible(true);
					bt_join.setVisible(false);
		        }
		        else {
		        	//비밀번호가 비밀번호확인과 같지 않을때
		        	check_pw_OK.setVisible(false);
		        	check_pw_FAIL.setVisible(true);
		        }
				
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
	    
	    JButton bt_back2 = new JButton("로그인 화면으로 이동");
        bt_back2.setBounds(120, 400, 260, 30);
        bt_back2.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Main.movePage(1);
            }
        });
        add(bt_back2);

	}
}
