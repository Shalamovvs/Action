package com.example.filmapp

import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.v7.widget.LinearLayoutManager
import android.view.View
import android.widget.EditText
import kotlinx.android.synthetic.main.activity_page2.*
import kotlinx.android.synthetic.main.movie_list.*
import kotlinx.android.synthetic.main.movie_list.view.*
import android.text.method.TextKeyListener.clear
import android.widget.Button
import android.widget.ImageButton
import com.example.filmapp.AppActivity.Companion.db
import java.io.File
import java.util.*


class Page2 : AppCompatActivity() {

    val nameList:ArrayList<Model> = ArrayList()
    val listSample = arrayListOf<String>()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_page2)
        recyclerView_Second.layoutManager = LinearLayoutManager(this)

        //Storage
        val filePath = File(filesDir, "deal")
        if (!filePath.isDirectory || !filePath.exists()){
            filePath.mkdir()
        }

        val list = filePath.listFiles()
        for (i in list){
            val fileText = i.readText()
            listSample.add(fileText)
        }

        recyclerView_Second.adapter = MainAdapter(listSample)

        val sendDetailsButton = findViewById<ImageButton>(R.id.sendButton)
        val nameEdit = findViewById<EditText>(R.id.textName)
        val yearEdit = findViewById<EditText>(R.id.textYear)

        sendDetailsButton.setOnClickListener {
            val fileName = "${UUID.randomUUID()}.deal"
            val name = nameEdit.text.toString()
            val year = yearEdit.text.toString()
            val dealFile = File(filePath, fileName)
            dealFile.createNewFile()
            dealFile.writeText(name + "\n" + year)

            val list = filePath.listFiles()
            for (i in list){
                println(i)
            }

            recyclerView_Second.adapter!!.notifyDataSetChanged()
            val intent = intent
            overridePendingTransition(0, 0);//4
            intent.addFlags(Intent.FLAG_ACTIVITY_NO_ANIMATION);//5
            finish();//6
            overridePendingTransition(0, 0);//7
            startActivity(intent);//8
        }
    }



    fun openPage(view: View)
    {
        val changePage = Intent(this, MainActivity::class.java)
        startActivity(changePage)
    }
    fun restart(view: View)
    {
        val filePath = File(filesDir, "deal")
        val list = filePath.listFiles()
        for (i in list) {
            if (i.exists()){
                i.canonicalFile.delete()
                if (i.exists()){
                    applicationContext.deleteFile(i.name)
                }
            }
        }
        recyclerView_Second.clearOnChildAttachStateChangeListeners()
        val intent = intent
        overridePendingTransition(0, 0);//4
        intent.addFlags(Intent.FLAG_ACTIVITY_NO_ANIMATION);//5
        finish();//6
        overridePendingTransition(0, 0);//7
        startActivity(intent);//8
    }


}
