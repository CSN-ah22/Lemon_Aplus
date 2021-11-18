package com.daelim.five1.Panel;

import javax.swing.*;
import javax.swing.event.AncestorListener;

import com.daelim.five1.Main;
import com.daelim.five1.Data.SettingData;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.*;

public class SettingPanel extends JPanel {
	JTextField server;
	JTextField port;
	//기본생성자
	public SettingPanel() {
		setView();
		
		setBackground(Color.PINK);
        setSize(500,500);
        setLayout(null);
	}
	
	//setView메서드
	private void setView() {
		JLabel label_server = new JLabel("SERVER");
	    label_server.setBounds(120,100,60,30);
	    add(label_server);
	     
	    server = new JTextField();
	    server.setBounds(180,100,200,30);
	    add(server);
	     
	    JLabel label_port = new JLabel("PORT");
	    label_port.setBounds(120,150,60,30);
	    add(label_port);
	     
	    port = new JTextField();
	    port.setBounds(180,150,200,30);
	    add(port);

	    JButton bt_save = new JButton("저장");
	    bt_save.setBounds(120,220,260,30);
		bt_save.addActionListener(new ActionListener() {
			@Override
	        public void actionPerformed(ActionEvent e) {
				//파일 이벤트
				System.out.println("SERVER:" + server.getText() + ", PORT: " + port.getText());
				
				//입력값이 없을 때 팝업창 띄우기
				if(server.getText().equals("")) {
                    JOptionPane.showMessageDialog(Main.f,"서버 정보가 입력되지 않았습니다.");
                    return;
                }
 /*               if(port.getText().equals("")) {
                    JOptionPane.showMessageDialog(Main.f,"포트 정보가 입력되지 않았습니다.");
                    return;
                }*/
                try {
                	SettingData data;
                    data = new SettingData(server.getText(), port.getText());
                    
                    // 파일에 저장
                    FileOutputStream fo = new FileOutputStream("d://settingData.txt");
                    String write_value = "ws://" + data.getServer() + ":"; //+ data.getPort();
                    ObjectOutputStream out = new ObjectOutputStream(fo);
					out.writeObject(write_value);
                    out.close();

                    //파일 읽어오기
                    FileInputStream fi = new FileInputStream("d://settingData.txt");
                    ObjectInputStream in = new ObjectInputStream(fi);
                    
                    //문자열 추출
                    String f_line = in.readObject().toString();
                    int first = f_line.indexOf("ws://");
                    String e_line = f_line.substring(first);
                    
                    //추출된 문자열을 Main으로 보낸다
                    Main.uri(e_line);
                    in.close();
                    
                }catch (Exception ex){
                	ex.printStackTrace();
                }
                Main.movePage(1);
			} 
		});
		add(bt_save);
		
	    JButton bt_back = new JButton("취소");
	    bt_back.setBounds(120,260,260,30);
	    bt_back.addActionListener(new ActionListener() {
	    	@Override
	        public void actionPerformed(ActionEvent e) {
	            Main.movePage(1);
	        }
	    });
	    add(bt_back);
	}
	//메인에 추가
}
