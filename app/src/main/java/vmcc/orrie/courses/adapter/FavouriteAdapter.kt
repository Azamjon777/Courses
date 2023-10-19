package vmcc.orrie.courses.adapter

import android.annotation.SuppressLint
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import vmcc.orrie.courses.databinding.BasicItemLayoutBinding
import vmcc.orrie.courses.model.BasicItemModel

class FavouriteAdapter : RecyclerView.Adapter<FavouriteAdapter.MyViewHolder>() {
    private var listBasic = emptyList<BasicItemModel>()

    class MyViewHolder(internal val binding: BasicItemLayoutBinding) :
        RecyclerView.ViewHolder(binding.root)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        val binding =
            BasicItemLayoutBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return MyViewHolder(binding)
    }

    override fun getItemCount(): Int {
        return listBasic.size
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        val item = listBasic[position]
        val binding = holder.binding

        binding.itemImg.setImageResource(item.img)
        binding.itemTitle.text = item.title
    }

    @SuppressLint("NotifyDataSetChanged")
    fun setList(list: List<BasicItemModel>) {
        listBasic = list
        notifyDataSetChanged()
    }
}