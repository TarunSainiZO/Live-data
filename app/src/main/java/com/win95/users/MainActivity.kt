package com.win95.users

import android.content.Context
import android.net.ConnectivityManager
import android.net.ConnectivityManager.NetworkCallback
import android.net.Network
import android.net.NetworkCapabilities
import android.net.NetworkRequest
import android.os.Bundle
import android.view.Gravity
import android.view.LayoutInflater
import android.view.View
import android.widget.Button
import androidx.appcompat.app.AlertDialog
import androidx.appcompat.app.AppCompatActivity
import androidx.core.content.ContextCompat.getSystemService
import androidx.lifecycle.Observer


class MainActivity : AppCompatActivity(){
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val view = LayoutInflater.from(this).inflate(R.layout.network,null,false)
        val builder = AlertDialog.Builder(this)
        builder.setView(view)
        val dialog : AlertDialog = builder.create()
        dialog.window?.setGravity(Gravity.CENTER)
        dialog.setCancelable(false)
        val networkConnection = NetworkConnection(applicationContext)
        networkConnection.observe(this, Observer {
            if(!it){
                dialog.show()
            }else{
                dialog.hide()
            }
        })
    }

}