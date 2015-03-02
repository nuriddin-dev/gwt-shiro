package testapp.client.root.presenter;

import com.mvp4g.client.annotation.Presenter;
import com.mvp4g.client.presenter.BasePresenter;
import testapp.client.root.LayoutEventBus;
import testapp.client.root.presenter.interfaces.IHeaderView;
import testapp.client.root.view.HeaderView;

@Presenter(view = HeaderView.class)
public class HeaderPresenter extends BasePresenter<IHeaderView, LayoutEventBus> implements IHeaderView.IHeaderPresenter{
}
