package vmcc.orrie.courses.db

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import vmcc.orrie.courses.db.dao.BasicDao
import vmcc.orrie.courses.model.BasicItemModel

@Database(entities = [BasicItemModel::class], version = 1)
abstract class BasicRoomDatabase : RoomDatabase() {

    abstract fun getBasicDao(): BasicDao

    companion object {
        private var database: BasicRoomDatabase? = null

        fun getInstance(context: Context): BasicRoomDatabase {
            return if (database == null) {
                database = Room.databaseBuilder(context, BasicRoomDatabase::class.java, "db")
                    .build()
                database as BasicRoomDatabase
            } else {
                database as BasicRoomDatabase
            }
        }
    }
}