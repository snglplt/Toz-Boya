package com.songul.tozboya.ui

import android.annotation.SuppressLint
import android.content.Context
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.widget.AdapterView
import android.widget.ArrayAdapter
import android.widget.Button
import android.widget.GridView
import android.widget.ImageView
import android.widget.Spinner
import android.widget.SpinnerAdapter
import android.widget.TextView
import androidx.appcompat.app.AlertDialog
import com.songul.tozboya.R
import com.songul.tozboya.adapter.MenuAdapter
import com.songul.tozboya.model.UrunModel

class FiyatSorgulamaActivity : AppCompatActivity() {
    lateinit var btntamam:Button
    lateinit var spinner_parca: Spinner
    lateinit var idGVcourses:GridView
    lateinit var ivBack:ImageView
    val tumUrunler = ArrayList<UrunModel>()
    val profilUrunler = ArrayList<UrunModel>()
    val puruzsuzUrunler = ArrayList<UrunModel>()
    val korkulukUrunler = ArrayList<UrunModel>()
    val insaatUrunler = ArrayList<UrunModel>()
    val hareketlilikUrunler = ArrayList<UrunModel>()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_fiyat_sorgulama)
        onBaslat()
        showCustomDialog(this)
        ivBack=findViewById(R.id.ivBack)
        overridePendingTransition(R.anim.anim_slide_in_right, R.anim.anim_slide_in_left)
        ivBack.setOnClickListener(View.OnClickListener { finish() })
        val spinner_arac_turu_police_alspinner1 = ArrayList<String>()
        val tur_value = this.resources.getStringArray(R.array.secim)
        for (i in tur_value.indices) {
            spinner_arac_turu_police_alspinner1.add(tur_value[i])
        }
        val tur_adapter: Any? = ArrayAdapter<Any?>(
            this,
            R.layout.spinner_item_text,
            spinner_arac_turu_police_alspinner1 as List<Any?>
        )
        spinner_parca.setAdapter(tur_adapter as SpinnerAdapter?)
        spinner_parca?.onItemSelectedListener = object : AdapterView.OnItemSelectedListener {
            override fun onItemSelected(
                parent: AdapterView<*>,
                view: View,
                position: Int,
                id: Long
            ) {
                val selectedItem = parent.getItemAtPosition(position).toString()
                if(selectedItem==getString(R.string.tumbolumler)){
                    idGVcourses.adapter=null
                    val adapter2 = MenuAdapter(this@FiyatSorgulamaActivity, tumUrunler)

                    idGVcourses.adapter = adapter2
                }else if(selectedItem==getString(R.string.profiller)){
                    idGVcourses.adapter=null
                    val adapter2 = MenuAdapter(this@FiyatSorgulamaActivity, profilUrunler)

                    idGVcourses.adapter = adapter2
                }else if(selectedItem==getString(R.string.puruzsuz)){
                    idGVcourses.adapter=null
                    val adapter2 = MenuAdapter(this@FiyatSorgulamaActivity, puruzsuzUrunler)

                    idGVcourses.adapter = adapter2
                }else if(selectedItem==getString(R.string.korkuluk)){
                    idGVcourses.adapter=null
                    val adapter2 = MenuAdapter(this@FiyatSorgulamaActivity, korkulukUrunler)

                    idGVcourses.adapter = adapter2
                }
                else if(selectedItem==getString(R.string.insaat)){
                    idGVcourses.adapter=null
                    val adapter2 = MenuAdapter(this@FiyatSorgulamaActivity, insaatUrunler)

                    idGVcourses.adapter = adapter2
                }else if(selectedItem==getString(R.string.hareketlilik)){
                    idGVcourses.adapter=null
                    val adapter2 = MenuAdapter(this@FiyatSorgulamaActivity, hareketlilikUrunler)

                    idGVcourses.adapter = adapter2
                }

            }

            override fun onNothingSelected(p0: AdapterView<*>?) {
            }
        }
    }

    private fun onBaslat() {
        spinner_parca=findViewById(R.id.spinner_parca)
        idGVcourses=findViewById(R.id.idGVcourses)
        tumUrunler.add(UrunModel("Profil", "profil.jpg"))
        tumUrunler.add(UrunModel(" Boru", "boru.jpg"))
        tumUrunler.add(UrunModel("Katlanır Sac", "katlanirsac7.PNG"))
        insaatUrunler.add(UrunModel("Raf", "raf12.PNG"))
        tumUrunler.add(UrunModel("Raf", "raf12.PNG"))
        tumUrunler.add(UrunModel("Kaynaklı parçalı profil", "kaynakliprofil1.PNG"))
        tumUrunler.add(UrunModel("Düz Saç/Plaka", "puruzsuzsac2.PNG"))
        tumUrunler.add(UrunModel("Askı", "aski3.PNG"))
        tumUrunler.add(UrunModel("C profili", "cprifili4.PNG"))
        tumUrunler.add(UrunModel("Yapı", "yapi6.PNG"))

        tumUrunler.add(UrunModel("Düz çubuk", "duzcubuk8.PNG"))
        tumUrunler.add(UrunModel("Korkuluk/çit inşaatı", "korkuluk9.PNG"))
        tumUrunler.add(UrunModel("Stant/Masa", "ayakta10.PNG"))
        tumUrunler.add(UrunModel("Panel", "doldruma11.PNG"))

        korkulukUrunler.add(UrunModel("Ferforje", "doldurmacubauk22.PNG"))
        tumUrunler.add(UrunModel("Dolgu(dekoratif)", "dolgu14.PNG"))
        tumUrunler.add(UrunModel("Masa çerçevesi", "masacercevesi18.PNG"))
        tumUrunler.add(UrunModel("Doldur(ızgara)", "doldurizgara19.PNG"))
        tumUrunler.add(UrunModel("H profili", "hprofili20.PNG"))
        tumUrunler.add(UrunModel("Masa çerçevesi(çapraz)", "masacapraz21.PNG"))
        tumUrunler.add(UrunModel("Doldurma(çubuklar)", "doldurmacubauk22.PNG"))
        tumUrunler.add(UrunModel("I profili", "iprofili23.PNG"))
        tumUrunler.add(UrunModel("L profili", "lprofili25.PNG"))
        tumUrunler.add(UrunModel("Doldur(çerçeve)", "doldurcerceve26.PNG"))

        tumUrunler.add(UrunModel("T profili", "tprofili.PNG"))
        tumUrunler.add(UrunModel("U profili", "uprofili.PNG"))
        profilUrunler.add(UrunModel("C profili", "cprifili4.PNG"))
        profilUrunler.add(UrunModel("Lema/Silme", "duzcubuk8.PNG"))
        profilUrunler.add(UrunModel("Form Tüpü", "form13.PNG"))
        profilUrunler.add(UrunModel("H Demiri", "hprofili20.PNG"))
        profilUrunler.add(UrunModel("I Demiri", "iprofili23.PNG"))
        profilUrunler.add(UrunModel("Köşebent/L Demiri", "lprofili25.PNG"))
        profilUrunler.add(UrunModel("Boru", "yuvarlak.PNG"))
        profilUrunler.add(UrunModel("T Demiri", "tprofili.PNG"))
        profilUrunler.add(UrunModel("U Demiri", "uprofili.PNG"))
        puruzsuzUrunler.add(UrunModel("Pürüzsüz sac/plaka", "puruzsuzsac2.PNG"))
        puruzsuzUrunler.add(UrunModel("Bükümlü Saç", "katlanirsac7.PNG"))
        korkulukUrunler.add(UrunModel("Askı/Bariyer", "aski3.PNG"))
        korkulukUrunler.add(UrunModel("Korkuluk/çit inşaatı", "korkuluk9.PNG"))
        korkulukUrunler.add(UrunModel("Doldurma(sac panel)", "doldruma11.PNG"))
        korkulukUrunler.add(UrunModel("Dekoratif Panel", "dolgu14.PNG"))
        korkulukUrunler.add(UrunModel("Çit/ızgara", "doldurizgara19.PNG"))

        korkulukUrunler.add(UrunModel("Çerçeve", "doldurcerceve26.PNG"))
        insaatUrunler.add(UrunModel("Kaynaklı parçalı profil", "kaynakliprofil1.PNG"))
        insaatUrunler.add(UrunModel("Konstriksiyon", "yapi6.PNG"))
        insaatUrunler.add(UrunModel("Ayakta masa çerçevesi", "ayakta10.PNG"))

        insaatUrunler.add(UrunModel("Masa çerçevesi", "masacercevesi18.PNG"))
        hareketlilikUrunler.add(UrunModel("Jant", "jant5.PNG"))
        hareketlilikUrunler.add(UrunModel("Tankı", "tanki15.PNG"))
    }


    @SuppressLint("MissingInflatedId")
    fun showCustomDialog(context: Context) {
        // LayoutInflater kullanarak layout dosyasını yükle
        val inflater = LayoutInflater.from(context)
        val dialogView = inflater.inflate(R.layout.information, null)
    //    val titleText = dialogView.findViewById<TextView>(R.id.custom_title_text)

        btntamam=dialogView.findViewById(R.id.btntamam)



        // AlertDialog oluştur ve layout'u ayarla
        val builder = AlertDialog.Builder(context)
        builder.setView(dialogView)

        // İsteğe bağlı: Dialog başlığını, butonlarını vs. ayarla
       // builder.setTitle(getString(R.string.bilgilendirme))


        // Dialog'u oluştur ve göster
        val dialog = builder.create()
        dialog.show()
        btntamam.setOnClickListener { dialog.dismiss()}
    }
}