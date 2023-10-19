package vmcc.orrie.courses.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import vmcc.orrie.courses.databinding.BasicItemLayoutBinding
import vmcc.orrie.courses.model.BasicItemModel

class BasicItemAdapter(
    private val itemClickListener: OnItemClickListener
) : RecyclerView.Adapter<BasicItemAdapter.ViewHolder>() {

    private val itemList = mutableListOf<BasicItemModel>()

    fun setData(newItemList: List<BasicItemModel>) {
        itemList.clear()
        itemList.addAll(newItemList)
        notifyDataSetChanged()
    }

    inner class ViewHolder(private val binding: BasicItemLayoutBinding) :
        RecyclerView.ViewHolder(binding.root) {

        init {
            binding.root.setOnClickListener {
                val position = adapterPosition
                if (position != RecyclerView.NO_POSITION) {
                    val item = itemList[position]
                    itemClickListener.onItemClick(item)
                }
            }
        }

        fun bind(item: BasicItemModel) {
            binding.itemImg.setImageResource(item.img)
            binding.itemTitle.text = item.title
        }
    }


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val binding = BasicItemLayoutBinding.inflate(
            LayoutInflater.from(parent.context),
            parent,
            false
        )
        return ViewHolder(binding)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val currentItem = itemList[position]
        holder.bind(currentItem)
    }

    override fun getItemCount(): Int {
        return itemList.size
    }

    interface OnItemClickListener {
        fun onItemClick(item: BasicItemModel)
    }
}
