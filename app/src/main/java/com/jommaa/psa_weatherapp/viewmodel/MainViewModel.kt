package com.jommaa.psa_weatherapp.viewmodel


import androidx.databinding.ObservableField
import androidx.lifecycle.*
import androidx.viewpager.widget.ViewPager
import com.jommaa.psa_weatherapp.domain.usecases.TownUseCases
import com.jommaa.psa_weatherapp.INavigationHandler
import com.jommaa.psa_weatherapp.view.AddNewTownActivity
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class MainViewModel  @Inject constructor(val useCase: TownUseCases ) : ViewModel() {


    fun getTownsList()=useCase.getTownsList()

    var townName = ObservableField<String>()
    private lateinit var  navigationHandler: INavigationHandler

    val onPageChangeListener : ViewPager.OnPageChangeListener = object :ViewPager.OnPageChangeListener{
        override fun onPageScrollStateChanged(state: Int) {
        }

        override fun onPageSelected(position: Int) {


        }

        override fun onPageScrolled(
            position: Int,
            positionOffset: Float,
            positionOffsetPixels: Int) {
        }
    }

    fun setNavigationHandler(navigationHandler: INavigationHandler){
        this.navigationHandler = navigationHandler
    }

    fun addTownButtonEvent(){
        navigationHandler.showNextActivity(AddNewTownActivity::class.java,null)
    }



}