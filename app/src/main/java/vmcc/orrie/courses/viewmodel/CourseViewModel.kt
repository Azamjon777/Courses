package vmcc.orrie.courses.viewmodel

import android.content.Context
import androidx.lifecycle.ViewModel
import vmcc.orrie.courses.R
import vmcc.orrie.courses.REALISATION
import vmcc.orrie.courses.db.BasicRoomDatabase
import vmcc.orrie.courses.db.repository.BasicRepositoryRealization
import vmcc.orrie.courses.model.CourseModel
import vmcc.orrie.courses.model.TestsModel

class CourseViewModel(context: Context) : ViewModel() {
    init {
        val daoBasic = BasicRoomDatabase.getInstance(context).getBasicDao()
        REALISATION = BasicRepositoryRealization(daoBasic)
    }

    private val questionsPython = listOf(
        context.getString(R.string.operator_for_commenting_lines_in_python),
        context.getString(R.string.keyword_for_declaring_a_variable_in_python),
        context.getString(R.string.function_for_displaying_text_on_the_screen_in_python),
        context.getString(R.string.keyword_for_conditional_statements_in_python),
        context.getString(R.string.data_type_for_creating_a_list_in_python)
    )

    private var correctAnswersPython = listOf(
        context.getString(R.string._rew),
        context.getString(R.string.var1),
        context.getString(R.string.print),
        context.getString(R.string.if1),
        context.getString(R.string.list)
    )

    private val choicesPython = listOf(
        listOf(
            context.getString(R.string._rew),
            context.getString(R.string.var1),
            context.getString(R.string.print),
            context.getString(R.string.if1)
        ),
        listOf(
            context.getString(R.string.var1), context.getString(R.string.let), context.getString(
                R.string.const1
            ), context.getString(R.string.fun1)
        ),
        listOf(
            context.getString(R.string.write),
            context.getString(R.string.echo),
            context.getString(R.string.print),
            context.getString(
                R.string.display
            )
        ),
        listOf(
            context.getString(R.string.for1),
            context.getString(R.string.while1),
            context.getString(R.string.if1),
            context.getString(
                R.string.switch1
            )
        ),
        listOf(
            context.getString(R.string.list), context.getString(R.string.array), context.getString(
                R.string.tuple
            ), context.getString(R.string.set)
        )
    )

    private val questionsKotlin = listOf(
        context.getString(R.string.what_is_kotlin),
        context.getString(R.string.how_to_declare_a_variable_in_kotlin),
        context.getString(R.string.how_to_create_a_function_in_kotlin),
        context.getString(R.string.what_is_null_safety_in_kotlin),
        context.getString(R.string.which_operator_is_used_for_conditional_operations_in_kotlin)
    )

    private var correctAnswersKotlin = listOf(
        context.getString(R.string.programming_language),
        context.getString(R.string.val_or_var),
        context.getString(R.string.fun1),
        context.getString(R.string.null_safety_mechanism),
        context.getString(R.string.if1)
    )

    private val choicesKotlin = listOf(
        listOf(
            context.getString(R.string.programming_language),
            context.getString(R.string.interpreter),
            context.getString(
                R.string.compiler
            ),
            context.getString(R.string.ide)
        ),
        listOf(
            context.getString(R.string.val_or_var),
            context.getString(R.string.let),
            context.getString(R.string.const1),
            context.getString(R.string.fun1)
        ),
        listOf(
            context.getString(R.string.function),
            context.getString(R.string.def),
            context.getString(R.string.fun1),
            context.getString(
                R.string.procedure
            )
        ),
        listOf(
            context.getString(R.string.a_mechanism_for_ensuring_safety_against_null_values),
            context.getString(R.string.null_check_operator),
            context.getString(R.string.exceptions),
            context.getString(R.string.smart_pointers)
        ),
        listOf(
            context.getString(R.string.if1),
            context.getString(R.string.switch1),
            context.getString(R.string.for1),
            context.getString(R.string.while1)
        )
    )

    private val questionsCpp = listOf(
        context.getString(R.string.what_is_c),
        context.getString(R.string.how_to_declare_a_variable_in_c),
        context.getString(R.string.how_to_create_a_function_in_c),
        context.getString(R.string.what_is_a_pointer_in_c),
        context.getString(R.string.which_operator_is_used_to_perform_looping_operations_in_c)
    )

    private val correctAnswersCpp = listOf(
        context.getString(R.string.programming_language),
        context.getString(R.string.variable_type_variable_name),
        context.getString(R.string.return_type_function_name),
        context.getString(R.string.a_variable_that),
        context.getString(R.string.for1)
    )

    private val choicesCpp = listOf(
        listOf(
            context.getString(R.string.programming_language),
            context.getString(R.string.interpreter),
            context.getString(R.string.compiler),
            context.getString(R.string.ide)
        ),
        listOf(
            context.getString(R.string.variable_type_variable_name),
            context.getString(R.string.var1),
            context.getString(R.string.let),
            context.getString(R.string.const1)
        ),
        listOf(
            context.getString(R.string.return_type_function_name),
            context.getString(R.string.def),
            context.getString(R.string.void_functionname),
            context.getString(R.string.procedure)
        ),
        listOf(
            context.getString(R.string.a_variable_that),
            context.getString(R.string.pointer),
            context.getString(R.string.link),
            context.getString(R.string.array)
        ),
        listOf(
            context.getString(R.string.if1),
            context.getString(R.string.switch1),
            context.getString(R.string.for1),
            context.getString(R.string.while1)
        )
    )

    val courseList: List<CourseModel> = listOf(
        CourseModel(
            context.getString(R.string.python),
            R.drawable.onboard1_img,
            TestsModel(
                choicesPython,
                questionsPython,
                correctAnswersPython
            )
        ),
        CourseModel(
            context.getString(R.string.c),
            R.drawable.onboard1_img,
            TestsModel(
                choicesCpp,
                questionsCpp,
                correctAnswersCpp
            )
        ),
        CourseModel(
            context.getString(R.string.kotlin),
            R.drawable.onboard1_img,
            TestsModel(
                choicesKotlin,
                questionsKotlin,
                correctAnswersKotlin
            )
        )
    )
}
