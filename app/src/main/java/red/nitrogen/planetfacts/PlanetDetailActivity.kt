package red.nitrogen.planetfacts

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import com.google.android.material.bottomsheet.BottomSheetDialogFragment
import kotlinx.android.synthetic.main.activity_planet_detail.*

class PlanetDetailActivity : AppCompatActivity(), ItemClickListener {
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
        val bottomsheetFragment = BottomSheet()
        setData(obj, planetImage!!, planetInternal!!, planetGeology!!, "Overview")
        button_info.setOnClickListener {
            bottomsheetFragment.show(supportFragmentManager,"BottomSheetDialog")
        }
    }
    private fun setData(obj:PlanetData, planetImage:Int, planetInternal:Int, planetGeology:Int, flag:String){
        if (flag == "Overview"){
            planet_name_info.text = obj.name
            planet_galaxy_info.text = obj.galaxy
            planet_dist_info.text = obj.distance
            planet_gravity_info.text = obj.gravity
            planet_day_info.text = obj.rotation
            planet_revolution_info.text = obj.revolution
            planet_radius_info.text = obj.radius
            planet_temperature_info.text = obj.temperature
            button_info.text = flag
            text_title.text = flag
            text_text.text = obj.overview
            planet_info_img.setImageResource(planetImage)
            planet_info_geo.setImageResource(android.R.color.transparent)
        } else if (flag == "Internal Structure"){
            button_info.text = flag
            text_title.text = flag
            text_text.text = obj.structure
            planet_info_img.setImageResource(planetInternal)
            planet_info_geo.setImageResource(android.R.color.transparent)
        } else if (flag == "Surface Geology"){
            button_info.text = flag
            text_title.text = flag
            text_text.text = obj.geology
            planet_info_img.setImageResource(planetImage)
            planet_info_geo.setImageResource(planetGeology)
        }
    }

    override fun onItemClick(item: String?) {
        if (item != null) {
            setData(obj, planetImage!!, planetInternal!!, planetGeology!!, item)
        }
    }
}