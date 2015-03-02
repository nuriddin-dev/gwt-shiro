package testapp.client.root.presenter;

import com.google.gwt.user.client.Command;
import com.mvp4g.client.Mvp4gLoader;
import com.mvp4g.client.annotation.Presenter;
import com.mvp4g.client.presenter.BasePresenter;
import testapp.client.common.presenter.interfaces.INamedView;
import testapp.client.root.LayoutEventBus;
import testapp.client.root.presenter.interfaces.IRootView;
import testapp.client.root.view.RootView;

@Presenter(view = RootView.class)
public class RootPresenter extends BasePresenter<IRootView, LayoutEventBus> implements IRootView.IRootPresenter, Mvp4gLoader<LayoutEventBus> {

    public void onOpenFrame(INamedView frame) {
        view.openFrame(frame);
    }

    public void onStart() {
        eventBus.goToPage1();
    }

    @Override
    public void preLoad(LayoutEventBus eventBus, String eventName, Object[] params, Command load) {
        load.execute();
    }

    @Override
    public void onSuccess(LayoutEventBus eventBus, String eventName, Object[] params) {

    }

    @Override
    public void onFailure(LayoutEventBus eventBus, String eventName, Object[] params, Throwable err) {

    }
}
