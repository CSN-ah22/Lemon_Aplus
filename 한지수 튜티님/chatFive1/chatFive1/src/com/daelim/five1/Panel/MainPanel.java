package com.daelim.five1.Panel;
import com.daelim.five1.Main;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.ActionEvent;

public class MainPanel extends JPanel{
	static JTextArea textArea;
	
	public MainPanel() {
		
		setView();
		setBackground(Color.pink);
        setSize(500, 500);
        setLayout(null);
    }
	
	private void setView() {
		textArea = new JTextArea();
		JScrollPane scrollPane = new JScrollPane(textArea);
		scrollPane.setBounds(3,10,480,300);
		add(scrollPane);
		
		JTextField text = new JTextField();
        text.setBounds(120, 350, 190, 30);
        add(text);
        
        JButton submit = new JButton("전송");
        submit.setBounds(320, 350, 60, 30);
        submit.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (text.getText().equals("")) { //빈값이 들어오면
                    return;
                } 
                else {
                     textArea.append(text.getText()+"\n");
                     //text.setText("");
                     System.out.println("전송됨");
                }

            }
        });
        add(submit);
        
        JButton bt_back = new JButton("로그인 화면으로 이동");
        bt_back.setBounds(120, 400, 260, 30);
        bt_back.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
            	Main.movePage(1);
            }
        });
        add(bt_back);
        
        /*엔터키 액션*/
        Action ok = new AbstractAction() {
            @Override
            public void actionPerformed(ActionEvent e) {
                textArea.append(text.getText()+"\n");
                text.setText("");
                textArea.setCaretPosition(textArea.getDocument().getLength()); 
                text.setText("");
            }
        };
        KeyStroke enter = KeyStroke.getKeyStroke(KeyEvent.VK_ENTER, 0, false);
        text.getInputMap(JTable.WHEN_ANCESTOR_OF_FOCUSED_COMPONENT).put(enter, "ENTER");
        text.getActionMap().put("ENTER", ok);
        /*엔터키 액션끝*/
	}

}
