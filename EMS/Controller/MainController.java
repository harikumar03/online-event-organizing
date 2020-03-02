package com.iim.EMS.Controller;

import java.awt.List;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Date;
import java.util.Iterator;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpRequest;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.context.support.HttpRequestHandlerServlet;
import org.springframework.web.servlet.ModelAndView;

import com.iim.EMS.DAO.UserDAO;
import com.iim.EMS.Model.User;
import com.iim.EMS.Model.Login;

@Controller
public class MainController {
	@Autowired
	private UserDAO userDAO1;
	@RequestMapping("/EMS")
			public String home(Map<String,Object>model) {
			
				System.out.print("Test Loading");
				
				return "index";
		}
		@RequestMapping("/index")
		public String homepage(Map<String,Object>model) {
	
		System.out.print("Test Loading");
		
		return "index";
		}
		@RequestMapping("/login")
		public String Login(Map<String,Object>model) {
	
		System.out.print("Test Loading");
		
		return "login";
		}
		@RequestMapping("/register")
		public String register(Map<String,Object>model) {
	
		System.out.print("Test Loading");
		
		return "register";
		}
		@RequestMapping("/about")
		public String about (Map<String,Object>model,HttpServletRequest request) {
		
			String user = null;
			if(request.getSession().getAttribute("loginUser") != null)
				user = request.getSession().getAttribute("loginUser").toString();

		    //request.getSession().setAttribute("loginUserId", login.getUserId);   @todo

			System.out.print("Test Loading");
			
			return "about";
		}
		@RequestMapping("/contact")
		public String contact(Map<String,Object>model) {
		
			System.out.print("Test Loading");
			
			return "contact";
		}
		@RequestMapping("/blog")
		public String blog(Map<String,Object>model) {
		
			System.out.print("Test Loading");
			
			return "blog";
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
	                        break;
	                    case 2:
	                    	String username = nextCell.getStringCellValue();
	                    	userreg.setUsername(username);
	                    	System.out.printf("username" + username);
	                        //statement.setInt(3, progress);
	                    	break;
	                    case 3:
	                    	String password = nextCell.getStringCellValue();
	                    	userreg.setPassword(password);
	                    	System.out.printf("password"+ password);
	                        //statement.setInt(3, progress);
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
		@RequestMapping(value = "/loginprocess", method = RequestMethod.POST)
		public ModelAndView loginProcess(HttpServletRequest request, HttpServletResponse response,
		  @ModelAttribute("login") Login login) {
		    ModelAndView mav = null;
		    Login user1 = userDAO1.validateUser(login);
		    if (null != user1) {
		    mav = new ModelAndView("index");
		    mav.addObject("username", user1.getLOGIN_NAME()); 
		    request.getSession().setAttribute("loginUser", login.getLOGIN_NAME());

		    request.getSession().setAttribute("loginUserId", login.getLOGIN_ID());   
		    } else {
		    	request.getSession().setAttribute("loginUser", null);

			    request.getSession().setAttribute("loginUserId", null);  

		    mav = new ModelAndView("login");
		    mav.addObject("message", "Username or Password is wrong!!");
		    }
		    return mav;
		}
		  
		@RequestMapping(value = "/user", method = RequestMethod.POST)
		   public String checkUser(@RequestBody User userForm, BindingResult result){//, RedirectAttributes redirectAttrs) {
		       System.out.println("Checking User " + userForm.getUsername() +" Checking Password" + userForm.getPassword()+"test");
		       List users = UserDAO.getAllUsers(userForm.getUsername());
		       boolean userExists = false;
		       String userName = null;
		       //for(User user1 : users){
		//if(user1.getVch_user_name().equalsIgnoreCase(userForm.getVch_user_name()) && user1.getVch_user_password().equalsIgnoreCase(userForm.getVch_user_password())){
		//userExists = true;
		//userName = user.getVch_user_name();
		// System.out.println("User Logged IN " + userForm.getVch_user_name());
		//}
		//}

		       if (!userExists) {
		           System.out.println("Invalid username or password" + userForm.getUsername());
		           //return new ResponseEntity<String>(HttpStatus.CONFLICT);
		       //resp.sendError(HttpServletResponse.SC_INTERNAL_SERVER_ERROR, "Invalid username or password " + userForm.getVch_user_name()); // explicitely put error message in request
		           return null;
		       }
		       // Save client ...
		       //redirectAttrs.addAttribute("userName", "admin").addFlashAttribute("message", "Client Page!");
		       return "Home";
		     
		   }

	}
