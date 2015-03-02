package testapp.client.root.view;

import com.google.gwt.core.client.GWT;
import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.user.client.ui.Widget;
import com.google.inject.Singleton;
import testapp.client.root.presenter.interfaces.IHeaderView;

@Singleton
public class HeaderView extends ReverseCompositeView<IHeaderView.IHeaderPresenter> implements IHeaderView {
    private static HeaderViewUiBinder uiBinder = GWT.create(HeaderViewUiBinder.class);

    interface HeaderViewUiBinder extends UiBinder<Widget, HeaderView> {
    }

    public HeaderView() {
        initWidget(uiBinder.createAndBindUi(this));
    }
}
