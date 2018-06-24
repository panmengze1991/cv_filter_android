package com.ustc.cv;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.os.Parcelable;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.widget.*;
import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import com.ustc.cv.callback.OnDialogSubmitListener;
import com.ustc.cv.model.FilterOptions;
import com.ustc.cv.model.http.ResultGetProperties;
import com.ustc.cv.model.http.ResultPostProperties;
import com.ustc.cv.utils.CommonUtils;
import com.ustc.cv.utils.Const;
import com.ustc.cv.utils.http.ConnInterface;
import com.ustc.cv.utils.http.ConnectionFactory;
import com.ustc.cv.utils.http.RetrofitClient;
import com.ustc.cv.view.FilterDialog;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;

import java.util.ArrayList;
import java.util.List;

import static com.ustc.cv.utils.Const.LeaveRate.ONCE_PER_TWO_YEAR;
import static com.ustc.cv.utils.Const.LeaveRate.ONCE_PER_YEAR;
import static com.ustc.cv.utils.Const.LeaveRate.TWICE_PER_YEAR;

public class SelectFilterActivity extends BaseActivity implements OnDialogSubmitListener<String[][]> {

    Context mContext;

    List<String> jobTypeList;

    FilterOptions filterOptions = new FilterOptions();
    String[][] duration = new String[][]{{"doctor", "0", "99"}, {"master", "0", "99"}, {"bachelor", "0", "99"},
            {"normal", "0", "99"}};

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



        initData();
        initView();
    }

    /**
     * author:      Daniel
     * description: 获取职位
     */
    private void initData() {
        showProgress();
        ConnInterface connection = ConnectionFactory.getConnection(RetrofitClient.getRetrofit());
        Call<ResultGetProperties> call = connection.getProperties();

        call.enqueue(new Callback<ResultGetProperties>() {
            @Override
            public void onResponse(Call<ResultGetProperties> call, Response<ResultGetProperties> response) {
                dismissProgress();
                ResultGetProperties resultGetProperties = response.body();
                Log.d("panmengze", "resultGetProperties.size() == "+resultGetProperties.getData().size());
                jobTypeList = resultGetProperties.getData();
                spJobType.setAdapter(new ArrayAdapter<>(mContext, R.layout.spinner_list__item, jobTypeList));
            }

            @Override
            public void onFailure(Call<ResultGetProperties> call, Throwable t) {
                dismissProgress();
                t.printStackTrace();
                jobTypeList =new ArrayList<>();
                jobTypeList.add("Java");
                jobTypeList.add("FrontEnd");
                jobTypeList.add("Mechanical");
                spJobType.setAdapter(new ArrayAdapter<>(mContext, R.layout.spinner_list__item, jobTypeList));
            }
        });
    }

    private void initView() {
        List<String> listLeaveRate = new ArrayList<>();
        listLeaveRate.add("一年两次");
        listLeaveRate.add("两年一次");
        listLeaveRate.add("一年一次");
        spLeaveRate.setAdapter(new ArrayAdapter<>(mContext, R.layout.spinner_list__item, listLeaveRate));
    }

    @OnClick(R.id.btn_go)
    public void onViewClicked() {
        showProgress(R.string.progress_hint);
        Integer gender = null;
        double leaveRate = -1;

        switch (rgGender.getCheckedRadioButtonId()) {
            case R.id.rb_gender_male:
                gender = 1;
                break;
            case R.id.rb_gender_female:
                gender = 0;
                break;
            case R.id.rb_gender_default:
                gender = null;
                break;
        }


        switch (spLeaveRate.getSelectedItem().toString()) {
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
        filterOptions.setAgeBottom(CommonUtils.getNumber(etAgeStart));
        filterOptions.setAgeTop(CommonUtils.getNumber(etAgeEnd));
//        filterOptions.setDuration(duration);
        filterOptions.setLeaveRate(leaveRate);
        filterOptions.setIsPublic(cbPublic.isChecked() ? "是" : "否");
        filterOptions.setCareer(spJobType.getSelectedItem().toString());
        filterOptions.setDescription(CommonUtils.getText(etDescription));

        // TODO: 2018/6/7  请求接口
        ConnInterface connection = ConnectionFactory.getConnection(RetrofitClient.getRetrofit());
        Call<ResultPostProperties> call = connection.postProperties(filterOptions);
        call.enqueue(new Callback<ResultPostProperties>() {
            @Override
            public void onResponse(Call<ResultPostProperties> call, Response<ResultPostProperties> response) {
                dismissProgress();
                if (response.code()==200){
                    Bundle bundle = new Bundle();
                    ArrayList<? extends  Parcelable> personList = response.body().getData();
                    bundle.putParcelableArrayList(Const.BundleKey.PERSON_LIST, personList);
                    Intent intent = new Intent(mContext,PeopleListActivity.class);
                    intent.putExtras(bundle);
                    startActivity(intent);
                    showToast(R.string.toast_filter_success);
                } else {
                    showToast(R.string.toast_filter_failed);
                }
            }

            @Override
            public void onFailure(Call<ResultPostProperties> call, Throwable t) {
                dismissProgress();
                showToast(R.string.toast_filter_failed);
                t.printStackTrace();
            }
        });

//        startActivity(new Intent(mContext, PeopleListActivity.class));
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
