package com.project.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.project.Model.DepartmentVO;
import com.project.Model.DesignationVO;
import com.project.Service.DesignationService;

@Controller
public class DesignationController {

	@Autowired
	private DesignationService designationService;

	@GetMapping(value = "admin/addDesignation")
	public ModelAndView addDesignation() {

		return new ModelAndView("admin/addDesignation", "designationVO", new DesignationVO());
	}
	@PostMapping(value = "admin/saveDesignation")
	public ModelAndView save(@ModelAttribute DesignationVO designationVO) {
		this.designationService.save(designationVO);
		return new ModelAndView("redirect:/admin/addDesignation");
	}
	@GetMapping(value = "admin/viewDesignation")
	public ModelAndView viewDesignation() {
		List<DesignationVO> designationList = this.designationService.search();
		return new ModelAndView("admin/viewDesignation", "designationList", designationList);
	}
	
	@GetMapping(value = "admin/deleteDesignation")
	public ModelAndView deleteDesignation(@ModelAttribute DesignationVO designationVO, @RequestParam int id) {
		List<DesignationVO> designationList = this.designationService.findById(id);
		designationVO= designationList.get(0);
		designationVO.setStatus(false);
		this.designationService.save(designationVO);
		return new ModelAndView("redirect:/admin/viewDesignation");
	}
	@GetMapping(value = "admin/editDesignation")
	public ModelAndView editDepartment(@ModelAttribute  DesignationVO designationVO, @RequestParam int id) {
		List<DesignationVO> designationList = this.designationService.findById(id);
		designationVO = designationList.get(0);

		return new ModelAndView("admin/addDesignation", "designationVO", designationVO);
	}
}
