package com.kh.forest.member.controller;

import java.io.IOException;
import java.nio.charset.Charset;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Base64;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.kh.forest.member.model.service.F_MemberService;
import com.kh.forest.member.model.vo.Member;

/**
 * Servlet implementation class F_MemberUpdateServlet
 */
@WebServlet("/updateMember.me")
public class F_MemberUpdateServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public F_MemberUpdateServlet() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();

		Member m = (Member) session.getAttribute("loginMember");
		String userNo = m.getUserNo();
		String postCode = request.getParameter("postcode");
		String roadAddress = request.getParameter("roadAddress");
		String detailAddress = request.getParameter("detailAddress");
		String address = postCode + "$" + roadAddress + "$" + detailAddress;
		String phone = request.getParameter("phone1") + request.getParameter("phone2")
		+ request.getParameter("phone3");
		String email = request.getParameter("email1") + request.getParameter("email2");
		String password1 = request.getParameter("password3");
		String bank = request.getParameter("bankName");
		String account = request.getParameter("account");

		if(password1 == "") {

			Member updateMember = new Member();
			updateMember.setUserNo(userNo);
			updateMember.setPassword(m.getPassword());
			updateMember.setPhone(phone);
			updateMember.setEmail(email);
			updateMember.setAddress(address);
			updateMember.setBank(bank);
			updateMember.setAccount(account);

			Member selectMember = new F_MemberService().updateMember(updateMember);
			session.setAttribute("loginMember", selectMember);
			request.setAttribute("selectMember", selectMember);
			request.getRequestDispatcher("views/user/mypage/F_MyPageSection_memberInfo.jsp").forward(request, response);
			
		
		}else {
			MessageDigest md;
			try {
				md = MessageDigest.getInstance("SHA-512");
				byte[] bytes = password1.getBytes(Charset.forName("UTF-8"));

				md.update(bytes);

				password1 = Base64.getEncoder().encodeToString(md.digest());


				Member updateMember = new Member();
				updateMember.setUserNo(userNo);
				updateMember.setPassword(password1);
				updateMember.setPhone(phone);
				updateMember.setEmail(email);
				updateMember.setAddress(address);
				updateMember.setBank(bank);
				updateMember.setAccount(account);

				Member selectMember = new F_MemberService().updateMember(updateMember);
				
				/*session.setAttribute("loginMember", selectMember);
				
				request.setAttribute("selectMember", selectMember);
				request.getRequestDispatcher("views/user/mypage/F_MyPageSection_memberInfo.jsp").forward(request, response);*/
				request.getSession().invalidate();
				request.setAttribute("errorCode", "83");
				request.getRequestDispatcher("views/user/member/error/F_loginFalse.jsp").forward(request, response);
				

			} catch (NoSuchAlgorithmException e) {
				e.printStackTrace();
			}

		}



	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
