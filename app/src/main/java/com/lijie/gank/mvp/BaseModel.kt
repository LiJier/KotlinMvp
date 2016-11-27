package com.lijie.gank.mvp

import rx.subscriptions.CompositeSubscription

/**
 * Created by LJ on 2016/11/27.
 * MVP中M的基类
 */
open class BaseModel(var presenter: IPresenter?) {

    protected var cs: CompositeSubscription = CompositeSubscription()

    fun onCancel() {
        if (!cs.isUnsubscribed) {
            cs.unsubscribe()
        }
        presenter = null
    }

}