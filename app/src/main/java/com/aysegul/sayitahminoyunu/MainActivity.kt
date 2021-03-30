package com.aysegul.sayitahminoyunu

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.aysegul.sayitahminoyunu.databinding.ActivityMainBinding
import java.util.*
import kotlin.random.Random

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding= ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        var skor = 100
        val randomSayi = Random.nextInt(1,100)
        binding.button.setOnClickListener {
            if( skor != 0){
                skor = SayiTahmini(skor, randomSayi)
                var skorText = getString(R.string.skorunuz)
                binding.textView3.text = skorText + skor.toString()
            }
        }
    }

    private fun SayiTahmini(skor:Int, randomSayi:Int) : Int {
        var skorN = skor

        if(skor >= 1 ) {
            val number = binding.textInputEditText.text.toString()
            if(number == randomSayi.toString()) {
                var numberText = getString(R.string.tebrikler_puaniniz)
                binding.textView2.text = numberText + skor.toString()
                return skorN
            }

            else if(number < randomSayi.toString()) {
                skorN--
                binding.textView2.text = getString(R.string.daha_buyuk)
                return skorN
            }

            else if (number > randomSayi.toString()) {
                skorN--
                binding.textView2.text = getString(R.string.daha_kucuk)
                return skorN
            }
        }
        return 0
    }

}