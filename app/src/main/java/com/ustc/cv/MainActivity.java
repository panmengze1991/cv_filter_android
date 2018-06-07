package com.ustc.cv;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class MainActivity extends AppCompatActivity {

//
//    @BindView(R.id.btn_filter)
//    Button btnFilter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);

    }

    @OnClick(R.id.btn_filter)
    public void onViewClicked() {
        startActivity(new Intent(this,SelectFilterActivity.class));
//        ConnInterface connection = ConnectionFactory.getConnection();
//        Call<ResultBase> call = connection.getProperties();
//
//        call.enqueue(new Callback<ResultBase>() {
//            @Override
//            public void onResponse(Call<ResultBase> call, Response<ResultBase> response) {
//                Log.d("panmengze response", response.body().getMsg());
//            }
//
//            @Override
//            public void onFailure(Call<ResultBase> call, Throwable t) {
//
//            }
//        });
    }
}
