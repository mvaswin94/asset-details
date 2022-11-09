package com.asset.login;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping(value = "/asset")
public class LoginController {
		
		@RequestMapping(value = "/login", method = RequestMethod.GET)
		public String loginForm() {
			//System.out.println("TEST NOW");
			return "login";
		}
		
		@RequestMapping(value = "/dashboard", method = RequestMethod.POST)
		public String loginFormSubmit() {
			return "dashboard";
		}
		
		@RequestMapping(value = "/dashboard", method = RequestMethod.GET)
		public String dashboard() {
			//System.out.println("TEST NOW");
			return "dashboard";
		}
}

