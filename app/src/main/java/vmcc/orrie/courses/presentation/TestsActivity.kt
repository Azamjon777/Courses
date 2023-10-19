package vmcc.orrie.courses.presentation

import android.content.DialogInterface
import android.graphics.Color
import android.os.Bundle
import android.view.View
import android.widget.Button
import androidx.appcompat.app.AlertDialog
import androidx.appcompat.app.AppCompatActivity
import vmcc.orrie.courses.R
import vmcc.orrie.courses.databinding.ActivityTestsBinding
import vmcc.orrie.courses.model.CourseModel

class TestsActivity : AppCompatActivity(), View.OnClickListener {

    private var totalQuestion: Int? = null
    private lateinit var binding: ActivityTestsBinding
    private var ansA: Button? = null
    private var ansB: Button? = null
    private var ansC: Button? = null
    private var ansD: Button? = null
    private var submitBtn: Button? = null
    private lateinit var selectedCourse: CourseModel

    private var score = 0

    private var currentQuestionIndex = 0
    private var selectedAnswer = ""

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityTestsBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)

        selectedCourse = (intent.getSerializableExtra("selectedCourse") as? CourseModel)!!
        totalQuestion = selectedCourse.testsModel.questions.size

        ansA = binding.ansA
        ansB = binding.ansB
        ansC = binding.ansC
        ansD = binding.ansD
        submitBtn = binding.submitBtn

        binding.ansA.setOnClickListener(this)
        binding.ansB.setOnClickListener(this)
        binding.ansC.setOnClickListener(this)
        binding.ansD.setOnClickListener(this)
        binding.submitBtn.setOnClickListener(this)

        supportActionBar?.hide()
        loadNewQuestion(selectedCourse)
    }

    override fun onClick(view: View) {
        binding.ansA.setBackgroundColor(Color.WHITE)
        binding.ansB.setBackgroundColor(Color.WHITE)
        binding.ansC.setBackgroundColor(Color.WHITE)
        binding.ansD.setBackgroundColor(Color.WHITE)
        val clickedButton = view as Button
        if (clickedButton.id == R.id.submit_btn) {
            if (selectedAnswer == selectedCourse.testsModel.correctAnswers[currentQuestionIndex]) {
                score++
            }
            currentQuestionIndex++
            loadNewQuestion(selectedCourse)
        } else {
            selectedAnswer = clickedButton.text.toString()
            clickedButton.setBackgroundColor(Color.GRAY)
        }
    }

    private fun loadNewQuestion(selectedCourse: CourseModel) {
        if (currentQuestionIndex == totalQuestion) {
            finishQuiz()
            return
        }
        binding.textView.text = selectedCourse.testsModel.questions[currentQuestionIndex]

        binding.ansA.text = selectedCourse.testsModel.answer[currentQuestionIndex][0]
        binding.ansB.text = selectedCourse.testsModel.answer[currentQuestionIndex][1]
        binding.ansC.text = selectedCourse.testsModel.answer[currentQuestionIndex][2]
        binding.ansD.text = selectedCourse.testsModel.answer[currentQuestionIndex][3]
    }

    private fun finishQuiz() {
        val passStatus = if (score > totalQuestion!! * 0.60) {
            "Passed"
        } else {
            "Failed"
        }
        AlertDialog.Builder(this)
            .setTitle(passStatus)
            .setMessage("Score is $score out of $totalQuestion")
            .setPositiveButton(
                "Restart"
            ) { _: DialogInterface?, _: Int -> restartQuiz() }
            .setCancelable(false)
            .show()
    }

    private fun restartQuiz() {
        score = 0
        currentQuestionIndex = 0
        loadNewQuestion(selectedCourse)
    }
}