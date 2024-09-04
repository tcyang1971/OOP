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
        //abap.x = "X"
        //abap.y = "Y" //y是private

        result += Course.Add() + abap.Display()

        var app = Course("行動應用軟體開發", "人工智慧應用", false)
        result += Course.Add() + app.Display()

        var tcyang = Teacher("楊子青","資管系")
        result += tcyang.Hello() + tcyang.Work()

        var George = Student("George","資管系")
        result += George.Hello() + George.Work()

        var McQueen = Car()
        var Kitty = Cat()
        result+= McQueen.Sound() + "\n" + Kitty.Sound()

        txv.text = result

    }
}

class Course(var CourseTitle: String= "",
             var CreditProgram: String = "",
             var SAP: Boolean = true){

    //public/private測試
    var x: String = ""
    private var y: String = ""

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

    companion object{
        var count: Int = 0
        fun Add():String{
            count++
            return "第" + count.toString() + "門課程：\n"
        }
    }

}

open class Person(var Name:String){
    open fun Hello():String{
        return Name + "，您好！\n"
    }
}

open class Teacher(Name:String, var dep:String):Person(Name){
    open fun Work():String{
        return "任職於" + dep + "\n\n"
    }
}

class Student(Name:String, dep:String):Teacher(Name,dep){
    override fun Work():String{
        return "就讀於" + dep + "\n\n"
    }
}


interface A{
    fun Sound():String
}

class Car: A {
    override fun Sound(): String {
        return "汽車叭叭叭"
    }
}

class Cat: A {
    override fun Sound():String {
        return "貓咪喵喵喵"
    }
}

