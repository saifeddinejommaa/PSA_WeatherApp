package com.jommaa.psa_weatherapp.view

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.jommaa.psa_weatherapp.INavigationHandler


open abstract class BaseActivity : AppCompatActivity() , INavigationHandler {



    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    override fun showNextActivity(clazz: Class<*>, bundle: Bundle?) {
        if(bundle!=null){
            startActivity(Intent(this,clazz).putExtras(bundle))
        }
        else{
            startActivity(Intent(this,clazz))
        }

    }

    override fun finishActivity() {
        finish()
    }


}