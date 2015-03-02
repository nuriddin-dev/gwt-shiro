package testapp.client.service;

import com.google.gwt.user.client.rpc.RemoteService;
import com.google.gwt.user.client.rpc.RemoteServiceRelativePath;
import testapp.client.dto.EventDTO;

import java.util.List;

@RemoteServiceRelativePath("eventservice")
public interface EventService extends RemoteService {
    List<EventDTO> findAll();
}
