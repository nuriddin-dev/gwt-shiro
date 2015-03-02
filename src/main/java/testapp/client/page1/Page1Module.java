package testapp.client.page1;

import com.mvp4g.client.Mvp4gModule;
import com.mvp4g.client.annotation.module.Loader;
import testapp.client.root.presenter.RootPresenter;

@Loader(RootPresenter.class)
public interface Page1Module extends Mvp4gModule {
}
