package testapp.client.page1.presenter;

import com.mvp4g.client.annotation.Presenter;
import com.mvp4g.client.presenter.LazyPresenter;
import testapp.client.page1.Page1EventBus;
import testapp.client.page1.presenter.interfaces.IPage1View;
import testapp.client.page1.view.Page1View;

@Presenter(view = Page1View.class)
public class Page1Presenter extends LazyPresenter<IPage1View, Page1EventBus> implements IPage1View.IPage1Presenter {

    public void onGoToPage1() {
        eventBus.openFrame(view);
    }


}
