package dhirendrayadav.quizapp

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView

class Result : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_result)
        var tvUserName : TextView = findViewById(R.id.tvUserName)
        var tvScore : TextView = findViewById(R.id.tvScore)
        var btnFinish : Button = findViewById(R.id.btnFinish)

        tvUserName.text = intent.getStringExtra(Constants.USER_NAME)

        val totalQues  = intent.getIntExtra(Constants.TOTAL_QUESTIONS,0)
        val correctAns = intent.getIntExtra(Constants.CORRECT_ANSWERS,0)

        tvScore.text = "Your Score is $correctAns out of $totalQues"

        btnFinish.setOnClickListener{
            startActivity(Intent(this,MainActivity::class.java))
        }
    }
}