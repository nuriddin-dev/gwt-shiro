package testapp.client.app.presenter;

import com.google.gwt.user.client.Command;
import com.google.gwt.user.client.rpc.AsyncCallback;
import com.google.gwt.user.client.ui.IsWidget;
import com.google.inject.Inject;
import com.mvp4g.client.Mvp4gLoader;
import com.mvp4g.client.annotation.Presenter;
import com.mvp4g.client.presenter.BasePresenter;
import com.sencha.gxt.widget.core.client.box.MessageBox;
import testapp.client.app.AppEventBus;
import testapp.client.app.presenter.interfaces.IAppView;
import testapp.client.app.view.AppView;
import testapp.client.service.AuthServiceAsync;

@Presenter(view = AppView.class)
public class AppPresenter extends BasePresenter<IAppView, AppEventBus> implements IAppView.IAppPresenter, Mvp4gLoader<AppEventBus> {

    @Inject
    AuthServiceAsync authService;

    public void onStart() {
        authService.isLoggedIn(new AsyncCallback<Boolean>() {
            @Override
            public void onFailure(Throwable throwable) {

            }

            @Override
            public void onSuccess(Boolean loggedIn) {
                if (loggedIn)
                    eventBus.goToHomePage();
                else
                    eventBus.goToLoginPage();
            }
        });
    }

    public void onChangeViewPortContent(IsWidget content) {
        view.changeViewPortContent(content);
    }

    @Override
    public void preLoad(AppEventBus appEventBus, String s, Object[] objects, Command command) {
        command.execute();
    }

    @Override
    public void onSuccess(AppEventBus appEventBus, String s, Object[] objects) {

    }

    @Override
    public void onFailure(AppEventBus appEventBus, String s, Object[] objects, Throwable throwable) {

    }
}
