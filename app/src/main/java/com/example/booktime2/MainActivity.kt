package com.example.booktime2

import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.AdapterView
import android.widget.ArrayAdapter
import android.widget.ListView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.Toolbar
import androidx.fragment.app.Fragment


class MainActivity : AppCompatActivity() {
    var array= arrayOf("Fiction","Non-Fiction","Romance")

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // assigning ID of the toolbar to a variable
        val toolbar = findViewById<View>(R.id.toolbar) as Toolbar

        // using toolbar as ActionBar
        setSupportActionBar(toolbar)



        // Display application icon in the toolbar
        supportActionBar!!.setDisplayShowHomeEnabled(true)
        supportActionBar!!.setDisplayUseLogoEnabled(true)

        val firstFragment=FirstFragment()
        val secondFragment=SecondFragment()
        val bottom= findViewById<View>(R.id.bottomNavigationView)


        val adapter = ArrayAdapter(this,
            R.layout.listview_item, array)
        val listView:ListView = findViewById(R.id.categorylist)
        listView.setAdapter(adapter)
        listView.onItemClickListener = object : AdapterView.OnItemClickListener {
            override fun onItemClick(parent: AdapterView<*>, view: View,
                                     position: Int, id: Long) {
                // value of item that is clicked
                val itemValue = listView.getItemAtPosition(position) as String
                // Toast the values

                    val intent= Intent(this, Fiction::class.java)
                    startActivity(intent)



                Toast.makeText(applicationContext,"Position :$position\nItem Value : $itemValue", Toast.LENGTH_LONG).show()
            }
        }




    }
    private fun setCurrentFragment(fragment: Fragment)=
        supportFragmentManager.beginTransaction().apply {
            replace(R.id.flFragment,fragment)
            commit()
        }
}