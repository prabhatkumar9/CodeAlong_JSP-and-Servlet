package dao;
import java.util.List;
import model.Blog;

public interface blogDaoInterface {
    
    void insertBlog(Blog blog) ;
    Blog selectBlog(int blogId);
    List<Blog> selectAllBlogs();
    boolean deleteBlog(int id );
    boolean updateBlog(Blog blog);
}
