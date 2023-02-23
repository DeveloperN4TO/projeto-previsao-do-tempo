package com.example.projetotempo

import android.os.AsyncTask
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.ProgressBar
import android.widget.RelativeLayout
import android.widget.TextView
import java.net.URL
import java.nio.charset.Charset

class MainActivity : AppCompatActivity() {

    val CIDADE: String = "Brasilia,br"
    val    API: String = "06c921750b9a82d8f5d1294e1586276f"


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        weatherTask().execute()
    }
    inner class weatherTask() : AsyncTask<String, Void, String>()
    {
        override fun onPostExecute(result: String?) {
            super.onPostExecute(result)
            findViewById<ProgressBar>(R.id.carregar).visibility = View.VISIBLE
            findViewById<RelativeLayout>(R.id.meuContainer).visibility = View.GONE
            findViewById<TextView>(R.id.errortext).visibility = View.GONE

        }

        override fun doInBackground(vararg params: String?): String {
            var response:String?
            try {
                response = URL("https://api.openweathermap.org/data/2.5/weather?q=" +
                        "$CIDADE&units=metric&appid=$API")
                    .readText(Charsets.UTF_8)
            }
        }


    }
}