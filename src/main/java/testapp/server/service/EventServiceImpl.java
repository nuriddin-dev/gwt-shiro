package testapp.server.service;

import com.google.gwt.user.server.rpc.RemoteServiceServlet;
import testapp.client.dto.EventDTO;
import testapp.client.service.EventService;
import testapp.server.domain.Event;
import testapp.server.util.JpaUtil;

import javax.persistence.EntityManager;
import java.util.ArrayList;
import java.util.List;

public class EventServiceImpl extends RemoteServiceServlet implements EventService {
    @Override
    public List<EventDTO> findAll() {
        EntityManager em = JpaUtil.getEntityManager();
        List<Event> eventList = em.createNamedQuery("findAll").getResultList();
        List<EventDTO> eventDTOList = new ArrayList<EventDTO>();
        for(Event event : eventList){
            eventDTOList.add(createEventsDTO(event));
        }
        return eventDTOList;
    }

    private EventDTO createEventsDTO(Event event) {
        return new EventDTO(event.getId(), event.getTitle(), event.getDate());
    }
}
