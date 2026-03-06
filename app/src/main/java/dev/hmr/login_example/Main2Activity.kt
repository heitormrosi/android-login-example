package dev.hmr.login_example

import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import dev.hmr.login_example.databinding.ActivityMain2Binding

class Main2Activity : AppCompatActivity() {
    private lateinit var binding: ActivityMain2Binding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        enableEdgeToEdge()

        this.binding = ActivityMain2Binding.inflate(layoutInflater)

        setContentView(this.binding.root)

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        val login = intent.getStringExtra("LOGIN_USUARIO") ?: "Desconhecido"

        this.binding.txtUsuario.text = "Bem-vindo, $login!"

        initListeners()
    }

    fun initListeners() {
        this.binding.sair.setOnClickListener {
            finish()
        }
    }
}