package com.iim.EMS.Controller;

import java.util.Map;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
@Controller
public class MainController {

		@RequestMapping("/EMS")
			public String home(Map<String,Object>model) {
			
				System.out.print("Test Loading");
				
				return "home";
		}
}
