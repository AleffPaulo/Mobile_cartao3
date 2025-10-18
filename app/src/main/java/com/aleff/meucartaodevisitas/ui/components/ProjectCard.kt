package com.aleff.meucartaodevisitas.ui.components


import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import com.aleff.meucartaodevisitas.model.Project

// Este componente representa visualmente um projeto na lista
// É um exemplo perfeito de composição: um componente reutilizável que pode ser
// usado em qualquer lugar do aplicativo
@Composable
fun ProjectCard(
    project: Project,
    onClick: () -> Unit,  // Função callback que será executada quando o card for clicado
    modifier: Modifier = Modifier
) {
    // O Card é um componente do Material Design 3 que fornece elevação e shape
    // Ele cria aquela aparência de "flutuação" sobre o fundo
    Card(
        modifier = modifier
            .fillMaxWidth()  // Ocupa toda a largura disponível
            .padding(horizontal = 16.dp, vertical = 8.dp)  // Margem externa
            .clickable { onClick() },  // torna inclinavel
        elevation = CardDefaults.cardElevation(
            defaultElevation = 4.dp  // Sombra de 4dp para dar sensação de profundidade
        ),
        colors = CardDefaults.cardColors(
            containerColor = MaterialTheme.colorScheme.surfaceVariant
        )
    ) {
        // Column organiza os elementos verticalmente dentro do card
        Column(
            modifier = Modifier
                .padding(16.dp)  // Padding interno do card
                .fillMaxWidth(),
            verticalArrangement = Arrangement.spacedBy(8.dp)
        ) {
            // Título do projeto em destaque
            Text(
                text = project.name,
                style = MaterialTheme.typography.titleLarge,
                fontWeight = FontWeight.Bold,
                color = MaterialTheme.colorScheme.onSurfaceVariant
            )

            // Descrição do projeto com limite de linhas
            // maxLines = 3 garante que a descrição não ocupe muito espaço
            // overflow especifica o que fazer quando o texto é muito longo
            Text(
                text = project.description,
                style = MaterialTheme.typography.bodyMedium,
                color = MaterialTheme.colorScheme.onSurfaceVariant.copy(alpha = 0.8f),
                maxLines = 3,  // Limita a 3 linhas
                overflow = TextOverflow.Ellipsis  // Adiciona "..." no final se for muito longo
            )

            // Chip mostrando as tecnologias usadas
            // Esta é uma forma elegante de destacar informações secundárias
            Surface(
                modifier = Modifier.padding(top = 4.dp),
                color = MaterialTheme.colorScheme.primaryContainer,
                shape = MaterialTheme.shapes.small
            ) {
                Text(
                    text = project.technologies,
                    style = MaterialTheme.typography.labelMedium,
                    color = MaterialTheme.colorScheme.onPrimaryContainer,
                    modifier = Modifier.padding(horizontal = 12.dp, vertical = 6.dp)
                )
            }
        }
    }
}