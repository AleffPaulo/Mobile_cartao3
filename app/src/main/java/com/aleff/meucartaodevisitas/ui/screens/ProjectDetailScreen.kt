package com.aleff.meucartaodevisitas.ui.screens


import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.ArrowBack
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material.icons.filled.Code
import androidx.compose.material.icons.filled.Info
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import com.aleff.meucartaodevisitas.model.mockProjects

// Esta tela mostra os detalhes completos de um projeto específico
// Ela recebe o ID do projeto e busca os dados correspondentes na lista mockada
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun ProjectDetailScreen(
    projectId: Int,  // ID do projeto que foi clicado na lista
    onNavigateBack: () -> Unit,  // Função para voltar à lista
    modifier: Modifier = Modifier
) {
    // Busca o projeto correspondente na lista usando o ID
    // A função 'find' percorre a lista e retorna o primeiro item que satisfaz a condição
    // Se não encontrar nenhum, retorna null
    val project = mockProjects.find { it.id == projectId }

    Scaffold(
        topBar = {
            TopAppBar(
                title = {
                    Text(
                        "Detalhes do Projeto",
                        fontWeight = FontWeight.Bold
                    )
                },
                navigationIcon = {
                    IconButton(onClick = onNavigateBack) {
                        Icon(
                            imageVector = Icons.AutoMirrored.Filled.ArrowBack,
                            contentDescription = "Voltar para lista de projetos"
                        )
                    }
                },
                colors = TopAppBarDefaults.topAppBarColors(
                    containerColor = MaterialTheme.colorScheme.primaryContainer,
                    titleContentColor = MaterialTheme.colorScheme.onPrimaryContainer,
                    navigationIconContentColor = MaterialTheme.colorScheme.onPrimaryContainer
                )
            )
        }
    ) { paddingValues ->
        // O operador '?.' é o "safe call": só executa se project não for null
        // O operador '?:' é o "Elvis operator": fornece um valor padrão se for null
        project?.let { projectData ->
            // Se o projeto foi encontrado, exibe seus detalhes
            Column(
                modifier = modifier
                    .fillMaxSize()
                    .padding(paddingValues)
                    .verticalScroll(rememberScrollState())  // Permite rolagem vertical
                    .padding(24.dp),
                verticalArrangement = Arrangement.spacedBy(20.dp)
            ) {
                // Card destacando o ID do projeto (requisito da atividade)
                Card(
                    colors = CardDefaults.cardColors(
                        containerColor = MaterialTheme.colorScheme.tertiaryContainer
                    )
                ) {
                    Row(
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(16.dp),
                        horizontalArrangement = Arrangement.spacedBy(12.dp),
                        verticalAlignment = Alignment.CenterVertically
                    ) {
                        Icon(
                            imageVector = Icons.Default.Info,
                            contentDescription = "Informação",
                            tint = MaterialTheme.colorScheme.onTertiaryContainer,
                            modifier = Modifier.size(32.dp)
                        )
                        Column {
                            Text(
                                text = "ID do Projeto",
                                style = MaterialTheme.typography.labelLarge,
                                color = MaterialTheme.colorScheme.onTertiaryContainer.copy(alpha = 0.8f)
                            )
                            Text(
                                text = projectData.id.toString(),
                                style = MaterialTheme.typography.headlineMedium,
                                fontWeight = FontWeight.Bold,
                                color = MaterialTheme.colorScheme.onTertiaryContainer
                            )
                        }
                    }
                }

                // Nome do projeto em destaque
                Text(
                    text = projectData.name,
                    style = MaterialTheme.typography.headlineLarge,
                    fontWeight = FontWeight.Bold,
                    color = MaterialTheme.colorScheme.onBackground
                )

                HorizontalDivider(
                    thickness = 2.dp,
                    color = MaterialTheme.colorScheme.primary
                )

                // Seção de descrição
                DetailSection(
                    title = "Descrição do Projeto",
                    icon = Icons.Default.Info
                ) {
                    Text(
                        text = projectData.description,
                        style = MaterialTheme.typography.bodyLarge,
                        color = MaterialTheme.colorScheme.onBackground,
                        lineHeight = MaterialTheme.typography.bodyLarge.lineHeight.times(1.5f)
                    )
                }

                // Seção de tecnologias
                DetailSection(
                    title = "Tecnologias Utilizadas",
                    icon = Icons.Default.Code
                ) {
                    // Divide as tecnologias por vírgula e cria um chip para cada uma
                    val techs = projectData.technologies.split(",").map { it.trim() }

                    FlowRow(
                        modifier = Modifier.fillMaxWidth(),
                        horizontalArrangement = Arrangement.spacedBy(8.dp),
                        verticalArrangement = Arrangement.spacedBy(8.dp)
                    ) {
                        techs.forEach { tech ->
                            TechnologyChip(technology = tech)
                        }
                    }
                }

                Spacer(modifier = Modifier.height(16.dp))

                // Informação adicional
                Card(
                    colors = CardDefaults.cardColors(
                        containerColor = MaterialTheme.colorScheme.secondaryContainer.copy(alpha = 0.5f)
                    )
                ) {
                    Text(
                        text = "💡 Este é um projeto do meu portfólio demonstrando minhas habilidades e experiências.",
                        style = MaterialTheme.typography.bodyMedium,
                        color = MaterialTheme.colorScheme.onSecondaryContainer,
                        modifier = Modifier.padding(16.dp)
                    )
                }
            }
        } ?: run {
            // Se o projeto não foi encontrado (projeto == null), mostra mensagem de erro
            Box(
                modifier = modifier
                    .fillMaxSize()
                    .padding(paddingValues),
                contentAlignment = Alignment.Center
            ) {
                Column(
                    horizontalAlignment = Alignment.CenterHorizontally,
                    verticalArrangement = Arrangement.spacedBy(16.dp)
                ) {
                    Text(
                        text = "😕",
                        style = MaterialTheme.typography.displayLarge
                    )
                    Text(
                        text = "Projeto não encontrado",
                        style = MaterialTheme.typography.titleLarge,
                        fontWeight = FontWeight.Bold,
                        color = MaterialTheme.colorScheme.onBackground
                    )
                    Text(
                        text = "O projeto com ID $projectId não existe na base de dados.",
                        style = MaterialTheme.typography.bodyMedium,
                        color = MaterialTheme.colorScheme.onBackground.copy(alpha = 0.7f)
                    )
                    Spacer(modifier = Modifier.height(8.dp))
                    Button(onClick = onNavigateBack) {
                        Text("Voltar para lista")
                    }
                }
            }
        }
    }
}

