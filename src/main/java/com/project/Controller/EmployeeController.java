package com.project.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.project.Model.EmployeeVO;
import com.project.Model.LoginVO;
import com.project.Service.DepartmentService;
import com.project.Service.DesignationService;
import com.project.Service.EmployeeService;
import com.project.Service.LoginService;
import com.project.utill.Basemethods;

@Controller
public class EmployeeController {

	@Autowired
	private EmployeeService employeeservice;

	@Autowired
	private DepartmentService departmentService;

	@Autowired
	private DesignationService designationService;

	@Autowired
	private LoginService loginService;

	@GetMapping(value = "admin/addEmployee")
	public ModelAndView addEmployee() {
		List departmentSearch = this.departmentService.search();
		List designationSearch = this.designationService.search();
		return new ModelAndView("admin/addEmployee", "employeeVO", new EmployeeVO())
				.addObject("departmentSearch", departmentSearch).addObject("designationSearch", designationSearch);
	}

	@PostMapping(value = "admin/saveEmployee")
	public ModelAndView saveEmployee(@ModelAttribute EmployeeVO employeeVO) {

		LoginVO loginVO = employeeVO.getLoginVO();
		String password = Basemethods.generatepassword();
		loginVO.setEnabled("1");
		loginVO.setRole("ROLE_USER");
		loginVO.setPassword(password);
		loginVO.setStatus(true);
		Basemethods.sendMail(employeeVO.getLoginVO().getUsername(), employeeVO.getFirstName(), password);

		this.loginService.insertLogin(loginVO);
		this.employeeservice.save(employeeVO);

		return new ModelAndView("redirect:/admin/addEmployee");
	}

	@GetMapping(value = "admin/viewEmployee")
	public ModelAndView viewEmployee() {
		List<EmployeeVO> employeeList = this.employeeservice.search();
		return new ModelAndView("admin/viewEmployee", "employeeList", employeeList);
	}

	@GetMapping(value = "admin/deleteEmployee")
	public ModelAndView deleteEmployee(@ModelAttribute EmployeeVO employeeVO, @RequestParam int id) {
		List<EmployeeVO> employeeList = this.employeeservice.findById(id);
		employeeVO = employeeList.get(0);
		employeeVO.setStatus(false);
		this.employeeservice.save(employeeVO);
		return new ModelAndView("redirect:/admin/viewEmployee");
	}

	@GetMapping(value = "admin/editEmployee")
	public ModelAndView editEmployee(@ModelAttribute EmployeeVO employeeVO, @RequestParam int id) {
		List<EmployeeVO> employeeList = this.employeeservice.findById(id);
		List departmentSearch = this.departmentService.search();
		List designationSearch = this.designationService.search();
		employeeVO = employeeList.get(0);

		return new ModelAndView("admin/addEmployee", "employeeVO", employeeVO)
				.addObject("departmentSearch", departmentSearch).addObject("designationSearch", designationSearch);
	}
}