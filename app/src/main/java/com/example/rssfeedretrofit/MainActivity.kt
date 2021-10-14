package com.example.rssfeedretrofit


import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import retrofit2.Retrofit
import retrofit2.converter.simplexml.SimpleXmlConverterFactory
import com.example.rssfeedretrofit.model.Rss
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.rssfeedretrofit.model.item.RssItem
import com.google.android.material.floatingactionbutton.FloatingActionButton
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class MainActivity : AppCompatActivity() {

    lateinit var fetch:FloatingActionButton
    lateinit var myRV:RecyclerView
    lateinit var rvAdapter: RVAdapter
    var feeds = mutableListOf<RssItem>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        myRV = findViewById(R.id.rvFeeds)
        fetch = findViewById(R.id.fabFetch)


        callApi()

        fetch.setOnClickListener{
            callApi()
        }

    }

    private fun callApi() {

        val retrofit = Retrofit.Builder()
            .baseUrl("https://www.freecodecamp.org/")
            .addConverterFactory(SimpleXmlConverterFactory.create())
            .build()
        val rssAPI = retrofit.create(RssAPI::class.java)
        val call = rssAPI.rss

                call!!.clone().enqueue(object : Callback<Rss?> {
                    override fun onResponse(call: Call<Rss?>, response: Response<Rss?>) {

                        val channel = response.body()!!.channel
                        feeds = channel?.items as MutableList<RssItem>

                        rvAdapter=RVAdapter(feeds,this@MainActivity)
                        myRV.adapter = rvAdapter
                        myRV.layoutManager = LinearLayoutManager(this@MainActivity)
                    }
                    override fun onFailure(call: Call<Rss?>, t: Throwable) {
                        Log.e("TAG", "onFailure: Unable to retrieve RSS: " + t.message)
                        Toast.makeText(this@MainActivity, "An Error Occured", Toast.LENGTH_SHORT).show()
                    }
                })
    }

}