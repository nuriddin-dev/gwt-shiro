package testapp.client.root.presenter;

import com.mvp4g.client.annotation.Presenter;
import com.mvp4g.client.presenter.BasePresenter;
import testapp.client.root.LayoutEventBus;
import testapp.client.root.presenter.interfaces.IMenuView;
import testapp.client.root.presenter.interfaces.IMenuView.IMenuPresenter;
import testapp.client.root.view.MenuView;

@Presenter(view = MenuView.class)
public class MenuPresenter extends BasePresenter<IMenuView, LayoutEventBus> implements IMenuPresenter {

    @Override
    public void goToPage1() {
        eventBus.goToPage1();
    }

    @Override
    public void goToPage2() {
        eventBus.goToPage2();
    }

    @Override
    public void goToEventPage() {
        eventBus.goToEventPage();
    }
}
