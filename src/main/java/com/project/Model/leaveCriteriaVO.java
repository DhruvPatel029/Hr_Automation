package com.project.Model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="leaveCriteria_table")
public class leaveCriteriaVO {
	
	@Id
	@Column(name="leaveId")
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int id;
	
	@Column(name="leave_Type")
	private String leaveType;
	
	@Column(name="days")
	private String days;
	
	@Column(name="leave_description")
	private String leavedescription;
	
	public String getLeavedescription() {
		return leavedescription;
	}

	public void setLeavedescription(String leavedescription) {
		this.leavedescription = leavedescription;
	}

	@Column(name="status")
	private boolean status=true;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}


	public boolean isStatus() {
		return status;
	}

	public String getLeaveType() {
		return leaveType;
	}

	public void setLeaveType(String leaveType) {
		this.leaveType = leaveType;
	}

	public String getDays() {
		return days;
	}

	public void setDays(String days) {
		this.days = days;
	}

	public void setStatus(boolean status) {
		this.status = status;
	}
	

}
