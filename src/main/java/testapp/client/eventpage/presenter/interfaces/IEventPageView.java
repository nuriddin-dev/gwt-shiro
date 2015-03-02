package testapp.client.eventpage.presenter.interfaces;

import com.mvp4g.client.view.LazyView;
import testapp.client.common.presenter.interfaces.INamedView;
import testapp.client.dto.EventDTO;

import java.util.List;

public interface IEventPageView extends INamedView, LazyView {

    public void addEvents(List<EventDTO> events);

    public void downloadPdf();

	public interface IEventPagePresenter {

	}

}
