package com.project.Model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name="attendance_table")
public class AttendenceVO {

	@Id
	@Column(name="attendenceId")
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int id;
	
	@ManyToOne
	public EmployeeVO employeeVO;
	
	@Column(name="month")
	private String month;
	
	@ManyToOne
	public leaveCriteriaVO leaveVO;
	
	@Column(name="paySlipStatus")
	public String paySlipStatus = "pending";

	
	public String getPaySlipStatus() {
		return paySlipStatus;
	}


	public void setPaySlipStatus(String paySlipStatus) {
		this.paySlipStatus = paySlipStatus;
	}


	public String getMonth() {
		return month;
	}


	public void setMonth(String month) {
		this.month = month;
	}

	public leaveCriteriaVO getLeaveVO() {
		return leaveVO;
	}


	public void setLeaveVO(leaveCriteriaVO leaveVO) {
		this.leaveVO = leaveVO;
	}





	@Column(name="workingDays")
	private Double numberOfWorkingDays;
	
	@Column(name="presentDays")
	private Double presentDays;
	
	@Column(name="leaveTaken")
	private Double numberOfLeavesTaken;
	
	
	//(name="leave")
	
	
	@Column(name="status")
	private boolean status=true;


	public int getId() {
		return id;
	}


	public void setId(int id) {
		this.id = id;
	}




	public EmployeeVO getEmployeeVO() {
		return employeeVO;
	}


	public void setEmployeeVO(EmployeeVO employeeVO) {
		this.employeeVO = employeeVO;
	}


	public Double getNumberOfWorkingDays() {
		return numberOfWorkingDays;
	}


	public void setNumberOfWorkingDays(Double numberOfWorkingDays) {
		this.numberOfWorkingDays = numberOfWorkingDays;
	}


	public Double getPresentDays() {
		return presentDays;
	}


	public void setPresentDays(Double presentDays) {
		this.presentDays = presentDays;
	}


	public Double getNumberOfLeavesTaken() {
		return numberOfLeavesTaken;
	}


	public void setNumberOfLeavesTaken(Double numberOfLeavesTaken) {
		this.numberOfLeavesTaken = numberOfLeavesTaken;
	}


	public boolean isStatus() {
		return status;
	}


	public void setStatus(boolean status) {
		this.status = status;
	}

}
	