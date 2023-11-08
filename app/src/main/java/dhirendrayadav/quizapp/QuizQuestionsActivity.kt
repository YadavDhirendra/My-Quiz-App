package dhirendrayadav.quizapp

import android.content.Intent
import android.graphics.Color
import android.graphics.Typeface
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.Button
import android.widget.ImageView
import android.widget.ProgressBar
import android.widget.TextView
import android.widget.Toast
import androidx.core.content.ContextCompat
import dhirendrayadav.quizapp.Result

class QuizQuestionsActivity : AppCompatActivity() , View.OnClickListener
{

    private var mCurrentPosition: Int = 1
    private var myQuestionsList: ArrayList<Questions>? = null
    private var mSelectedOptionPosition: Int = 0
    private var mUserName : String? = null
    private var correctAnswer : Int = 0
    private var totalQuestions : Int = 0

    private var progressBar: ProgressBar? = null
    private var tvProgress: TextView? = null
    private var tvQuestion: TextView? = null
    private var ivImage: ImageView? = null

    private var tvOptionOne: TextView? = null
    private var tvOptionTwo: TextView? = null
    private var tvOptionThree: TextView? = null
    private var tvOptionFour: TextView? = null
    private var btnSubmit: Button? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_quiz_questions)

        progressBar = findViewById(R.id.progressBar)
        tvProgress = findViewById(R.id.tv_progressText)
        tvQuestion = findViewById(R.id.tv_ques)
        ivImage = findViewById(R.id.tv_image)

        mUserName = intent.getStringExtra(Constants.USER_NAME)

        tvOptionOne = findViewById(R.id.optionOne)
        tvOptionTwo = findViewById(R.id.optionTwo)
        tvOptionThree = findViewById(R.id.optionThree)
        tvOptionFour = findViewById(R.id.optionFour)

        btnSubmit = findViewById(R.id.btnSubmit)

        myQuestionsList = Constants.getQuestions()

        setQuestion()


        tvOptionOne?.setOnClickListener(this)
        tvOptionTwo?.setOnClickListener(this)
        tvOptionThree?.setOnClickListener(this)
        tvOptionFour?.setOnClickListener(this)
        btnSubmit?.setOnClickListener(this)


    }

    private fun setQuestion() {
        defaultOptionsView()
        val questionList: ArrayList<Questions> = Constants.getQuestions()//Question Array
        totalQuestions = questionList.size


        var question: Questions = questionList[mCurrentPosition - 1]//Question
        progressBar?.progress = mCurrentPosition
        tvProgress?.text = "$mCurrentPosition / ${progressBar?.max}"
        tvQuestion?.text = question.question

        ivImage?.setImageResource(question.image)
        tvOptionOne?.text = question.optionOne
        tvOptionTwo?.text = question.optionTwo
        tvOptionThree?.text = question.optionThree
        tvOptionFour?.text = question.optionFour


        if(mCurrentPosition < questionList.size)
        {
            btnSubmit?.text = "SUBMIT"
        }
        else
        {
            btnSubmit?.text = "FINISH"
        }
    }

   private fun defaultOptionsView(){
        val options = ArrayList<TextView>()

       tvOptionOne?.let {
           options.add(it)
       }
       tvOptionTwo?.let {
           options.add(it)
       }
       tvOptionThree?.let {
           options.add(it)
       }
       tvOptionFour?.let {
           options.add(it)
       }

       for(option in options){
           option.setTextColor(Color.parseColor("#7A8089"))
           option.typeface = Typeface.DEFAULT
           option.background = ContextCompat.getDrawable(this,
               R.drawable.default_option_border_bg)
       }
    }

    private fun selectedOptionView(tv:TextView, selectedOptionNum:Int){


        mSelectedOptionPosition = selectedOptionNum
        tv.setTextColor(Color.parseColor("#363A43"))
        tv.setTypeface(tv.typeface,Typeface.BOLD)
        tv.background = ContextCompat.getDrawable(this,
            R.drawable.selected_option_border)
    }

    private fun answerView(answer:Int , drawableView:Int){
        when(answer){
            1 -> {
                tvOptionOne?.background = ContextCompat.getDrawable(this,
                    drawableView)
            }
            2 -> {
                tvOptionTwo?.background = ContextCompat.getDrawable(this,
                    drawableView)
            }
            3 -> {
                tvOptionThree?.background = ContextCompat.getDrawable(this,
                    drawableView)
            }
            4 -> {
                tvOptionFour?.background = ContextCompat.getDrawable(this,
                    drawableView)
            }
        }
    }

    override fun onClick(view: View?) {
        when(view?.id){
            R.id.optionOne -> {
                tvOptionOne?.let{
                    selectedOptionView(it,1)
                }
                }
            R.id.optionTwo -> {
                tvOptionTwo?.let{
                    selectedOptionView(it,2)
                }
            }
            R.id.optionThree -> {
                tvOptionThree?.let{
                    selectedOptionView(it,3)
                }
            }
            R.id.optionFour -> {
                tvOptionFour?.let{
                    selectedOptionView(it,4)
                }
            }
            R.id.btnSubmit ->{
                if(mSelectedOptionPosition == 0) {
                    mCurrentPosition++

                    when{
                        mCurrentPosition <= myQuestionsList!!.size ->{
                            setQuestion()
                        }
                        else ->{
                            val intent = Intent(this,Result::class.java)
                            intent.putExtra(Constants.USER_NAME,mUserName)
                            intent.putExtra(Constants.CORRECT_ANSWERS,correctAnswer)
                            intent.putExtra(Constants.TOTAL_QUESTIONS,totalQuestions)
                            startActivity(intent)
                        }
                    }
                }
                else
                {
                    val question = myQuestionsList?.get(mCurrentPosition-1)
                    if(question?.correctAnswer != mSelectedOptionPosition)
                    {
                        answerView(mSelectedOptionPosition,R.drawable.wrong_option_bg)
                    }
                    answerView(question!!.correctAnswer,R.drawable.correct_option_bg)

                    if(mCurrentPosition == myQuestionsList!!.size){
                        btnSubmit?.text = "FINISH"
                    }
                    else{
                        correctAnswer++
                        btnSubmit?.text = "GO TO NEXT QUESTION"
                    }
                    mSelectedOptionPosition = 0
                }
            }
        }
    }
}