package org.school.persisted;

import java.util.Date;

public class Exam implements java.io.Serializable {
	private static final long serialVersionUID = 1L;
	private long id;
	private long ts_id;
	private String code;
	private Date startTime;
	private Date endTime;

	public Exam() {
	}

	public Exam(long id) {
		super();
		this.id = id;
	}

	public Exam(long ts_id, String code, Date startTime, Date endTime) {
		super();
		this.ts_id = ts_id;
		this.code = code;
		this.startTime = startTime;
		this.endTime = endTime;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public long getTs_id() {
		return ts_id;
	}

	public void setTs_id(long ts_id) {
		this.ts_id = ts_id;
	}

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public Date getStartTime() {
		return startTime;
	}

	public void setStartTime(Date startTime) {
		this.startTime = startTime;
	}

	public Date getEndTime() {
		return endTime;
	}

	public void setEndTime(Date endTime) {
		this.endTime = endTime;
	}

}