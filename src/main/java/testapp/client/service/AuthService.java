package testapp.client.service;

import com.google.gwt.user.client.rpc.RemoteService;
import com.google.gwt.user.client.rpc.RemoteServiceRelativePath;

@RemoteServiceRelativePath("authservice")
public interface AuthService extends RemoteService {

    boolean isLoggedIn();

    boolean login(String userName, String password, boolean rememberMe);

    void logout();
}
