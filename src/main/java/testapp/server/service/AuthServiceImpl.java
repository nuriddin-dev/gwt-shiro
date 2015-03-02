package testapp.server.service;

import com.google.gwt.user.server.rpc.RemoteServiceServlet;
import testapp.client.service.AuthService;


public class AuthServiceImpl extends RemoteServiceServlet implements AuthService {
    @Override
    public boolean isLoggedIn() {
        return false;
    }

    @Override
    public boolean login(String userName, String password, boolean rememberMe) {
        return false;
    }

    @Override
    public void logout() {

    }
}
