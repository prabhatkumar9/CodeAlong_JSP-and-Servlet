package controller;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import dao.BlogDAO;
import model.Blog;

@WebServlet("/edit")
public class Edit extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public Edit() {
        super();
        
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	    System.out.println("update blog");
		try {
		    updateBlog(request,response);
		}catch(Exception e) {
		    e.printStackTrace();
		}
	}

	protected void updateBlog(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	    Blog blog = new Blog();
	    BlogDAO blogdao = new BlogDAO();
	    
	    int id = Integer.parseInt(request.getParameter("id"));
	    
	    blog = blogdao.selectBlog(id);
	    blogdao.updateBlog(blog);
	    response.sendRedirect("allblogs");
	}

}
