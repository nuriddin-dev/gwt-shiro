package testapp.client.loginpage.view;

import com.google.gwt.core.client.GWT;
import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.uibinder.client.UiField;
import com.google.gwt.uibinder.client.UiHandler;
import com.google.gwt.user.client.ui.Widget;
import com.sencha.gxt.widget.core.client.button.TextButton;
import com.sencha.gxt.widget.core.client.event.SelectEvent;
import com.sencha.gxt.widget.core.client.form.CheckBox;
import com.sencha.gxt.widget.core.client.form.PasswordField;
import com.sencha.gxt.widget.core.client.form.TextField;
import testapp.client.loginpage.presenter.interfaces.ILoginPageView;
import testapp.client.root.view.ReverseCompositeView;

public class LoginPageView extends ReverseCompositeView<ILoginPageView.ILoginPagePresenter> implements ILoginPageView {

    private static LoginPageViewUiBinder uiBinder = GWT.create(LoginPageViewUiBinder.class);

    interface LoginPageViewUiBinder extends UiBinder<Widget, LoginPageView> {
    }

    @UiField
    TextField loginField;

    @UiField
    PasswordField passwordField;

    @UiField
    CheckBox rememberMeField;

    @UiField
    TextButton loginButton;

    @Override
    public void createView() {
        initWidget(uiBinder.createAndBindUi(this));
    }

    @UiHandler("loginButton")
    public void onButtonClick(SelectEvent event) {
        presenter.tryLogin(loginField.getValue(), passwordField.getValue(), rememberMeField.getValue());
    }

}
