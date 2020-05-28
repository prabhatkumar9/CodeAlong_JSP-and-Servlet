package dao;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import model.Blog;
import utility.ConnectionManager;

public class BlogDAO  implements blogDaoInterface{

    @Override
    public void insertBlog(Blog blog) {
	System.out.println("INsert blog sql");
	String sql = "insert into blog values(seq_blog.nextval,?,?,?)";
	try {
	    Connection con = ConnectionManager.getConnection();
	    PreparedStatement ps = con.prepareStatement(sql);
	    ps.setInt(1, blog.getBlogId());
	    ps.setString(2, blog.getBlogTitle());
	    ps.setString(3, blog.getBlogDescription());
	    ps.setDate(4, java.sql.Date.valueOf(blog.getPsotedOn()));
	    ps.executeQuery();
	}catch(Exception e) {
	    System.out.println(e);
	}
	
    }

    @Override
    public Blog selectBlog(int blogId) {
	Blog blog = new Blog();
	String select_blog = "SELECT  BLOGTITLE, BLOGDESCRIPTION,POSTEDON  FROM Customers where BLOGID= "+blogId;
	try {
	    Connection con = ConnectionManager.getConnection();
	    PreparedStatement ps = con.prepareStatement(select_blog);
	    System.out.println(ps);
	    ResultSet rs = ps.executeQuery();
	    while(rs.next()) {
		String title = rs.getString("blogTitle");
		String description = rs.getString("blogDescription");
		LocalDate postedOn = rs.getDate("PostedOn").toLocalDate();

		blog.setBlogId(blogId);
		blog.setBlogTitle(title);
		blog.setBlogDescription(description);
		blog.setPsotedOn(postedOn);
	    }
	    
	}catch(Exception e) {
	    System.out.println(e);
	}
	return blog;
    }

    @Override
    public List<Blog> selectAllBlogs() {
	Blog blog = null;
	List<Blog> bloglist = new ArrayList<Blog>();
	String sql = "select * from blog";
	try {
	    Connection con = ConnectionManager.getConnection();
	    PreparedStatement ps = con.prepareStatement(sql);
	    System.out.println(ps);
	    ResultSet rs = ps.executeQuery();
	    while(rs.next()) {
		int id = rs.getInt("blogId");
		String title = rs.getString("blogTitle");
		String description = rs.getString("blogDescription");
		LocalDate postedOn = rs.getDate("PostedOn").toLocalDate();
		
		blog = new Blog();
		blog.setBlogId(id);
		blog.setBlogTitle(title);
		blog.setBlogDescription(description);
		blog.setPsotedOn(postedOn);
		bloglist.add(blog);
	    }
	    
	}catch(Exception e) {
	    System.out.println(e);
	}
	return bloglist;
	
    }

    @Override
    public boolean deleteBlog(int id) {
	System.out.println(id);
	String delete_Sql = "delete from blog where blogId = ?";
	boolean rowDeleted = false;
	try {
	    Connection con = ConnectionManager.getConnection();
	    PreparedStatement ps = con.prepareStatement(delete_Sql);
	    ps.setInt(1, id);
	    rowDeleted=ps.executeUpdate()>0;
	}catch(Exception e) {
	    System.out.println(e);
	}
	return rowDeleted;
    }

    @Override
    public boolean updateBlog(Blog blog) {
	String sql = "update description from blog where id = ?";
	boolean rowUpdated = false;
//	try {
//	    Connection con = ConnectionManager.getConnection();
//	    PreparedStatement ps = con.prepareStatement(sql);
//	    ps.setInt(1, id);
//	    rowDeleted=ps.executeUpdate()>0;
//	}catch(Exception e) {
//	    System.out.println(e);
//	}
	return rowUpdated;
    }

}
