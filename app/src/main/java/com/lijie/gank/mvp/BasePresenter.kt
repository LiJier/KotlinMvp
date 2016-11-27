package com.lijie.gank.mvp

import rx.subscriptions.CompositeSubscription

/**
 * Created by LJ on 2016/11/27.
 * MVP中P的基类
 */
abstract class BasePresenter<V : IView, M : IModel>(var view: V?) {

    protected var cs: CompositeSubscription = CompositeSubscription()
    protected var model: M? = null

    init {
        this.model = this.createModel()
    }

    abstract fun createModel(): M

    fun onDestroy() {
        if (!cs.isUnsubscribed) {
            cs.unsubscribe()
        }
        this.model?.onCancel()
        view = null
    }

}