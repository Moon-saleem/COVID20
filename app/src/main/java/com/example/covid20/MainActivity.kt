package com.example.covid20

import android.content.Intent
import android.graphics.Color
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.view.View
import android.widget.ScrollView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.android.volley.Request
import com.android.volley.Response
import com.android.volley.toolbox.StringRequest
import com.android.volley.toolbox.Volley
import com.leo.simplearcloader.SimpleArcLoader
import kotlinx.android.synthetic.main.activity_main.*
import org.eazegraph.lib.charts.PieChart
import org.eazegraph.lib.models.PieModel
import org.json.JSONException
import org.json.JSONObject

class MainActivity : AppCompatActivity() {
    private var simpleArcLoader:SimpleArcLoader?=null
    private var scrollView:ScrollView?=null
    private var pieChart:PieChart?=null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        supportActionBar!!.title = "Covid 19"
        simpleArcLoader=findViewById(R.id.loader)
        scrollView=findViewById(R.id.scroll)
        pieChart=findViewById(R.id.piechart)
        fetchVirusData()

    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.menu_main,menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        var id=item.itemId
        when (id)
        {
            R.id.About ->
            {
//                Toast.makeText(applicationContext,"About Menu clicked",Toast.LENGTH_LONG).show()
                var about_intent=Intent(applicationContext,AboutApp::class.java)
                startActivity(about_intent)
            }
            R.id.help ->
                Toast.makeText(applicationContext,"help Menu clicked",Toast.LENGTH_LONG).show()

        }
        return super.onOptionsItemSelected(item)
    }

    private fun fetchVirusData() {
        var url ="https://corona.lmao.ninja/v2/all/"
        simpleArcLoader!!.start()
        var request= object:StringRequest(Request.Method.GET,url,
            Response.Listener<String> { response ->
                try {
                    var jsonObject:JSONObject = JSONObject(response.toString())
                    tvCases.text = jsonObject.getString("cases")
                    tvRecoverd.text = jsonObject.getString("recovered")
                    tvCritical.text=jsonObject.getString("critical")
                    tvActive.text=jsonObject.getString("active")
                    tvTodayCases.text=jsonObject.getString("todayCases")
                    tvTodayDeath.text=jsonObject.getString("todayDeaths")
                    tvTotalDeath.text=jsonObject.getString("deaths")
                    tvAffectedCountry.text=jsonObject.getString("affectedCountries")
                    tvPopulation.text=jsonObject.getString("population")

                    pieChart!!.addPieSlice(PieModel("Cases", Integer.parseInt(tvCases.text.toString()).toFloat(),Color.parseColor("#95AA690A")))
                    pieChart!!.addPieSlice(PieModel("Recoverd", Integer.parseInt(tvRecoverd.text.toString()).toFloat(),Color.parseColor("#66BB6A")))
                    pieChart!!.addPieSlice(PieModel("Deaths", Integer.parseInt(tvTotalDeath.text.toString()).toFloat(),Color.parseColor("#EF5350")))
                    pieChart!!.addPieSlice(PieModel("Active", Integer.parseInt(tvActive.text.toString()).toFloat(),Color.parseColor("#29B6F6")))
                    pieChart!!.startAnimation()

                    simpleArcLoader?.stop()
                    simpleArcLoader!!.visibility= View.GONE
                    scrollView!!.visibility=View.VISIBLE








                } catch (e:JSONException) {
                    e.printStackTrace()
                    simpleArcLoader?.stop()
                    simpleArcLoader!!.visibility= View.GONE
                    scrollView!!.visibility=View.VISIBLE

                }
            },
            Response.ErrorListener { error ->
                simpleArcLoader?.stop()
                simpleArcLoader!!.visibility= View.GONE
                scrollView!!.visibility=View.VISIBLE
                Toast.makeText(this,error?.message,Toast.LENGTH_LONG).show() })
        {}
                var requestQueue= Volley.newRequestQueue(this)
                requestQueue.add(request)
    }

    fun TrackCountries(view: View) {
        startActivity(Intent(applicationContext,CountryAffected::class.java))

    }

}
