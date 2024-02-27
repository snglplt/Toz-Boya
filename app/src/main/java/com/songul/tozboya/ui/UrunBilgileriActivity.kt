package com.songul.tozboya.ui

import android.annotation.SuppressLint
import android.content.Intent
import android.graphics.Color
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import com.songul.tozboya.R
import com.squareup.picasso.Picasso

class UrunBilgileriActivity : AppCompatActivity() {
    lateinit var imageviewUrun:ImageView
    lateinit var ivBack:ImageView
    lateinit var txturunAdi:TextView
    lateinit var txtaluminyum:TextView
    lateinit var btnfiyatihesapla:Button
    @SuppressLint("ResourceAsColor")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_urun_bilgileri)
        onBaslat()

        overridePendingTransition(R.anim.anim_slide_in_right, R.anim.anim_slide_in_left)
        ivBack.setOnClickListener(View.OnClickListener { finish() })
        txtaluminyum.setOnClickListener {
            txtaluminyum.setTextColor(R.color.colorPrimary)
            txtaluminyum.setBackgroundColor(R.color.black)
        }
        btnfiyatihesapla.setOnClickListener {
            val i=Intent(this,MusteriBilgisiActivity::class.java)
            startActivity(i)
        }
    }

    private fun onBaslat() {
        imageviewUrun=findViewById(R.id.imageviewUrun)
        txturunAdi=findViewById(R.id.txturunAdi)
        ivBack=findViewById(R.id.ivBack)
        btnfiyatihesapla=findViewById(R.id.btnfiyatihesapla)
        val resimLink="https://pratikhasar.com/netting/toz/"+intent.getStringExtra("urunResmi")
        Picasso.get().load(resimLink).into(imageviewUrun)
        txturunAdi.setText(intent.getStringExtra("urunAdi"))
    }
}