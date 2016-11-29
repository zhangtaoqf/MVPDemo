package test.zt.com.mvpdemo;


import android.os.Handler;

import java.util.ArrayList;

/**
 * Created by Administrator on 2016/11/4.
 */

public class MainModelImpl implements MainModel {
    MainPresenter mainPresenter;

    public MainModelImpl(MainPresenter mainPresenter) {
        this.mainPresenter = mainPresenter;
    }

    Handler handler = new Handler();
    @Override
    public void loadData() {
        //记载数据库


        //加载网络
        handler.postDelayed(new Runnable() {
            @Override
            public void run() {
                ArrayList<String> datas = new ArrayList<>();
                for (int i = 0; i < 200; i++) {
                    datas.add("item:"+i);
                }
                mainPresenter.response().response(datas);
                mainPresenter.loadSuccess();
            }
        },2000);
    }
}
