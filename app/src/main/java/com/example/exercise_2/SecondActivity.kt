package com.example.exercise_2

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView

class SecondActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_second)

        val tvNumber = findViewById<TextView>(R.id.tvNumber)

        val number = intent.getStringExtra("EXTRA_NUMBER")

        tvNumber.text = converter(number!!.toInt())
    }
}

fun converter(randomInt: Int) : String {
    val units = arrayOf("ნული", "ერთი", "ორი", "სამი", "ოთხი", "ხუთი", "ექვსი", "შვიდი", "რვა", "ცხრა", )
    val teens = arrayOf("თერთმეტი", "თორმეტი", "ცამეტი", "თოთხმეტი", "თხუთმეტი", "თექვსმეტი", "ჩვიდმეტი", "თვრამეტი", "ცხრამეტი", )
    val tens = arrayOf("ათი", "ოცი", "ოცდაათი", "ორმოცი","ორმოცდაათი", "სამოცი", "სამოცდაათი", "ოთხმოცი", "ოთხმოცდაათი",)
    val hundreds = arrayOf("ასი", "ორასი", "სამასი", "ოთხასი", "ხუთასი", "ექვსასი", "შვიდასი", "რვაასი", "ცხრაასი",)

    var randomNumber =  randomInt

    if(randomNumber < 0){
        return "ციფრი/რიცხვი უნდა იყოს დადებითი (კეთილიც :D)"
    }


    val word = mutableListOf<String>()
    val aseulebi = mutableListOf<String>()


    val hundredsDigit = randomNumber / 100
    val tensAndOnes = randomNumber % 100


    val twenties = tensAndOnes / 20
    val afterTwenties = tensAndOnes % 20

    var result : String = ""

//  main code
        if (randomNumber < 10) {
//      0..9
            word.add(units[randomNumber])
        } else if (randomNumber == 10) {
//        10
            word.add(tens[0])
        } else if (randomNumber in 11..19) {
//      11..19
            word.add(teens[randomNumber - 11])
        } else if (tensAndOnes != 0) {

//        20..99
            if (tensAndOnes % 10 == 0) {
//                10-20-30..90
                word.add(tens[tensAndOnes / 10 - 1])
            } else {
//                twenties

                if (twenties > 0) {

                    word.add("${tens[twenties + (twenties - 1)].removeSuffix("ი")}და")
                }
//                digits
                if (afterTwenties < 10) {
                    word.add(units[afterTwenties])
                } else {

                    word.add(teens[afterTwenties - 11])
                }
            }
        }
//  hundreds and a thousand
        if (randomNumber in 100..1000) {

            if (randomNumber == 1000) {
                aseulebi.add("ათასი")
            } else if (tensAndOnes == 0) {
                aseulebi.add(hundreds[hundredsDigit - 1])
            } else {
                aseulebi.add(hundreds[hundredsDigit - 1].removeSuffix("ი"))
            }
        }


    result = "${randomNumber} ქართულად არის: ${aseulebi.joinToString("")} ${word.joinToString("")}"
    return result
}