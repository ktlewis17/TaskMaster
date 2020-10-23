package com.taskmaster.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "alertrequest")
public class Alert {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int alertid;
	@Column
	private String phone;
	@Column
	private String message;
	@Column
	private String datetime;
	@Column
	private int repeatincrement; // how space out the messages are from each other
	@Column
	private int repeatcount; // how many times a message is going to get sent

	public Alert(int alertid, String phone, String message, String datetime, int repeatincrement, int repeatcount) {
		super();
		this.alertid = alertid;
		this.phone = phone;
		this.message = message;
		this.datetime = datetime;
		this.repeatincrement = repeatincrement;
		this.repeatcount = repeatcount;
	}
	public Alert() {
		super();
		// TODO Auto-generated constructor stub
	}
	public int getId() {
		return alertid;
	}
	public void setId(int id) {
		this.alertid = id;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	public String getPhone() {
		return phone;
	}
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	public String getDateTime() {
		return datetime;
	}
	public void setDateTime(String datetime) {
		this.datetime = datetime;
	}
	public int getRepeatTime() {
		return repeatincrement;
	}
	public void setRepeatTime(int repeatincrement) {
		this.repeatincrement = repeatincrement;
	}
	public int getRepeatNum() {
		return repeatcount;
	}
	public void setRepeatNum(int repeatcount) {
		this.repeatcount = repeatcount;
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((message == null) ? 0 : message.hashCode());
		result = prime * result + alertid;
		result = prime * result + repeatincrement;
		result = prime * result + repeatcount;
		return result;
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Alert other = (Alert) obj;
		if (message == null) {
			if (other.message != null)
				return false;
		} else if (!message.equals(other.message))
			return false;
		if (alertid != other.alertid)
			return false;
		if (repeatincrement != other.repeatincrement)
			return false;
		if (repeatcount != other.repeatcount)
			return false;
		return true;
	}
	@Override
	public String toString() {
		return "Alert [id=" + alertid + ", body=" + message + ", repeatNum=" + repeatincrement + ", repeatTime=" + repeatcount + "]";
	}
	
}
