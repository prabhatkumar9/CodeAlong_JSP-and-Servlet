package controller;
import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import dao.BlogDAO;
import model.Blog;

@WebServlet("/allblogs")
public class viewAllBlogController extends HttpServlet {
	private static final long serialVersionUID = 1L;
 
    public viewAllBlogController() {
        super();
       
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	    System.out.println("view all blogs");
	    System.out.println("Getting all blog post");
	    BlogDAO blogdao = new BlogDAO();
	    List<Blog> listBlog = blogdao.selectAllBlogs();
	    
	    for(Blog blog: listBlog) {
		System.out.println(blog.getBlogId());
		System.out.println(blog.getBlogTitle());
		System.out.println(blog.getBlogDescription());
		System.out.println(blog.getPsotedOn());
	    }
	    request.setAttribute("listBlog", listBlog);
	    RequestDispatcher rd = this.getServletContext().getRequestDispatcher("/WEB-INF/views/blogView.jsp");
	    rd.forward(request, response);
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

	}

}
