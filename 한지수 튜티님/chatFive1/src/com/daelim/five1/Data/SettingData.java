package com.daelim.five1.Data;

import java.io.Serializable;

public class SettingData implements Serializable {
	private String server, port;
	
	//기본생성자
	public SettingData() {
		
	}
	//매개변수생성자
	public SettingData(String ser, String po) {
		setServer(ser);
		setPort(po);
	}
	/* Getter, Setter */
	
	public String getServer() {
		return server;
	}

	public void setServer(String server) {
		this.server = server;
	}

	public String getPort() {
		return port;
	}

	public void setPort(String port) {
		this.port = port;
	}
	
	

}
