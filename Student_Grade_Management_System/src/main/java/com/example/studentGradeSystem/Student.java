package com.example.studentGradeSystem;

public class Student {
	    private String id;
	    private String name;
	    private String dept;
	    private int grade;

	    public Student(String id, int grade) {
	        this.id = id;
	        this.grade = grade;
	    }

	    public String getId() {
			return id;
		}

		public void setId(String id) {
			this.id = id;
		}

		public String getName() {
			return name;
		}

		public void setName(String name) {
			this.name = name;
		}

		public String getDept() {
			return dept;
		}

		public void setDept(String dept) {
			this.dept = dept;
		}

		public int getGrade() {
			return grade;
		}

		public void setGrade(int grade) {
			this.grade = grade;
		}

		@Override
	    public String toString() {
	        return "ID: " + id + " | Grade: " + grade;
	    }
	}