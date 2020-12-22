package com.example.simpleloginmvvm

import android.os.Bundle
import android.os.StrictMode
import androidx.appcompat.app.AppCompatActivity

import org.jetbrains.exposed.sql.Database

abstract class BaseActivity:AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        StrictMode.setThreadPolicy(StrictMode.ThreadPolicy.Builder().permitAll().build())
        val host = "192.168.0.200"
        val databaseName = "repairdbv2"
        val url = "jdbc:mysql://$host:3306/$databaseName?useUnicode=true&characterEncoding=utf-8"
        Database.connect(
            url = url,
            driver = "com.mysql.jdbc.Driver",
            user = "drusp",
            password = "drusp",
        )
    }

}
