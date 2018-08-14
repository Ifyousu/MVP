package com.example.asus.mvp;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;

import com.example.asus.mvp.base.BaseActivity;
import com.example.asus.mvp.model.entity.NewsBean;
import com.example.asus.mvp.ui.module.home.HomeContract;
import com.example.asus.mvp.ui.module.home.HomePresenter;

public class MainActivity extends BaseActivity<HomePresenter> implements HomeContract.View{

    @Override
    protected int getLayoutId() {
        return R.layout.activity_main;
    }

    @Override
    protected void init() {

    }

    @Override
    protected void loadData() {
        presenter.newsList("","05129f51999497de7c17d9a5f62f89fc");
    }

    @Override
    public void showNews(NewsBean bean) {
        Log.e("MainActivity", "bean:" + bean.getReason());
    }

    @Override
    public void showMsg(String msg) {
        Log.e("MainActivity", msg);
    }
}
