package com.lijie.gank.base

import com.lijie.gank.mvp.BaseView
import com.lijie.gank.mvp.IPresenter

/**
 * Created by LJ on 2016/11/27.
 */
abstract class BaseFragment<P : IPresenter> : BaseView<P>() {
}