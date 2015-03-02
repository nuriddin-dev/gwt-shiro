package testapp.client.page2.view;

import com.google.gwt.core.client.GWT;
import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.uibinder.client.UiField;
import com.google.gwt.user.client.ui.Label;
import com.google.gwt.user.client.ui.Widget;
import testapp.client.page2.presenter.interfaces.IPage2View;
import testapp.client.root.view.ReverseCompositeView;

public class Page2View extends ReverseCompositeView<IPage2View.IPage2Presenter> implements IPage2View {

    private static Page2ViewUiBinder uiBinder = GWT.create(Page2ViewUiBinder.class);

    interface Page2ViewUiBinder extends UiBinder<Widget, Page2View> {
    }

    @UiField
    Label text;

    private String name = "Page 2";

    @Override
    public void createView() {
        initWidget(uiBinder.createAndBindUi(this));
        text.setText(name);
    }

    @Override
    public String getName() {
        return name;
    }

}
