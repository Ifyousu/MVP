package com.example.asus.mvp.ui.module.home;

import com.example.asus.mvp.model.entity.NewsBean;
import com.example.asus.mvp.model.network.RetrofitUtils;

import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.functions.Consumer;
import io.reactivex.schedulers.Schedulers;

public class HomePresenter implements HomeContract.Presenter{
    private HomeContract.View view;

    @Override
    public void newsList(String type, String key) {
        RetrofitUtils.getInstance().getHomeService().newsList(type, key)
                .subscribeOn(Schedulers.newThread())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Consumer<NewsBean>() {
                    @Override
                    public void accept(NewsBean bean) throws Exception {
                        if (view != null) {
                            view.showNews(bean);
                        }
                    }
                });
    }

    @Override
    public void attachView(HomeContract.View view) {
        this.view = view;
    }

    @Override
    public void detachView() {
        this.view = null;
    }
}
