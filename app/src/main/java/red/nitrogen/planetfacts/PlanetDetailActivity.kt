package red.nitrogen.planetfacts

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import kotlinx.android.synthetic.main.activity_planet_detail.*

class PlanetDetailActivity : AppCompatActivity() {
    private lateinit var obj:PlanetData
    private var planetImage:Int? = null
    private var planetInternal:Int? = null
    private var planetGeology:Int? = null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_planet_detail)
        window.decorView.apply {
            systemUiVisibility =
                View.SYSTEM_UI_FLAG_HIDE_NAVIGATION or View.SYSTEM_UI_FLAG_FULLSCREEN
        }
        obj = intent.getParcelableExtra("planet")!!
        planetImage = intent.getIntExtra("planetImage", -1)
        planetInternal = intent.getIntExtra("planetInternal", -1)
        planetGeology = intent.getIntExtra("planetGeology", -1)
        setData(obj, planetImage!!)
    }
    private fun setData(obj:PlanetData, planetImage:Int){
        planet_name_info.text = obj.name
        planet_galaxy_info.text = obj.galaxy
        planet_dist_info.text = obj.distance
        planet_gravity_info.text = obj.gravity
        planet_day_info.text = obj.rotation
        planet_revolution_info.text = obj.revolution
        planet_radius_info.text = obj.radius
        planet_temperature_info.text = obj.temperature
        text_text.text = obj.overview
        planet_info_img.setImageResource(planetImage)
    }
}