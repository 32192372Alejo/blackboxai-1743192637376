package com.example.interviewsimulator

import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.cardview.widget.CardView
import android.widget.RadioGroup
import android.widget.Button
import android.widget.ImageButton

class InterviewSelectionActivity : AppCompatActivity() {
    
    private lateinit var btnBack: ImageButton
    private lateinit var cvTechnical: CardView
    private lateinit var cvSales: CardView
    private lateinit var rgDifficulty: RadioGroup
    private lateinit var btnStartSimulation: Button
    private lateinit var btnFAQ: Button
    
    private var selectedInterviewType: String? = null
    
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_interview_selection)
        
        initializeViews()
        setupListeners()
    }
    
    private fun initializeViews() {
        btnBack = findViewById(R.id.btnBack)
        cvTechnical = findViewById(R.id.cvTechnical)
        cvSales = findViewById(R.id.cvSales)
        rgDifficulty = findViewById(R.id.rgDifficulty)
        btnStartSimulation = findViewById(R.id.btnStartSimulation)
        btnFAQ = findViewById(R.id.btnFAQ)
    }
    
    private fun setupListeners() {
        btnBack.setOnClickListener {
            finish()
        }
        
        cvTechnical.setOnClickListener {
            selectedInterviewType = "technical"
            highlightSelectedCard(cvTechnical)
        }
        
        cvSales.setOnClickListener {
            selectedInterviewType = "sales"
            highlightSelectedCard(cvSales)
        }
        
        btnStartSimulation.setOnClickListener {
            if (selectedInterviewType == null) {
                Toast.makeText(this, "Por favor seleccione un tipo de entrevista", Toast.LENGTH_SHORT).show()
                return@setOnClickListener
            }
            
            val selectedDifficulty = when (rgDifficulty.checkedRadioButtonId) {
                R.id.rbEasy -> "easy"
                R.id.rbNormal -> "normal"
                R.id.rbHard -> "hard"
                else -> {
                    Toast.makeText(this, "Por favor seleccione un nivel de dificultad", Toast.LENGTH_SHORT).show()
                    return@setOnClickListener
                }
            }
            
            startInterview(selectedInterviewType!!, selectedDifficulty)
        }
        
        btnFAQ.setOnClickListener {
            // Navigate to FAQ screen
            // startActivity(Intent(this, FAQActivity::class.java))
        }
    }
    
    private fun highlightSelectedCard(selectedCard: CardView) {
        // Reset all cards
        cvTechnical.setCardBackgroundColor(getColor(R.color.card_background))
        cvSales.setCardBackgroundColor(getColor(R.color.card_background))
        
        // Highlight selected card
        selectedCard.setCardBackgroundColor(getColor(R.color.blue_button))
    }
    
    private fun startInterview(type: String, difficulty: String) {
        // Start the interview simulation
        // val intent = Intent(this, InterviewSimulationActivity::class.java).apply {
        //     putExtra("type", type)
        //     putExtra("difficulty", difficulty)
        // }
        // startActivity(intent)
    }
}