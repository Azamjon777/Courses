package vmcc.orrie.courses.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.launch
import vmcc.orrie.courses.REALISATION
import vmcc.orrie.courses.model.BasicItemModel

class FavouriteViewModel : ViewModel() {
    fun getAllBasics(): LiveData<List<BasicItemModel>> {
        return REALISATION.allBasicCourses
    }

    fun deleteAll() {
        viewModelScope.launch {
            REALISATION.deleteAll()
        }
    }
}