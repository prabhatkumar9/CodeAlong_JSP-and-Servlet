package model;
import java.time.LocalDate;

public class Blog {
     private int blogId;
     private String blogTitle;
     private String blogDescription;
     private LocalDate psotedOn;
     
    public int getBlogId() {
        return blogId;
    }
    public void setBlogId(int blogId) {
        this.blogId = blogId;
    }
    public String getBlogTitle() {
        return blogTitle;
    }
    public void setBlogTitle(String blogTitle) {
        this.blogTitle = blogTitle;
    }
    public String getBlogDescription() {
        return blogDescription;
    }
    public void setBlogDescription(String blogDescription) {
        this.blogDescription = blogDescription;
    }
    public LocalDate getPsotedOn() {
        return psotedOn;
    }
    public void setPsotedOn(LocalDate psotedOn) {
        this.psotedOn = psotedOn;
    }
     
}
