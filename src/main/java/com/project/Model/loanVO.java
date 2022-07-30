package com.project.Model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "Loan_table")
public class loanVO {
	
	@Id
	@Column(name = "id")
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int Id;
		
	@ManyToOne
	@JoinColumn(name = "designationId")
	private DesignationVO designationVO;
	
	@Column(name="loanLimit")
	private int  loanLimit;
	
	@Column(name="timeLimitYears")
     private int  timeLimitYears;
	
	@Column(name="rateOfinterest")
	private int rateOfinterest;
	@Column(name="status")
	private boolean status=true;

	public boolean isStatus() {
		return status;
	}

	public void setStatus(boolean status) {
		this.status = status;
	}

	public int getId() {
		return Id;
	}

	public void setId(int id) {
		Id = id;
	}

	public DesignationVO getDesignationVO() {
		return designationVO;
	}

	public void setDesignationVO(DesignationVO designationVO) {
		this.designationVO = designationVO;
	}

	public int getLoanLimit() {
		return loanLimit;
	}

	public void setLoanLimit(int loanLimit) {
		this.loanLimit = loanLimit;
	}

	public int getTimeLimitYears() {
		return timeLimitYears;
	}

	public void setTimeLimitYears(int timeLimitYears) {
		this.timeLimitYears = timeLimitYears;
	}

	public int getRateOfinterest() {
		return rateOfinterest;
	}

	public void setRateOfinterest(int rateOfinterest) {
		this.rateOfinterest = rateOfinterest;
	}
}

