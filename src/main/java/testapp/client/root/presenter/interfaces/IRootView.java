package testapp.client.root.presenter.interfaces;

import com.google.gwt.user.client.ui.IsWidget;
import com.mvp4g.client.view.LazyView;
import testapp.client.common.presenter.interfaces.INamedView;

public interface IRootView extends IsWidget, LazyView {

    public interface IRootPresenter {

    }

    void openFrame(INamedView frame);

}