// Componente auxiliar para seções de detalhes com ícone
@Composable
private fun DetailSection(
    title: String,
    icon: androidx.compose.ui.graphics.vector.ImageVector,
    content: @Composable () -> Unit
) {
    Column(
        verticalArrangement = Arrangement.spacedBy(12.dp)
    ) {
        Row(
            horizontalArrangement = Arrangement.spacedBy(8.dp),
            verticalAlignment = Alignment.CenterVertically
        ) {
            Icon(
                imageVector = icon,
                contentDescription = null,
                tint = MaterialTheme.colorScheme.primary,
                modifier = Modifier.size(24.dp)
            )
            Text(
                text = title,
                style = MaterialTheme.typography.titleLarge,
                fontWeight = FontWeight.Bold,
                color = MaterialTheme.colorScheme.onBackground
            )
        }

        content()
    }
}

// Componente para exibir cada tecnologia como um chip
@Composable
private fun TechnologyChip(technology: String) {
    Surface(
        color = MaterialTheme.colorScheme.primaryContainer,
        shape = MaterialTheme.shapes.medium,
        tonalElevation = 2.dp
    ) {
        Text(
            text = technology,
            style = MaterialTheme.typography.bodyMedium,
            fontWeight = FontWeight.Medium,
            color = MaterialTheme.colorScheme.onPrimaryContainer,
            modifier = Modifier.padding(horizontal = 16.dp, vertical = 8.dp)
        )
    }
}