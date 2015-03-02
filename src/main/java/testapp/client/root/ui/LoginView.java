package testapp.client.root.ui;

import com.google.gwt.core.client.GWT;
import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.uibinder.client.UiField;
import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.Widget;
import com.sencha.gxt.widget.core.client.Window;

public class LoginView extends Composite {
    private static LoginViewUiBinder uiBinder = GWT.create(LoginViewUiBinder.class);

    interface LoginViewUiBinder extends UiBinder<Widget, LoginView> {
    }

    @UiField
    Window window;

    public LoginView() {
        initWidget(uiBinder.createAndBindUi(this));
    }

    public void show() {
        window.show();
    }
}
