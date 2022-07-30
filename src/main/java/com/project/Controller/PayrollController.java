package com.project.Controller;

import java.io.File;
import java.util.ArrayList;
import java.util.Iterator;
import javax.servlet.http.HttpSession;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.project.Model.AllowanceDeductionVO;
import com.project.Model.AttendenceVO;
import com.project.Model.DesignationVO;
import com.project.Model.EmployeeVO;
import com.project.Model.PayrollVO;
import com.project.Model.SalarySlipVO;
import com.project.Service.AllowanceDeductionService;
import com.project.Service.AttendenceService;
import com.project.Service.DesignationService;
import com.project.Service.EmployeeService;
import com.project.Service.PayrollService;
import com.project.Service.SalarySlipService;
import com.project.utill.Basemethods;

@Controller
public class PayrollController {

	@Autowired
	private PayrollService payrollservice;
	@Autowired
	private EmployeeService employeeService;
	@Autowired
	private DesignationService designationService;
	@Autowired
	private AttendenceService attendenceService; 
	@Autowired
	private AllowanceDeductionService allowanceDeductionService ;
	@Autowired
	private SalarySlipService salarySlipService;
	

	@GetMapping(value = "admin/addPayroll")
	public ModelAndView addPayroll() {
		List designationSearch = this.designationService.search();

		return new ModelAndView("admin/addPayroll", "PayrollVO", new PayrollVO()).addObject("designationSearch",
				designationSearch);
	}

	@PostMapping(value = "admin/savePayroll")
	public ModelAndView save(@ModelAttribute PayrollVO payrollVO) {
		this.payrollservice.save(payrollVO);
		return new ModelAndView("redirect:/admin/addPayroll");

	}

	@GetMapping(value = "admin/viewPayroll")
	public ModelAndView viewPayroll() {
		List<PayrollVO> payrollList = this.payrollservice.search();
		return new ModelAndView("admin/viewPayroll", "payrollList", payrollList);
	}
	@GetMapping(value = "admin/generatepay")
	public ModelAndView viewgeneratepay() {
		List<SalarySlipVO> employeeList = this.salarySlipService.search();
		List employeeList1 = this.employeeService.search();
		List attendenceList = this.attendenceService.search();
		System.out.println("SalaryList::::::"+employeeList);
		return new ModelAndView("admin/generatepay", "employeeList", employeeList).addObject("attendenceList", attendenceList).addObject("employeeList1", employeeList1);
	}
 
	@GetMapping(value = "admin/deletePayroll")
	public ModelAndView deletePayroll(@ModelAttribute PayrollVO payrollVO, @RequestParam int id) {
		List<PayrollVO> payrollList = this.payrollservice.findById(id);
		payrollVO = payrollList.get(0);
		payrollVO.setStatus(false);
		this.payrollservice.save(payrollVO);
		return new ModelAndView("redirect:/admin/viewPayroll");
	}

	@GetMapping(value = "admin/editPayroll")
	public ModelAndView editPayroll(@ModelAttribute PayrollVO payrollVo, @RequestParam int id) {
		List<PayrollVO> payrollList = this.payrollservice.findById(id);
		payrollVo = payrollList.get(0);
		List designationSearch = this.designationService.search();
		return new ModelAndView("admin/addPayroll", "PayrollVO", payrollVo).addObject("designationSearch",
				designationSearch);
	}

