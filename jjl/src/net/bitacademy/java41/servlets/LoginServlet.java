package net.bitacademy.java41.servlets;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import net.bitacademy.java41.dao.MemberDao;
import net.bitacademy.java41.vo.Member;

@WebServlet("/auth/login")
@SuppressWarnings("serial")
public class LoginServlet extends HttpServlet {
	@Override
	protected void doGet(
			HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.setContentType("text/html;charset=UTF-8");
		PrintWriter out = response.getWriter();
		
		out.println("<!DOCTYPE html>");
		out.println("<html>");
		out.println("<head>");
		out.println("<meta charset=\"UTF-8\">");
		out.println("<title>로그인</title>");
		out.println("</head>");
		out.println("<body>");
		out.println("<h1>사용자 로그인</h1> ");
		out.println("<form action=\"login\" > method=\"post\"");
		// 만약 쿠키 정보에 email의 값이 있다면, 기본적으로 그 값을 입력 상자에 출력한다.
		Cookie[] cookies = request.getCookies();
		String email = "";
		String checked = "";
		if ( cookies != null) {
			for(Cookie c : cookies) {
				if (c.getName().equals("email")) {
					email = "value='" + c.getValue() + "'";
					checked = "checked";
					break;
				}
			}
		}

		out.println("Email: <input type=\"text\" name=\"email\" "
				+ email
				+ " placeholder=\"hong@test.com\"><br>");
		out.println("Password: <input type=\"password\" name=\"password\" placeholder=\"password\"><br>");
		out.println("<input type=\"checkbox\" name=\"saveId\" "
				+ checked
				+ " >ID저장<br>");
		out.println("<input type=\"submit\" value=\"Login\">");
		out.println("</form>");
		out.println("</body>");
		out.println("</html>");
	}
	
	@Override
	protected void doPost(
			HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.setContentType("text/html;charset=UTF-8");
		PrintWriter out = response.getWriter();
		
		String email = request.getParameter("email");
		String password = request.getParameter("password");
		String saveId = request.getParameter("saveId");
		MemberDao memberDao = 
				(MemberDao) this.getServletContext().getAttribute("memberDao");
		try {
			Member member = memberDao.getMember(email, password);
			HttpSession session = request.getSession();
			
			if(request.getParameter("saveId") != null) {
				Cookie cookie = new Cookie("email", email);
				cookie.setMaxAge(240); // 쿠키의 생존 시간을 지정한다.
				Cookie cookie1 = new Cookie("saveId", saveId);
				cookie1.setMaxAge(240); // 쿠키의 생존 시간을 지정한다.
				// 컴퓨터를 껐다가 켜도 해당 시간 동안은 유효하다. 
				// 유효하다는 의미는 서버에 해당 쿠키정보를 보낸다는 의미이다.
				response.addCookie(cookie);
				response.addCookie(cookie1);
			} else {
				Cookie cookie = new Cookie("email", null);
				cookie.setMaxAge(0); // 브라우저에 더이상 email 쿠키를 보내지 말 것을 요청.
				// 쿠키의 생존 시간을 지정하지 않으면, 웹브라우저가 실행되는 동안만 유효하다.
				Cookie cookie1 = new Cookie("saveId", null);
				cookie1.setMaxAge(0);
				response.addCookie(cookie);
				response.addCookie(cookie1);
			}
			
			if (member != null) {
				session.setAttribute("member", member);
				response.sendRedirect("../main");
				
			} else {
				session.invalidate();
				out.println("<html><head><title>로그인 결과!</title></head>");
				out.println("<body><p>해당 사용자를 찾을 수 없습니다.</p></body></html>");
				
				response.setHeader(
						"Refresh", "1;url=LoginForm.jsp");
			}
	
			
		} catch (Exception e) {
			e.printStackTrace();
			out.println("<html><head><title>시스템오류!</title></head>");
			out.println("<body><p>실행 오류입니다.</p></body></html>");
		}
	}

}







