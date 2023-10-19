package vmcc.orrie.courses.presentation

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentTransaction
import vmcc.orrie.courses.R
import vmcc.orrie.courses.databinding.ActivityMainBinding
import vmcc.orrie.courses.presentation.fragments.CoursesFragment
import vmcc.orrie.courses.presentation.fragments.FavouriteFragment
import vmcc.orrie.courses.presentation.fragments.HomeFragment

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val initialFragment = HomeFragment()
        replaceFragment(initialFragment)

        binding.bottomNavView.setOnNavigationItemSelectedListener { item ->
            when (item.itemId) {
                R.id.homeFragment -> {
                    val homeFragment = HomeFragment()
                    replaceFragment(homeFragment)
                    true
                }

                R.id.coursesFragment -> {
                    val coursesFragment = CoursesFragment()
                    replaceFragment(coursesFragment)
                    true
                }

                R.id.favouriteFragment -> {
                    val favouriteFragment = FavouriteFragment()
                    replaceFragment(favouriteFragment)
                    true
                }

                else -> false
            }
        }
    }

    fun replaceFragment(fragment: Fragment) {
        supportFragmentManager.beginTransaction()
            .replace(binding.fragmentMainContainer.id, fragment)
            .addToBackStack(null)
            .setTransition(FragmentTransaction.TRANSIT_FRAGMENT_FADE)
            .commit()
    }
}
