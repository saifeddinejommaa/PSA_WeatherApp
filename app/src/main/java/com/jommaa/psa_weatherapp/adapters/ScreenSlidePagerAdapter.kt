package com.jommaa.psa_weatherapp.adapters


import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentStatePagerAdapter
import com.jommaa.psa_weatherapp.domain.entities.Town
import com.jommaa.psa_weatherapp.view.fragment.WeatherDetailFragment

 class ScreenSlidePagerAdapter( fm:FragmentManager,var towns:List<Town>?) : FragmentStatePagerAdapter(fm) {


     fun setTwonsList(townsList:List<Town>){
        this.towns = townsList
         notifyDataSetChanged()
     }
     override fun getCount(): Int {
        if(towns==null){
            return 0
        }
         return towns!!.size
     }

     override fun getItem(position: Int): Fragment {
         val town:Town? = towns?.let{ it?.get(position) }
         return WeatherDetailFragment(town)
     }
}