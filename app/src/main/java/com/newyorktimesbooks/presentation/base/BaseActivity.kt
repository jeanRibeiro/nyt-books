package com.newyorktimesbooks.presentation.base

import android.os.Build
import android.widget.Toolbar
import androidx.annotation.RequiresApi
import androidx.appcompat.app.AppCompatActivity

open class BaseActivity: AppCompatActivity() {

    @RequiresApi(Build.VERSION_CODES.LOLLIPOP)
    protected fun setupToolbar(toolbar: Toolbar, tituloRes: Int){
        toolbar.title = getString(tituloRes)
        //setSupportActionBar(toolbar)
    }

}