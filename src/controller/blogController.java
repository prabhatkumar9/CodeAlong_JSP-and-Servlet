package controller;
import java.io.IOException;
import java.time.LocalDate;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import dao.BlogDAO;
import model.Blog;

@WebServlet(urlPatterns = {"/new"})
public class blogController extends HttpServlet {
    
	private static final long serialVersionUID = 1L;
	static int i=0;
	
    public blogController() {
        super();
        
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println();
		RequestDispatcher rd = this.getServletContext().getRequestDispatcher("/WEB-INF/views/blogListView.jsp");
		rd.forward(request, response);
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("Entering do post");
		
		String blogTitle = request.getParameter("title");
		String blogDescription = request.getParameter("message");
		LocalDate postedOn = LocalDate.now();
		
		Blog blog = new Blog();
		blog.setBlogId(++i);
		blog.setBlogTitle(blogTitle);
		blog.setBlogDescription(blogDescription);
		blog.setPsotedOn(postedOn);
		
		BlogDAO blogDao = new BlogDAO();
		try {
		    blogDao.insertBlog(blog);
		}catch(Exception e) {
		    e.printStackTrace();
		}
		response.sendRedirect("allblogs");
		//RequestDispatcher rd = this.getServletContext().getRequestDispatcher(("/WEB-INF/views/blogListView.jsp");
		
	}

}
