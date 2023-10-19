package vmcc.orrie.courses.model

import java.io.Serializable

data class TestsModel(
    val answer: List<List<String>>,
    val questions: List<String>,
    val correctAnswers: List<String>
) : Serializable