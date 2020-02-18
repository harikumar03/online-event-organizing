package com.iim.EMS.Controller;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Date;
import java.util.Iterator;
import java.util.Map;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.iim.EMS.DAO.UserDAO;
import com.iim.EMS.Model.User;
@Controller
public class MainController {
	@Autowired
	private UserDAO userDAO1;

		@RequestMapping("/EMS")
			public String home(Map<String,Object>model) {
			
				System.out.print("Test Loading");
				
				return "contact";
		}
		
		@RequestMapping("/ExcelImport")
		public String ExcelImport(Map<String,Object>model) {
		
			System.out.print("Test Excel Import");
			
			//String jdbcURL = "jdbc:mysql://localhost:3306/sales";
	        //String username = "user";
	        //String password = "password";
	 
	        String excelFilePath = "/EMS/Students.xlsx";
	 
	        //int batchSize = 20;
	 
	        //Connection connection = null;
	 
	        try {
	            long start = System.currentTimeMillis();
	             
	            FileInputStream inputStream = new FileInputStream(excelFilePath);
	 
	            Workbook workbook = new XSSFWorkbook(inputStream);
	 
	            Sheet firstSheet = workbook.getSheetAt(0);
	            Iterator<Row> rowIterator = firstSheet.iterator();
	 
	            //connection = DriverManager.getConnection(jdbcURL, username, password);
	            //connection.setAutoCommit(false);
	  
	            //String sql = "INSERT INTO students (name, enrolled, progress) VALUES (?, ?, ?)";
	            //PreparedStatement statement = connection.prepareStatement(sql);    
	             
	            //int count = 0;
	             
	            rowIterator.next(); // skip the header row
	             
	            while (rowIterator.hasNext()) {
	                Row nextRow = rowIterator.next();
	                Iterator<Cell> cellIterator = nextRow.cellIterator();
	 
	                User userreg=new User();
	                while (cellIterator.hasNext()) {
	                    Cell nextCell = cellIterator.next();
	 
	                    int columnIndex = nextCell.getColumnIndex();
	                    int sno=0;
	                    switch (columnIndex) {
	                    case 0:    
	                    	if(nextCell.getNumericCellValue()>0)
	                    	{
	                    	sno = (int) nextCell.getNumericCellValue();	  
	                    	System.out.printf("sno "+ sno);
	                    	userreg.setSno(sno);
	                    	}
	                    	else
		                    	userreg.setSno(0);
	                        //statement.setString(1, name);
	                        break;
	                    	
	                    case 1:
	                        Date enrollDate = nextCell.getDateCellValue();
	                        userreg.setEnrollDate(enrollDate);
	                        System.out.printf("enrollDate "+ enrollDate);
	                        //statement.setTimestamp(2, new Timestamp(enrollDate.getTime()));
	                    /*case 2:
	                    	String uname = nextCell.getStringCellValue();
	                        //statement.setInt(3, progress);
	                    case 3:
	                    	String pass = nextCell.getStringCellValue();
	                        //statement.setInt(3, progress);*/
	                    }
	                    
	                }
	                userDAO1.UserRegistration(userreg);
	                 
	                //statement.addBatch();
	                 
	                /*if (count % batchSize == 0) {
	                    statement.executeBatch();
	                } */             
	 
	            }
	 
	            workbook.close();
	             
	            // execute the remaining queries
	            //statement.executeBatch();
	  
	            //connection.commit();
	            //connection.close();
	             
	            long end = System.currentTimeMillis();
	            System.out.printf("Import done in %d ms\n", (end - start));
	             
	        } catch (IOException ex1) {
	            System.out.println("Error reading file");
	            ex1.printStackTrace();
	        } /*catch (SQLException ex2) {
	            System.out.println("Database error");
	            ex2.printStackTrace();
	        }*/
			return "contact";
			
	 
			
			
	}
}
