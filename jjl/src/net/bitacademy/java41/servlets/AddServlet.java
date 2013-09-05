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

@WebServlet("/auth/add")
@SuppressWarnings("serial")
public class AddServlet extends HttpServlet {
	@Override
	protected void doGet(
			HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
			}
	
	@Override
	protected void doPost(
			HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.setContentType("text/html;charset=UTF-8");
		PrintWriter out = response.getWriter();
		
		String email = request.getParameter("email");
		String mname = request.getParameter("mname");
		String password = request.getParameter("password");
		String tel = request.getParameter("tel");
		String blog = request.getParameter("blog");
		
		MemberDao memberDao = 
				(MemberDao) this.getServletContext().getAttribute("memberDao");
		
		
		if("".equals(email) | "".equals(mname) | "".equals(password) | "".equals(tel) | "".equals(blog)){
			
			out.println("다음 필드를 입력하고 다시 시도해주세요.<br>");
			if("".equals(email)){
				out.println("이메일<br> ");
			}
			if("".equals(mname)){
				out.println("이름<br>");
			}
			if("".equals(password)){
				out.println("비밀번호<br>");
			}
			if("".equals(tel)){
				out.println("전화번호<br>");
			}
			if("".equals(blog)){
				out.println("블로그<br>");
			}
			
			response.setHeader(
					"Refresh", "2;url=AddMember.jsp");
			
			
		}else{
			
			try {
				memberDao.add(email, mname, password, tel, blog);
				out.println("멤버가 추가되었습니다. 로그인 화면으로 이동합니다.");
				response.setHeader(
						"Refresh", "2;url=LoginForm.jsp");
				
				
			} catch (Exception e) {
				e.printStackTrace();
				out.println("<html><head><title>시스템오류!</title></head>");
				out.println("<body><p>실행 오류입니다.</p></body></html>");
			}
			
		}
		
		
		
		
	}

}







