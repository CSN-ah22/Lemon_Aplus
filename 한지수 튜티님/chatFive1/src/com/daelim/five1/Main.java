package com.daelim.five1;

import javax.swing.JFrame;
import java.net.URI;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.java_websocket.client.WebSocketClient;
import org.java_websocket.handshake.ServerHandshake;

import com.daelim.five1.Panel.LoginPanel;
import com.daelim.five1.Panel.MainPanel;
import com.daelim.five1.Panel.JoinPanel;
import com.daelim.five1.Panel.SettingPanel;

public class Main {
	static WebSocketClient ws;
	static String user = "";
	static String s_s;
	private static String URI;
	
	//JFrame 객체 생성 JFrame이 Jpanel의 밑바탕
	public static JFrame f;
	private static LoginPanel loginPage;
	private static JoinPanel joinPage;
	private static MainPanel mainPage;
	private static SettingPanel settingPage;
	
	public static void uri(String uri) {
		URI = uri;
	}
	
	public static void connect(String ID) {
		user = ID;
		try {
			ws = new WebSocketClient(new URI(URI)) {
				@Override
				public void onOpen(ServerHandshake serverHandshake) {
					System.out.println("open");
                    System.out.println("😀" + user + "|서버 접속!");
                    movePage(3);
				}
				
				@Override
				public void onMessage(String s) {
					s_s = s;
                    String[] strs = s.split("\\|");
                    if (strs[0].equals(user)) {
                        System.out.println("나 : " + strs[0]);
                    } 
                    else {
                        System.out.println("메세지 보낸 사람 : " + strs[0]);
                    }
                    System.out.println("보낸 시간 : " + strs[1]);
                    System.out.println("보낸 메세지 : " + strs[2]);
                    System.out.println("----------------------");
                    MainPanel.recvMsg(s);
				}
				
				@Override
				public void onClose(int i, String s, boolean b) {
					System.out.println("onclose");
				}
				
				@Override 
				public void onError(Exception e) {
					 System.out.println("error");
				}
			};
			
			ws.connect();
            ws.close();
            
		}
		catch (Exception e) {
			e.printStackTrace();
		}
	} 
	
	public static void sendMessage(String msg) {
		String timeSpent = "";
		timeSpent = new SimpleDateFormat("HH:mm:ss").format(new Date());
        ws.send(user + "|" + timeSpent + "|" + msg);
        MainPanel.recvMsg(user + "|" + timeSpent + "|" + msg);
	}
	
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