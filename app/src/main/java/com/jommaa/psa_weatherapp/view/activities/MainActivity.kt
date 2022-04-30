package com.jommaa.psa_weatherapp.view

import android.os.Bundle
import android.view.View
import androidx.activity.viewModels
import androidx.appcompat.app.ActionBar
import androidx.lifecycle.Observer
import androidx.viewpager.widget.ViewPager
import com.jommaa.psa_weatherappapplication.domain.Results.DataResult
import com.jommaa.psa_weatherapp.R
import com.jommaa.psa_weatherapp.adapters.ScreenSlidePagerAdapter
import com.jommaa.psa_weatherapp.viewmodel.MainViewModel
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.android.synthetic.main.activity_main.*

@AndroidEntryPoint
class MainActivity :  BaseActivity() {

        private lateinit var mPager: ViewPager
        private val vm: MainViewModel by viewModels()

      override fun onCreate(savedInstanceState: Bundle?) {
          super.onCreate(savedInstanceState)

          setContentView(R.layout.activity_main)

          initPager()

          vm.getTownsList()?.observe(this, Observer<DataResult>{ result ->
              when(result){
                  is DataResult.Loading -> {
                      progressBar1.visibility = View.VISIBLE
                  }
                  is DataResult.TownsListResult -> {
                      progressBar1.visibility = View.INVISIBLE
                      result.list?.let {
                          (mPager.adapter as ScreenSlidePagerAdapter).setTwonsList(it)
                      }

                  }
                  is DataResult.Failure -> {
                      progressBar1.visibility = View.INVISIBLE
                  }
              }

          })

          fab.setOnClickListener{
              vm.addTownButtonEvent()
          }
          vm.setNavigationHandler(this)

    }

    private fun initPager(){
        mPager = findViewById(R.id.pager)
        val pagerAdapter= ScreenSlidePagerAdapter(supportFragmentManager,null)
        mPager!!.adapter=pagerAdapter
    }

    override fun onBackPressed() {
        if (mPager.currentItem == 0) {
            super.onBackPressed()
        } else {
            mPager.currentItem = mPager.currentItem - 1
        }
    }


}
