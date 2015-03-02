package testapp.server;

import testapp.server.domain.Event;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import java.util.List;

public class TestDb {
    public static void main(String[] args) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("sample");
        EntityManager em = emf.createEntityManager();
        List<Event> events = em.createNamedQuery("findAll", Event.class).getResultList();
        printEvents(events);
    }

    static void printEvents(List<Event> events) {
        for (Event event : events) {
            System.out.println(event.getTitle());
        }
    }
}
