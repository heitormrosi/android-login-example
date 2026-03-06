package dev.hmr.login_example

import android.content.Intent
import android.os.Bundle
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import dev.hmr.login_example.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()

        this.binding = ActivityMainBinding.inflate(layoutInflater)

        setContentView(this.binding.root)

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        initListeners()
    }

    fun initListeners() {
        this.binding.loginButton.setOnClickListener {
            val login = this.binding.loginInput.text.toString().trim()
            val senha = this.binding.passwordInput.text.toString().trim()

            if(login == "usuario" && senha == "senha") {
                val intent = Intent(this, Main2Activity::class.java)
                intent.putExtra("LOGIN_USUARIO", login)
                startActivity(intent)
            } else {
                Toast
                    .makeText(
                        this,
                        "Login ou senha incorreta.",
                        Toast.LENGTH_SHORT
                    )
                    .show()
            }
        }
    }
}