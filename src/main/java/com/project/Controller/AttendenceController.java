package com.project.Controller;

import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

import javax.servlet.http.HttpSession;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import com.project.Model.AttendenceVO;
import com.project.Model.EmployeeVO;
import com.project.Model.SalarySlipVO;
import com.project.Model.leaveCriteriaVO;
import com.project.Service.AttendenceService;
import com.project.Service.EmployeeService;
import com.project.Service.LoginService;
import com.project.Service.SalarySlipService;

@Controller
public class AttendenceController {

	private static final AttendenceVO AttendanceVO = null;

	@Autowired
	private AttendenceService AttendenceService;
	
	@Autowired
	private EmployeeService employeeservice;
	
	@Autowired
	private LoginService loginService;
	
	@Autowired
	private SalarySlipService salarySlipService;

	@GetMapping("admin/addAttendence")
	public ModelAndView addAttendence() {

		return new ModelAndView("admin/addAttendence", "AttendenceVO", new AttendenceVO());
	}

	@PostMapping(value = "admin/saveAttendence")
	public ModelAndView saveAttendence(HttpSession session, @ModelAttribute AttendenceVO AttendenceVO, @RequestParam MultipartFile attendencefile,
			@RequestParam String month)  {

		String path = session.getServletContext().getRealPath("/");
		
	//	String path = request.getSession().getServletContext().getRealPath("/");
		String attendanceFileMonthTosaveAttendence = attendencefile.getOriginalFilename();
		String attendanceFilePath = path + "documents\\attendance\\"; 
		
		System.out.println(attendanceFileMonthTosaveAttendence);
		System.out.println(attendanceFilePath);
		

		EmployeeVO employeeVO = new EmployeeVO();
		try {

			byte[] b = attendencefile.getBytes();
			BufferedOutputStream bufferedOutputStream = new BufferedOutputStream(
					new FileOutputStream(attendanceFilePath + attendanceFileMonthTosaveAttendence));

			bufferedOutputStream.write(b);
			bufferedOutputStream.flush();
			bufferedOutputStream.close();
			
				
				
		     
	        try
	        {
	        	FileInputStream file = new FileInputStream(new File(attendanceFilePath+"/"+attendanceFileMonthTosaveAttendence));
	 
	            //Create Workbook instance holding reference to .xlsx file
	            XSSFWorkbook workbook = new XSSFWorkbook(file);
	 
	            //Get first/desired sheet from the workbook
	            XSSFSheet sheet = workbook.getSheetAt(0);
	 
	            //Iterate through each rows one by one
	            Iterator<Row> rowIterator = sheet.iterator();
	            while (rowIterator.hasNext())
	            {
	            	
	            	
	            	
	                Row row = rowIterator.next();
	                //For each row, iterate through all the columns
	                Iterator<Cell> cellIterator = row.cellIterator();
	                
	                if (row.getRowNum() >= 1 ){
	                
	                	AttendenceVO attendanceVO = new AttendenceVO(); 
		            	attendanceVO.setStatus(true);
		            	attendanceVO.setMonth(month);
		            	
	                	
	                while (cellIterator.hasNext())
	                {
	                    Cell cell = cellIterator.next();
	                    
	                    //Check the cell type and format accordingly
	                     switch (cell.getColumnIndex())
	                    {
	                        case 0:
	                            System.out.print(cell.getStringCellValue()+ "\t");

	                            
	                            String employeeId = cell.getStringCellValue();
	                            List employeeList = this.employeeservice.findByemployeeId(employeeId);
	                            
	                            employeeVO = (EmployeeVO) employeeList.get(0);
	                
	                          	attendanceVO.setEmployeeVO(employeeVO); 
	                            break;
	                        case 1:
	                            System.out.print(cell.getNumericCellValue()+ "\t");
	                            attendanceVO.setNumberOfWorkingDays(cell.getNumericCellValue());
	                            break;
	                        case 2:
	                            System.out.print(cell.getNumericCellValue() + "\t");
	                            attendanceVO.setPresentDays(cell.getNumericCellValue());
	                            break;
	                        case 3:
	                            System.out.print(cell.getNumericCellValue() + "\t");
	                            double leaveTypeId = cell.getNumericCellValue();
	                            leaveCriteriaVO leaveVO = new leaveCriteriaVO();
	                            leaveVO.setId((int)leaveTypeId);
	                          	attendanceVO.setLeaveVO(leaveVO);
	                            break;
	                        case 4:
	                            System.out.print(cell.getNumericCellValue() + "\t");
	                            attendanceVO.setNumberOfLeavesTaken(cell.getNumericCellValue());
	                            break;
	                        
	                    }
	                }
	                
	                SalarySlipVO salaryVO = new SalarySlipVO();
			        this.AttendenceService.save(attendanceVO);
			        this.salarySlipService.insert(salaryVO);
	                System.out.println(">>>>");

	                }
	            }
	            file.close();
	        }
	        catch (Exception e)
	        {
	            e.printStackTrace();
	        }
		} catch (Exception e) {
			e.printStackTrace();
		}

	return new ModelAndView ("redirect:/admin/addAttendence");
}
		

/*	@GetMapping(value = "admin/saveAttendence")
	public ModelAndView saveAttendence(@ModelAttribute AttendenceVO AttendenceVO) {
		this.AttendenceService.save(AttendenceVO);
		return new ModelAndView("redirect:/admin/viewAttendence");
	}*/
		

	@GetMapping(value = "admin/viewAttendence")
	public ModelAndView viewAttendence() {
		List<AttendenceVO> AttendenceList = this.AttendenceService.search();
		return new ModelAndView("admin/viewAttendence", "AttendenceList", AttendenceList);
	}

	@GetMapping(value = "admin/deleteAttendence")
	public ModelAndView deleteAttendence(@ModelAttribute AttendenceVO attendenceVO, @RequestParam int id) {
		List<AttendenceVO> AttendenceList = this.AttendenceService.findById(id);
		attendenceVO = AttendenceList.get(0);
		attendenceVO.setStatus(false);
		this.AttendenceService.save(attendenceVO);
		return new ModelAndView("redirect:/admin/viewAttendence");
	}

	/*
	 * @GetMapping(value = "editAttendence") public ModelAndView
	 * editAttendence(@ModelAttribute AttendenceVO AttendenceVO, @RequestParam
	 * int id) { List<AttendenceVO> AttendenceList =
	 * this.AttendenceService.findById(id); AttendenceVO =
	 * AttendenceList.get(0);
	 * 
	 * return new ModelAndView("admin/AttendenceName", "AttendenceVO",
	 * AttendenceVO); }
	 */

}










































