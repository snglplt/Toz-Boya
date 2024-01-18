package com.songul.tozboya.ui

import android.content.Context
import android.content.Intent
import android.content.SharedPreferences
import android.content.res.Configuration
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.widget.Button
import android.widget.CheckBox
import android.widget.CompoundButton
import android.widget.EditText
import android.widget.ImageView
import androidx.appcompat.app.AlertDialog
import com.songul.tozboya.R
import java.util.Locale

class SingInActivity : AppCompatActivity() {
    lateinit var checkTurkce: CheckBox
    lateinit var checkEnglish: CheckBox
    lateinit var checkAlmanca: CheckBox
    lateinit var checkRusca: CheckBox
    lateinit var checkFlemence: CheckBox
    lateinit var CBsignIn:Button
    lateinit var edkullaniciadi:EditText
    lateinit var password:EditText
    var adi:String=""
    var soyadi:String=""
    var username:String=""
    var uid:String=""
    var calismasekli:String=""
    var entegrator:String=""
    var entegratorkullanici:String=""
    var entegratorsifre:String=""
    var vergino:String=""
    var PlasiyerId:String=""
    var PlasiyerAdi:String=""
    var KullaniciId:String=""
    var FirmaLogo:String=""
    var dil_secimi: String = ""
    lateinit var imageViewLanguage:ImageView
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_sing_in)
        onBaslat()
        CBsignIn.setOnClickListener {
            val i=Intent(this, MainActivity::class.java)
            startActivity(i)


        }
        val sharedPreferens = getSharedPreferences("MY_PRE", Context.MODE_PRIVATE)

        imageViewLanguage.setOnClickListener { ShowLanguageDialog() }



    }
    private fun ShowLanguageDialog() {
        val alertadd = AlertDialog.Builder(this)
        alertadd.setTitle(getString(R.string.dil_secimi))
        val factory = LayoutInflater.from(this)
        val view: View = factory.inflate(R.layout.dilsecimi, null)
        checkTurkce = view.findViewById<CheckBox>(R.id.checkTurkce)
        checkEnglish = view.findViewById<CheckBox>(R.id.checkEnglish)
        checkAlmanca = view.findViewById<CheckBox>(R.id.checkAlmanca)
        checkRusca = view.findViewById<CheckBox>(R.id.checkRusca)
        val locale =
            Locale.getDefault()
        Locale.setDefault(locale)
        val config = Configuration()
        config.locale = locale
        baseContext.resources.updateConfiguration(
            config,
            baseContext.resources.displayMetrics
        )
        if (locale.language == "en") {
            checkEnglish.isChecked = true
            checkTurkce.isChecked = false
            checkAlmanca.isChecked = false
            checkRusca.isChecked = false
            // Toast.makeText(this,"Türkçe değil",Toast.LENGTH_LONG).show()
        } else if (locale.language == "de") {
            checkAlmanca.isChecked = true
            checkTurkce.isChecked = false
            checkEnglish.isChecked = false
            checkRusca.isChecked = false
            // Toast.makeText(this,"Türkçe değil",Toast.LENGTH_LONG).show()
        }else if (locale.language == "os") {
            checkAlmanca.isChecked = false
            checkTurkce.isChecked = false
            checkEnglish.isChecked = false
            checkRusca.isChecked = true
            // Toast.makeText(this,"Türkçe değil",Toast.LENGTH_LONG).show()
        }
        else if (locale.language == "nl") {
            checkAlmanca.isChecked = false
            checkTurkce.isChecked = false
            checkEnglish.isChecked = false
            checkRusca.isChecked = false
            // Toast.makeText(this,"Türkçe değil",Toast.LENGTH_LONG).show()
        }else {
            checkTurkce.isChecked = true
            checkAlmanca.isChecked = false
            checkEnglish.isChecked = false
            checkRusca.isChecked = false
        }
        checkTurkce.setOnCheckedChangeListener(object : CompoundButton.OnCheckedChangeListener {
            override fun onCheckedChanged(buttonView: CompoundButton, isChecked: Boolean) {
                if (checkTurkce!!.isChecked) {
                    checkTurkce.isChecked = true
                    checkAlmanca.isChecked = false
                    checkEnglish.isChecked = false
                    checkRusca.isChecked = false

                }


            }
        })
        checkEnglish.setOnCheckedChangeListener(object : CompoundButton.OnCheckedChangeListener {
            override fun onCheckedChanged(buttonView: CompoundButton, isChecked: Boolean) {
                if (checkEnglish!!.isChecked) {
                    checkEnglish.isChecked = true
                    checkTurkce.isChecked = false
                    checkAlmanca.isChecked = false
                    checkRusca.isChecked = false

                }


            }
        })
        checkAlmanca.setOnCheckedChangeListener(object : CompoundButton.OnCheckedChangeListener {
            override fun onCheckedChanged(buttonView: CompoundButton, isChecked: Boolean) {
                if (checkAlmanca!!.isChecked) {
                    checkAlmanca.isChecked = true
                    checkTurkce.isChecked = false
                    checkEnglish.isChecked = false
                    checkRusca.isChecked = false

                }


            }
        })
        checkRusca.setOnCheckedChangeListener(object : CompoundButton.OnCheckedChangeListener {
            override fun onCheckedChanged(buttonView: CompoundButton, isChecked: Boolean) {
                if (checkRusca!!.isChecked) {
                    checkAlmanca.isChecked = false
                    checkTurkce.isChecked = false
                    checkEnglish.isChecked = false
                    checkRusca.isChecked = true

                }


            }
        })


        alertadd.setView(view)
        alertadd.setPositiveButton(
            getString(R.string.ekle)
        ) { dialogInterface, which ->
            if (checkTurkce.isChecked) {
                SetLocale("tr")
                recreate()
                dil_secimi = "tr"
            } else if (checkEnglish.isChecked) {
                SetLocale("en")
                recreate()
                dil_secimi = "en"
            }
            else if (checkAlmanca.isChecked) {
                SetLocale("de")
                recreate()
                dil_secimi = "de"
            }else if (checkRusca.isChecked) {
                SetLocale("os")
                recreate()
                dil_secimi = "os"
            }


        }
        alertadd.show()

    }

    private fun SetLocale(lang: String) {
        val locale = Locale(lang)
        Locale.setDefault(locale)
        val config: Configuration = Configuration()
        config.setLocale(locale)

        baseContext.resources.updateConfiguration(config, baseContext.resources.displayMetrics)

        val editor: SharedPreferences.Editor =
            getSharedPreferences("MY_PRE", Context.MODE_PRIVATE).edit()
        editor.putString("My_Lang", lang)
        editor.apply()
    }



    private fun onBaslat() {
        CBsignIn=findViewById(R.id.CBsignIn)
        edkullaniciadi=findViewById(R.id.edkullaniciadi)
        password=findViewById(R.id.password)
        imageViewLanguage=findViewById(R.id.imageViewLanguage)
    }
}