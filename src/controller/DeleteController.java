package controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.BlogDAO;

@WebServlet(urlPatterns = {"/delete"})
public class DeleteController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
 
    public DeleteController() {
        super();
   
    }


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("Delete blog");
		try {
		    deleteBlog(request,response);
		}catch(Exception e) {
		    e.printStackTrace();
		}
	}

	private void deleteBlog(HttpServletRequest request, HttpServletResponse response) throws IOException {
	    int id = Integer.parseInt(request.getParameter("id"));
	    BlogDAO blogdao = new BlogDAO();
	    blogdao.deleteBlog(id);
	    response.sendRedirect("allblogs");
	}

}
