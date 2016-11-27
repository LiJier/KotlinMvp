package com.lijie.gank.mvp

import android.app.Fragment
import rx.subscriptions.CompositeSubscription

/**
 * Created by LJ on 2016/11/27.
 * MVP中V的基类
 */
abstract class BaseView<P : IPresenter> : Fragment() {

    protected var cs: CompositeSubscription = CompositeSubscription()

    protected var presenter: P? = null

    init {
        this.presenter = this.createPresenter()
    }

    abstract fun createPresenter(): P

    override fun onDestroy() {
        super.onDestroy()
        if (!cs.isUnsubscribed) {
            cs.unsubscribe()
        }
        this.presenter?.onDestroy()
    }

}