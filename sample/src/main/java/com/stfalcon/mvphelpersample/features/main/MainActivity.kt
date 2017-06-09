package com.stfalcon.mvphelpersample.features.main

import android.view.View
import android.widget.Toast
import com.stfalcon.mvphelper.MvpActivity
import com.stfalcon.mvphelpersample.R
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : MvpActivity<MainActivityContract.Presenter, MainActivityContract.View>(),
        MainActivityContract.View {

    override fun getLayoutResId(): Int = R.layout.activity_main

    override fun showData(data: String) {
        Toast.makeText(this, "message received: $data", Toast.LENGTH_LONG).show()
    }

    override fun showLoading(show: Boolean) {
        loadingLayout.visibility = if (show) View.VISIBLE else View.GONE
    }
}
