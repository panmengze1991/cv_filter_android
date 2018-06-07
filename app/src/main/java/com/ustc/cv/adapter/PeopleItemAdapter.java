package com.ustc.cv.adapter;

import android.content.Context;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import butterknife.BindView;
import com.bumptech.glide.Glide;
import com.ustc.cv.R;
import com.ustc.cv.model.Person;

import java.util.List;

/**
 * Author        Daniel
 * Class:        PeopleItemAdapter
 * Date:         2018/5/26 17:29
 * Description:  简历列表
 */
public class PeopleItemAdapter extends BaseRecyclerAdapter<Person> {



    public PeopleItemAdapter(List<Person> dataList, Context mContext, int layoutId) {
        super(dataList, mContext, layoutId);
    }

    @Override
    protected void bindData(BaseViewHolder holder, final int position) {
        final Person person = dataList.get(position);

        ImageView ivPeople = (ImageView) holder.getView(R.id.iv_person);
        TextView tvPeopleName = (TextView) holder.getView(R.id.tv_person_name);
        TextView tvGraduateFrom = (TextView) holder.getView(R.id.tv_graduate_from);
        TextView tvGender = (TextView) holder.getView(R.id.tv_gender);
        TextView tvAge = (TextView) holder.getView(R.id.tv_age);
        TextView tvDuration = (TextView) holder.getView(R.id.tv_duration);
        TextView btnInvite = (TextView) holder.getView(R.id.btn_invite);
        LinearLayout llPeopleItem = (LinearLayout) holder.getView(R.id.ll_people_item);

        Glide.with(mContext).load(R.drawable.ic_logo).into(ivPeople);
        tvPeopleName.setText(person.getName());
        tvGraduateFrom.setText(person.getGraduateFrom());
        tvGender.setText(person.getGender()==1?"男":"女");
        tvAge.setText(String.valueOf(person.getAge())+ "岁");
        tvDuration.setText(String.valueOf(person.getDuration())+"年");
        btnInvite.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onItemBtnClickListener.onClick(person,position);
            }
        });
        llPeopleItem.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onItemClickListener.onClick(person,position);
            }
        });


    }
}
