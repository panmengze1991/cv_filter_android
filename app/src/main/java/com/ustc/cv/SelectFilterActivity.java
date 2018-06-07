package com.ustc.cv;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.widget.*;
import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import com.google.gson.Gson;
import com.ustc.cv.callback.OnDialogSubmitListener;
import com.ustc.cv.model.FilterOptions;
import com.ustc.cv.utils.CommonUtils;
import com.ustc.cv.utils.Const;
import com.ustc.cv.view.FilterDialog;

import java.util.ArrayList;
import java.util.List;

import static com.ustc.cv.utils.Const.LeaveRate.ONCE_PER_TWO_YEAR;
import static com.ustc.cv.utils.Const.LeaveRate.ONCE_PER_YEAR;
import static com.ustc.cv.utils.Const.LeaveRate.TWICE_PER_YEAR;

public class SelectFilterActivity extends AppCompatActivity implements OnDialogSubmitListener<String[][]> {

    Context mContext;


    FilterOptions filterOptions = new FilterOptions();
    String[][] duration = new String[][]{{"doctor", "-1", "-1"}, {"master", "-1", "-1"}, {"bachelor", "-1", "-1"},
            {"normal", "-1", "-1"}};

    @BindView(R.id.et_age_start)
    EditText etAgeStart;
    @BindView(R.id.et_age_end)
    EditText etAgeEnd;
    @BindView(R.id.sp_leave_rate)
    Spinner spLeaveRate;
    @BindView(R.id.sp_job_type)
    Spinner spJobType;
    @BindView(R.id.btn_select_duration)
    TextView btnSelectDuration;
    @BindView(R.id.btn_go)
    Button btnGo;
    @BindView(R.id.cb_public)
    CheckBox cbPublic;
    @BindView(R.id.rb_gender_default)
    RadioButton rbGenderDefault;
    @BindView(R.id.rb_gender_male)
    RadioButton rbGenderMale;
    @BindView(R.id.rb_gender_female)
    RadioButton rbGenderFemale;
    @BindView(R.id.rg_gender)
    RadioGroup rgGender;
    @BindView(R.id.et_description)
    EditText etDescription;

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

        List<String> list1 = new ArrayList<>();
        list1.add("一年两次");
        list1.add("两年一次");
        list1.add("一年一次");
        spLeaveRate.setAdapter(new ArrayAdapter<>(mContext, R.layout.spinner_list__item, list1));
        spJobType.setAdapter(new ArrayAdapter<>(mContext, R.layout.spinner_list__item, list));
    }

    @OnClick(R.id.btn_go)
    public void onViewClicked() {
        int gender = -1;
        double leaveRate = -1;

        switch (rgGender.getCheckedRadioButtonId()){
            case R.id.rb_gender_male:
                gender=1;
                break;
            case R.id.rb_gender_female:
                gender=0;
                break;
            case R.id.rb_gender_default:
                gender=-1;
                break;
        }


        switch (spLeaveRate.getSelectedItem().toString()){
            case TWICE_PER_YEAR:
                leaveRate = 2.0;
                break;
            case ONCE_PER_YEAR:
                leaveRate = 1.0;
                break;
            case ONCE_PER_TWO_YEAR:
                leaveRate = 0.5;
                break;
        }

        filterOptions.setGender(gender);
        filterOptions.setAgeBottom(Integer.valueOf(CommonUtils.getText(etAgeStart)));
        filterOptions.setAgeTop(Integer.valueOf(CommonUtils.getText(etAgeEnd)));
        filterOptions.setDuration(duration);
        filterOptions.setLeaveRate(leaveRate);
        filterOptions.setIsPublic(cbPublic.isChecked()?"是":"否");
        filterOptions.setCareer(spJobType.getSelectedItem().toString());
        filterOptions.setDescription(CommonUtils.getText(etDescription));

        // TODO: 2018/6/7  请求接口

        Log.d("panmengze",new Gson().toJson(filterOptions));

        startActivity(new Intent(mContext, PeopleListActivity.class));
    }

    @OnClick(R.id.btn_select_duration)
    public void onDurationClick() {
        FilterDialog filterDialog = new FilterDialog(mContext, R.layout.layout_filter_dialog, this);
        filterDialog.setCancelable(false);
        filterDialog.show();
    }

    @Override
    public void onSubmit(String[][] duration, FilterDialog filterDialog) {
        this.duration = duration;
        filterDialog.dismiss();
    }
}
