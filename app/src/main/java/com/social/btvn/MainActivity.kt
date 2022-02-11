package com.social.btvn

import android.app.Dialog
import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.social.btvn.databinding.ActivityMainBinding
import kotlin.random.Random

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    private var soA = 0
    private var soB = 0
    private var ketQua = 0
    private var diem = 0
    private var random = Random(100)
    override fun onCreate(savedInstanceState: Bundle?) {
        binding = ActivityMainBinding.inflate(layoutInflater)
        super.onCreate(savedInstanceState)
        setContentView(binding.root)
        start()
        binding.imgCheck.setOnClickListener {
            if (soA + soB == ketQua) {
                diem++
                binding.tvDiem.text = diem.toString()
                start()
            } else {
                showDialog()
            }
        }
        binding.imgCancel.setOnClickListener {
            if (soA + soB != ketQua) {
                diem++
                binding.tvDiem.text = diem.toString()
                start()
            } else {
                showDialog()
                start()
            }
        }
    }

    fun start() {
        soA = random.nextInt(100)
        soB = random.nextInt(100)

        val resultIndex = random.nextInt(2)

        binding.tvSoA.text = soA.toString()
        binding.tvSoB.text = soB.toString()

        if (resultIndex == 0) {
            ketQua = random.nextInt(200)
            binding.tvKetQua.text = ketQua.toString()
        } else {
            ketQua = soA + soB
            binding.tvKetQua.text = ketQua.toString()
        }
    }

    fun showDialog() {
        val dialog = Dialog(this)
        dialog.setContentView(R.layout.dialog)
        dialog.show()
        diem = 0
        binding.tvDiem.text = diem.toString()
        start()
    }
}