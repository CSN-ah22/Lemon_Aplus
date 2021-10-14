package com.daelim.five1.Panel;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class LoginPanel extends JPanel {
    public String line = "";

    //JFrame 객체 생성 JFrame이 Jpanel의 밑바탕
    public JFrame f = new JFrame();

    //기본생성자
   public LoginPanel(){
       f.getContentPane().setBackground(Color.ORANGE);
       f.setSize(500,500);
       f.setLayout(null);
       f.setVisible(true);
       setView();
   }

   private void setView(){
       JTextField idField = new JTextField();
       idField.setBounds(150,100,200,30);
       f.add(idField);

       JLabel label_id = new JLabel("아이디:");
       label_id.setBounds(100,100,50,30);
       f.add(label_id);

       JTextField pwField = new JTextField();
       pwField.setBounds(150,150,200,30);
       f.add(pwField);

       JLabel label_pw = new JLabel("비밀번호:");
       label_pw.setBounds(85,150,200,30);
       f.add(label_pw);

       JButton bt_login = new JButton("로그인");
       bt_login.setBounds(120,250,260,30);
       bt_login.addActionListener(new ActionListener(){

           @Override
           public void actionPerformed(ActionEvent e) {
               //이벤트 기능
               System.out.println("로그인을 요청했습니다");
           }
       });
       f.add(bt_login);
   }
}
