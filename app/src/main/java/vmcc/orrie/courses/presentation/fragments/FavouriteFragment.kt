package vmcc.orrie.courses.presentation.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.recyclerview.widget.RecyclerView
import kotlinx.coroutines.launch
import vmcc.orrie.courses.REALISATION
import vmcc.orrie.courses.adapter.FavouriteAdapter
import vmcc.orrie.courses.databinding.FragmentFavouriteBinding
import vmcc.orrie.courses.viewmodel.FavouriteViewModel

class FavouriteFragment : Fragment() {

    private lateinit var binding: FragmentFavouriteBinding
    private lateinit var recyclerView: RecyclerView
    private val myAdapter = FavouriteAdapter()

    private val favouriteViewModel: FavouriteViewModel by viewModels()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentFavouriteBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        recyclerView = binding.favouriteRecyclerView
        recyclerView.adapter = myAdapter
        favouriteViewModel.getAllBasics().observe(viewLifecycleOwner) { list ->
            myAdapter.setList(list.asReversed())
        }
    }
}

