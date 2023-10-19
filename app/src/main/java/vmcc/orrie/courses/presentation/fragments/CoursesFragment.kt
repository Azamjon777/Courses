package vmcc.orrie.courses.presentation.fragments

import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import vmcc.orrie.courses.R
import vmcc.orrie.courses.adapter.BasicItemAdapter
import vmcc.orrie.courses.databinding.FragmentCoursesBinding
import vmcc.orrie.courses.model.BasicItemModel
import vmcc.orrie.courses.presentation.DetailActivity

class CoursesFragment : Fragment(), BasicItemAdapter.OnItemClickListener {

    private lateinit var binding: FragmentCoursesBinding
    private lateinit var adapter: BasicItemAdapter

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentCoursesBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        adapter = BasicItemAdapter(this)

        binding.coursesRecyclerView.adapter = adapter

        val itemList = mutableListOf(
            BasicItemModel(
                img = R.drawable.basic_img1,
                title = getString(R.string.basic_title1),
                description = getString(R.string.basic_desc1)
            ),
            BasicItemModel(
                img = R.drawable.basic_img2,
                title = getString(R.string.basic_title2),
                description = getString(R.string.basic_desc2)
            ),
            BasicItemModel(
                img = R.drawable.basic_img3,
                title = getString(R.string.basic_title3),
                description = getString(R.string.basic_desc3)
            )
        )

        adapter.setData(itemList)
    }

    override fun onItemClick(item: BasicItemModel) {
        val intent = Intent(requireActivity(), DetailActivity::class.java)
        val bundle = Bundle()
        bundle.putSerializable("basic", item)
        intent.putExtras(bundle)
        startActivity(intent)
    }
}
