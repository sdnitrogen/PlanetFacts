package red.nitrogen.planetfacts

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import kotlinx.android.synthetic.main.view.view.*

class Adapter(var planets:List<PlanetData>): RecyclerView.Adapter<Adapter.ViewHolder>() {
    class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        var title = itemView.planet_name
        var image = itemView.planet_img
        var galaxy = itemView.planet_galaxy
        var distance = itemView.planet_dist
        var gravity = itemView.planet_gravity
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        var itemView = LayoutInflater.from(parent.context).inflate(R.layout.view,parent,false)
        return ViewHolder(itemView)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        var imgHolder:Int? = null
        holder.title.text = planets[position].name
        holder.galaxy.text = planets[position].galaxy
        holder.distance.text = planets[position].distance
        holder.gravity.text = planets[position].gravity
        when(planets[position].name!!.lowercase()) {
            "mercury" -> {
                imgHolder = R.drawable.ic_planet_mercury
            }
            "venus" -> {
                imgHolder = R.drawable.ic_planet_venus
            }
            "earth" -> {
                imgHolder = R.drawable.ic_planet_earth
            }
            "mars" -> {
                imgHolder = R.drawable.ic_planet_mars
            }
            "jupiter" -> {
                imgHolder = R.drawable.ic_planet_jupiter
            }
            "saturn" -> {
                imgHolder = R.drawable.ic_planet_saturn
            }
            "uranus" -> {
                imgHolder = R.drawable.ic_planet_uranus
            }
            "neptune" -> {
                imgHolder = R.drawable.ic_planet_neptune
            }
        }
        if (imgHolder != null) {
            holder.image.setImageResource(imgHolder)
        }
    }

    override fun getItemCount(): Int {
        return planets.size
    }
}