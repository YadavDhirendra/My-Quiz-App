package dhirendrayadav.quizapp

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.appcompat.widget.AppCompatEditText

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val editText = findViewById<EditText>(R.id.editText)
        val btnStart = findViewById<Button>(R.id.btn_start)
        btnStart.setOnClickListener {
                if(editText.text.isEmpty())
                {
                    Toast.makeText(this,"Please enter your name",Toast.LENGTH_SHORT).show()
                }
            else
                {
                    val intent = Intent(this,QuizQuestionsActivity::class.java)
                    intent.putExtra(Constants.USER_NAME,editText.text.toString())
                    startActivity(intent)
                    finish()
                }
        }

    }
}