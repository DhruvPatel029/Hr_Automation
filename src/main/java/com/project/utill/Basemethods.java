package com.project.utill;

import java.io.File;
import java.io.FileOutputStream;
import java.util.List;
import java.util.Properties;

import javax.mail.Authenticator;
import javax.mail.Message;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.User;

import com.amazonaws.auth.BasicAWSCredentials;
import com.amazonaws.services.s3.AmazonS3Client;
import com.amazonaws.services.s3.model.CannedAccessControlList;
import com.amazonaws.services.s3.model.PutObjectRequest;
import com.itextpdf.text.Document;
import com.itextpdf.text.Font;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.pdf.PdfPCell;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.pdf.PdfWriter;
import com.project.Model.AllowanceDeductionVO;
import com.project.Model.AttendenceVO;
import com.project.Model.EmployeeVO;

public class Basemethods {
	
/*
	final static String accesskey = "AKIA3IOYOK3D4FFPCL75";
	final static String secretkey = "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";*/
	final static String bucketName = "hrautomation2022";

	public static String getUser(){
		User user = (User) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
		String userName = user.getUsername();
		return userName;
		
		
	} 
	@SuppressWarnings("rawtypes")
	public static String generatePaySlip(EmployeeVO employeeVO ,AttendenceVO attendanceVO,String path ,String basicSalary, List allowanceList, List deductionList){

		
		String allowance = "";
		String deduction = "";
		
		Double grandTotal = 0.0d;
		Double netPayable = 0.0d;
		Double total = 0.0d;
		
		int bs = Integer.parseInt(basicSalary);
		
		grandTotal = grandTotal + bs;
		
		System.out.println("****************allowances*************************");
		
		for(int i = 0 ; i < allowanceList.size(); i++){
			AllowanceDeductionVO allowanceVO = (AllowanceDeductionVO) allowanceList.get(i);
			
			String allowanceType =	allowanceVO.getAllowDedtype();
			int limit = allowanceVO.getAllowancelimit();
		
			
			double d= ( bs * limit) / 100;
			
			String data = "  " +  allowanceType + "  : " + d; 
		
			System.out.println(data);
		
		allowance = allowance + " \n"  + data ;
		
		grandTotal = grandTotal +  d;
		
		}
		
		
		System.out.println("****************DEDUCTION*************************");
		
		
		for(int j = 0 ; j < deductionList.size() ; j++){
			
			AllowanceDeductionVO allowanceVO = (AllowanceDeductionVO) deductionList.get(j);
			String deductionType = allowanceVO.getAllowDedtype();
			int limit = allowanceVO.getAllowancelimit();
			
			double d= ( bs * limit) / 100;
			
			total = total + d ;
			
			String data = "  " +deductionType + "  : " + d; 
		
			System.out.println(data);
		
			deduction = deduction + " \n" + data ;
		}
		
		
		
		System.out.println(allowance);
		System.out.println(deduction);
		
		String name = employeeVO.getFirstName() + " " + employeeVO.getLastName();
		String designation = employeeVO.getDesignationVO().getDesignationName();
		String department = employeeVO.getDepartmentVO().getDepartmentName();
		
		String month = attendanceVO.getMonth();
		Double leaveTaken = attendanceVO.getNumberOfLeavesTaken();
		Double workingDays= attendanceVO.getNumberOfWorkingDays();
		Double presentDays = attendanceVO.getPresentDays();
		double absentDays = workingDays - presentDays;
		double basicSalary1 = Double.parseDouble(basicSalary);
		double daySalary = basicSalary1/workingDays;
		double salary_1 = basicSalary1 - (absentDays*daySalary);
		grandTotal = grandTotal- (absentDays*daySalary);
		netPayable = grandTotal - total ; 
		Document document = new Document();

        try {
            PdfWriter.getInstance(document,
                new FileOutputStream(path+"//salary"+month+".pdf"));
  
            document.open();

            PdfPTable table = new PdfPTable(2); // 2 columns.x
            table.setWidthPercentage(100);
            Font font = new Font(Font.FontFamily.COURIER, 8);
            Font font1 = new Font(Font.FontFamily.COURIER, 12);         
            
            
            PdfPCell cell1 = new PdfPCell(new Paragraph("Name of Employee: " + name+"\n\nDesignation: " + designation + " \n\nDepartment : " + department ,font));
            PdfPCell cell2 = new PdfPCell(new Paragraph("Month: " + month + " \n\nTotal Working Days: " + workingDays + "\n\nLeave Taken:" + leaveTaken,font));
            
            PdfPCell cell3 = new PdfPCell(new Paragraph("SALARY",font1));
            PdfPCell cell4 = new PdfPCell(new Paragraph("DEDUCTION",font1));
            
            PdfPCell cell5 = new PdfPCell(new Paragraph("Basic: " + basicSalary +"\n\n\nSpecial Allowance:\n\n " + allowance+ "\n\n\n\n Salary of Total working days:"+salary_1+" \n\n\n\n\n\n\n\n\n Grand Total: " + grandTotal,font));
            PdfPCell cell6 = new PdfPCell(new Paragraph("\n\n\nDeductions: \n\n" + deduction + " \n\n\n\n\n\n\n\n\n Net Payable: " + netPayable,font));

            cell1.setFixedHeight(50);
            cell2.setFixedHeight(50);
            
            cell3.setFixedHeight(20);
            	cell3.setIndent(100);
            cell4.setFixedHeight(20);
            	cell4.setIndent(100);
            
            cell5.setFixedHeight(150);
            cell6.setFixedHeight(150);
            
            
            float[] columnWidths = {1f, 1f};

            table.setWidths(columnWidths);
            
            table.addCell(cell1);
            table.addCell(cell2);
            table.addCell(cell3);
            table.addCell(cell4);
            table.addCell(cell5);
            table.addCell(cell6);
           
            
            document.add(table);

            document.close();
            
            
            
            
        } catch(Exception e){
        	e.printStackTrace();
        }
        
        return path+"//salary"+month+".pdf";
	}
	
