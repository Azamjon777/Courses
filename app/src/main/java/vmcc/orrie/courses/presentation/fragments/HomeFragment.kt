package vmcc.orrie.courses.presentation.fragments

import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.RecyclerView
import vmcc.orrie.courses.R
import vmcc.orrie.courses.adapter.CourseAdapter
import vmcc.orrie.courses.databinding.FragmentHomeBinding
import vmcc.orrie.courses.model.BasicItemModel
import vmcc.orrie.courses.model.CourseModel
import vmcc.orrie.courses.presentation.DetailActivity
import vmcc.orrie.courses.presentation.MainActivity
import vmcc.orrie.courses.presentation.TestsActivity
import vmcc.orrie.courses.viewmodel.CourseViewModel
import vmcc.orrie.courses.viewmodel.CourseViewModelFactory

class HomeFragment : Fragment(), CourseAdapter.OnItemClickListener {

    private lateinit var binding: FragmentHomeBinding
    private lateinit var recyclerView: RecyclerView
    private lateinit var courseAdapter: CourseAdapter
    private lateinit var viewModel: CourseViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentHomeBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val activity = requireActivity() as MainActivity

        viewModel = ViewModelProvider(
            this,
            CourseViewModelFactory(requireContext())
        )[CourseViewModel::class.java]

        val courseList = viewModel.courseList

        recyclerView = binding.courseRecyclerView
        courseAdapter = CourseAdapter(courseList, this)

        recyclerView.adapter = courseAdapter

        binding.startTraining.setOnClickListener {
            val coursesFragment = CoursesFragment()
            activity.replaceFragment(coursesFragment)
        }
        binding.tvMarketing.setOnClickListener {

            val item = BasicItemModel(
                img = R.drawable.basic_img1,
                title = getString(R.string.basic_title1),
                description = getString(R.string.basic_desc1)
            )

            val intent = Intent(requireActivity(), DetailActivity::class.java)
            val bundle = Bundle()
            bundle.putSerializable("basic", item)
            intent.putExtras(bundle)
            startActivity(intent)
        }
    }

    override fun onItemClick(course: CourseModel) {
        val intent = Intent(requireContext(), TestsActivity::class.java)
        intent.putExtra("selectedCourse", course)
        startActivity(intent)
    }
}
