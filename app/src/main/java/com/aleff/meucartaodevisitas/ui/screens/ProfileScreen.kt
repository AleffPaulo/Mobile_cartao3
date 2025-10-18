package com.aleff.meucartaodevisitas.ui.screens

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.AvTimer
import androidx.compose.material.icons.filled.Email
import androidx.compose.material.icons.filled.EmojiEmotions
import androidx.compose.material.icons.filled.Phone
import androidx.compose.material.icons.filled.LocationOn
import androidx.compose.material3.*
import androidx.compose.material3.HorizontalDivider
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import com.aleff.meucartaodevisitas.R
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll

// Esta é a tela principal do cartão de visitas
// O parâmetro onNavigateToProjects será uma função que leva à tela de projetos
@Composable
fun ProfileScreen(
    onNavigateToProjects: () -> Unit = {},  // Valor padrão vazio para preview
    modifier: Modifier = Modifier
) {
    // Column organiza os elementos verticalmente, um embaixo do outro
    Column(
        modifier = modifier
            .fillMaxSize()  // Ocupa toda a tela disponível
            .background(MaterialTheme.colorScheme.background)
            .verticalScroll(rememberScrollState())
            .padding(24.dp),  // Espaçamento interno de 24dp em todos os lados
        horizontalAlignment = Alignment.CenterHorizontally,  // Centraliza horizontalmente
        verticalArrangement = Arrangement.spacedBy(16.dp)  // Espaço de 16dp entre elementos
    ) {

        Spacer(modifier = Modifier.height(32.dp))

        Box(
            modifier = Modifier
                .size(150.dp)  // Tamanho quadrado de 150dp
                .clip(CircleShape)  // Recorta em formato circular
                .background(MaterialTheme.colorScheme.primaryContainer),
            contentAlignment = Alignment.Center
        ) {
            Icon(
                imageVector = Icons.Default.EmojiEmotions,  // Ícone temporário
                contentDescription = "Foto de perfil",
                modifier = Modifier.size(80.dp),
                tint = MaterialTheme.colorScheme.onPrimaryContainer
            )
        }

        Spacer(modifier = Modifier.height(8.dp))

        // Nome completo
        Text(
            text = "Aleff Paulo Silva Nogueira",
            style = MaterialTheme.typography.headlineLarge,
            fontWeight = FontWeight.Bold,
            color = MaterialTheme.colorScheme.onBackground
        )

        // PROFISSÃO
        Text(
            text = "Desenvolvedor Mobile | Estudante de Sistemas para Internet",
            style = MaterialTheme.typography.titleMedium,
            color = MaterialTheme.colorScheme.onSurfaceVariant
        )

        Spacer(modifier = Modifier.height(24.dp))

        // CONTATO
        Card(
            modifier = Modifier.fillMaxWidth(),
            colors = CardDefaults.cardColors(
                containerColor = MaterialTheme.colorScheme.surfaceVariant
            )
        ) {
            Column(
                modifier = Modifier.padding(16.dp),
                verticalArrangement = Arrangement.spacedBy(12.dp)
            ) {
                // Email
                ContactItem(
                    icon = Icons.Default.Email,
                    label = "Email",
                    value = "aleffpaulosilvanogueira@gmail.com"
                )

                HorizontalDivider(Modifier, DividerDefaults.Thickness, DividerDefaults.color)

                // Telefone
                ContactItem(
                    icon = Icons.Default.Phone,
                    label = "Telefone",
                    value = "(84) 99991-6845" ,
                )

                HorizontalDivider(Modifier, DividerDefaults.Thickness, DividerDefaults.color)

                // Localização
                ContactItem(
                    icon = Icons.Default.LocationOn,
                    label = "Localização",
                    value = "Mossoró, RN"
                )
            }
        }

        Spacer(modifier = Modifier.height(16.dp))

        // "Sobre Mim"
        Card(
            modifier = Modifier.fillMaxWidth(),
            colors = CardDefaults.cardColors(
                containerColor = MaterialTheme.colorScheme.surfaceVariant
            )
        ) {
            Column(
                modifier = Modifier.padding(16.dp)
            ) {
                Text(
                    text = "Sobre Mim",
                    style = MaterialTheme.typography.titleLarge,
                    fontWeight = FontWeight.Bold,
                    color = MaterialTheme.colorScheme.onSurfaceVariant
                )

                Spacer(modifier = Modifier.height(8.dp))

                Text(
                    text = "Estudante apaixonado por tecnologia e desenvolvimento mobile. " +
                            "Focado em criar aplicativos que fazem diferença na vida das pessoas. " +
                            "Sempre buscando aprender novas tecnologias e melhores práticas.",
                    style = MaterialTheme.typography.bodyLarge,
                    color = MaterialTheme.colorScheme.onSurfaceVariant
                )
            }
        }

        Spacer(modifier = Modifier.weight(1f))

        // Botão para navegar aos projetos
        Button(
            onClick = onNavigateToProjects,
            modifier = Modifier
                .fillMaxWidth()
                .height(56.dp),
            colors = ButtonDefaults.buttonColors(
                containerColor = MaterialTheme.colorScheme.primary
            )
        ) {
            Text(
                text = "Ver Meus Projetos",
                style = MaterialTheme.typography.titleMedium,
                fontWeight = FontWeight.Bold
            )
        }

        Spacer(modifier = Modifier.height(16.dp))
    }
}

// Componente reutilizável para itens de contato
// Este padrão de criar componentes pequenos e reutilizáveis é fundamental no Compose
@Composable
private fun ContactItem(
    icon: androidx.compose.ui.graphics.vector.ImageVector,
    label: String,
    value: String
) {
    Row(
        modifier = Modifier.fillMaxWidth(),
        horizontalArrangement = Arrangement.spacedBy(12.dp),
        verticalAlignment = Alignment.CenterVertically
    ) {
        Icon(
            imageVector = icon,
            contentDescription = label,
            tint = MaterialTheme.colorScheme.primary,
            modifier = Modifier.size(24.dp)
        )

        Column {
            Text(
                text = label,
                style = MaterialTheme.typography.labelMedium,
                color = MaterialTheme.colorScheme.onSurfaceVariant.copy(alpha = 0.7f)
            )
            Text(
                text = value,
                style = MaterialTheme.typography.bodyLarge,
                color = MaterialTheme.colorScheme.onSurfaceVariant
            )
        }
    }
}

