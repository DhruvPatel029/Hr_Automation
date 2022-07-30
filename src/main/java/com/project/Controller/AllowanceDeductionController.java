package com.project.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.project.Model.AllowanceDeductionVO;
import com.project.Model.PayrollVO;
import com.project.Service.AllowanceDeductionService;
import com.project.Service.DesignationService;
import com.project.Service.PayrollService;

@Controller
public class AllowanceDeductionController {

	@Autowired
	private AllowanceDeductionService allowanceDeductionService;

	@Autowired
	private DesignationService designationService;

	@Autowired
	private PayrollService payRollService;

	@GetMapping("admin/addAllowanceDeduction")
	public ModelAndView addAllowanceDeduction() {
		List designationSearch = this.designationService.search();
		return new ModelAndView("admin/addAllowanceDeduction", "allowanceDeductionVO", new AllowanceDeductionVO())
				.addObject("designationSearch", designationSearch);

	}

	@PostMapping(value = "admin/saveAllowanceDeduction")
	public ModelAndView save(@ModelAttribute AllowanceDeductionVO allowanceDeductionVO) {
		this.allowanceDeductionService.save(allowanceDeductionVO);
		return new ModelAndView("redirect:/admin/addAllowanceDeduction");
	}

	@GetMapping("admin/viewAllowanceDeduction")
	public ModelAndView viewAllowanceDeduction() {
		List<AllowanceDeductionVO> allowanceDeductionlist = this.allowanceDeductionService.search();
		System.out.println(allowanceDeductionlist.size());
		return new ModelAndView("admin/viewAllowanceDeduction", "allowanceDeductionlist", allowanceDeductionlist);
	}

	@GetMapping(value = "admin/deleteAllowanceDeduction")
	public ModelAndView deleteAllowancededuction(@ModelAttribute AllowanceDeductionVO allowanceDeductionVO,
			@RequestParam int id) {
		List<AllowanceDeductionVO> allowanceDeductionlist = this.allowanceDeductionService.findById(id);
		allowanceDeductionVO = allowanceDeductionlist.get(0);
		allowanceDeductionVO.setStatus(false);
		this.allowanceDeductionService.save(allowanceDeductionVO);

		return new ModelAndView("redirect:/admin/viewAllowanceDeduction");
	}

	@GetMapping(value = "admin/editAllowanceDeduction")
	public ModelAndView editAllowancededuction(@ModelAttribute AllowanceDeductionVO allowanceDeductionVO,
			@RequestParam int id) {
		List<AllowanceDeductionVO> allowanceDeductionlist = this.allowanceDeductionService.findById(id);
		allowanceDeductionVO = allowanceDeductionlist.get(0);
		List designationSearch = this.designationService.search();
		return new ModelAndView("admin/addAllowanceDeduction", "allowanceDeductionVO", allowanceDeductionVO)
				.addObject("designationSearch", designationSearch);
	}

	@SuppressWarnings({ "unchecked", "rawtypes" })
	@GetMapping(value = "admin/getSalaryByDesignation")
	public ResponseEntity getSalary(@RequestParam int id) {
		List<PayrollVO> designationList = this.payRollService.findByDesignationID(id);
		return new ResponseEntity(designationList.get(0), HttpStatus.OK);
	}

}