package com.example.socialmediakotlin

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import java.util.*


class MainActivity : AppCompatActivity() {

    private var recyclerView: RecyclerView? = null
    private var adapter: NewsListAdapter? = null
    private var listener: NewsListAdapter.ItemClickListener? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        listener = object : NewsListAdapter.ItemClickListener {
            override fun itemClick(position: Int, item: News?) {
                val intent = Intent(this@MainActivity, NewsDetailActivity::class.java)
                intent.putExtra("news", item)
                startActivity(intent)
            }
        }

        recyclerView = findViewById(R.id.recyclerView)
        this.recyclerView?.layoutManager = LinearLayoutManager(this)

        adapter = NewsListAdapter(newsGenerator()!!, listener as NewsListAdapter.ItemClickListener)
        this.recyclerView?.adapter = adapter
    }

    private fun newsGenerator(): List<News>? {
        val items: MutableList<News> = ArrayList()
        val s = "Likes: "
        var k: String
        val news1 = News(
                R.drawable.avatar,
                "20 december",
                "d1as".also {
                    k = it
                },
                R.drawable.iv1,
                "$k  your ad will be here",
                s + 150, "see all commentaries (3)"
        )
        val news2 = News(
                R.drawable.avatar,
                "2 july",
                "vasya".also {
                    k = it
                },
                R.drawable.iv2,
                "$k  your add will be here",
                s + 1234,
                "see all commentaries (123)"
        )
        val news3 = News(
                R.drawable.avatar2,
                "10 July",
                "Alex".also {
                    k = it
                },
                R.drawable.iv3,
                "$k  your ad will be here",
                s + 150, "see all commentaries (12)"
        )
        val news4 = News(
                R.drawable.avatar2,
                "29 august",
                "Dias".also {
                    k = it
                },
                R.drawable.iv4,
                "$k  your ad will be here",
                s + 150, "see all commentaries (13)"
        )
        val news5 = News(
                R.drawable.avatar3,
                "1 september",
                "danil".also {
                    k = it
                },
                R.drawable.iv5,
                "$k  your add will be here",
                s + 150, "see all commentaries (23)"
        )
        val news6 = News(
                R.drawable.avatar3,
                "6 october",
                "artem".also {
                    k = it
                },
                R.drawable.iv6,
                "$k  my car",
                s + 350, "see all commentaries (223)"
        )
        val news7 = News(
                R.drawable.avatar4,
                "3 january",
                "d.danik".also {
                    k = it
                },
                R.drawable.iv7,
                "$k  your add will be here",
                s + 550, "see all commentaries (124)"
        )
        val news8 = News(
                R.drawable.avatar4,
                "14 february",
                "zange".also {
                    k = it
                },
                R.drawable.iv8,
                "$k  your add will be here",
                s + 950, "see all commentaries (14)"
        )
        val news9 = News(
                R.drawable.avatar5,
                "3 december",
                "zangur".also {
                    k = it
                },
                R.drawable.iv9,
                "$k  my cars",
                s + 850, "see all commentaries (24)"
        )
        val news10 = News(
                R.drawable.avatar5,
                "10 june",
                "romanus".also {
                    k = it
                },
                R.drawable.iv10,
                "$k  your add will be here",
                s + 650, "see all commentaries (42)"
        )
        items.add(news1)
        items.add(news2)
        items.add(news3)
        items.add(news4)
        items.add(news5)
        items.add(news6)
        items.add(news7)
        items.add(news8)
        items.add(news9)
        items.add(news10)

        return items
    }
}
