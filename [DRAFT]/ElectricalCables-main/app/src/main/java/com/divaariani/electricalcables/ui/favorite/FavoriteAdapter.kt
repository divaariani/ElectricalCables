import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.divaariani.electricalcables.R
import com.divaariani.electricalcables.data.Cable

class FavoriteAdapter{

}
//class FavoriteAdapter (private val cableList: List<Cable>, private val onItemClick: (Cable) -> Unit) :
//    RecyclerView.Adapter<FavoriteAdapter.FavoriteViewHolder>() {
//
//    inner class FavoriteViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
//        val titleCable: TextView = itemView.findViewById(R.id.title_cable)
//        val photoCable: ImageView = itemView.findViewById(R.id.image_cable)
//
//        fun bind(cable: Cable) {
//            titleCable.text = cable.name
//
//            Glide.with(itemView)
//                .load(cable.photoUrl)
//                .into(photoCable)
//
//            itemView.setOnClickListener {
//                onItemClick(cable)
//            }
//        }
//    }
//
//    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): FavoriteViewHolder {
//        val itemView = LayoutInflater.from(parent.context)
//            .inflate(R.layout.item_favorite, parent, false)
//        return  FavoriteViewHolder(itemView)
//    }
//
//    override fun onBindViewHolder(holder: FavoriteViewHolder, position: Int) {
//        val currentItem = cableList[position]
//        holder.bind(currentItem)
//        holder.titleCable.text = currentItem.name
//
//        Glide.with(holder.itemView)
//            .load(currentItem.photoUrl)
//            .into(holder.photoCable)
//    }
//
//    override fun getItemCount() = cableList.size
//}