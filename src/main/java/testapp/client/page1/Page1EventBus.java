package testapp.client.page1;

import com.mvp4g.client.annotation.Event;
import com.mvp4g.client.annotation.Events;
import com.mvp4g.client.event.EventBus;
import testapp.client.page1.presenter.Page1Presenter;
import testapp.client.common.presenter.interfaces.INamedView;

@Events(startPresenter = Page1Presenter.class, module = Page1Module.class)
public interface Page1EventBus extends EventBus {

    @Event(handlers = Page1Presenter.class)
    void goToPage1();

    @Event(forwardToParent = true)
    void openFrame(INamedView frame);
}
