import java.io.Serializable;
import java.util.*;

class Note implements Serializable {
    private String title;
    private String content;
    private String dateCreated;

    public Note(String title, String content, Date dateCreated) {
        this.title = title;
        this.content = content;
        this.dateCreated = dateCreated.toString();
    }

    public String getTitle() {
        return title;
    }

    public String getContent() {
        return content;
    }

    public String getDateCreated() {
        return dateCreated;
    }
}
