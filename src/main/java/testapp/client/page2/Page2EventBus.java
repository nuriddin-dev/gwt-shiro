package testapp.client.page2;

import com.mvp4g.client.annotation.Event;
import com.mvp4g.client.annotation.Events;
import com.mvp4g.client.event.EventBus;
import testapp.client.page2.presenter.Page2Presenter;
import testapp.client.common.presenter.interfaces.INamedView;

@Events(startPresenter = Page2Presenter.class, module = Page2Module.class)
public interface Page2EventBus extends EventBus {

    @Event(handlers = Page2Presenter.class)
    void goToPage2();

    @Event(forwardToParent = true)
    void openFrame(INamedView frame);
}
