package testapp.client.root.view;

import com.google.gwt.core.client.GWT;
import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.uibinder.client.UiHandler;
import com.google.gwt.user.client.ui.Widget;
import com.google.inject.Singleton;
import testapp.client.root.presenter.interfaces.IMenuView;

@Singleton
public class MenuView extends ReverseCompositeView<IMenuView.IMenuPresenter> implements IMenuView {

    private static MenuViewUiBinder uiBinder = GWT.create(MenuViewUiBinder.class);

    interface MenuViewUiBinder extends UiBinder<Widget, MenuView> {
    }

    public MenuView() {
        initWidget(uiBinder.createAndBindUi(this));
    }

    @UiHandler("page1")
    public void onClickPage1(ClickEvent e) {
        presenter.goToPage1();
    }

    @UiHandler("page2")
    public void onClickPage2(ClickEvent e) {
        presenter.goToPage2();
    }

    @UiHandler("events")
    public void onClickEvents(ClickEvent e) {
        presenter.goToEventPage();
    }
}
