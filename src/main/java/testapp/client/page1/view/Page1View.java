package testapp.client.page1.view;

import com.google.gwt.core.client.GWT;
import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.uibinder.client.UiField;
import com.google.gwt.user.client.ui.Label;
import com.google.gwt.user.client.ui.Widget;
import testapp.client.page1.presenter.interfaces.IPage1View;
import testapp.client.root.view.ReverseCompositeView;

public class Page1View extends ReverseCompositeView<IPage1View.IPage1Presenter> implements IPage1View {

    private static Page1ViewUiBinder uiBinder = GWT.create(Page1ViewUiBinder.class);

    interface Page1ViewUiBinder extends UiBinder<Widget, Page1View> {
    }

    @UiField
    Label text;

    private String name = "Page 1";


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
