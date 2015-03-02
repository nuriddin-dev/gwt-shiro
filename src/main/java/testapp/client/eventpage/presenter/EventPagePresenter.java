package testapp.client.eventpage.presenter;

import com.google.gwt.user.client.rpc.AsyncCallback;
import com.google.inject.Inject;
import com.mvp4g.client.annotation.Presenter;
import com.mvp4g.client.presenter.LazyPresenter;
import testapp.client.dto.EventDTO;
import testapp.client.eventpage.EventPageEventBus;
import testapp.client.eventpage.presenter.interfaces.IEventPageView;
import testapp.client.eventpage.view.EventPageView;
import testapp.client.page1.presenter.interfaces.IPage1View;
import testapp.client.service.EventServiceAsync;

import java.util.List;

@Presenter(view = EventPageView.class)
public class EventPagePresenter extends LazyPresenter<IEventPageView, EventPageEventBus> implements IEventPageView.IEventPagePresenter {

    @Inject
    EventServiceAsync service;

    public void onGoToEventPage() {
        eventBus.openFrame(view);
        eventBus.addEvents();
    }

    public void onAddEvents() {
        service.findAll(new AsyncCallback<List<EventDTO>>() {
            @Override
            public void onFailure(Throwable throwable) {

            }

            @Override
            public void onSuccess(List<EventDTO> eventDTOs) {
                view.addEvents(eventDTOs);
            }
        });
    }

    public void onDownloadPdf(){

    }


}
