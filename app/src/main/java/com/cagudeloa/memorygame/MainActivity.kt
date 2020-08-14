package com.cagudeloa.memorygame

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.databinding.DataBindingUtil
import com.cagudeloa.memorygame.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    private val listNumbers: MutableList<Int> = (1..12).toMutableList()
    private val animals = listOf<Int>(
        R.drawable.butterfly,
        R.drawable.color_parrot,
        R.drawable.dog,
        R.drawable.elephant,
        R.drawable.iguana,
        R.drawable.jellyfish,
        R.drawable.jiraffe,
        R.drawable.leopard,
        R.drawable.lion,
        R.drawable.parrot,
        R.drawable.rabbit,
        R.drawable.sharks,
        R.drawable.white_dog
    )
    var totalScore: Int = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView<ActivityMainBinding>(this,  R.layout.activity_main)

        binding.mainButton.setOnClickListener {
            showAnimals()
        }
    }

    private fun showAnimals() {
        listNumbers.shuffle()
        val selectedAnimal: MutableList<Int> =  (1..13).toMutableList()
        selectedAnimal.shuffle()
        for (i in 1..11 step 2){
            val selectedImage = (1..animals.size).random() -1       // -1 for lists starting on zero
            chooseImageLocation(listNumbers[i-1], selectedAnimal[i]-1)
            chooseImageLocation(listNumbers[i], selectedAnimal[i]-1)
        }
    }

    private fun chooseImageLocation(index: Int, selectedImage: Int){
        val drawableResource = when(index){
            1 -> binding.image1
            2 -> binding.image2
            3 -> binding.image3
            4 -> binding.image4
            5 -> binding.image5
            6 -> binding.image6
            7 -> binding.image7
            8 -> binding.image8
            9 -> binding.image9
            10 -> binding.image10
            11 -> binding.image11
            else -> binding.image12
        }
        drawableResource.setImageResource(animals[selectedImage])
    }
}