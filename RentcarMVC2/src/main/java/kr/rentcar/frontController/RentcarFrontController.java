package kr.rentcar.frontController;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("*.do")
public class RentcarFrontController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		String URI = req.getRequestURI();
		String ctx = req.getContextPath();
		String command = URI.substring(ctx.length());
		
		Controller controller = null;
		String nextPage = null;
		HandlerMapping mapping = new HandlerMapping();
		controller = mapping.getController(command);
		nextPage = controller.requestHandler(req, res);
		
		if(nextPage != null) {
			if(nextPage.indexOf("redirect:") != -1) {
				res.sendRedirect(nextPage.split(":")[1]);
			}else {
				RequestDispatcher rd = req.getRequestDispatcher(ViewResolver.makeView(nextPage));
				rd.forward(req, res);
			}
		}
	}
}
