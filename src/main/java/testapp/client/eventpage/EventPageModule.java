package testapp.client.eventpage;

import com.mvp4g.client.Mvp4gModule;
import com.mvp4g.client.annotation.module.Loader;
import testapp.client.root.presenter.RootPresenter;

@Loader(RootPresenter.class)
public interface EventPageModule extends Mvp4gModule {
}
