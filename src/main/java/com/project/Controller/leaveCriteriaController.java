package com.project.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.project.Model.DesignationVO;
import com.project.Model.leaveCriteriaVO;
import com.project.Service.leaveCriteriaService;



@Controller
public class leaveCriteriaController {

	
	@Autowired
	private leaveCriteriaService leavecriteriaService;
	@GetMapping(value = "admin/addLeave")
	public ModelAndView addLeave() {

		return new ModelAndView("admin/addLeave", "leaveCriteriaVO", new leaveCriteriaVO());
	}
	@PostMapping(value = "admin/saveLeaveCriteria")
	public ModelAndView save(@ModelAttribute leaveCriteriaVO leavecriteriaVO) {
		this.leavecriteriaService.save(leavecriteriaVO);
		return new ModelAndView("redirect:/admin/addLeave");
	}
	@GetMapping(value = "admin/viewLeave")
	public ModelAndView viewLeave() {
		List<leaveCriteriaVO> leavecriteriaList = this.leavecriteriaService.search();
		return new ModelAndView("admin/viewLeave", "leaveCriteriaList", leavecriteriaList);
	}
	@GetMapping(value = "admin/deleteLeave")
	public ModelAndView deleteDesignation(@ModelAttribute leaveCriteriaVO leavecriteriaVO, @RequestParam int id) {
		List<leaveCriteriaVO> designationList = this.leavecriteriaService.findById(id);
	    leavecriteriaVO= designationList.get(0);
	    leavecriteriaVO.setStatus(false);
		this.leavecriteriaService.save(leavecriteriaVO);
		return new ModelAndView("redirect:/admin/viewLeave");
	}
	@GetMapping(value = "admin/editLeave")
	public ModelAndView editDepartment(@ModelAttribute  leaveCriteriaVO leavecriteriaVO, @RequestParam int id) {
		List<leaveCriteriaVO> designationList = this.leavecriteriaService.findById(id);
		leavecriteriaVO = designationList.get(0);

		return new ModelAndView("admin/addLeave", "leaveCriteriaVO", leavecriteriaVO);
	}
}
