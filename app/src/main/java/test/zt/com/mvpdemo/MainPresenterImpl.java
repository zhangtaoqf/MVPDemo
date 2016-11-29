package test.zt.com.mvpdemo;

import android.view.View;
import android.widget.AdapterView;

/**
 * Created by Administrator on 2016/11/4.
 */

public class MainPresenterImpl implements MainPresenter{
    private MainModel.Listener listener;
    private MainView mainView;
    private MainModel mainModel;
    public MainPresenterImpl(MainView mainView, MainModel.Listener listener) {
        this.mainView = mainView;
        mainModel = new MainModelImpl(this);
        this.listener = listener;
    }
    @Override
    public void loadData() {
        mainView.showPregress();
        mainModel.loadData();
    }
    @Override
    public MainModel.Listener response() {
        return listener;
    }
    @Override
    public void loadSuccess() {
        mainView.hideProgress();
    }

    @Override
    public void dealWithListViewItemClick(AdapterView<?> adapterView, View view, int i, long l) {
        mainView.showMsg("点击了"+i);
    }
}
