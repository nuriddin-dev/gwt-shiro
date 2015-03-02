package testapp.client.root.presenter.interfaces;


import com.google.gwt.user.client.ui.IsWidget;

public interface IMenuView extends IsWidget {

    public interface IMenuPresenter {
        void goToPage1();

        void goToPage2();

        void goToEventPage();
    }

}
