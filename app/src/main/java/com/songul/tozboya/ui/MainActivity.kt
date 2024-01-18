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
    lateinit var txtBlog:TextView
    lateinit var txtRalKaldera:TextView
    lateinit var txtHesaplama:TextView
    lateinit var txtBizeUlasin:TextView
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        onBaslat()
        menuLeftIV!!.setOnClickListener(View.OnClickListener { drawerOpen() })
        cardBlog.setOnClickListener {
            linearRalKaldera.setBackgroundColor(Color.parseColor("#FFFFFF"))
            linearHesaplama.setBackgroundColor(Color.parseColor("#FFFFFF"))
            linearlayoutBizeUlasin.setBackgroundColor(Color.parseColor("#FFFFFF"))
            linearlayoutBlog.setBackgroundColor(Color.parseColor("#FF6E40"))
            txtBlog.setTextColor(Color.parseColor("#FFFFFF"))
            txtRalKaldera.setTextColor(Color.parseColor("#FF6E40"))
            txtHesaplama.setTextColor(Color.parseColor("#FF6E40"))
            txtBizeUlasin.setTextColor(Color.parseColor("#FF6E40"))
            val i=Intent(this,TozBoyaActivity::class.java)
            startActivity(i)
        }
        cardRalKaldera.setOnClickListener {
            linearlayoutBlog.setBackgroundColor(Color.parseColor("#FFFFFF"))
            linearHesaplama.setBackgroundColor(Color.parseColor("#FFFFFF"))
            linearlayoutBizeUlasin.setBackgroundColor(Color.parseColor("#FFFFFF"))
            linearRalKaldera.setBackgroundColor(Color.parseColor("#FF6E40"))
            txtRalKaldera.setTextColor(Color.WHITE)
            txtBlog.setTextColor(Color.parseColor("#FF6E40"))
            txtHesaplama.setTextColor(Color.parseColor("#FF6E40"))
            txtBizeUlasin.setTextColor(Color.parseColor("#FF6E40"))
            val i=Intent(this,RalActivity::class.java)
            startActivity(i)
        }
        cardHesaplama.setOnClickListener {
            linearlayoutBlog.setBackgroundColor(Color.parseColor("#FFFFFF"))
            linearRalKaldera.setBackgroundColor(Color.parseColor("#FFFFFF"))
            linearlayoutBizeUlasin.setBackgroundColor(Color.parseColor("#FFFFFF"))
            linearHesaplama.setBackgroundColor(Color.parseColor("#FF6E40"))
            txtHesaplama.setTextColor(Color.WHITE)
            txtBlog.setTextColor(Color.parseColor("#FF6E40"))
            txtRalKaldera.setTextColor(Color.parseColor("#FF6E40"))
            txtBizeUlasin.setTextColor(Color.parseColor("#FF6E40"))
        }
        cardBizeUlasin.setOnClickListener {
            linearlayoutBlog.setBackgroundColor(Color.parseColor("#FFFFFF"))
            linearRalKaldera.setBackgroundColor(Color.parseColor("#FFFFFF"))
            linearHesaplama.setBackgroundColor(Color.parseColor("#FFFFFF"))
            linearlayoutBizeUlasin.setBackgroundColor(Color.parseColor("#FF6E40"))
            txtBizeUlasin.setTextColor(Color.WHITE)
            txtHesaplama.setTextColor(Color.parseColor("#FF6E40"))
            txtBlog.setTextColor(Color.parseColor("#FF6E40"))
            txtRalKaldera.setTextColor(Color.parseColor("#FF6E40"))
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
        linearlayoutBizeUlasin = findViewById(R.id.linearlayoutBizeUlasin)
        txtBlog = findViewById(R.id.txtBlog)
        txtRalKaldera = findViewById(R.id.txtRalKaldera)
        txtHesaplama = findViewById(R.id.txtHesaplama)
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


        item1.setIconName(getString(R.string.hesaplama))
        item1.setIconImg(R.drawable.hesaplama)
        item2.setIconName(getString(R.string.ralkartelasi))
        item2.setIconImg(R.drawable.ral)
        item3.setIconName(getString(R.string.blog))
        item3.setIconImg(R.drawable.blog)
        item4.setIconName(getString(R.string.bizeulasin))
        item4.setIconImg(R.drawable.contact)
        item5.setIconName(getString(R.string.geribildirim))
        item5.setIconImg(R.drawable.geri_bildirim)
        item6.setIconName(getString(R.string.logout))
        item6.setIconImg(R.drawable.logout)
        (listDataHeader as ArrayList<ExpandedMenuModel>).add(item1)
        (listDataHeader as ArrayList<ExpandedMenuModel>).add(item2)
        (listDataHeader as ArrayList<ExpandedMenuModel>).add(item3)
        (listDataHeader as ArrayList<ExpandedMenuModel>).add(item4)
        (listDataHeader as ArrayList<ExpandedMenuModel>).add(item5)
        (listDataHeader as ArrayList<ExpandedMenuModel>).add(item6)


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
        expandableList!!.setAdapter(mMenuAdapterYedekExpandableListAdapter)
        expandableList!!.setOnGroupClickListener { expandableListView, view, groupPosition, l ->
            val groupName = mMenuAdapterYedekExpandableListAdapter!!.getGroupName(groupPosition)
            //Toast.makeText(this,"this:"+groupName,Toast.LENGTH_LONG).show()

            when (groupName) {
                getString(R.string.logout) -> {
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
                     true
                }
                getString(R.string.ralkartelasi) -> {
                    val i=Intent(this,RalActivity::class.java)
                    startActivity(i)
                     true
                }


            }


            false
        }
        expandableList!!.setOnChildClickListener { parent, v, groupPosition, childPosition, id -> //Nothing here ever fires
            val groupName = mMenuAdapterYedekExpandableListAdapter!!.getGroup(groupPosition)
            val childName =
                mMenuAdapterYedekExpandableListAdapter!!.getChild(groupPosition, childPosition)
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