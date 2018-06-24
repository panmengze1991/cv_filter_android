package com.ustc.cv;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import butterknife.ButterKnife;
import butterknife.OnClick;
import com.ustc.cv.model.http.ResultBase;
import com.ustc.cv.model.http.ResultGetProperties;
import com.ustc.cv.utils.http.ConnInterface;
import com.ustc.cv.utils.http.ConnectionFactory;
import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

import java.io.IOException;

public class MainActivity extends BaseActivity {

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
    }
}
