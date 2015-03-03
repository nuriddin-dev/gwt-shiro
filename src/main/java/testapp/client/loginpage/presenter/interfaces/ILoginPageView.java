package testapp.client.loginpage.presenter.interfaces;

import com.google.gwt.user.client.ui.IsWidget;
import com.mvp4g.client.view.LazyView;
import testapp.client.common.presenter.interfaces.INamedView;
import testapp.client.dto.EventDTO;

import java.util.List;

public interface ILoginPageView extends IsWidget, LazyView {

	public interface ILoginPagePresenter {
        void tryLogin(String userName, String password, boolean rememberMe);
	}

}
