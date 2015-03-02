package testapp.client.root.view;

import com.google.gwt.core.client.GWT;
import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.user.client.ui.Widget;
import com.google.inject.Singleton;
import testapp.client.root.presenter.interfaces.IFooterView;

@Singleton
public class FooterView extends ReverseCompositeView<IFooterView.IFooterPresenter> implements IFooterView {
    private static FooterViewUiBinder uiBinder = GWT.create(FooterViewUiBinder.class);

    interface FooterViewUiBinder extends UiBinder<Widget, FooterView> {
    }

    public FooterView() {
        initWidget(uiBinder.createAndBindUi(this));
    }
}
