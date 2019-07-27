package com.project.alunoproject.handler;

import javax.servlet.http.HttpServletRequest;

import org.springframework.boot.web.servlet.error.ErrorController;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class ErrorHandler  implements ErrorController {

	  @RequestMapping("/error")
	  public String handleError(HttpServletRequest request) {
	      Integer statusCode = (Integer) request.getAttribute("javax.servlet.error.status_code");
	      Exception exception = (Exception) request.getAttribute("javax.servlet.error.exception");
	      return statusCode + ":" + exception.getMessage();
	  }
	
	@Override
	public String getErrorPath() {
		return "/error";
	}
	
}
