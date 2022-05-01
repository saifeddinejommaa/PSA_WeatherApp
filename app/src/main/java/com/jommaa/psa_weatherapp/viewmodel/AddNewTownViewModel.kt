package com.jommaa.psa_weatherapp.viewmodel


import android.location.Address
import android.location.Geocoder
import android.widget.Toast
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.jommaa.psa_weatherapp.domain.entities.Town
import com.jommaa.psa_weatherapp.domain.usecases.TownUseCases
import com.jommaa.psa_weatherapp.INavigationHandler
import dagger.hilt.android.lifecycle.HiltViewModel
import dagger.hilt.android.qualifiers.ApplicationContext
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import java.lang.StringBuilder
import java.util.*
import javax.inject.Inject

@HiltViewModel
class AddNewTownViewModel @Inject constructor(val townsUseCases: TownUseCases, @ApplicationContext val application : android.content.Context) : ViewModel() {


    var result= MutableLiveData<Town>()
    var newTown: Town? = null
    var isAddTownButtonVisible : Boolean = false
    private lateinit var  navigationHandler: INavigationHandler

    fun setNavigationHandler(navigationHandler: INavigationHandler){
        this.navigationHandler = navigationHandler
    }

   fun findTown(townName: String){
       if(townName.equals("")){
           Toast.makeText(application,"Please enter a valid town Name",Toast.LENGTH_LONG).show()
           return
       }

       val geocoder = Geocoder(application,Locale.getDefault())
       val addressList: MutableList<Address>? =geocoder.getFromLocationName(townName,1)
       addressList?.let {
           if(addressList?.count()?.compareTo(0)!=0){
               val FoundTown = Town(townName,addressList[0].latitude,addressList[0].longitude)
               result.postValue(FoundTown)
               newTown=FoundTown

               isAddTownButtonVisible = true
           }

       }

   }
        fun addNewTown(){
        isAddTownButtonVisible = false
        newTown?.let {
            viewModelScope.launch(Dispatchers.IO) {
                townsUseCases.addNewTown(it)
            }
        }
        navigationHandler.finishActivity()
    }

}