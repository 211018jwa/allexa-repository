package com.revature.model;

import java.util.Objects;

public class Assignment {
	
	private int id;
	private String assignment;
	private int grade;
	private int graderID;
	private int authorID;
	
	public Assignment() {
		super();
	}

	public Assignment(int id, String assignment, int grade, int graderID, int authorID) {
		super();
		this.id = id;
		this.assignment = assignment;
		this.grade = grade;
		this.graderID = graderID;
		this.authorID = authorID;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getAssignment() {
		return assignment;
	}

	public void setAssignment(String assignment) {
		this.assignment = assignment;
	}

	public int getGrade() {
		return grade;
	}

	public void setGrade(int grade) {
		this.grade = grade;
	}

	public int getGraderID() {
		return graderID;
	}

	public void setGraderID(int graderID) {
		this.graderID = graderID;
	}

	public int getAuthorID() {
		return authorID;
	}

	public void setAuthorID(int authorID) {
		this.authorID = authorID;
	}

	@Override
	public int hashCode() {
		return Objects.hash(assignment, authorID, grade, graderID, id);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Assignment other = (Assignment) obj;
		return Objects.equals(assignment, other.assignment) && authorID == other.authorID && grade == other.grade
				&& graderID == other.graderID && id == other.id;
	}

	@Override
	public String toString() {
		return "Assignment [id=" + id + ", assignment=" + assignment + ", grade=" + grade + ", graderID=" + graderID
				+ ", authorID=" + authorID + "]";
	}
	
}
