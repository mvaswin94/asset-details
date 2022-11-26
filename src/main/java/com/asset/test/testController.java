package com.asset.test;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping(value = "/asset")
public class testController {
		
		@RequestMapping(value = "/test", method = RequestMethod.GET)
		public String test() {
			return "z-test";
		}
}
