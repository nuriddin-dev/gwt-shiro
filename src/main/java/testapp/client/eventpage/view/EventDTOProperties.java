package testapp.client.eventpage.view;

import com.sencha.gxt.core.client.ValueProvider;
import com.sencha.gxt.data.shared.ModelKeyProvider;
import com.sencha.gxt.data.shared.PropertyAccess;
import testapp.client.dto.EventDTO;

import java.util.Date;

public interface EventDTOProperties extends PropertyAccess<EventDTO> {
    ModelKeyProvider<EventDTO> id();
    ValueProvider<EventDTO, String> title();
    ValueProvider<EventDTO, Date> date();
}
