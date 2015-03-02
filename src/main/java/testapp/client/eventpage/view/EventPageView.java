package testapp.client.eventpage.view;

import com.google.gwt.core.client.GWT;
import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.uibinder.client.UiField;
import com.google.gwt.uibinder.client.UiHandler;
import com.google.gwt.user.client.Window;
import com.google.gwt.user.client.ui.Widget;
import com.sencha.gxt.data.shared.ListStore;
import com.sencha.gxt.widget.core.client.event.SelectEvent;
import com.sencha.gxt.widget.core.client.grid.ColumnConfig;
import com.sencha.gxt.widget.core.client.grid.ColumnModel;
import com.sencha.gxt.widget.core.client.grid.Grid;
import com.sencha.gxt.widget.core.client.grid.GridView;
import testapp.client.dto.EventDTO;
import testapp.client.eventpage.presenter.interfaces.IEventPageView;
import testapp.client.root.view.ReverseCompositeView;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class EventPageView extends ReverseCompositeView<IEventPageView.IEventPagePresenter> implements IEventPageView {

    private static Page2ViewUiBinder uiBinder = GWT.create(Page2ViewUiBinder.class);

    interface Page2ViewUiBinder extends UiBinder<Widget, EventPageView> {
    }

    private static final EventDTOProperties props = GWT.create(EventDTOProperties.class);

    @UiField(provided = true)
    ColumnModel<EventDTO> columnModel;
    @UiField(provided = true)
    ListStore<EventDTO> listStore;
    @UiField(provided = true)
    GridView<EventDTO> gridView = new GridView<EventDTO>();
    @UiField
    Grid grid;

    private String name = "Events";

    @Override
    public void createView() {

        listStore = initListStore();
        columnModel = initColumnModel();
        initWidget(uiBinder.createAndBindUi(this));
    }

    private ListStore<EventDTO> initListStore() {
        return new ListStore<EventDTO>(props.id());
    }

    private ColumnModel<EventDTO> initColumnModel() {
        List<ColumnConfig<EventDTO, ?>> columns = new ArrayList<ColumnConfig<EventDTO, ?>>();
        ColumnConfig<EventDTO, String> colTitle = new ColumnConfig<EventDTO, String>(props.title(), 150, "Title");
        ColumnConfig<EventDTO, Date> colDate = new ColumnConfig<EventDTO, Date>(props.date(), 150, "Date");
        columns.add(colTitle);
        columns.add(colDate);
        gridView.setAutoExpandColumn(colTitle);
        return new ColumnModel<EventDTO>(columns);
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public void addEvents(List<EventDTO> events) {
        listStore.addAll(events);
    }

    @UiHandler("exportPdf")
    public void onClickExportPdf(SelectEvent event) {
        String url = GWT.getModuleBaseURL() + "downloadService?report=event/report1&type=pdf";
        Window.open(url, "_blank", "status=0,toolbar=0,menubar=0,location=0");
    }

}
