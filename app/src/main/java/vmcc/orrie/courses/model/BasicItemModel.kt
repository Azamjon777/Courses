package vmcc.orrie.courses.model

import androidx.room.Entity
import androidx.room.PrimaryKey
import java.io.Serializable

@Entity(tableName = "basic_item_table")
data class BasicItemModel(
    @PrimaryKey(autoGenerate = true)
    val id: Int? = null,
    val img: Int,
    val title: String,
    val description: String,
) : Serializable
