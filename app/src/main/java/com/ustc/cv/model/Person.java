package com.ustc.cv.model;

import android.os.Parcel;
import android.os.Parcelable;

/**
 * Author        Daniel
 * Class:        Person
 * Date:         2018/5/26 11:38
 * Description:  姓名、年龄、性别、毕业院校、工作年限、职位、技能、自我介绍、工作经验、项目经验、头像
 */
public class Person implements Parcelable {

    private String name;
    private Integer avatar;
    private Integer age;
    private String gender;
    private String graduateFrom;
    private String duration;
    private String duty;
    private String skill;
    private String description;
    private String jobExp;
    private String projectExp;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getAvatar() {
        return avatar;
    }

    public void setAvatar(Integer avatar) {
        this.avatar = avatar;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getGraduateFrom() {
        return graduateFrom;
    }

    public void setGraduateFrom(String graduateFrom) {
        this.graduateFrom = graduateFrom;
    }

    public String getDuration() {
        return duration;
    }

    public void setDuration(String duration) {
        this.duration = duration;
    }

    public String getDuty() {
        return duty;
    }

    public void setDuty(String duty) {
        this.duty = duty;
    }

    public String getSkill() {
        return skill;
    }

    public void setSkill(String skill) {
        this.skill = skill;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getJobExp() {
        return jobExp;
    }

    public void setJobExp(String jobExp) {
        this.jobExp = jobExp;
    }

    public String getProjectExp() {
        return projectExp;
    }

    public void setProjectExp(String projectExp) {
        this.projectExp = projectExp;
    }


    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(this.name);
        dest.writeValue(this.avatar);
        dest.writeValue(this.age);
        dest.writeString(this.gender);
        dest.writeString(this.graduateFrom);
        dest.writeString(this.duration);
        dest.writeString(this.duty);
        dest.writeString(this.skill);
        dest.writeString(this.description);
        dest.writeString(this.jobExp);
        dest.writeString(this.projectExp);
    }

    public Person() {
    }

    protected Person(Parcel in) {
        this.name = in.readString();
        this.avatar = (Integer) in.readValue(Integer.class.getClassLoader());
        this.age = (Integer) in.readValue(Integer.class.getClassLoader());
        this.gender = in.readString();
        this.graduateFrom = in.readString();
        this.duration = in.readString();
        this.duty = in.readString();
        this.skill = in.readString();
        this.description = in.readString();
        this.jobExp = in.readString();
        this.projectExp = in.readString();
    }

    public static final Creator<Person> CREATOR = new Creator<Person>() {
        @Override
        public Person createFromParcel(Parcel source) {
            return new Person(source);
        }

        @Override
        public Person[] newArray(int size) {
            return new Person[size];
        }
    };
}
