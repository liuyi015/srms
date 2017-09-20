package cn.ly.srms.entity;

// Generated 2017-7-13 11:33:49 by Hibernate Tools 3.4.0.CR1

import java.io.Serializable;
import java.util.Date;

/**
 * Messageinfo generated by hbm2java
 */
	public class MessageInfo implements java.io.Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private Integer id;
	private int sendId;
	private int receiveId;
	private String title;
	private String message;
	private String sendTime;
	private String status;

	public MessageInfo() {
	}

	public MessageInfo(int sendId, int receiveId, String sendTime, String status) {
		this.sendId = sendId;
		this.receiveId = receiveId;
		this.sendTime = sendTime;
		this.status = status;
	}

	public MessageInfo(int sendId, int receiveId, String title, String message,
			String sendTime, String status) {
		this.sendId = sendId;
		this.receiveId = receiveId;
		this.title = title;
		this.message = message;
		this.sendTime = sendTime;
		this.status = status;
	}

	public Integer getId() {
		return this.id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public int getSendId() {
		return this.sendId;
	}

	public void setSendId(int sendId) {
		this.sendId = sendId;
	}

	public int getReceiveId() {
		return this.receiveId;
	}

	public void setReceiveId(int receiveId) {
		this.receiveId = receiveId;
	}

	public String getTitle() {
		return this.title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getMessage() {
		return this.message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public String getSendTime() {
		return this.sendTime;
	}

	public void setSendTime(String sendTime) {
		this.sendTime = sendTime;
	}

	public String getStatus() {
		return this.status;
	}

	public void setStatus(String status) {
		this.status = status;
	}
	
	private String sendName;

	public String getSendName() {
		return sendName;
	}

	public void setSendName(String sendName) {
		this.sendName = sendName;
	}
	

}