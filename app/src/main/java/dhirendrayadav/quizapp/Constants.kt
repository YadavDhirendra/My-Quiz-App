package dhirendrayadav.quizapp

object Constants {

    const val USER_NAME :String = "user_name"
    const val TOTAL_QUESTIONS : String  = "total_questions"
    const val CORRECT_ANSWERS : String = "correct_answers"

    fun getQuestions():ArrayList<Questions>{

        val questionList  = ArrayList<Questions>()

        val ques1 = Questions(1,"What Country does this flag belongs to?",R.drawable.canada_flag,"Argentina","India","China","Canada",4)


        val ques2 = Questions(2,"What Country does this flag belongs to?",R.drawable.india_flag,"Argentina","India","China","Canada",2)

        val ques3 = Questions(3,"What Country does this flag belongs to?",R.drawable.nepal_flag,"Nepal","India","China","Bangladesh",1)

        val ques4 = Questions(4,"What Country does this flag belongs to?",R.drawable.china_flag,"Japan","India","China","Canada",3)

        val ques5 = Questions(5,"What Country does this flag belongs to?",R.drawable.argentina_flag,"Argentina","India","USA","Brazil",1)

        val ques6 = Questions(6,"What Country does this flag belongs to?",R.drawable.southkorea_flag,"South Korea","North Korea","China","Japan",1)

        val ques7 = Questions(7,"What Country does this flag belongs to?",R.drawable.srilanka_flag,"India","Sri Lanka","China","Canada",2)

        val ques8 = Questions(8,"What Country does this flag belongs to?",R.drawable.usa_flag,"Argentina","England","USA","Canada",3)

        val ques9 = Questions(1,"What Country does this flag belongs to?",R.drawable.russia_flag,"Russia","India","China","Canada",1)

        questionList.add(ques1)
        questionList.add(ques2)
        questionList.add(ques3)
        questionList.add(ques4)
        questionList.add(ques5)
        questionList.add(ques6)
        questionList.add(ques7)
        questionList.add(ques8)
        questionList.add(ques9)
        return questionList
    }
}