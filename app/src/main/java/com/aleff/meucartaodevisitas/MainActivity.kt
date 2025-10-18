package com.aleff.meucartaodevisitas

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.ui.Modifier
import androidx.navigation.compose.rememberNavController
import com.aleff.meucartaodevisitas.ui.navigation.AppNavGraph
import com.aleff.meucartaodevisitas.ui.theme.MeuCartaoDeVisitasTheme

// MainActivity é o ponto de entrada do aplicativo Android
// É a primeira coisa que é executada quando o usuário abre o app
class MainActivity : ComponentActivity() {

    // onCreate é chamado quando a Activity é criada
    // savedInstanceState contém dados salvos de uma execução anterior (se houver)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        // setContent define o conteúdo da tela usando Jetpack Compose
        // Todo o código dentro daqui é Compose, não XML tradicional
        setContent {
            // Aplica o tema personalizado que definimos
            MeuCartaoDeVisitasTheme {
                // rememberNavController cria e "lembra" do controlador de navegação
                // "Remember" é crucial: sem ele, o navController seria recriado
                // toda vez que a tela fosse recomposta, perdendo o histórico de navegação
                val navController = rememberNavController()

                // Surface é um container básico do Material Design
                // Fornece cor de fundo e comportamentos do Material Design
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    // Inicia o grafo de navegação
                    // A partir daqui, o sistema de navegação assume o controle
                    AppNavGraph(navController = navController)
                }
            }
        }
    }
}