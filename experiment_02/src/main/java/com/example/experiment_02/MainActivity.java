package com.example.experiment_02;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;
import androidx.lifecycle.ViewModelProviders;

import com.example.experiment_02.databinding.ActivityMainBinding;
import com.example.experiment_02.viewmodel.MainViewModel;

public class MainActivity extends AppCompatActivity {
    private static final String TAG = "MainActivity";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        // 取消默认调用setContentView()方法代码
       // setContentView(R.layout.activity_main);

        ActivityMainBinding binding = DataBindingUtil.setContentView(this, R.layout.activity_main);

        MainViewModel mainViewModel = ViewModelProviders.of(this).get(MainViewModel.class);
        binding.setMainVM(mainViewModel);
        /**
         * 将绑定数据，与当前activity生命周期绑定
         * 例如，当数据改变时，且activity可见时，自动更新页面
         */
        binding.setLifecycleOwner(this);

    }

}
