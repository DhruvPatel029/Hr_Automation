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
@Table(name="allowanceDeduction_table")
public class AllowanceDeductionVO {

	@Id
	@Column(name="allowanceDeductionId")
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int id;
	
	@ManyToOne
	@JoinColumn(name="designationId")
	private DesignationVO designationVO;
	

	@Column(name="basic_salary")
	private String basicSalary;
	

	@Column(name="allowance_Deduction")
	private String allowancdeduction;
	

	@Column(name="allowDedtype")
	private String allowDedtype;
	
	@Column(name="allowance_limit")
	private int allowancelimit;
	
	@Column(name="description")
	private String description;
	
	@Column(name="status")
	private boolean status=true;
	
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public DesignationVO getDesignationVO() {
		return designationVO;
	}

	public void setDesignationVO(DesignationVO designationVO) {
		this.designationVO = designationVO;
	}

	public String getBasicSalary() {
		return basicSalary;
	}

	public void setBasicSalary(String basicSalary) {
		this.basicSalary = basicSalary;
	}

	
	public String getAllowancdeduction() {
		return allowancdeduction;
	}

	public void setAllowancdeduction(String allowancdeduction) {
		this.allowancdeduction = allowancdeduction;
	}

	public String getAllowDedtype() {
		return allowDedtype;
	}

	public void setAllowDedtype(String allowDedtype) {
		this.allowDedtype = allowDedtype;
	}

	public int getAllowancelimit() {
		return allowancelimit;
	}

	public void setAllowancelimit(int allowancelimit) {
		this.allowancelimit = allowancelimit;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public boolean isStatus() {
		return status;
	}

	public void setStatus(boolean status) {
		this.status = status;
	}

	
	
}
