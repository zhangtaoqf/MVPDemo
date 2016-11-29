package test.zt.com.mvpdemo;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.ProgressBar;
import android.widget.Toast;

import java.util.List;

/**
 *
 * M:model:数据加载，更新
 * V:View:view所有的操作.
 * P:Presenter:
 */
public class MainActivity extends AppCompatActivity implements MainView, MainModel.Listener, AdapterView.OnItemClickListener {

    ProgressBar progressBar;
    ListView listView;
    ArrayAdapter<String> adapter;
    MainPresenter mainPresenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        progressBar = ((ProgressBar) findViewById(R.id.progressId));
        listView = ((ListView) findViewById(R.id.listViewId));
        adapter = new ArrayAdapter<String>(this,android.R.layout.simple_list_item_1);
        listView.setAdapter(adapter);
        listView.setOnItemClickListener(this);
        mainPresenter = new MainPresenterImpl(this,this);
    }
    @Override
    protected void onResume() {
        super.onResume();
        listView.postDelayed(new Runnable() {
            @Override
            public void run() {
                mainPresenter.loadData();
            }
        },5000);
    }

    @Override
    public void showMsg(String msg) {
        Toast.makeText(this, ""+msg, Toast.LENGTH_SHORT).show();
    }
    @Override
    public void hideProgress() {
        listView.setVisibility(View.VISIBLE);
        progressBar.setVisibility(View.INVISIBLE);
    }

    @Override
    public void showPregress() {
        listView.setVisibility(View.INVISIBLE);
        progressBar.setVisibility(View.VISIBLE);
    }

    @Override
    public void response(List<String> dd) {
        adapter.addAll(dd);
    }

    @Override
    public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
        mainPresenter.dealWithListViewItemClick(adapterView,view,i,l);
    }
}
