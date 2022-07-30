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
@Table(name = "Employee_table")
public class EmployeeVO {
	@Id
	@Column(name = "EmployeeTableid")
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int employeeTableId;

	@Column(name = "First_name")
	private String firstName;

	@Column(name = "Last_name")
	private String lastName;

	@Column(name = "Employee_id")
	private String employeeId;

	@ManyToOne
	@JoinColumn(name = "designationId")
	private DesignationVO designationVO;

	@ManyToOne
	@JoinColumn(name = "departmentId")
	private DepartmentVO departmentVO;

	@ManyToOne
	@JoinColumn(name = "loginId")
	private LoginVO loginVO;

	@Column(name = "Gender")
	private String gender;

	@Column(name = "DateOfBirth")
	private String dateOfBirth;

	@Column(name = "BloodGroup")
	private String bloodGroup;

	@Column(name = "Address")
	private String address;

	@Column(name = "MaritalStatus")
	private String maritalStatus;

	@Column(name = "MobileNumber")
	private String mobileNumber;

	@Column(name = "status")
	private boolean status = true;

	public DepartmentVO getDepartmentVO() {
		return departmentVO;
	}

	public void setDepartmentVO(DepartmentVO departmentVO) {
		this.departmentVO = departmentVO;
	}

	public LoginVO getLoginVO() {
		return loginVO;
	}

	public void setLoginVO(LoginVO loginVO) {
		this.loginVO = loginVO;
	}

	public int getEmployeeTableId() {
		return employeeTableId;
	}

	public void setEmployeeTableId(int employeeTableId) {
		this.employeeTableId = employeeTableId;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getEmployeeId() {
		return employeeId;
	}

	public void setEmployeeId(String employeeId) {
		this.employeeId = employeeId;
	}

	public DesignationVO getDesignationVO() {
		return designationVO;
	}

	public void setDesignationVO(DesignationVO designationVO) {
		this.designationVO = designationVO;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public String getDateOfBirth() {
		return dateOfBirth;
	}

	public void setDateOfBirth(String dateOfBirth) {
		this.dateOfBirth = dateOfBirth;
	}

	public String getBloodGroup() {
		return bloodGroup;
	}

	public void setBloodGroup(String bloodGroup) {
		this.bloodGroup = bloodGroup;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getMaritalStatus() {
		return maritalStatus;
	}

	public void setMaritalStatus(String maritalStatus) {
		this.maritalStatus = maritalStatus;
	}

	public String getMobileNumber() {
		return mobileNumber;
	}

	public void setMobileNumber(String mobileNumber) {
		this.mobileNumber = mobileNumber;
	}

	public boolean isStatus() {
		return status;
	}

	public void setStatus(boolean status) {
		this.status = status;
	}

}