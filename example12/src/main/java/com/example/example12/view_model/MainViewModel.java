package com.example.example12.view_model;

import android.app.Application;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.MutableLiveData;

import com.example.example12.entity.User;

public class MainViewModel extends AndroidViewModel {
    private static final String TAG = "ManiViewModel";
    /* 将预在页面绑定的数据，声明为与页面生命周期绑定的MutableLiveData可变类型
    可以想象为一个能够绑定到视图页面的容器*/
    public MutableLiveData<User> userLiveData = new MutableLiveData<>();

    /**
     * 必须声明的构造器，alt+insert
     * 自动注入application对象,便于后期使用
     *
     * @param application
     */
    public MainViewModel(@NonNull Application application) {
        super(application);
        User user = new User("GT");
        userLiveData.setValue(user);
    }

    /**
     * 在子线程中异步操作修改绑定数据，而非主线程
     * 因此必须使用postValue()方法，自动通知主线程修改
     */
    public void change() {
        new Thread(() -> {
            try {
                Thread.sleep(2000);
                //重新创建一个user对象置入
                User u = new User("Jack");
                userLiveData.setValue(u);
                userLiveData.postValue(u);
            } catch (InterruptedException e) {

            }
        }).start();
    }
}
