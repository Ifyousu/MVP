package com.example.asus.mvp.ui.module.home;

import com.example.asus.mvp.base.BasePresenter;
import com.example.asus.mvp.base.BaseView;
import com.example.asus.mvp.model.entity.NewsBean;

public class HomeContract {
    public interface View extends BaseView{
        void showNews(NewsBean bean);
    }

    interface Presenter extends BasePresenter<View>{
        void newsList(String type , String key);
    }
}
