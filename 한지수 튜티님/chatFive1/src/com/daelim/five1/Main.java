package com.daelim.five1;

import javax.swing.JFrame;

import com.daelim.five1.Panel.LoginPanel;
import com.daelim.five1.Panel.MainPanel;
import com.daelim.five1.Panel.JoinPanel;
import com.daelim.five1.Panel.SettingPanel;

public class Main {
	
	//JFrame 객체 생성 JFrame이 Jpanel의 밑바탕
	public static JFrame f;
	private static LoginPanel loginPage;
	private static JoinPanel joinPage;
	private static MainPanel mainPage;
	private static SettingPanel settingPage;
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		f = new JFrame();
		f.setSize(500,500);
		f.setLayout(null);
		
		//로그인판넹 객체 생성
		//클래스 이름 상수변수 = new 생성자()
		loginPage = new LoginPanel();
		joinPage = new JoinPanel();
		mainPage = new MainPanel();
		settingPage = new SettingPanel();
		
		f.add(loginPage);//보이는 부분, 출력하는 부분
		f.add(joinPage);
		f.add(mainPage);
		f.add(settingPage);
		f.setVisible(true);
		
		movePage(1);
		
		f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
	
	public static void movePage(int index) {
		loginPage.setVisible(false);
		joinPage.setVisible(false);
		mainPage.setVisible(false);
		settingPage.setVisible(false);
		
		 switch (index) {
	         case 1:
				 f.setTitle("Chat - 로그인 화면");
				 loginPage.setVisible(true);
	             break;
	         case 2:
				 f.setTitle("Chat - 회원가입 화면");
				 joinPage.setVisible(true);
	             break;
	         case 3:
				 f.setTitle("Chat - 채팅 화면");
				 mainPage.setVisible(true);
	             break;  
	         case 4:
	        	 f.setTitle("Chat - 환경설정 화면");
	        	 settingPage.setVisible(true);
	        	 break;
	    }

	}
}