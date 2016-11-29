package test.zt.com.mvpdemo;

import java.util.List;

/**
 * Created by Administrator on 2016/11/4.
 */

public interface MainModel {
    public void loadData();
    public interface Listener{
        public void response(List<String> dd);
    }
}
