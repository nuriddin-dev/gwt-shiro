package testapp.client.root;

import com.mvp4g.client.annotation.Event;
import com.mvp4g.client.annotation.Events;
import com.mvp4g.client.annotation.Start;
import com.mvp4g.client.annotation.module.ChildModule;
import com.mvp4g.client.annotation.module.ChildModules;
import com.mvp4g.client.event.EventBus;
import testapp.client.common.presenter.interfaces.INamedView;
import testapp.client.eventpage.EventPageModule;
import testapp.client.page1.Page1Module;
import testapp.client.page2.Page2Module;
import testapp.client.root.presenter.*;

@Events(startPresenter = RootPresenter.class)
@ChildModules({
        @ChildModule(moduleClass = Page1Module.class, autoDisplay = false),
        @ChildModule(moduleClass = Page2Module.class, autoDisplay = false),
        @ChildModule(moduleClass = EventPageModule.class, autoDisplay = false)})
public interface LayoutEventBus extends EventBus {

    @Start
    @Event(bind = {HeaderPresenter.class, MenuPresenter.class, FooterPresenter.class}, handlers = RootPresenter.class)
    void start();

    @Event(handlers = RootPresenter.class)
    void openFrame(INamedView frame);

    @Event(forwardToModules = Page1Module.class)
    void goToPage1();

    @Event(forwardToModules = Page2Module.class)
    void goToPage2();

    @Event(forwardToModules = EventPageModule.class)
    void goToEventPage();
}
