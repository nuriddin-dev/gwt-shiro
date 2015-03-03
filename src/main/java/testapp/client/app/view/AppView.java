package testapp.client.app.view;

import com.google.gwt.core.client.GWT;
import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.uibinder.client.UiField;
import com.google.gwt.user.client.ui.IsWidget;
import com.google.gwt.user.client.ui.Widget;
import com.sencha.gxt.widget.core.client.container.Viewport;
import testapp.client.app.presenter.interfaces.IAppView;
import testapp.client.root.view.ReverseCompositeView;

public class AppView extends ReverseCompositeView<IAppView.IAppPresenter> implements IAppView {

    private static AppViewUiBinder uiBinder = GWT.create(AppViewUiBinder.class);

    interface AppViewUiBinder extends UiBinder<Widget, AppView> {
    }

    @UiField
    Viewport viewport;

    public AppView() {
        initWidget(uiBinder.createAndBindUi(this));
    }

    @Override
    public void changeViewPortContent(IsWidget content) {
        viewport.setWidget(content);
    }

}
