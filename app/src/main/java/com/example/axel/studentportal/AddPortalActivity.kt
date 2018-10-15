package com.example.axel.studentportal

import android.app.Activity
import android.content.Intent
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.text.TextUtils
import android.widget.Button
import android.widget.EditText
import android.widget.Toast

class AddPortalActivity : AppCompatActivity() {
    private var addUrl: EditText? = null
    private var addTitle: EditText? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_add_portal_activity)
        val addPortalButton = findViewById<Button>(R.id.addPortalButton)
        addPortalButton.setOnClickListener { view ->
            addTitle = findViewById(R.id.titleTextInput)
            addUrl = findViewById(R.id.urlTextInput)
            //  println(addTitle)
            val textTitle = addTitle!!.text.toString()
            val textUrl = addUrl!!.text.toString()

            if (!TextUtils.isEmpty(textTitle)) {
                val newPortal = Portal(textUrl, textTitle)
                val resultIntent = Intent(this@AddPortalActivity, MainActivity::class.java)
                val bundle = Bundle()
                bundle.putSerializable("portalObject", newPortal)
                resultIntent.putExtras(bundle)
                setResult(Activity.RESULT_OK, resultIntent)
                finish()

            } else {
                Toast.makeText(this@AddPortalActivity, "Enter data in both fields", Toast.LENGTH_SHORT).show()
            }
        }
    }

}


