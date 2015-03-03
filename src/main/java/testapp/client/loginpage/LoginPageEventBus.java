package testapp.client.loginpage;

import com.google.gwt.user.client.ui.IsWidget;
import com.mvp4g.client.annotation.Event;
import com.mvp4g.client.annotation.Events;
import com.mvp4g.client.event.EventBus;
import testapp.client.common.presenter.interfaces.INamedView;
import testapp.client.eventpage.EventPageModule;
import testapp.client.eventpage.presenter.EventPagePresenter;
import testapp.client.loginpage.presenter.LoginPagePresenter;
import testapp.client.root.RootModule;

@Events(startPresenter = LoginPagePresenter.class, module = LoginPageModule.class)
public interface LoginPageEventBus extends EventBus {

    @Event(handlers = LoginPagePresenter.class)
    void goToLoginPage();

    @Event(forwardToParent = true)
    void changeViewPortContent(IsWidget content);

    @Event(forwardToModules = RootModule.class)
    void goToHomePage();
}
