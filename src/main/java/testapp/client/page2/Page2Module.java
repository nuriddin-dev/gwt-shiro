package testapp.client.page2;

import com.mvp4g.client.Mvp4gModule;
import com.mvp4g.client.annotation.module.Loader;
import testapp.client.root.presenter.RootPresenter;

@Loader(RootPresenter.class)
public interface Page2Module extends Mvp4gModule {
}
