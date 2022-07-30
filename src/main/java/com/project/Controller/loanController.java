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
import com.project.Model.loanVO;
import com.project.Service.DesignationService;
import com.project.Service.loanService;

@Controller
public class loanController {
		@Autowired
		private DesignationService designationService;
	  @Autowired
	  private loanService loanservice;
	  @GetMapping(value="admin/addLoan")
	  public ModelAndView addLoan()
	  {
		List<DesignationVO> designationList = this.designationService.search();
		System.out.println("size:>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>"+designationList.size());
		return new ModelAndView("admin/addLoan","loanVO",new loanVO()).addObject("designationList", designationList);
	  }
	  @PostMapping(value = "admin/saveLoan")
		public ModelAndView save(@ModelAttribute loanVO loanVO) {
			this.loanservice.save(loanVO);
			return new ModelAndView("redirect:/admin/addLoan");
		}
	  @GetMapping("admin/viewLoan")
	  public ModelAndView viewLoan()
	  {
		  List<loanVO> loanList=this.loanservice.search();
	//	  System.out.println(loanList.size());
		  return new ModelAndView("admin/viewLoan","loanList",loanList);
	  }
		@GetMapping(value = "admin/deleteLoan")
		public ModelAndView deleteLoan(@ModelAttribute loanVO loanVO, @RequestParam int id)
		{
			List <loanVO> designationList=this.loanservice.findById(id);
			loanVO=designationList.get(0);
			loanVO.setStatus(false);
			this.loanservice.save(loanVO);
			return new ModelAndView("redirect:/admin/viewLoan");
			
		}
		
		@GetMapping(value = "admin/editLoan")
		public ModelAndView editLoan(@ModelAttribute loanVO loanVO, @RequestParam int id)
		{
			List <loanVO> loanList=this.loanservice.findById(id);
			loanVO=loanList.get(0);
			List<DesignationVO> designationList = this.designationService.search();
			return new ModelAndView("admin/addLoan","loanVO",loanVO).addObject("designationList", designationList);
		  
		}
}	

