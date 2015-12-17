
package com.jverstry.LoginLogout.Controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class MyController {

	 @Value("${user}") private String VerifyUsername;
	 @Value("${password}") private String VerifyPassword;
	@RequestMapping(value = "/")
	public String home(Model model) {

		model.addAttribute("CurrPrincipal", SecurityContextHolder.getContext().getAuthentication().getAuthorities());

		if (SecurityContextHolder.getContext().getAuthentication().getAuthorities()
				.contains( (new SimpleGrantedAuthority("ROLE_ADMIN")) ) ||SecurityContextHolder.getContext().getAuthentication().getAuthorities()
				.contains( (new SimpleGrantedAuthority("ROLE_USER")) )) {
			return "AuthenticatedUser";
		} else {
			return "index";
		}

	}

	
	@RequestMapping(value = "/loginPage")
	public String login() {
			return "LoginPage";
	}
}
