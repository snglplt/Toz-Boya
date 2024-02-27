package com.songul.tozboya.adapter

import android.annotation.SuppressLint
import android.app.DatePickerDialog
import android.content.Context
import android.content.DialogInterface
import android.content.Intent
import android.graphics.Color
import android.os.Build
import android.util.DisplayMetrics
import android.util.Log
import android.view.LayoutInflater
import android.view.View.VISIBLE
import android.widget.Button
import android.widget.DatePicker
import android.widget.EditText
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AlertDialog
import com.songul.tozboya.R
import com.songul.tozboya.model.UrunModel
import com.songul.tozboya.ui.UrunBilgileriActivity
import com.songul.tozboya.ui.UrunBilgisi_Activity
import com.squareup.picasso.Picasso

class MenuAdapter (context: android.content.Context, courseModelArrayList: ArrayList<UrunModel>) :
    android.widget.ArrayAdapter<UrunModel?>(context, 0, courseModelArrayList!! as List<UrunModel?>) {

    var bundlem= android.os.Bundle()
    var base_url="https://selparbulut.com/"
    lateinit var evrakAdi:String
    lateinit var alt_url:String
    var imageResources=ArrayList<String>()
    var currentImageIndex=courseModelArrayList.size
    lateinit var imageView2: ImageView
    lateinit var idTVCourse:TextView
    @SuppressLint("MissingInflatedId")
    override fun getView(position: Int, @androidx.annotation.Nullable convertView: android.view.View?, parent: android.view.ViewGroup): android.view.View {
        var listitemView = convertView

        if (listitemView == null) {
            // Layout Inflater inflates each item to be displayed in GridView.
            listitemView = android.view.LayoutInflater.from(context).inflate(com.songul.tozboya.R.layout.item_card_menu, parent, false)
        }
        val courseModel: UrunModel? = getItem(position)

        // imageResources.add(base_url+courseModel!!.EvrakAdi.trim()+courseModel.ResimYolu.trim()
        val courseIV = listitemView!!.findViewById<android.widget.ImageView>(com.songul.tozboya.R.id.idIVcourse)
        val idTVCourse = listitemView!!.findViewById<android.widget.TextView>(com.songul.tozboya.R.id.idTVCourse)
        val resimLink="https://pratikhasar.com/netting/toz/"+ courseModel!!.resim
        Picasso.get().load(resimLink).into(courseIV)
        idTVCourse.setText(courseModel.adi)


        listitemView!!.setOnClickListener {
            val i=Intent(listitemView.context, UrunBilgisi_Activity::class.java)
            i.putExtra("urunAdi",courseModel.adi)
            i.putExtra("urunResmi",courseModel.resim)
            listitemView.context.startActivity(i)
        }

        return listitemView!!
    }


}
