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
        //txv.text = "物件導向實例"
        var result: String = ""
        var abap = Course()
        abap.CourseTitle = "ABAP程式設計"
        abap.CreditProgram = "智慧企業"
        abap.SAP = true
        result += abap.Display()
        txv.text = result
    }
}

class Course{
    var CourseTitle: String = ""
    var CreditProgram: String = ""
    var SAP: Boolean = true

    fun Display(): String{
        var info:String = CourseTitle + ":"
        info += CreditProgram + "學程"
        if (SAP) info+= " (搭配SAP系統授課)"
        info+= "\n\n"
        return info
    }
}