package com.kh.forest.filter;

import java.io.IOException;


import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;

import com.kh.forest.wrapper.F_ProtectPassword;

/**
 * Servlet Filter implementation class EncryptFilter
 */
@WebFilter("*.me")
public class F_EncryptFilter implements Filter {

    /**
     * Default constructor. 
     */
    public F_EncryptFilter() {
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
		HttpServletRequest hRequest = (HttpServletRequest) request; //서블릿에서 사용하는 걸로 다운캐스팅
		
		F_ProtectPassword lw = new F_ProtectPassword(hRequest);
		
		//F_ProtectAccount pa = new F_ProtectAccount(hRequest);
		//request대신에 사용하는 lw
		chain.doFilter(lw, response);
	}

	/**
	 * @see Filter#init(FilterConfig)
	 */
	public void init(FilterConfig fConfig) throws ServletException {
		// TODO Auto-generated method stub
	}

}
