package com.codingvictor.newhope.filter;

import java.io.IOException;
import java.util.Locale;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;

import org.springframework.web.servlet.i18n.SessionLocaleResolver;


/**
 * Servlet Filter implementation class LocaleFilter
 */
public class LocaleFilter implements Filter {

	/**
     * Default constructor. 
     */
    public LocaleFilter() {
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see Filter#destroy()
	 */
	public void destroy() {
		// TODO Auto-generated method stub
	}

	/**
	 * @see Filter#doFilter(ServletRequest, ServletResponse, FilterChain)
	 */
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
		
//		ApplicationContext context = new ClassPathXmlApplicationContext("springmvc-servlet.xml");
//	    Internationalization info = (Internationalization) context.getBean("Internationalization");
		
	    String lang = "zh";
	    String country = "CN";
	    
		HttpServletRequest httpServletRequest = (HttpServletRequest)request;
    	    	
    	Cookie[] cookies = httpServletRequest.getCookies();
		
		if (cookies != null && cookies.length > 0) {
			for (Cookie cookie : cookies) {
				if ("lang".equals(cookie.getName())) {
					lang = cookie.getValue();
				}
				if ("country".equals(cookie.getName())) {
					country = cookie.getValue();
				}
			}
		}

		httpServletRequest.getSession().setAttribute(SessionLocaleResolver.LOCALE_SESSION_ATTRIBUTE_NAME, new Locale(lang, country));

		httpServletRequest.getSession().setAttribute("lang", lang);

		httpServletRequest.getSession().setAttribute("country", country);
		
		// pass the request along the filter chain
		chain.doFilter(request, response);
	}

	/**
	 * @see Filter#init(FilterConfig)
	 */
	public void init(FilterConfig fConfig) throws ServletException {
		// TODO Auto-generated method stub
	}

}
