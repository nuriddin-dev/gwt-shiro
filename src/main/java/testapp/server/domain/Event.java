package testapp.server.domain;



import testapp.client.dto.EventDTO;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.NamedQuery;
import java.io.Serializable;
import java.util.Date;

@Entity
@NamedQuery(name = "findAll", query = "select e from Event e")
public class Event implements Serializable {
    private Long id;
    private String title;
    private Date date;

    public Event() {
    }

    public Event(EventDTO eventsDTO) {
        id = eventsDTO.getId();
        title = eventsDTO.getTitle();
        date = eventsDTO.getDate();
    }

    @Id
    @GeneratedValue
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
