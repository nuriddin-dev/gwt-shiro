package testapp.client.service;

import com.google.gwt.user.client.rpc.AsyncCallback;
import testapp.client.dto.EventDTO;

import java.util.List;

public interface EventServiceAsync {
    void findAll(AsyncCallback<List<EventDTO>> async);
}
