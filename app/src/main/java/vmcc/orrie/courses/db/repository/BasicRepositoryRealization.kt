package vmcc.orrie.courses.db.repository

import androidx.lifecycle.LiveData
import vmcc.orrie.courses.db.dao.BasicDao
import vmcc.orrie.courses.model.BasicItemModel

class BasicRepositoryRealization(private val basicDao: BasicDao) : BasicRepository {
    override val allBasicCourses: LiveData<List<BasicItemModel>>
        get() = basicDao.getAllBasicItems()

    override suspend fun insertBasicItem(basicItemModel: BasicItemModel, onSuccess: () -> Unit) {
        basicDao.insert(basicItemModel)
        onSuccess()
    }

    override suspend fun deleteBasicItem(basicItemModel: BasicItemModel, onSuccess: () -> Unit) {
        basicDao.delete(basicItemModel)
        onSuccess()
    }

    override fun checkItemExists(title: String): LiveData<Boolean> {
        return basicDao.checkItemExists(title)
    }

    override fun deleteAll() {
        basicDao.deleteAll()
    }
}