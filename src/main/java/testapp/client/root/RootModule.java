package testapp.client.root;

import com.mvp4g.client.Mvp4gModule;
import com.mvp4g.client.annotation.module.Loader;
import testapp.client.app.presenter.AppPresenter;

@Loader(AppPresenter.class)
public interface RootModule extends Mvp4gModule {
}
