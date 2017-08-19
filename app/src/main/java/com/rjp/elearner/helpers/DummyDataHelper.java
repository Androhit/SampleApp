package com.rjp.elearner.helpers;

import android.support.annotation.NonNull;

import com.rjp.elearner.beans.WeeksBean;

import java.util.ArrayList;
import java.util.HashMap;

/**
 * Created by SAT on 8/19/2017.
 */

public class DummyDataHelper {

    @NonNull
    public static HashMap<String, String> getUrls() {
        HashMap<String, String> urls = new HashMap();
        urls.put("abc", "http://www.e-learner.in/assets/landing-page/elearner-img/webbanner1.jpg");
        urls.put("xyz", "http://www.e-learner.in/assets/landing-page/elearner-img/webbanner2.jpg");
        urls.put("pqr", "http://www.e-learner.in/assets/landing-page/elearner-img/webbanner3.jpg");
        return urls;
    }

    @NonNull
    public static ArrayList<WeeksBean> getWeeks() {
        ArrayList<WeeksBean> weeks = new ArrayList<>();

        WeeksBean obj = new WeeksBean();
        obj.setName("First Week");
        obj.setDesc("Basic Concepts of English Language");
        obj.setNo_of_days("5");
        obj.setComplete_status(0);
        weeks.add(obj);
        obj = new WeeksBean();
        obj.setName("Second Week");
        obj.setDesc("Fundamentals of English");
        obj.setNo_of_days("4");
        obj.setComplete_status(0);
        weeks.add(obj);
        obj = new WeeksBean();
        obj.setName("Third Week");
        obj.setDesc("Fundamentals of English");
        obj.setNo_of_days("6");
        obj.setComplete_status(0);
        weeks.add(obj);
        obj = new WeeksBean();
        obj.setName("Fourth Week");
        obj.setDesc("Basic Concepts of English Language");
        obj.setNo_of_days("5");
        obj.setComplete_status(0);
        weeks.add(obj);
        return weeks;
    }
}
