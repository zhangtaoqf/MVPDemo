package test.zt.com.mvpdemo;

import android.view.View;
import android.widget.AdapterView;

/**
 * Created by Administrator on 2016/11/4.
 */

public interface MainPresenter {
    public void loadData();
    public MainModel.Listener response();
    public void loadSuccess();
    public void dealWithListViewItemClick(AdapterView<?> adapterView, View view, int i, long l);
}
