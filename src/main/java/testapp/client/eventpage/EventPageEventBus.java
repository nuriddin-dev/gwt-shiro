package testapp.client.eventpage;

import com.mvp4g.client.annotation.Event;
import com.mvp4g.client.annotation.Events;
import com.mvp4g.client.event.EventBus;
import testapp.client.common.presenter.interfaces.INamedView;
import testapp.client.eventpage.presenter.EventPagePresenter;

@Events(startPresenter = EventPagePresenter.class, module = EventPageModule.class)
public interface EventPageEventBus extends EventBus {

    @Event(handlers = EventPagePresenter.class)
    void goToEventPage();

    @Event(forwardToParent = true)
    void openFrame(INamedView frame);

    @Event(handlers = EventPagePresenter.class)
    void addEvents();
}
