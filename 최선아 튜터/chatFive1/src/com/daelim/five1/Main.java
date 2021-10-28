package com.daelim.five1;

import com.daelim.five1.Panel.JoinPanel;
import com.daelim.five1.Panel.LoginPanel;

import javax.swing.*;

public class Main {

    //JFrame 객체 생성 JFrame이 Jpanel의 밑바탕
    public static JFrame f;
    private static LoginPanel loginPage;
    private static JoinPanel joinPage;

    public static void main(String[] args) {

       f = new JFrame();
       f.setSize(500,500);
       f.setLayout(null);

        //로그인판넬 객체 생성
        //클래스이름 참조변수 = new 생성자()
        loginPage = new LoginPanel();
        joinPage = new JoinPanel();

        f.add(loginPage); //보이는 부분,출력하는 부분
        f.add(joinPage);

        f.setVisible(true);

        movePage(1);

        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    public static void movePage(int index){
        loginPage.setVisible(false);
        joinPage.setVisible(false);

        switch (index){
            case 1:
                f.setTitle("Chat - 로그인 화면");
                loginPage.setVisible(true);
                break;
            case 2:
                f.setTitle("Chat - 회원가입 화면");
                joinPage.setVisible(true);
                break;
        }

    }
}
