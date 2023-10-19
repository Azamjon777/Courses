package vmcc.orrie.courses.db.repository

import androidx.lifecycle.LiveData
import vmcc.orrie.courses.model.BasicItemModel

interface BasicRepository {
    val allBasicCourses: LiveData<List<BasicItemModel>>

    suspend fun insertBasicItem(basicItemModel: BasicItemModel, onSuccess: () -> Unit)
    suspend fun deleteBasicItem(basicItemModel: BasicItemModel, onSuccess: () -> Unit)
    fun checkItemExists(title: String): LiveData<Boolean>

    fun deleteAll()
}
