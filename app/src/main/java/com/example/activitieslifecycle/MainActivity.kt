package com.example.activitieslifecycle

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import com.example.activitieslifecycle.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    // Obrigatório - quando starta a activity é ele quem é chamado
    // Evite operações pesadas
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        Log.i("Log", "Foi criado na primeira " + System.currentTimeMillis())
    }

    // Executado quando o onCreate termina, ela entra em um estado de inicada, passando a ser visível
    // Operações pesadas
    override fun onStart() {
        super.onStart()

        Log.i("Log", "Foi startado na primeira " + System.currentTimeMillis())
    }

    // Invocado imediatamente antes da acitivity começar a interagir com o usuário
    // Não quer dizer que seja a primeira vez que ela é criada
    // Exemplo no botão, a cada interação ele startou e resumiu
    override fun onResume() {
        super.onResume()

        Log.i("Log", "Foi resumido na primeira " + System.currentTimeMillis())

        binding.button.setOnClickListener {
            startActivity(Intent(this, DetailsActivity::class.java))
        }
    }

    // Invocada quando a activity sai de foco
    // Perdeu o foco ela entra em uma espécie de foco
    // Player de midea é um bom exemplo, mesmo estando fora de foco, ela continua funcionando
    // Não executar transações, salvar dados, fazer chamadas
    // Activity está perdendo a prioridade aqui
    override fun onPause() {
        super.onPause()

        Log.i("Log", "Foi pausado na primeira " + System.currentTimeMillis())
    }

    // Executado depois do onPause
    // Pode ocorrer devido a activity estar sendo destruida/retomada
    // Para qualquer ação
    override fun onStop() {
        super.onStop()

        Log.i("Log", "Foi totalmente pausado na primeira " + System.currentTimeMillis())
    }

    // Quando a activity está destruida
    // Literalmente quando a activity morre, ele é acionado
    // Usado quado deseja fazer uma ultima ação na activity, antes dela ser de fato destruida
    override fun onDestroy() {
        super.onDestroy()

        Log.i("Log", "Foi totalmente desturido na primeira " + System.currentTimeMillis())
    }

}