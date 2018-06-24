package com.ustc.cv.adapter;

import android.app.Activity;
import android.content.Context;
import android.support.v4.view.PagerAdapter;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import butterknife.BindView;
import com.bumptech.glide.Glide;
import com.ustc.cv.R;
import com.ustc.cv.model.Person;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Daniel
 * @ClassName: FoodDetailPageAdapter.java
 * @Description: 食品详情adapter
 * @date 2017/10/13 19:22
 */
public class PersonDetailPageAdapter extends PagerAdapter {

    private List<Person> personList;
    private List<View> viewList;
    private int resId;
    private Context mContext;

    public PersonDetailPageAdapter(List<Person> personList, int resId, Context mContext) {
        this.personList = personList;
        this.resId = resId;
        this.mContext = mContext;
        initViewList();
    }

    private void initViewList() {
        viewList = new ArrayList<>();
        LayoutInflater inflater = ((Activity) mContext).getLayoutInflater();
        for (Person person : personList) {
            viewList.add(inflater.inflate(resId, null));
        }
    }

    @Override
    public int getCount() {
        return viewList.size();
    }

    @Override
    public boolean isViewFromObject(View view, Object object) {
        return view == object;
    }

    @Override
    public void destroyItem(ViewGroup container, int position, Object object) {
        container.removeView(viewList.get(position));
    }

    @Override
    public Object instantiateItem(ViewGroup container, int position) {
        View pageView = viewList.get(position);
        Person person = personList.get(position);

        TextView tvPersonName = (TextView) pageView.findViewById(R.id.tv_person_name);
        ImageView ivPerson = (ImageView) pageView.findViewById(R.id.iv_person);
        TextView tvGraduateFrom = (TextView) pageView.findViewById(R.id.tv_graduate_from);
        TextView tvGender = (TextView) pageView.findViewById(R.id.tv_gender);
        TextView tvAge = (TextView) pageView.findViewById(R.id.tv_age);
        TextView tvDuration = (TextView) pageView.findViewById(R.id.tv_duration);
        TextView tvDescription = (TextView) pageView.findViewById(R.id.tv_description);
        TextView tvSkill = (TextView) pageView.findViewById(R.id.tv_skill);
        TextView tvJobExp = (TextView) pageView.findViewById(R.id.tv_job_exp);
        TextView tvProjectExp = (TextView) pageView.findViewById(R.id.tv_project_exp);

        tvPersonName.setText(person.getName());
        tvGraduateFrom.setText(person.getGraduateFrom());
        tvGender.setText(person.getGender() == 1?"男":"女");
        tvAge.setText(String.valueOf(person.getAge())+"岁");
        tvDuration.setText(person.getDuration()+"年");
        tvDescription.setText(person.getDescription());
        tvSkill.setText(person.getSkill());
        tvJobExp.setText(person.getJobExp());
        tvProjectExp.setText(person.getProjectExp());
        Glide.with(mContext).load(person.getAvatar()).into(ivPerson);

        container.addView(viewList.get(position));


        return viewList.get(position);
    }
}
