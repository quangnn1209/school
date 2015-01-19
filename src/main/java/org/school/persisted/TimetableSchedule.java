package org.school.persisted;

import java.util.List;

public class TimetableSchedule implements java.io.Serializable {
	private static final long serialVersionUID = 1L;
	private long id;
	private String code;
	private List<Class> classes;
	private List<Exam> exams;

	public TimetableSchedule() {
	}

	public TimetableSchedule(long id, String code) {
		super();
		this.id = id;
		this.code = code;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public List<Class> getClasses() {
		return classes;
	}

	public void setClasses(List<Class> classes) {
		this.classes = classes;
	}

	public List<Exam> getExams() {
		return exams;
	}

	public void setExams(List<Exam> exams) {
		this.exams = exams;
	}
}