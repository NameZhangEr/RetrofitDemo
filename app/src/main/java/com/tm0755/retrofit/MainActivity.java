package com.tm0755.retrofit;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.Button;
import android.widget.TextView;

import com.tm0755.retrofit.api.GankApi;

import butterknife.ButterKnife;
import butterknife.InjectView;
import butterknife.OnClick;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import rx.android.schedulers.AndroidSchedulers;
import rx.functions.Action1;
import rx.schedulers.Schedulers;

public class MainActivity extends BaseActivity {

    @InjectView(R.id.bt_get)
    Button btGet;
    @InjectView(R.id.tv_result)
    TextView tvResult;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.inject(this);
    }

    @OnClick(R.id.bt_get)
    public void onViewClicked() {
        GankApi gankApi = retrofit.create(GankApi.class);
        gankApi.getAndroidInfo()
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Action1<GankBean>() {
                    @Override
                    public void call(GankBean gankBean) {
                        tvResult.setText(gankBean.getResults().get(0).getDesc());
                    }
                });
    }
}
