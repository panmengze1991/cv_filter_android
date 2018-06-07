package com.ustc.cv.utils;

/**
 * Created by panmengze on 2018/5/25.
 */

public class Const {
    public static class IntentKey{
        public static final String PERSON_POSITION = "person_position";
    }

    public static class BundleKey{
        public static final String PERSON_LIST = "person_list";
    }

    public static class Duration{
        public static final int DOCTOR = 0;
        public static final int MASTER = 1;
        public static final int BACHELOR = 2;
        public static final int NORMAL = 3;
        public static final int START = 1;
        public static final int END = 2;
        public static final String DEFAULT_VALUE = "-1";
    }

    public static class LeaveRate{
        public static final String TWICE_PER_YEAR = "一年两次";
        public static final String ONCE_PER_YEAR = "一年一次";
        public static final String ONCE_PER_TWO_YEAR = "两年一次";
    }
}
