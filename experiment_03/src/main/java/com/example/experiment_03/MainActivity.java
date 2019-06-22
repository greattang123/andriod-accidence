package com.example.experiment_03;

import android.os.Bundle;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.example.experiment_03.dto.NewsDTO;
import com.example.experiment_03.entity.News;
import com.example.experiment_03.service.NewsService;
import com.example.experiment_03.service.ServiceFactory;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity {

    private static final String TAG = "MainActivity";
    private Button button;
    private TextView textView;
    private ImageView imageView;
    NewsService service = ServiceFactory.getNewsService();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        button = findViewById(R.id.button);
        textView = findViewById(R.id.textView);
        imageView = findViewById(R.id.imageView);
        button.setOnClickListener(v -> {
            // 像网络请求这种线程阻塞的操作，禁止在主线程中执行
            // enqueue()为异步方法，将请求任务加入应用全局异步请求队列
            // 在异步子线程中获取响应对象，在主线程，回调结果。即onResponse()方法为主线程调用
            service.listNews().enqueue(new Callback<NewsDTO>() {
                @Override
                public void onResponse(Call<NewsDTO> call, Response<NewsDTO> response) {
                    if (response.body() == null) {
                        return;
                    }
                    // 基于converter-gson自动完成反序列化
                    NewsDTO newsDTO = response.body();
                    List<News> newsList = newsDTO.newsList;
                    textView.setText(newsList.get(0).title);
                }

                @Override
                public void onFailure(Call<NewsDTO> call, Throwable t) {

                }
            });
        });

    }
}
