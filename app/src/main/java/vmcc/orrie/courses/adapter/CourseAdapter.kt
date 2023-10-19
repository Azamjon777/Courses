package vmcc.orrie.courses.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import vmcc.orrie.courses.databinding.CourseItemBinding
import vmcc.orrie.courses.model.CourseModel

class CourseAdapter(
    private val courseList: List<CourseModel>,
    private val itemClickListener: OnItemClickListener
) : RecyclerView.Adapter<CourseAdapter.ViewHolder>() {

    inner class ViewHolder(private val binding: CourseItemBinding) :
        RecyclerView.ViewHolder(binding.root), View.OnClickListener {
        init {
            binding.root.setOnClickListener(this)
        }

        fun bind(course: CourseModel) {
            binding.nameOfCourse.text = course.title
            binding.imgOfCourse.setImageResource(course.img)
        }

        override fun onClick(v: View?) {
            val position = adapterPosition
            if (position != RecyclerView.NO_POSITION) {
                val course = courseList[position]
                itemClickListener.onItemClick(course)
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val binding =
            CourseItemBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return ViewHolder(binding)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bind(courseList[position])
    }

    override fun getItemCount(): Int {
        return courseList.size
    }

    interface OnItemClickListener {
        fun onItemClick(course: CourseModel)
    }
}
