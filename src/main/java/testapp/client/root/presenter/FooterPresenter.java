package testapp.client.root.presenter;

import com.mvp4g.client.annotation.Presenter;
import com.mvp4g.client.presenter.BasePresenter;
import testapp.client.root.LayoutEventBus;
import testapp.client.root.presenter.interfaces.IFooterView;
import testapp.client.root.view.FooterView;

@Presenter(view = FooterView.class)
public class FooterPresenter extends BasePresenter<IFooterView, LayoutEventBus> implements IFooterView.IFooterPresenter {

}
