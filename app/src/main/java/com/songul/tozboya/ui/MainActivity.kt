package com.songul.tozboya.ui

import android.annotation.SuppressLint
import android.content.Intent
import android.graphics.Color
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.MenuItem
import android.view.View
import android.view.inputmethod.InputMethodManager
import android.widget.ExpandableListView
import android.widget.ImageView
import android.widget.LinearLayout
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AlertDialog
import androidx.cardview.widget.CardView
import androidx.core.view.GravityCompat
import androidx.drawerlayout.widget.DrawerLayout
import com.google.android.material.navigation.NavigationView
import com.songul.tozboya.model.ExpandedMenuModel
import com.songul.tozboya.R
import com.songul.tozboya.adapter.YedekExpandableListAdapter
import java.util.ArrayList
import java.util.HashMap

class MainActivity : AppCompatActivity() {
    var navigationView: NavigationView? = null
    var drawer: DrawerLayout? = null
    var menuLeftIV: ImageView? = null
    var txtad_soyad: TextView? = null
    var inputManager: InputMethodManager? = null
    var expandableList: ExpandableListView? = null
    var listDataHeader: List<ExpandedMenuModel>? = null
    var listDataChild: HashMap<ExpandedMenuModel, List<String>>? = null
    var mMenuAdapterYedekExpandableListAdapter: YedekExpandableListAdapter? = null
    lateinit var cardBlog:CardView
    lateinit var cardRalKaldera:CardView
    lateinit var cardHesaplama:CardView
    lateinit var cardBizeUlasin:CardView
    lateinit var linearlayoutBlog:LinearLayout
    lateinit var linearRalKaldera:LinearLayout
    lateinit var linearHesaplama:LinearLayout
    lateinit var linearlayoutBizeUlasin:LinearLayout
    lateinit var linearlayoutOnarilenFirmalar:LinearLayout
    lateinit var txtBlog:TextView
    lateinit var txtRalKaldera:TextView
    lateinit var txtHesaplama:TextView
    lateinit var txtOnarilenFirmalar:TextView
    lateinit var txtBizeUlasin:TextView
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        onBaslat()
        menuLeftIV!!.setOnClickListener(View.OnClickListener { drawerOpen() })
        setUpNavigationView()
        cardBlog.setOnClickListener {
            linearRalKaldera.setBackgroundColor(Color.parseColor("#FFFFFF"))
            linearHesaplama.setBackgroundColor(Color.parseColor("#FFFFFF"))
            linearlayoutBizeUlasin.setBackgroundColor(Color.parseColor("#FFFFFF"))
            linearlayoutOnarilenFirmalar.setBackgroundColor(Color.parseColor("#FFFFFF"))
            linearlayoutBlog.setBackgroundColor(Color.parseColor("#058B8C"))
            txtBlog.setTextColor(Color.parseColor("#FFFFFF"))
            txtRalKaldera.setTextColor(Color.parseColor("#058B8C"))
            txtHesaplama.setTextColor(Color.parseColor("#058B8C"))
            txtBizeUlasin.setTextColor(Color.parseColor("#058B8C"))
            txtOnarilenFirmalar.setTextColor(Color.parseColor("#058B8C"))
            val i=Intent(this,TozBoyaActivity::class.java)
            startActivity(i)
        }
        cardRalKaldera.setOnClickListener {
            linearlayoutBlog.setBackgroundColor(Color.parseColor("#FFFFFF"))
            linearHesaplama.setBackgroundColor(Color.parseColor("#FFFFFF"))
            linearlayoutBizeUlasin.setBackgroundColor(Color.parseColor("#FFFFFF"))
            linearlayoutOnarilenFirmalar.setBackgroundColor(Color.parseColor("#FFFFFF"))
            linearRalKaldera.setBackgroundColor(Color.parseColor("#058B8C"))
            txtRalKaldera.setTextColor(Color.WHITE)
            txtBlog.setTextColor(Color.parseColor("#058B8C"))
            txtHesaplama.setTextColor(Color.parseColor("#058B8C"))
            txtBizeUlasin.setTextColor(Color.parseColor("#058B8C"))
            txtOnarilenFirmalar.setTextColor(Color.parseColor("#058B8C"))
            val i=Intent(this,RalActivity::class.java)
            startActivity(i)
        }
        cardHesaplama.setOnClickListener {
            linearlayoutBlog.setBackgroundColor(Color.parseColor("#FFFFFF"))
            linearRalKaldera.setBackgroundColor(Color.parseColor("#FFFFFF"))
            linearlayoutOnarilenFirmalar.setBackgroundColor(Color.parseColor("#FFFFFF"))
            linearlayoutBizeUlasin.setBackgroundColor(Color.parseColor("#FFFFFF"))
            linearHesaplama.setBackgroundColor(Color.parseColor("#058B8C"))
            txtHesaplama.setTextColor(Color.WHITE)
            txtBlog.setTextColor(Color.parseColor("#058B8C"))
            txtRalKaldera.setTextColor(Color.parseColor("#058B8C"))
            txtBizeUlasin.setTextColor(Color.parseColor("#058B8C"))
            txtOnarilenFirmalar.setTextColor(Color.parseColor("#058B8C"))
            val i=Intent(this,FiyatSorgulamaActivity::class.java)
            startActivity(i)
        }
        cardBizeUlasin.setOnClickListener {
            linearlayoutBlog.setBackgroundColor(Color.parseColor("#FFFFFF"))
            linearRalKaldera.setBackgroundColor(Color.parseColor("#FFFFFF"))
            linearHesaplama.setBackgroundColor(Color.parseColor("#FFFFFF"))
            linearlayoutOnarilenFirmalar.setBackgroundColor(Color.parseColor("#FFFFFF"))
            linearlayoutBizeUlasin.setBackgroundColor(Color.parseColor("#058B8C"))
            txtBizeUlasin.setTextColor(Color.WHITE)
            txtHesaplama.setTextColor(Color.parseColor("#058B8C"))
            txtBlog.setTextColor(Color.parseColor("#058B8C"))
            txtOnarilenFirmalar.setTextColor(Color.parseColor("#058B8C"))
            txtRalKaldera.setTextColor(Color.parseColor("#058B8C"))
        }
        linearlayoutOnarilenFirmalar.setOnClickListener {
            linearlayoutOnarilenFirmalar.setBackgroundColor(Color.parseColor("#058B8C"))
            linearlayoutBlog.setBackgroundColor(Color.parseColor("#FFFFFF"))
            linearRalKaldera.setBackgroundColor(Color.parseColor("#FFFFFF"))
            linearHesaplama.setBackgroundColor(Color.parseColor("#FFFFFF"))
            linearlayoutBizeUlasin.setBackgroundColor(Color.parseColor("#FFFFFF"))
            txtOnarilenFirmalar.setTextColor(Color.WHITE)
            txtBizeUlasin.setTextColor(Color.parseColor("#058B8C"))
            txtHesaplama.setTextColor(Color.parseColor("#058B8C"))
            txtBlog.setTextColor(Color.parseColor("#058B8C"))
            txtRalKaldera.setTextColor(Color.parseColor("#058B8C"))
        }
        val menu = navigationView!!.menu
        expandableList =
            findViewById<View>(R.id.navigationmenu) as ExpandableListView
        val navigationView =
            findViewById<View>(R.id.navigationview) as NavigationView

