package testapp.client.root.presenter;

import com.google.gwt.user.client.rpc.AsyncCallback;
import com.google.inject.Inject;
import com.mvp4g.client.annotation.Presenter;
import com.mvp4g.client.presenter.BasePresenter;
import com.sencha.gxt.widget.core.client.box.MessageBox;
import testapp.client.root.LayoutEventBus;
import testapp.client.root.presenter.interfaces.IHeaderView;
import testapp.client.root.view.HeaderView;
import testapp.client.service.AuthServiceAsync;

@Presenter(view = HeaderView.class)
public class HeaderPresenter extends BasePresenter<IHeaderView, LayoutEventBus> implements IHeaderView.IHeaderPresenter {

    @Inject
    AuthServiceAsync authService;

    @Override
    public void logout() {
        authService.logout(new AsyncCallback<Void>() {
            @Override
            public void onFailure(Throwable throwable) {
                eventBus.goToLoginPage();
                MessageBox m = new MessageBox("error");
                m.show();
            }

            @Override
            public void onSuccess(Void aVoid) {
                eventBus.goToLoginPage();
            }
        });
    }
}
