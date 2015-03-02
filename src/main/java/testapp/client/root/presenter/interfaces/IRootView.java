package testapp.client.root.presenter.interfaces;

import com.google.gwt.user.client.ui.IsWidget;
import testapp.client.common.presenter.interfaces.INamedView;

public interface IRootView extends IsWidget {

	public interface IRootPresenter {

	}

    void openFrame(INamedView frame);

}
