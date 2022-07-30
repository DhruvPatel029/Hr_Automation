package com.project.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.project.Model.DepartmentVO;
import com.project.Service.DepartmentService;

import java.util.List;

@Controller
public class DepartmentController {

	@Autowired
	private DepartmentService departmentService;

	@GetMapping(value = "admin/departmentName")
	public ModelAndView addDepartment() {
		return new ModelAndView("admin/departmentName", "departmentVO", new DepartmentVO());
	}

	@PostMapping(value = "admin/saveDepartment")
	public ModelAndView saveDepartment(@ModelAttribute DepartmentVO departmentVO) {
		this.departmentService.save(departmentVO);
		return new ModelAndView("redirect:/admin/departmentName");
	}

	@GetMapping(value = "admin/viewDepartment")
	public ModelAndView viewDepartment() {
		List<DepartmentVO> departmentList = this.departmentService.search();
		return new ModelAndView("admin/viewDepartment", "departmentList", departmentList);
	}

	@GetMapping(value = "admin/deleteDepartment")
	public ModelAndView deleteDepartment(@ModelAttribute DepartmentVO departmentVO, @RequestParam int id) {
		List<DepartmentVO> departmentList = this.departmentService.findById(id);
		departmentVO = departmentList.get(0);
		departmentVO.setStatus(false);
		this.departmentService.save(departmentVO);
		return new ModelAndView("redirect:/admin/viewDepartment");
	}

	@GetMapping(value = "admin/editDepartment")
	public ModelAndView editDepartment(@ModelAttribute DepartmentVO departmentVO, @RequestParam int id) {
		List<DepartmentVO> departmentList = this.departmentService.findById(id);
		departmentVO = departmentList.get(0);

		return new ModelAndView("admin/departmentName", "departmentVO", departmentVO);
	}

}
