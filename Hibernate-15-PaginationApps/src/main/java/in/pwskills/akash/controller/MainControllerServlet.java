package in.pwskills.akash.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.hibernate.HibernateException;

import in.pwskills.akash.entity.InsurancePolicyDTO;
import in.pwskills.akash.service.InsurancePolicyManagementService;
import in.pwskills.akash.service.InsurancePolicyMgmtServiceImpl;

/**
 * Servlet implementation class MainControllerServlet
 */
@WebServlet(value = "/controller", loadOnStartup = 1)
public class MainControllerServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	private InsurancePolicyManagementService service;

	@Override
	public void init() throws ServletException {
		service = new InsurancePolicyMgmtServiceImpl();
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	@Override
	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		int pageNo = 0;
		int pageSize = 3; // defautl pageSize
		long pagesCount = 0;
		
		String input = request.getParameter("s1");
		
		HttpSession session = null;
		List<InsurancePolicyDTO> listDto = null;
		RequestDispatcher rd = null;
		String targetPage = null;

		session = request.getSession(true);

		if (input.equalsIgnoreCase("generateReport")) {
			// user clicked on submit button
			pageSize = Integer.parseInt(request.getParameter("pageSize"));

			// default pageNo is 1 for initial request[index.html]
			pageNo = 1;

			// keeping pageSize in session scope to access across multiple requests
			if (session != null) {
				session.setAttribute("pageSize", pageSize);
			}

		} else {
			// user clicked on hyperlink for what pageNo to display
			pageNo = Integer.parseInt(request.getParameter("pageNo"));

			// keeping pageSize in session scope to access across multiple requests
			if (session != null) {
				session.setAttribute("pageSize", pageSize);
			}

		}

		try {
			// No of pages need to display the records in pagination style
			pagesCount = service.fetchPagesCount(pageSize);

			// Get the records in each page to print on the UI
			listDto = service.fetchPageData(pageSize, pageNo);

			request.setAttribute("policyList", listDto);
			request.setAttribute("pagesCount", pagesCount);
			request.setAttribute("pageNo", pageNo);
			targetPage = "/report.jsp";

		} catch (HibernateException he) {
			he.printStackTrace();
			targetPage = "/error.jsp";
		} catch (Exception e) {
			e.printStackTrace();
			targetPage = "/error.jsp";
		}

		// sending the request to jsp page
		rd = request.getRequestDispatcher(targetPage);
		rd.forward(request, response);
	}

}
