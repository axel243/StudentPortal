package com.example.axel.studentportal

import android.app.Activity
import android.content.Intent
import android.os.Bundle
import android.support.design.widget.FloatingActionButton
import android.support.v7.app.AppCompatActivity
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.RecyclerView
import android.view.Menu
import android.view.MenuItem
import kotlinx.android.synthetic.main.activity_main.*
import android.support.v7.widget.StaggeredGridLayoutManager

class MainActivity : AppCompatActivity(), PortalAdapter.PortalClickListener{

    private var mPortals: MutableList<Portal>? = ArrayList()
    private var mAdapter: PortalAdapter? = null
    private var mRecyclerView: RecyclerView? = null
    companion object {
        val ADDED_NOTE = "portalObject"
    }
    val REQUESTCODE = 1234

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        setSupportActionBar(toolbar)

        mPortals!!.add(Portal("www.youtube.nl", "youtube"))

        mRecyclerView = findViewById(R.id.recyclerView)
        mAdapter = PortalAdapter(mPortals, mPortalClickListener = this)
        mRecyclerView!!.layoutManager = StaggeredGridLayoutManager(4, LinearLayoutManager.HORIZONTAL)
        val fab = findViewById<FloatingActionButton>(R.id.fab)
        mRecyclerView!!.adapter = mAdapter
        fab.setOnClickListener {
            addPortalOnClick()
        }
    }

    override fun onCreateOptionsMenu(menu: Menu): Boolean {
        // Inflate the menu; this adds items to the action bar if it is present.
        menuInflater.inflate(R.menu.menu_main, menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        return when (item.itemId) {
            R.id.action_settings -> true
            else -> super.onOptionsItemSelected(item)
        }
    }

    fun addPortalOnClick() {
        val intent = Intent(this@MainActivity, AddPortalActivity::class.java)
        startActivityForResult(intent, REQUESTCODE)
    }

    override fun portalOnClick(i: Int) {
        val intent = Intent(this@MainActivity, WebviewPortalActivity::class.java)
        intent.putExtra(ADDED_NOTE, mPortals!!.get(i))
        startActivity(intent)
    }

    public override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent) {
        if (requestCode == REQUESTCODE) {
            if (resultCode == Activity.RESULT_OK) {
                val bundel: Bundle = data.extras
                val portalObject = bundel.getSerializable("portalObject") as Portal
                mPortals!!.add(portalObject)
            }
        }
    }
}