        navigationView?.let { setupDrawerContent(it) }
        if (navigationView != null) {
            setupDrawerContent(navigationView);
        }
        //  changeColorItem(menu, R.id.nav_home_features)
        //  changeColorItem(menu, R.id.nav_bookings_and_job)
        //  changeColorItem(menu, R.id.nav_personal)
        //  changeColorItem(menu, R.id.other)

        for (i in 0 until menu.size()) {
            val mi = menu.getItem(i)
            val subMenu = mi.subMenu
            if (subMenu != null && subMenu.size() > 0) {
                for (j in 0 until subMenu.size()) {
                    val subMenuItem = subMenu.getItem(j)
                    // applyCustomFont(subMenuItem)
                }
            }
            //applyCustomFont(mi)
        }
        // onYanMenu()
        generateMenuData(intent)

    }
    private fun setUpNavigationView() {
        navigationView!!.setNavigationItemSelectedListener { menuItem ->
            val fragmentTransaction = supportFragmentManager.beginTransaction()
            fragmentTransaction.setCustomAnimations(
                android.R.anim.fade_in,
                android.R.anim.fade_out
            )
            fragmentTransaction.commitAllowingStateLoss()
            //drawer!!.closeDrawers()
            if (menuItem.isChecked) {
                menuItem.isChecked = false
            } else {
                menuItem.isChecked = true
            }
            menuItem.isChecked = true
            true
        }
    }

    private fun onBaslat() {
        navigationView = findViewById<View>(R.id.navigationview) as NavigationView
        drawer = findViewById<View>(R.id.drawelayout) as DrawerLayout
        menuLeftIV = findViewById<View>(R.id.menuLeftIV) as ImageView
        txtad_soyad = findViewById(R.id.txtad_soyad)
        cardBlog = findViewById(R.id.cardBlog)
        cardRalKaldera = findViewById(R.id.cardRalKaldera)
        cardHesaplama = findViewById(R.id.cardHesaplama)
        cardBizeUlasin = findViewById(R.id.cardBizeUlasin)
        linearlayoutBlog = findViewById(R.id.linearlayoutBlog)
        linearRalKaldera = findViewById(R.id.linearRalKaldera)
        linearHesaplama = findViewById(R.id.linearHesaplama)
        linearlayoutOnarilenFirmalar = findViewById(R.id.linearlayoutOnarilenFirmalar)
        linearlayoutBizeUlasin = findViewById(R.id.linearlayoutBizeUlasin)
        txtBlog = findViewById(R.id.txtBlog)
        txtRalKaldera = findViewById(R.id.txtRalKaldera)
        txtHesaplama = findViewById(R.id.txtHesaplama)
        txtOnarilenFirmalar = findViewById(R.id.txtOnarilenFirmalar)
        txtBizeUlasin = findViewById(R.id.txtBizeUlasin)
        txtad_soyad!!.setText("TOZ BOYA")
    }

    fun generateMenuData(intent: Intent) {
        listDataHeader = ArrayList<ExpandedMenuModel>()
        listDataChild = HashMap<ExpandedMenuModel, List<String>>()
        val item1 = ExpandedMenuModel()
        val item2 = ExpandedMenuModel()
        val item3 = ExpandedMenuModel()
        val item4 = ExpandedMenuModel()
        val item5 = ExpandedMenuModel()
        val item6 = ExpandedMenuModel()
        val item7 = ExpandedMenuModel()
        val item8 = ExpandedMenuModel()



        item1.setIconName(getString(R.string.ralkartelasi))
        item1.setIconImg(R.drawable.ral)
        item2.setIconName(getString(R.string.renktanimlama))
        item2.setIconImg(R.drawable.blog)
        item3.setIconName(getString(R.string.fiyatsorgulama))
        item3.setIconImg(R.drawable.hesaplama)
        item4.setIconName(getString(R.string.renkuzayi))
        item4.setIconImg(R.drawable.baseline_invert_colors_24)
        item5.setIconName(getString(R.string.geridonusum))
        item5.setIconImg(R.drawable.baseline_recycling_24)
        item6.setIconName(getString(R.string.boyahatalarivecozumleri))
        item6.setIconImg(R.drawable.error)
        item7.setIconName(getString(R.string.kullanicigeribildirim))
        item7.setIconImg(R.drawable.geri_bildirim)
        item8.setIconName(getString(R.string.logout))
        item8.setIconImg(R.drawable.logout)
        val heading1: MutableList<String> = ArrayList()
        heading1.add(getString(R.string.hesaplama))
        (listDataHeader as ArrayList<ExpandedMenuModel>).add(item1)
        (listDataHeader as ArrayList<ExpandedMenuModel>).add(item2)
        (listDataHeader as ArrayList<ExpandedMenuModel>).add(item3)
        (listDataHeader as ArrayList<ExpandedMenuModel>).add(item4)
        (listDataHeader as ArrayList<ExpandedMenuModel>).add(item5)
        (listDataHeader as ArrayList<ExpandedMenuModel>).add(item6)
        (listDataHeader as ArrayList<ExpandedMenuModel>).add(item7)
        (listDataHeader as ArrayList<ExpandedMenuModel>).add(item8)
        listDataChild!!.put((listDataHeader as ArrayList<ExpandedMenuModel>).get(2), heading1)


    onMenuGoster(listDataHeader as ArrayList<ExpandedMenuModel>, listDataChild!!)
        //return Pair(listDataHeader, listDataChild)
    }

    private fun onMenuGoster(expandedMenuModels: ArrayList<ExpandedMenuModel>, listDataChild: HashMap<ExpandedMenuModel, List<String>>) {
        mMenuAdapterYedekExpandableListAdapter = YedekExpandableListAdapter(
            this,
            listDataHeader!!, listDataChild!!,
            expandableList!!
        )
        // Toast.makeText(this,listDataHeader.toString(),Toast.LENGTH_LONG).show()
        expandableList!!.setAdapter(mMenuAdapterYedekExpandableListAdapter)

        expandableList!!.setOnGroupClickListener { expandableListView, view, groupPosition, l ->
            val groupName = mMenuAdapterYedekExpandableListAdapter!!.getGroupName(groupPosition)
            Toast.makeText(this, "this:" + groupName, Toast.LENGTH_LONG).show()

            when (groupName) {
                getString(R.string.fiyatsorgulama) -> {
                    val builder = AlertDialog.Builder(this)

                    builder
                        .setMessage(getString(R.string.cikis_yapisin_mi))
                        .setPositiveButton(getString(R.string.evet)) { dialog, which ->
                            val i=Intent(this, SingInActivity::class.java)
                            startActivity(i)
                        }
                        .setNegativeButton(getString(R.string.hayir)) { dialog, which ->
                        }

                    val dialog = builder.create()
                    dialog.show()
                    true // Grup tıklamasının işlendiğini belirtmek için true dön
                }
                getString(R.string.ralkartelasi) -> {
                    val i=Intent(this,RalActivity::class.java)
                    startActivity(i)
                    true // Grup tıklamasının işlendiğini belirtmek için true dön
                }
                else -> false // Diğer durumlarda false dön
            }
            true
        }
        expandableList!!.setOnChildClickListener { parent, v, groupPosition, childPosition, id -> //Nothing here ever fires
            val groupName = mMenuAdapterYedekExpandableListAdapter!!.getGroup(groupPosition)
            val childName =
                mMenuAdapterYedekExpandableListAdapter!!.getChild(groupPosition, childPosition)
            if (childName==getString(R.string.geridonusum)) {
                val i = Intent(this, FiyatSorgulamaActivity::class.java)
                startActivity(i)
            }
            true
        }
    }

    private fun setupDrawerContent(navigationView: NavigationView) {
        //revision: this don't works, use setOnChildClickListener() and setOnGroupClickListener() above instead
        navigationView.setNavigationItemSelectedListener(
            object : NavigationView.OnNavigationItemSelectedListener {
                @SuppressLint("SuspiciousIndentation")
                override fun onNavigationItemSelected(menuItem: MenuItem): Boolean {
                    menuItem.setChecked(true)
                    if (menuItem.itemId == 0)
                        drawer!!.closeDrawers()
                    //  Toast.makeText(this@HomeActivity,menuItem.itemId,Toast.LENGTH_LONG).show()
                    return true
                }
            })
    }
    fun onFacebookClick(view: View) {
        openSocialMediaPage("https://www.facebook.com/")
    }

    fun onTwitterClick(view: View) {
        openSocialMediaPage("https://twitter.com/")
    }

    fun onInstagramClick(view: View) {
        openSocialMediaPage("https://www.instagram.com/")
    }

    fun onLinkedInClick(view: View) {
        openSocialMediaPage("https://www.linkedin.com/")
    }

    private fun openSocialMediaPage(url: String) {
        val intent = Intent(Intent.ACTION_VIEW, Uri.parse(url))
        startActivity(intent)
    }
    fun drawerOpen() {
        //  onYanMenu()
        try {
            inputManager!!.hideSoftInputFromWindow(
                currentFocus!!.windowToken,
                InputMethodManager.HIDE_NOT_ALWAYS
            )
        } catch (e: Exception) {
            e.printStackTrace()
        }
        if (drawer!!.isDrawerOpen(GravityCompat.START)) {
            drawer!!.closeDrawer(GravityCompat.START)
        } else {
            drawer!!.openDrawer(GravityCompat.START)
        }
    }
}