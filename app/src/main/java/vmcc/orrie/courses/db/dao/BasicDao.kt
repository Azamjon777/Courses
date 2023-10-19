package vmcc.orrie.courses.db.dao

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import vmcc.orrie.courses.model.BasicItemModel

@Dao
interface BasicDao {
    @Query("SELECT EXISTS (SELECT 1 FROM basic_item_table WHERE title = :title)")
    fun checkItemExists(title: String): LiveData<Boolean>

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    suspend fun insert(basicItemModel: BasicItemModel)

    @Delete
    suspend fun delete(basicItemModel: BasicItemModel)

    @Query("SELECT * FROM basic_item_table")
    fun getAllBasicItems(): LiveData<List<BasicItemModel>>

    @Query("DELETE FROM basic_item_table")
    fun deleteAll()
}