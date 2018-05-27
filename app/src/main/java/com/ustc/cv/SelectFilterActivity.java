package com.ustc.cv;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;
import android.widget.Toast;
import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import com.ustc.cv.model.FilterOptions;

import java.util.ArrayList;
import java.util.List;

public class SelectFilterActivity extends AppCompatActivity {

    Context mContext;

    @BindView(R.id.sp_qualify_1)
    Spinner spQualify1;
    @BindView(R.id.sp_exp_2)
    Spinner spExp2;
    @BindView(R.id.sp_job_type_3)
    Spinner spJobType3;
    @BindView(R.id.btn_go)
    Button btnGo;

    FilterOptions filterOptions = new FilterOptions();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_select_filter);
        mContext = this;
        ButterKnife.bind(this);

        initView();
    }

    private void initView() {
        List<String> list = new ArrayList<>();
        list.add("JAVA");
        list.add("Web前端");
        list.add("机械");
        spQualify1.setAdapter(new ArrayAdapter<String>(mContext, R.layout.spinner_list__item, list));
        spExp2.setAdapter(new ArrayAdapter<String>(mContext, R.layout.spinner_list__item, list));
        spJobType3.setAdapter(new ArrayAdapter<String>(mContext, R.layout.spinner_list__item, list));
//        spQualify1.setOnItemSelectedListener(this);
//        spExp2.setOnItemSelectedListener(this);
//        spJobType3.setOnItemSelectedListener(this);
    }

    @OnClick(R.id.btn_go)
    public void onViewClicked() {
        filterOptions.setGender("男");
        filterOptions.setAge(22);
        filterOptions.setDurationBachelor("3年");
        filterOptions.setDurationNormal("5年");
        filterOptions.setLeaveRate("1年1次");
        filterOptions.setIsPublic("否");



        startActivity(new Intent(mContext,PeopleListActivity.class));
    }

//    @Override
//    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
//        switch (view.getId()){
//            case R.id.sp_qualify_1:
//                filterOptions.setQualify((String) spQualify1.getAdapter().getItem(position));
//                break;
//            case R.id.sp_exp_2:
//                filterOptions.setExp((String) spExp2.getAdapter().getItem(position));
//                break;
//            case R.id.sp_job_type_3:
//                filterOptions.setJobType((String) spJobType3.getAdapter().getItem(position));
//                break;
//        }
//    }
}
