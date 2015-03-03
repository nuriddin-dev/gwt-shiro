package testapp.server.service;

import com.google.gwt.user.server.rpc.RemoteServiceServlet;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.*;
import org.apache.shiro.subject.Subject;
import testapp.client.exceptions.CustomException;
import testapp.client.service.AuthService;


public class AuthServiceImpl extends RemoteServiceServlet implements AuthService {
    @Override
    public boolean isLoggedIn() {
        Subject currentUser = SecurityUtils.getSubject();
        return currentUser.isAuthenticated();
    }

    @Override
    public boolean login(String userName, String password, boolean rememberMe) throws CustomException {
        UsernamePasswordToken token = new UsernamePasswordToken(userName, password);
        token.setRememberMe(rememberMe);

        Subject currentUser = SecurityUtils.getSubject();
        try {
            currentUser.login(token);
        } catch (UnknownAccountException uae) {
            throw new CustomException("Unknown Account");
        } catch (IncorrectCredentialsException ice) {
            throw new CustomException("Incorrect Credentials");
        } catch (LockedAccountException lae) {
            throw new CustomException("Locked Account");
        } catch (AuthenticationException ae) {
            throw new CustomException("Authentication Exception");
        }
        return true;
    }

    @Override
    public void logout() {
        Subject currentUser = SecurityUtils.getSubject();
        currentUser.logout();
    }
}