	@SuppressWarnings("deprecation")
	public static String uploadIntoS3(File file,String employeeId){
		
		System.out.println(file.getName());
		System.out.println(file.getAbsolutePath());
		
		AmazonS3Client s3Client=new AmazonS3Client(new BasicAWSCredentials("AKIA3VRMPRCH5I2KYZNE","8k81xV32GW+NeTFu1b00mF3MX5Lm5QhEqjeDQ+sx"));
		
		String link ="";
		String key = employeeId+"/"+file.getName();
		try{
				PutObjectRequest request = new PutObjectRequest(bucketName, key, file);
	            request.setCannedAcl(CannedAccessControlList.PublicRead);
	            s3Client.putObject(request);

				link = s3Client.getUrl(bucketName, key).toString();
				System.out.println(link);
	            
		}catch(Exception e){
			System.out.println(e);
		}
		
		return link;
	}
	
	
	public static String generatepassword(){
		int n = 8;
		// chose a Character random from this String 
        String AlphaNumericString = "ABCDEFGHIJKLMNOPQRSTUVWXYZ"
                                    + "0123456789"
                                    + "abcdefghijklmnopqrstuvxyz"; 
  
        // create StringBuffer size of AlphaNumericString 
        StringBuilder sb = new StringBuilder(n); 
  
        for (int i = 0; i < n; i++) { 
  
            // generate a random number between 
            // 0 to AlphaNumericString variable length 
            int index 
                = (int)(AlphaNumericString.length() 
                        * Math.random()); 
  
            // add Character one by one in end of sb 
            sb.append(AlphaNumericString 
                          .charAt(index)); 
        } 
  
        return sb.toString(); 

	}
	@SuppressWarnings("unused")
	public static void sendMail (String to ,String name , String securityKey){
		final String from = "wastemanagmentai@gmail.com";
		final String username = "waste management";
		final String password = "aiwastemanagment";

		String host = "smtp.gmail.com";

		Properties props = new Properties();
		props.put("mail.smtp.auth", "true");
		props.put("mail.smtp.starttls.enable", "true");
		props.put("mail.smtp.host", host);
		props.put("mail.smtp.port", "587");
		
		Authenticator auth = new Authenticator() {
			//override the getPasswordAuthentication method
			protected PasswordAuthentication getPasswordAuthentication() {
				return new PasswordAuthentication(from, password);
			}
		};
		Session session = Session.getInstance(props, auth);

		try {
			Message message = new MimeMessage(session);
			message.setFrom(new InternetAddress(from));
			message.setRecipients(Message.RecipientType.TO,
					InternetAddress.parse(to));
			message.setSubject("Approve ");
			/*
			 * int num = 0; String pass = ""; for (int i = 0; i < 4;
			 * i++) { num = (int) (Math.random() * 10); pass += num; }
			 * 
			 * System.out.println(pass);
			 * 
			 * s.setAttribute("password", pass);
			 */

			message.setText(" Hello " + name  + " your password is " + securityKey 
					 );

			Transport.send(message);

			System.out.println("Sent message successfully....");

		} catch (Exception e) {

			e.printStackTrace();
		}

	}		
	
	// Send mail to user
		protected static void sendMail1(String email, String subject , String content) {

			java.util.Properties properties = new java.util.Properties();
			properties.put("mail.smtp.auth", "true");
			properties.put("mail.smtp.starttls.enable", "true");
			javax.mail.Session mailSession = javax.mail.Session.getInstance(properties);

			try {
				MimeMessage message = new MimeMessage(mailSession);

				message.setContent(content, "text/html");
				message.setSubject(subject);

				InternetAddress sender = new InternetAddress("wastemanagmentai@gmail.com", "HR_Automation Portal");
				InternetAddress receiver = new InternetAddress(email);
				message.setFrom(sender);
				message.setRecipient(Message.RecipientType.TO, receiver);
				message.saveChanges();

				javax.mail.Transport transport = mailSession.getTransport("smtp");
				transport.connect("smtp.gmail.com", 587, "wastemanagmentai@gmail.com" , "aiwastemanagment");
				transport.sendMessage(message, message.getAllRecipients());
				transport.close();

			} catch (Exception e) {
				e.printStackTrace();
			}

		}
	
}
