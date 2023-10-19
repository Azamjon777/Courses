package vmcc.orrie.courses.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import vmcc.orrie.courses.REALISATION
import vmcc.orrie.courses.model.BasicItemModel

class DetailViewModel : ViewModel() {

    fun insert(basicItemModel: BasicItemModel, onSuccess: () -> Unit) =
        viewModelScope.launch(Dispatchers.IO) {
            REALISATION.insertBasicItem(basicItemModel) {
                onSuccess()
            }
        }

    fun delete(basicItemModel: BasicItemModel, onSuccess: () -> Unit) =
        viewModelScope.launch(Dispatchers.IO) {
            REALISATION.deleteBasicItem(basicItemModel) {
                onSuccess()
            }
        }

    fun checkItemExists(title: String): LiveData<Boolean> {
        return REALISATION.checkItemExists(title)
    }
}