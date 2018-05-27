package com.ustc.cv;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.os.Parcelable;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.widget.Toast;
import butterknife.BindView;
import butterknife.ButterKnife;
import com.ustc.cv.adapter.PeopleItemAdapter;
import com.ustc.cv.callback.OnItemBtnClickListener;
import com.ustc.cv.callback.OnItemClickListener;
import com.ustc.cv.model.Person;
import com.ustc.cv.utils.Const;

import java.util.ArrayList;
import java.util.List;

public class PeopleListActivity extends AppCompatActivity {


    Context mContext;
    @BindView(R.id.rv_people_list)
    RecyclerView rvPeopleList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_people_list);
        ButterKnife.bind(this);
        mContext = this;
        initRecyclerView();
    }

    /**
     * @description: 初始化列表
     * @author: Daniel
     */
    protected void initRecyclerView() {
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(mContext, LinearLayoutManager.VERTICAL, false);
        // 设置布局管理器
        rvPeopleList.setLayoutManager(layoutManager);
        // 设置adapter
        final List<Person> personList = new ArrayList<>();
        Person person = new Person();
        person.setAvatar(R.drawable.ic_logo);
        person.setName("李俊锋");
        person.setAge(22);
        person.setGender("男");
        person.setGraduateFrom("中国科学技术大学");
        person.setDuration("1年");
        person.setDuty("软件工程师");
        person.setSkill("JAVA C++ Python JAVA C++ Python JAVA C++ Python JAVA C++ Python JAVA C++ Python JAVA C++ Python ");
        person.setDescription("非常牛逼非常牛逼非常牛逼非常牛逼非常牛逼非常牛逼非常牛逼非常牛逼非常牛逼非常牛逼非常牛逼非常牛逼");
        person.setJobExp("一家企业一家企业一家企业一家企业一家企业一家企业一家企业一家企业一家企业一家企业一家企业一家企业");
        person.setProjectExp("非常多的项目非常多的项目非常多的项目非常多的项目非常多的项目非常多的项目");
        personList.add(person);
        personList.add(person);
        personList.add(person);
        personList.add(person);
        personList.add(person);
        personList.add(person);
        personList.add(person);
        personList.add(person);
        personList.add(person);
        PeopleItemAdapter peopleItemAdapter=   new PeopleItemAdapter(personList,mContext,R.layout.recycler_item_people);
        peopleItemAdapter.setOnItemBtnClickListener(new OnItemBtnClickListener<Person>() {
            @Override
            public void onClick(Person person, int position) {
                Toast.makeText(mContext,"已发出邀约！",Toast.LENGTH_SHORT).show();
            }
        });
        peopleItemAdapter.setOnItemClickListener(new OnItemClickListener<Person>() {
            @Override
            public void onClick(Person person, int position) {
                Bundle bundle = new Bundle();
                bundle.putParcelableArrayList(Const.BundleKey.PERSON_LIST, (ArrayList<? extends Parcelable>) personList);
                Intent intent = new Intent(mContext, PeopleDetailActivity.class);
                intent.putExtra(Const.IntentKey.PERSON_POSITION,position);
                intent.putExtras(bundle);
                startActivity(intent);
            }
        });
        rvPeopleList.setAdapter(peopleItemAdapter);
    }
}
