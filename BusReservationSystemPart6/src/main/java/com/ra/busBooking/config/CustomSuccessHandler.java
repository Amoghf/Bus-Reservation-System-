package com.ra.busBooking.config;

import java.io.IOException;
import java.util.Collection;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.web.DefaultRedirectStrategy;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;
import org.springframework.stereotype.Component;

@Component
public class CustomSuccessHandler implements AuthenticationSuccessHandler {

	@Override
	public void onAuthenticationSuccess(HttpServletRequest request, HttpServletResponse response,
			Authentication authentication) throws IOException, ServletException {

		String redirectUrl = null;

		Collection<? extends GrantedAuthority> authorities = authentication.getAuthorities();
		for (GrantedAuthority grantedAuthority : authorities) {
			if (grantedAuthority.getAuthority().equals("USER")) {
				redirectUrl = "/dashboard";
				break;
			} else if (grantedAuthority.getAuthority().equals("ADMIN")) {
				redirectUrl = "/adminScreen";
				break;
			}
		}
		if (redirectUrl == null) {
			throw new IllegalStateException();
		}
		new DefaultRedirectStrategy().sendRedirect(request, response, redirectUrl);
	}
}
//Design Principles Used:
//Single Responsibility Principle (SRP): The class is responsible for handling the success of authentication by determining the appropriate redirect URL based on the user's role.
//SOLID Principles Violated:
//Open/Closed Principle (OCP): The class could be closed for modification by extracting the logic for determining the redirect URL into separate classes or strategies. This would make it easier to extend the behavior without modifying existing code.
//Dependency Injection (DI):Spring uses dependency injection extensively to manage object dependencies. In the SpringSecurityConfig class, dependencies like DefaultUserServiceImpl and AuthenticationSuccessHandler are injected using @Autowired annotations.
//Strategy Pattern:The CustomSuccessHandler class implements the AuthenticationSuccessHandler interface, which defines a strategy for handling successful authentication. The onAuthenticationSuccess method in this class encapsulates different strategies for determining the redirect URL based on the user's role.
//Factory Method Pattern:In the SpringSecurityConfig class, the passwordEncoder and authenticationProvider methods are annotated with @Bean, indicating that they produce bean instances. These methods act as factories for creating instances of BCryptPasswordEncoder and DaoAuthenticationProvider, respectively.
//Template Method Pattern:The configure methods in the SpringSecurityConfig class are overridden from the WebSecurityConfigurerAdapter class, which follows the Template Method pattern. These methods provide a template for configuring security settings in a web application, allowing subclasses to customize specific aspects of security configuration.
//Singleton Pattern:Spring beans are by default singleton scoped, ensuring that only one instance of a bean is created per container. This is evident in the SpringSecurityConfig class, where beans like BCryptPasswordEncoder and DaoAuthenticationProvider are defined using @Bean annotations.
//Factory Pattern:
//While not explicitly shown in the provided code snippets, Spring uses factory patterns internally for creating various beans and managing application contexts.
//Template View Pattern:
//In the ThymeleafConfig class, a template resolver is configured for Thymeleaf, a popular templating engine. This follows a template view pattern where a central resolver is used to locate templates based on specific criteria.