	@GetMapping(value =  "admin/CalculatePayment")
	public ModelAndView CalculatePayroll(@ModelAttribute EmployeeVO employeeVO,@RequestParam int employeeTableId , HttpSession httpSession)
	{
		/*System.out.println(employeeTableId);
		
		List employeeList = this.employeeService.findById(employeeTableId);
		List employeeAttendanceList = this.attendenceService.findByEmpId(employeeTableId);
		List emplBasicSalaryList = this.payrollservice.findByDesignationID(designationId);
		List emplAllowanceDeductionList = this.allowanceDeductionService.findByDesignationId(designationId);
		
		AttendenceVO attendenceVO;
		
		Iterator av = employeeAttendanceList.iterator();
		Double workingDays = null ;
		Double presentDays = null;
		while(av.hasNext())
		{
			attendenceVO = (AttendenceVO)av.next();
			workingDays = attendenceVO.getNumberOfWorkingDays();
			presentDays = attendenceVO.getPresentDays();
			System.out.println(presentDays);
		}
		
		PayrollVO payrollVO = (PayrollVO) emplBasicSalaryList.get(0);
		
		String bs = payrollVO.getBasicSalary();
		double basicSalary = Double.parseDouble(bs);
		int allowanceLimit=0;
		int deductionLimit=0;
		Iterator i = emplAllowanceDeductionList.iterator();
		AllowanceDeductionVO allowanceDeductionVO ;
		int j=0;
		while(i.hasNext())
		{
			//allowanceDeductionVO = (AllowanceDeductionVO) emplAllowanceDeductionList.get(j);
			allowanceDeductionVO = (AllowanceDeductionVO) i.next();
			j++;
			//System.out.println(j);
			String ad = allowanceDeductionVO.getAllowancdeduction();
			if(ad.equals("allowance"))
			{
				allowanceLimit=allowanceLimit+allowanceDeductionVO.getAllowancelimit();
				System.out.println("allowance "+allowanceLimit);
			}
			else if(ad.equals("deduction"))
			{
				deductionLimit = deductionLimit +allowanceDeductionVO.getAllowancelimit();
				System.out.println("deduction "+deductionLimit);
			}
		}
		double emplfinalPayroll = this.payrollservice.calculatePayroll(workingDays, presentDays, basicSalary , allowanceLimit, deductionLimit );
		System.out.println(emplfinalPayroll);*/
		String path = httpSession.getServletContext().getRealPath("/")+"documents//salaryslip";
		
		employeeVO.setEmployeeTableId(employeeTableId);
		
		
		/*********************** EMPLOYEE LIST ***********************/
		List employeeList = employeeService.findById(employeeTableId);
		
		EmployeeVO employeeVO2 = (EmployeeVO)employeeList.get(0);
		
		/*********************** ATTENDANCE LIST ***********************/
		List attendanceList = this.attendenceService.findByEmpId(employeeVO2.getEmployeeTableId());
		
		AttendenceVO attendanceVO = null ; 
		Iterator av = attendanceList.iterator();
		
		while(av.hasNext())
		{
			attendanceVO = (AttendenceVO)av.next();
			
		}
		attendanceVO.setPaySlipStatus("Generated");
		System.out.println("paySlipStatus:::::::::"+attendanceVO.getPaySlipStatus());
		System.out.println("attendanceId:::::::::"+attendanceVO.getId());
		this.attendenceService.save(attendanceVO);
		int designationId1 = employeeVO2.getDesignationVO().getId();
		
		/*********************** SALARY LIST ***********************/
		List salaryList = payrollservice.findByDesignationID(designationId1);
		
		
		PayrollVO salaryVO= (PayrollVO)salaryList.get(0);
		
		String basicSalary = salaryVO.getBasicSalary();
		
		List allowanceVOList = allowanceDeductionService.findByDesignationId(designationId1);
		List allowanceList = new ArrayList<Object>();
		List deductionList = new ArrayList<Object>();

		for(int i = 0 ; i  < allowanceVOList.size() ; i++){
		
			AllowanceDeductionVO  allowanceVO = (AllowanceDeductionVO) allowanceVOList.get(i);
		
			String deductionType = 	allowanceVO.getAllowancdeduction();
		
			if (deductionType.equals("allowance")) {
				allowanceList.add(allowanceVO);
			}
			if (deductionType.equals("deduction")) {
				deductionList.add(allowanceVO);				
			}
			
			System.out.println(deductionType);
		}
	
		System.out.println("  DEDUCTION "+ deductionList.size());
		System.out.println(" ALLOWANCE " + allowanceList.size());
		
		File f = new File(path+"//"+employeeVO2.getEmployeeId());
		
		f.mkdirs();
		
		String fileName = Basemethods.generatePaySlip(employeeVO2,attendanceVO,path+"//"+employeeVO2.getEmployeeId(),basicSalary,allowanceList,deductionList);
		String link = Basemethods.uploadIntoS3(new File(fileName),employeeVO2.getEmployeeId());
		SalarySlipVO salarySlipVO = new SalarySlipVO();
		
		salarySlipVO.setSalarySlipLink(link);
		salarySlipVO.setEmployeeVO(employeeVO2);
		
		
		this.salarySlipService.insert(salarySlipVO);
		return new ModelAndView("redirect:/admin/generatepay");
	}
	
	

}
