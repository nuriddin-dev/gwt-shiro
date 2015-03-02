package testapp.client.service;

import com.google.gwt.user.client.rpc.AsyncCallback;
import com.google.gwt.user.client.rpc.RemoteService;

public interface AuthServiceAsync {
    void isLoggedIn(AsyncCallback<Boolean> async);

    void login(String userName, String password, boolean rememberMe, AsyncCallback<Boolean> async);

    void logout(AsyncCallback<Void> async);
}
