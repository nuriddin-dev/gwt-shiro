package testapp.client.root.view;

import com.google.gwt.core.client.GWT;
import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.uibinder.client.UiField;
import com.google.gwt.user.client.ui.IsWidget;
import com.google.gwt.user.client.ui.Label;
import com.google.gwt.user.client.ui.Widget;
import com.google.inject.Inject;
import com.sencha.gxt.core.client.util.Margins;
import com.sencha.gxt.widget.core.client.TabItemConfig;
import com.sencha.gxt.widget.core.client.TabPanel;
import com.sencha.gxt.widget.core.client.Window;
import com.sencha.gxt.widget.core.client.box.MessageBox;
import com.sencha.gxt.widget.core.client.button.TextButton;
import com.sencha.gxt.widget.core.client.container.BorderLayoutContainer.BorderLayoutData;
import com.sencha.gxt.widget.core.client.container.MarginData;
import com.sencha.gxt.widget.core.client.event.CloseEvent;
import com.sencha.gxt.widget.core.client.event.SelectEvent;
import testapp.client.common.presenter.interfaces.INamedView;
import testapp.client.root.presenter.interfaces.IRootView;
import testapp.client.root.ui.LoginView;

import java.util.HashSet;
import java.util.Set;

public class RootView extends ReverseCompositeView<IRootView.IRootPresenter> implements IRootView {

    private static RootViewUiBinder uiBinder = GWT.create(RootViewUiBinder.class);

    @UiField(provided = true)
    Widget header, menu, footer;

    @UiField
    TabPanel tabPanel;

    LoginView loginView = new LoginView();

    private Set<IsWidget> frames = new HashSet<IsWidget>();

    interface RootViewUiBinder extends UiBinder<Widget, RootView> {
    }

    @UiField(provided = true)
    BorderLayoutData northData = new BorderLayoutData(70);
    @UiField(provided = true)
    MarginData centerData = new MarginData();
    @UiField(provided = true)
    BorderLayoutData southData = new BorderLayoutData(100);

    @Inject
    public RootView(HeaderView header, MenuView menu, FooterView footer) {
        this.header = header;
        this.menu = menu;
        this.footer = footer;

        northData.setMargins(new Margins(5));
        southData.setMargins(new Margins(5));

        initWidget(uiBinder.createAndBindUi(this));

        tabPanel.addCloseHandler(new CloseEvent.CloseHandler<Widget>(){
            @Override
            public void onClose(CloseEvent<Widget> event) {
                frames.remove(event.getItem().asWidget());
            }
        });
    }

    @Override
    public void openFrame(INamedView frame) {
        addTab(frame);
    }

    @Override
    public void login() {
        final Window window = new Window();
        window.setPixelSize(500, 300);
        window.setModal(true);
        window.setBlinkModal(true);
        window.setHeadingText("Login");
        window.setClosable(false);

        TextButton b = new TextButton("Login");
        b.addSelectHandler(new SelectEvent.SelectHandler() {

            @Override
            public void onSelect(SelectEvent event) {
                window.hide();
            }
        });
        window.addButton(b);
        window.setFocusWidget(window.getButtonBar().getWidget(0));

        window.show();
    }

    @Override
    public void logout() {

    }

    private void addTab(INamedView frame) {
        if (!frames.contains(frame)) {
            tabPanel.add(frame, new TabItemConfig(frame.getName(), true));
            frames.add(frame);
        }
        tabPanel.setActiveWidget(frame);
    }

}
