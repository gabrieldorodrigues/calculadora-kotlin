package com.example.calculadora

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.lifecycle.ViewModelProvider
import com.example.calculadora.ui.theme.CalculatorTheme // Corrigido o caminho do pacote para o tema

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val calculatorViewModel = ViewModelProvider(this)[CalculatorViewModel::class.java]

        setContent {
            CalculatorTheme {
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                    Calculator(
                        modifier = Modifier.padding(innerPadding),
                        viewModel = calculatorViewModel
                    )
                }
            }
        }
    }
}

// Função de visualização prévia
@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    val calculatorViewModel = CalculatorViewModel() // Simulação de um ViewModel para a prévia
    CalculatorTheme {
        Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
            Calculator(
                modifier = Modifier.padding(innerPadding),
                viewModel = calculatorViewModel
            )
        }
    }
}
