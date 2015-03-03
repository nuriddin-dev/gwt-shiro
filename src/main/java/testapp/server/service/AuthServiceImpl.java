package testapp.server.service;

import com.google.gwt.user.server.rpc.RemoteServiceServlet;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.subject.Subject;
import testapp.client.service.AuthService;


public class AuthServiceImpl extends RemoteServiceServlet implements AuthService {
    @Override
    public boolean isLoggedIn() {
        Subject currentUser = SecurityUtils.getSubject();
        return currentUser.isAuthenticated();
    }

    @Override
    public boolean login(String userName, String password, boolean rememberMe) {
        UsernamePasswordToken token = new UsernamePasswordToken(userName, password);
        token.setRememberMe(rememberMe);

        Subject currentUser = SecurityUtils.getSubject();
        try {
            currentUser.login(token);
        } catch (AuthenticationException ae) {
            return false;
        }
        return true;
    }

    @Override
    public void logout() {

    }
}
