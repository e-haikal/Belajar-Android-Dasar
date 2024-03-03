package com.tuntasdigital.belajarandroiddasar

import android.content.pm.PackageManager
import android.content.res.Resources
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import kotlin.math.log

class MainActivity : AppCompatActivity() {
    private lateinit var namaAndaEditText: EditText
    private lateinit var sayHaiButton: Button
    private lateinit var hiTextView: TextView

    private fun initComponents(){
        //inisialisasi
        namaAndaEditText = findViewById(R.id.namaAndaEditText)
        sayHaiButton = findViewById(R.id.sayHaiButton)
        hiTextView = findViewById(R.id.haiTextView)
    }

    private fun checkFingerprint(){
        if (packageManager.hasSystemFeature(PackageManager.FEATURE_FINGERPRINT)){
            Log.i("FEATURE", "Finger Feature is ON")
        } else {
            Log.e("FEATURE", "Fingerprint feature is OFF")
        }
    }

    private fun printHello(name: String){
        Log.i("DEBUG", name)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
        initComponents()
        hiTextView.text = resources.getString(R.string.app_name)


        sayHaiButton.setOnClickListener {
            val firstName = "Asman"
            printHello(firstName)


            checkFingerprint()
            //raw resource - menampilkan file json
            val sample = resources.openRawResource(R.raw.sample)
                .bufferedReader()
                .use { it.readText() }
            Log.i("RAW", sample)

            // asset manager - menampilkan json file
            val json = assets.open("sample.json")
                .bufferedReader()
                .use { it.readText() }
            Log.i("ASSET", json)

            //uji coba log
            Log.v("MainLog", "Ini adalah log verbouse Kal")
            Log.d("MainLog", "Ini adalah log Kal")
            Log.i("MainLog", "Ini adalah log Kal")
            Log.w("MainLog", "Ini adalah log Kal")
            Log.e("MainLog", "Ini adalah log Kal")

            //test memanggil resource
            Log.i("valueResourceKal", resources.getInteger(R.integer.maxPage).toString())
            Log.i("ValueResourceKal", resources.getIntArray(R.array.numbers).joinToString(","))
            Log.i("valueResourceKal", resources.getBoolean(R.bool.isProductionMode).toString())
            Log.i("valueResourceKal", resources.getColor(R.color.backgroundRed).toString())

            sayHaiButton.setBackgroundColor(resources.getColor(R.color.backgroundRed, theme))

            val tampil:String = namaAndaEditText.text.toString()
            hiTextView.text = resources.getString(R.string.haiTextView, tampil)

            //uji coba string array
            resources.getStringArray(R.array.names).forEach {
                Log.i("HAI", it)
            }
        }

    }
}