package testapp.client.loginpage.presenter;

import com.google.gwt.user.client.rpc.AsyncCallback;
import com.google.inject.Inject;
import com.mvp4g.client.annotation.Presenter;
import com.mvp4g.client.presenter.LazyPresenter;
import com.sencha.gxt.widget.core.client.box.MessageBox;
import testapp.client.exceptions.CustomException;
import testapp.client.loginpage.LoginPageEventBus;
import testapp.client.loginpage.presenter.interfaces.ILoginPageView;
import testapp.client.loginpage.view.LoginPageView;
import testapp.client.service.AuthServiceAsync;

@Presenter(view = LoginPageView.class)
public class LoginPagePresenter extends LazyPresenter<ILoginPageView, LoginPageEventBus> implements ILoginPageView.ILoginPagePresenter {

    @Inject
    AuthServiceAsync service;

    public void onGoToLoginPage() {
        eventBus.changeViewPortContent(view);
    }


    @Override
    public void tryLogin(String userName, String password, boolean rememberMe) {
        service.login(userName, password, rememberMe, new AsyncCallback<Boolean>() {
            @Override
            public void onFailure(Throwable throwable) {
                if (throwable instanceof CustomException) {
                    String message = throwable.getMessage();
                    MessageBox m = new MessageBox(message);
                    m.show();
                }
            }

            @Override
            public void onSuccess(Boolean success) {
                if (success)
                    eventBus.goToHomePage();
            }
        });
    }
}
