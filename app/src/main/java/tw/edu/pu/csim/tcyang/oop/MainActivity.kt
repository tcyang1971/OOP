package tw.edu.pu.csim.tcyang.oop

import android.os.Bundle
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class MainActivity : AppCompatActivity() {

    lateinit var txv: TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
        txv = findViewById(R.id.txv)

        var result: String = ""
        var abap = Course("ABAP程式設計", "智慧企業")
        result += abap.Display()

        var app = Course("行動應用軟體開發", "人工智慧應用", false)
        result += app.Display()
        txv.text = result

    }
}

class Course(var CourseTitle: String= "",
             var CreditProgram: String = "",
             var SAP: Boolean = true){

    init {
        this.CourseTitle = CourseTitle + "課程"
    }

    fun Display(): String{
        var info:String = CourseTitle + ":"
        info += CreditProgram + "學程"
        if (SAP) info+= " (搭配SAP系統授課)"
        info+= "\n\n"
        return info
    }
}