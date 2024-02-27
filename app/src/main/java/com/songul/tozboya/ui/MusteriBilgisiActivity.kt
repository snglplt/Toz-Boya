package com.songul.tozboya.ui

import android.app.DatePickerDialog
import android.icu.util.Calendar
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.ImageView
import android.widget.TextView
import com.songul.tozboya.R
import java.time.LocalDate

class MusteriBilgisiActivity : AppCompatActivity() {
    lateinit var ivBack:ImageView
    lateinit var edTarih1:TextView
    lateinit var edTarih2:TextView
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_musteri_bilgisi)
        onBaslat()

        overridePendingTransition(R.anim.anim_slide_in_right, R.anim.anim_slide_in_left)
        ivBack.setOnClickListener(View.OnClickListener { finish() })
        val c = Calendar.getInstance()

        val year = c.get(Calendar.YEAR)
        val month = c.get(Calendar.MONTH)
        val day = c.get(Calendar.DAY_OF_MONTH)
        val startDate = LocalDate.of(year, month+1, day)

        // Belirli gün sayısını çıkarma işlemi
        val daysToSubtract =2
        val daysToSubtract_ = 0
        val resultDate = startDate.minusDays(daysToSubtract.toLong())

        val resultDate_ = startDate.minusDays(daysToSubtract_.toLong())

        if(resultDate.dayOfMonth.toString().length==1 && resultDate.monthValue.toString().length==1){
            edTarih1.setText("0"+resultDate.dayOfMonth.toString()+"."+"0"+resultDate.monthValue+"."+year)
        }
        if(resultDate.dayOfMonth.toString().length==1 && resultDate.monthValue.toString().length==2){
            edTarih1.setText("0"+resultDate.dayOfMonth.toString()+"."+resultDate.monthValue+"."+year)
        }
        if(resultDate.dayOfMonth.toString().length==2 && resultDate.monthValue.toString().length==1){
            edTarih1.setText(resultDate.dayOfMonth.toString()+"."+"0"+resultDate.monthValue+"."+year)
        }
        if(resultDate.dayOfMonth.toString().length==2 && resultDate.monthValue.toString().length==2){
            edTarih1.setText(resultDate.dayOfMonth.toString()+"."+resultDate.monthValue+"."+year)
        }

        ///
        if(resultDate_.dayOfMonth.toString().length==1 && resultDate_.monthValue.toString().length==1){
            edTarih2.setText("0"+resultDate_.dayOfMonth.toString()+"."+"0"+resultDate_.monthValue+"."+year)
        }
        if(resultDate_.dayOfMonth.toString().length==1 && resultDate_.monthValue.toString().length==2){
            edTarih2.setText("0"+resultDate_.dayOfMonth.toString()+"."+resultDate_.monthValue+"."+year)
        }
        if(resultDate_.dayOfMonth.toString().length==2 && resultDate_.monthValue.toString().length==1){
            edTarih2.setText(resultDate_.dayOfMonth.toString()+"."+"0"+resultDate_.monthValue+"."+year)
        }
        if(resultDate_.dayOfMonth.toString().length==2 && resultDate_.monthValue.toString().length==2){
            edTarih2.setText(resultDate_.dayOfMonth.toString()+"."+resultDate_.monthValue+"."+year)
        }

      //  edTarih1.setText(resultDate.dayOfMonth.toString()+"."+resultDate.monthValue+"."+year)
       // edTarih2.setText(resultDate_.dayOfMonth.toString()+"."+resultDate_.monthValue+"."+year)

        edTarih1.setOnClickListener {
            val calendar = Calendar.getInstance()
            val year = calendar.get(Calendar.YEAR)
            val month = calendar.get(Calendar.MONTH)
            val day = calendar.get(Calendar.DAY_OF_MONTH)

            val datePickerDialog = DatePickerDialog(
                this,
                DatePickerDialog.OnDateSetListener { _, selectedYear, selectedMonth, selectedDay ->
                    // Tarih seçildiğinde yapılacak işlemler
                    val selectedDate = "$selectedDay.${selectedMonth + 1}.$selectedYear"
                    edTarih1.setText(selectedDate)
                },
                year,
                month,
                day
            )

            // Tarih seçici üzerinde değişiklik yapılmasını istiyorsanız
            datePickerDialog.setOnDateSetListener { _, selectedYear, selectedMonth, selectedDay ->
                // Tarih seçildiğinde yapılacak işlemler
                val selectedDate = "$selectedDay.${selectedMonth + 1}.$selectedYear"
                edTarih1.setText(selectedDate)
            }

            datePickerDialog.show()


        }
        edTarih2.setOnClickListener {
            val calendar = Calendar.getInstance()
            val year = calendar.get(Calendar.YEAR)
            val month = calendar.get(Calendar.MONTH)
            val day = calendar.get(Calendar.DAY_OF_MONTH)

            val datePickerDialog = DatePickerDialog(
                this,
                DatePickerDialog.OnDateSetListener { _, selectedYear, selectedMonth, selectedDay ->
                    // Tarih seçildiğinde yapılacak işlemler
                    val selectedDate = "$selectedDay.${selectedMonth + 1}.$selectedYear"
                    edTarih2.setText(selectedDate)
                },
                year,
                month,
                day
            )

            // Tarih seçici üzerinde değişiklik yapılmasını istiyorsanız
            datePickerDialog.setOnDateSetListener { _, selectedYear, selectedMonth, selectedDay ->
                // Tarih seçildiğinde yapılacak işlemler
                val selectedDate = "$selectedDay.${selectedMonth + 1}.$selectedYear"
                edTarih2.setText(selectedDate)
            }

            datePickerDialog.show()


        }
    }

    private fun onBaslat() {
        ivBack=findViewById(R.id.ivBack)
        edTarih1=findViewById(R.id.edTarih1)
        edTarih2=findViewById(R.id.edTarih2)
    }
}