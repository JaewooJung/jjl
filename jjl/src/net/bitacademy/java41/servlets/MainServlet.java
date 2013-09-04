package net.bitacademy.java41.servlets;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.GenericServlet;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import net.bitacademy.java41.vo.Member;

@WebServlet("/main")
@SuppressWarnings("serial")
public class MainServlet extends GenericServlet {

	@Override
	public void service(ServletRequest request, ServletResponse response)
			throws ServletException, IOException {
		//Member member  = (Member)request.getAttribute("member");
		HttpSession session = ((HttpServletRequest)request).getSession();
		Member member = (Member)session.getAttribute("member");
		
		response.setContentType("text/html;charset=UTF-8");
		PrintWriter out = response.getWriter();
		
		out.println("<html><head><title>메인</title></head>");
		out.println("<body>");
		out.println("<td align=\"center\"><h1>로그인 성공.<br> 메인 화면으로 이동합니다.</h1>");
		out.println("<p>이메일:" + member.getEmail() + "<br>" 
				+ "이름:" + member.getName() + "<br>"
				+ "전화:" + member.getTel() + "</p>"
				+ "</td></body></html>");
		out.println("</body>");
		out.println("</html>");
		out.println(
				"<meta http-equiv='Refresh' content='2;url=../jjl/auth/main.html'>"
				+ "</head>");
	
		
	}

}
