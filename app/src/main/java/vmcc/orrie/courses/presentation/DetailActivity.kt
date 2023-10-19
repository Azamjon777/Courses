package vmcc.orrie.courses.presentation

import android.os.Bundle
import android.widget.Toast
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.MutableLiveData
import vmcc.orrie.courses.R
import vmcc.orrie.courses.databinding.ActivityDetailBinding
import vmcc.orrie.courses.db.SaveShared
import vmcc.orrie.courses.model.BasicItemModel
import vmcc.orrie.courses.viewmodel.DetailViewModel

class DetailActivity : AppCompatActivity() {
    private lateinit var binding: ActivityDetailBinding
    private val isFavourite = MutableLiveData(false)

    private val detailViewModel: DetailViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityDetailBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val bundle = intent.extras
        val item = bundle!!.getSerializable("basic") as BasicItemModel

        val valueBool = SaveShared.getFavourite(applicationContext, item.title)
        isFavourite.observe(this) { isFavouriteValue ->
            if (isFavouriteValue != valueBool) {
                binding.favouriteImg.setImageResource(R.drawable.ic_favourite)
            } else {
                binding.favouriteImg.setImageResource(R.drawable.ic_unfavourite)
            }
        }

        binding.itemImg.setImageResource(item.img)
        binding.itemTitle.text = item.title
        binding.itemDesc.text = item.description

        binding.favouriteImg.setOnClickListener {
            val itemTitle = item.title

            detailViewModel.checkItemExists(itemTitle).observe(this) { itemExists ->
                if (itemExists) {
                    binding.favouriteImg.setImageResource(R.drawable.ic_unfavourite)
                    SaveShared.setFavourite(applicationContext, itemTitle, false)
                    detailViewModel.delete(item) {}
                    isFavourite.value = false
                    Toast.makeText(this, "Added", Toast.LENGTH_SHORT).show()
                } else {
                    binding.favouriteImg.setImageResource(R.drawable.ic_favourite)
                    SaveShared.setFavourite(applicationContext, itemTitle, true)
                    detailViewModel.insert(item) {}
                    isFavourite.value = true
                }
            }
        }
    }
}