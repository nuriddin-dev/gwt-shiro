package testapp.client.page2.presenter;

import com.mvp4g.client.annotation.Presenter;
import com.mvp4g.client.presenter.LazyPresenter;
import testapp.client.page2.Page2EventBus;
import testapp.client.page2.presenter.interfaces.IPage2View;
import testapp.client.page2.view.Page2View;

@Presenter(view = Page2View.class)
public class Page2Presenter extends LazyPresenter<IPage2View, Page2EventBus> implements IPage2View.IPage2Presenter {

    public void onGoToPage2() {
        eventBus.openFrame(view);
    }

}
