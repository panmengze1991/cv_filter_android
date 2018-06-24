package com.ustc.cv;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import com.ustc.cv.adapter.PersonDetailPageAdapter;
import com.ustc.cv.model.Person;
import com.ustc.cv.utils.Const;

import java.util.List;

public class PeopleDetailActivity extends BaseActivity {

    @BindView(R.id.vp_people_detail)
    ViewPager vpPeopleDetail;

    private static int currentPageIndex = -1;

    List<Person> personList;

    PersonDetailPageAdapter pageAdapter;

    Context mContext;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_people_detail);
        ButterKnife.bind(this);
        mContext = this;
        initViewPager();
    }

    private void initViewPager() {
        Intent intent = getIntent();
        currentPageIndex = intent.getIntExtra(Const.IntentKey.PERSON_POSITION, 0);
        Bundle bundle = intent.getExtras();
        personList = bundle.getParcelableArrayList(Const.BundleKey.PERSON_LIST);
        pageAdapter = new PersonDetailPageAdapter(personList, R.layout.layout_people_detail,
                mContext);
        vpPeopleDetail.setAdapter(pageAdapter);
        vpPeopleDetail.setCurrentItem(currentPageIndex);
    }

    @OnClick(R.id.btn_invite)
    public void onViewClicked() {
        showToast(R.string.toast_invite);
    }
}
