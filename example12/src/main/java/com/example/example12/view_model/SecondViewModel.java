package com.example.example12.view_model;

import android.app.Application;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.MutableLiveData;

import com.example.example12.entity.News;

import java.util.ArrayList;
import java.util.List;

public class SecondViewModel extends AndroidViewModel {
    private static final String TAG = "SecondViewModel";
    //模拟每次获取的新数据，而不是加上旧的全部数据
    public MutableLiveData<List<News>> newsLoad = new MutableLiveData<List<News>>();

    public SecondViewModel(@NonNull Application application) {
        super(application);
        initNews();
    }

    /**
     * 模拟异步请求并获取最新数据
     */
    private void initNews() {
        new Thread(() -> {
            try {
                Thread.sleep(1000);
                News n = new News(1, "阿根廷VS波黑", "小组赛F组 阿根廷VS波黑");
                List<News> news = new ArrayList<News>();
                news.add(n);
                //将数据异步更新绑定
                newsLoad.postValue(news);
            } catch (InterruptedException e) {
            }
        }).start();
    }

    public void loanNews(){
        new Thread(()->{
            try {
                Thread.sleep(2000);
                News n=new News(1, "荷兰VS西班牙", "小组赛F组 荷兰VS西班牙");
                List<News>news=new ArrayList<News>();
                news.add(n);
                newsLoad.postValue(news);
            }catch (InterruptedException e){}
        }).start();
    }
}
