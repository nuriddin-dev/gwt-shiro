package testapp.client.loginpage;

import com.mvp4g.client.Mvp4gModule;
import com.mvp4g.client.annotation.module.Loader;
import testapp.client.app.presenter.AppPresenter;
import testapp.client.root.presenter.RootPresenter;

@Loader(AppPresenter.class)
public interface LoginPageModule extends Mvp4gModule {
}
