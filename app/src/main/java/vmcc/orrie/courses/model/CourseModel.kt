package vmcc.orrie.courses.model

import java.io.Serializable

data class CourseModel(
    val title: String,
    val img: Int,
    val testsModel: TestsModel
) : Serializable