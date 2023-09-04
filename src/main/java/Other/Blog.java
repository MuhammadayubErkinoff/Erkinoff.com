package Other;

public class Blog {
    private int ID;
    private String title;
    private String blog;

    private String date;

    public Blog() {
    }

    public Blog(int ID, String title, String blog, String date) {
        this.ID = ID;
        this.title = title;
        this.blog = blog;
        this.date = date;
    }

    public int getID() {
        return ID;
    }

    public void setID(int ID) {
        this.ID = ID;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getBlog() {
        return blog;
    }

    public void setBlog(String blog) {
        this.blog = blog;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }
}
