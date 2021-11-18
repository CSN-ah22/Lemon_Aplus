package com.daelim.five1.Panel;

import com.daelim.five1.Main;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.FileInputStream;
import java.io.ObjectInputStream;

public class LoginPanel extends JPanel {
    public String line = "";

    private JTextField idField;
    private JPasswordField pwField;

    //기본생성자
   public LoginPanel(){
       setBackground(Color.ORANGE);
       setSize(500,500);
       setLayout(null);
       setVisible(true);
       setView();
   }

   private void setView(){

       JLabel label_id = new JLabel("아이디:");
       label_id.setBounds(100,100,50,30);
       add(label_id);

       idField = new JTextField();
       idField.setBounds(150,100,200,30);
       add(idField);


       JLabel label_pw = new JLabel("비밀번호:");
       label_pw.setBounds(85,150,200,30);
       add(label_pw);

       pwField = new JPasswordField();
       pwField.setBounds(150,150,200,30);
       add(pwField);

       JButton bt_login = new JButton("로그인");
       bt_login.setBounds(120,250,260,30);
       bt_login.addActionListener(new ActionListener(){

           @Override
           public void actionPerformed(ActionEvent e) {
               //이벤트 기능
               Main.movePage(3);
               // 세팅되어있는 서버:포트 값을 읽어옵니다
               try{
                   FileInputStream fis = new FileInputStream("d://settingData.txt");
                   ObjectInputStream in = new ObjectInputStream(fis);

                   //문자열 추출
                   String f_line = in.readObject().toString();
                   int first = f_line.indexOf("ws://");
                   String e_line = f_line.substring(first);

                   //추출된 문자열을 Main으로 보낸다
                   Main.uri(e_line);
                   in.close();

               }catch (Exception es){
                   es.printStackTrace();
               }

               Main.connect(idField.getText());
           }
       });
       add(bt_login);

       JButton bt_join = new JButton("회원가입");
       bt_join.setBounds(120,300,260,30);
       bt_join.addActionListener(new ActionListener() {
           @Override
           public void actionPerformed(ActionEvent e) {
               Main.movePage(2);
           }
       });
       add(bt_join);

       JButton bt_setting = new JButton("환경설정");
       bt_setting.setBounds(120,350,260,30);
       bt_setting.addActionListener(new ActionListener() {
           @Override
           public void actionPerformed(ActionEvent e) {

               Main.movePage(4);
           }
       });
       add(bt_setting);
   }
}
