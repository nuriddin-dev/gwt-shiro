package testapp.client.root.view;

import com.google.gwt.core.client.GWT;
import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.uibinder.client.UiField;
import com.google.gwt.uibinder.client.UiHandler;
import com.google.gwt.user.client.ui.Widget;
import com.google.inject.Singleton;
import com.sencha.gxt.widget.core.client.button.TextButton;
import com.sencha.gxt.widget.core.client.event.SelectEvent;
import testapp.client.root.presenter.interfaces.IHeaderView;

@Singleton
public class HeaderView extends ReverseCompositeView<IHeaderView.IHeaderPresenter> implements IHeaderView {
    private static HeaderViewUiBinder uiBinder = GWT.create(HeaderViewUiBinder.class);

    interface HeaderViewUiBinder extends UiBinder<Widget, HeaderView> {
    }

    @UiField
    TextButton logoutButton;

    public HeaderView() {
        initWidget(uiBinder.createAndBindUi(this));
    }

    @UiHandler("logoutButton")
    public void onClickButton(SelectEvent event) {
        presenter.logout();
    }
}
