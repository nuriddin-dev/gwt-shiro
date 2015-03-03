package testapp.client.app;

import com.google.gwt.user.client.ui.IsWidget;
import com.mvp4g.client.annotation.Event;
import com.mvp4g.client.annotation.Events;
import com.mvp4g.client.annotation.Start;
import com.mvp4g.client.annotation.module.ChildModule;
import com.mvp4g.client.annotation.module.ChildModules;
import com.mvp4g.client.event.EventBus;
import testapp.client.app.presenter.AppPresenter;
import testapp.client.loginpage.LoginPageModule;
import testapp.client.root.RootModule;

@Events(startPresenter = AppPresenter.class)
@ChildModules({@ChildModule(moduleClass = RootModule.class, autoDisplay = false),
        @ChildModule(moduleClass = LoginPageModule.class, autoDisplay = false)})
public interface AppEventBus extends EventBus {

    @Start
    @Event(handlers = AppPresenter.class)
    void start();

    @Event(handlers = AppPresenter.class)
    void changeViewPortContent(IsWidget content);

    @Event(forwardToModules = LoginPageModule.class)
    void goToLoginPage();

    @Event(forwardToModules = RootModule.class)
    void goToHomePage();
}
