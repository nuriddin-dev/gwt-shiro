package testapp.client.dto;

import java.io.Serializable;
import java.util.Date;

public class EventDTO implements Serializable{
    private Long id;
    private String title;
    private Date date;

    public EventDTO() {
    }

    public EventDTO(Long id, String title, Date date) {
        this.id = id;
        this.title = title;
        this.date = date;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }
}
