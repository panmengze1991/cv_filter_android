package com.ustc.cv.view;

import android.app.Dialog;
import android.content.Context;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import butterknife.BindView;
import butterknife.ButterKnife;
import com.ustc.cv.R;
import com.ustc.cv.callback.OnDialogSubmitListener;
import com.ustc.cv.utils.CommonUtils;
import com.ustc.cv.utils.Const.Duration;

import static com.ustc.cv.utils.Const.Duration.*;

public class FilterDialog extends Dialog {
    Context mContext;
    FilterDialog filterDialog;
    OnDialogSubmitListener<String[][]> onDialogSubmitListener;
    int resId;

    @BindView(R.id.tv_title)
    TextView tvTitle;
    @BindView(R.id.et_doctor_start)
    EditText etDoctorStart;
    @BindView(R.id.et_doctor_end)
    EditText etDoctorEnd;
    @BindView(R.id.et_master_start)
    EditText etMasterStart;
    @BindView(R.id.et_master_end)
    EditText etMasterEnd;
    @BindView(R.id.et_bachelor_start)
    EditText etBachelorStart;
    @BindView(R.id.et_bachelor_end)
    EditText etBachelorEnd;
    @BindView(R.id.et_normal_start)
    EditText etNormalStart;
    @BindView(R.id.et_normal_end)
    EditText etNormalEnd;
    @BindView(R.id.btn_finish)
    TextView btnFinish;

    public FilterDialog(@NonNull Context context, int resId, OnDialogSubmitListener<String[][]> onDialogSubmitListener) {
        super(context);
        mContext = context;
        this.resId = resId;
        this.onDialogSubmitListener = onDialogSubmitListener;
        this.filterDialog = this;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        initView();
    }

    private void initView() {
        LayoutInflater inflater = LayoutInflater.from(mContext);
        View view = inflater.inflate(resId, null);
        setContentView(view);
        ButterKnife.bind(this);

        btnFinish.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onDialogSubmitListener.onSubmit(getDuration(),filterDialog);
            }
        });
    }

    private String[][] getDuration() {
        String[][] duration = new String[][]{{"doctor", "-1", "-1"}, {"master", "-1", "-1"}, {"bachelor", "-1", "-1"},
                {"normal", "-1", "-1"}};
        if(CommonUtils.isNotEmpty(etDoctorStart,etDoctorEnd)){
            String[] range = order(etDoctorStart,etDoctorEnd);
            duration[DOCTOR][START] = range[0];
            duration[DOCTOR][END] = range[1];
        } else {
            duration[DOCTOR][START] = DEFAULT_VALUE;
            duration[DOCTOR][END] = DEFAULT_VALUE;
        }

        if(CommonUtils.isNotEmpty(etMasterStart,etMasterEnd)){
            String[] range = order(etMasterStart,etMasterEnd);
            duration[MASTER][START] = range[0];
            duration[MASTER][END] = range[1];
        } else {
            duration[MASTER][START] = DEFAULT_VALUE;
            duration[MASTER][END] = DEFAULT_VALUE;
        }

        if(CommonUtils.isNotEmpty(etBachelorStart,etBachelorEnd)){
            String[] range = order(etBachelorStart,etBachelorEnd);
            duration[BACHELOR][START] = range[0];
            duration[BACHELOR][END] = range[1];
        } else {
            duration[BACHELOR][START] = DEFAULT_VALUE;
            duration[BACHELOR][END] = DEFAULT_VALUE;
        }

        if(CommonUtils.isNotEmpty(etNormalStart,etNormalEnd)){
            String[] range = order(etNormalStart,etNormalEnd);
            duration[NORMAL][START] = range[0];
            duration[NORMAL][END] = range[1];
        } else {
            duration[NORMAL][START] = DEFAULT_VALUE;
            duration[NORMAL][END] = DEFAULT_VALUE;
        }
        return duration;
    }

    private String[] order(EditText et1,EditText et2){
        String start = Integer.valueOf(CommonUtils.getText(et1))<Integer.valueOf(CommonUtils.getText(et2))?CommonUtils.getText(et1):CommonUtils.getText(et2);
        String end = Integer.valueOf(CommonUtils.getText(et1))>Integer.valueOf(CommonUtils.getText(et2))?CommonUtils.getText(et1):CommonUtils.getText(et2);
        return new String[] {start,end};
    }
}
