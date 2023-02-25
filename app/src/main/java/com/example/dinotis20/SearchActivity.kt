package com.example.dinotis20

import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import android.util.Log
import android.view.View
import android.widget.EditText
import android.widget.LinearLayout
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.lifecycleScope
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.dinotis20.adapter.MeetingScheduleAdapter
import com.example.dinotis20.adapter.SearchCreatorAdapter
import com.example.dinotis20.helper.MeetingRetrofitHelper
import com.example.dinotis20.`interface`.ApiInterface
import com.example.dinotis20.model.Creator
import com.example.dinotis20.model.Meeting

class SearchActivity : AppCompatActivity() {

    private lateinit var searchEditText : EditText
    private lateinit var searchLayout : LinearLayout
    private lateinit var defaultLayout: LinearLayout
    private lateinit var rvTrending : RecyclerView
    private lateinit var rvTrendingAdapter : MeetingScheduleAdapter
    private lateinit var rvSearch : RecyclerView
    private lateinit var rvSearchAdapter : SearchCreatorAdapter
    private var listTrending = emptyList<Meeting>()
    private var listCreator = emptyList<Creator>()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_search)

        rvSearch = findViewById(R.id.src_rv_creators)
        rvTrending = findViewById(R.id.src_rv_trending)
        defaultLayout = findViewById(R.id.layout_default)
        searchLayout = findViewById(R.id.layout_search_creators)
        searchLayout.visibility = View.GONE

        val meetingApi = MeetingRetrofitHelper.getInstance().create(ApiInterface::class.java)
        lifecycleScope.launchWhenCreated {
            val result = meetingApi.getMeeting()
            if (result.isSuccessful) {
                listTrending = result.body()!!.meetings
                Log.d("", result.body().toString())

                rvTrendingAdapter = MeetingScheduleAdapter(listTrending)
                rvTrending.adapter = rvTrendingAdapter
                rvTrending.layoutManager = LinearLayoutManager(this@SearchActivity, LinearLayoutManager.HORIZONTAL, false)
            }
        }

        searchEditText = findViewById(R.id.src_edt_search)
        searchEditText.addTextChangedListener(object : TextWatcher {

            override fun afterTextChanged(s: Editable) {}

            override fun beforeTextChanged(s: CharSequence, start: Int,
                                           count: Int, after: Int) {}

            override fun onTextChanged(s: CharSequence, start: Int,
                                       before: Int, count: Int) {
                if (searchEditText.text.isEmpty()) {
                    defaultLayout.visibility = View.VISIBLE
                    searchLayout.visibility = View.GONE
                } else {
                    defaultLayout.visibility = View.GONE
                    searchLayout.visibility = View.VISIBLE
                    val creatorApi = MeetingRetrofitHelper.getInstance().create(ApiInterface::class.java)
                    lifecycleScope.launchWhenCreated {
                        val result = creatorApi.getCreators(searchEditText.text.toString())
                        if (result.isSuccessful) {
                            listCreator = result.body()!!.creators
                            Log.d("", result.body().toString())

                            rvSearchAdapter = SearchCreatorAdapter(listCreator)
                            rvSearch.adapter = rvSearchAdapter
                            rvSearch.layoutManager = LinearLayoutManager(this@SearchActivity)
                        }
                    }
                }
            }
        })

        searchEditText.requestFocus()
    }
}