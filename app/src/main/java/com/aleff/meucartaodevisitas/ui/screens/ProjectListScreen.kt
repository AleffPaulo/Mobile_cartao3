package com.aleff.meucartaodevisitas.ui.screens


import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.ArrowBack
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import com.aleff.meucartaodevisitas.model.mockProjects
import com.aleff.meucartaodevisitas.ui.components.ProjectCard


@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun ProjectListScreen(
    onNavigateBack: () -> Unit,
    onProjectClick: (Int) -> Unit,
    modifier: Modifier = Modifier
) {

    Scaffold(
        topBar = {
            // TopAppBar cria a barra superior com título e ícones
            TopAppBar(
                title = {
                    Text(
                        "Meus Projetos",
                        fontWeight = FontWeight.Bold
                    )
                },
                navigationIcon = {
                    // Botão de voltar que chama a função onNavigateBack
                    IconButton(onClick = onNavigateBack) {
                        Icon(
                            imageVector = Icons.AutoMirrored.Filled.ArrowBack,
                            contentDescription = "Voltar para o perfil"
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

        LazyColumn(
            modifier = modifier
                .fillMaxSize()
                .padding(paddingValues),  // Respeita o padding do Scaffold (TopBar)
            contentPadding = PaddingValues(vertical = 8.dp)  // Padding interno da lista
        ) {
            // Cabeçalho opcional da lista
            item {
                Card(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(horizontal = 16.dp, vertical = 8.dp),
                    colors = CardDefaults.cardColors(
                        containerColor = MaterialTheme.colorScheme.secondaryContainer
                    )
                ) {
                    Column(
                        modifier = Modifier.padding(16.dp)
                    ) {
                        Text(
                            text = "Portfólio de Projetos",
                            style = MaterialTheme.typography.titleLarge,
                            fontWeight = FontWeight.Bold,
                            color = MaterialTheme.colorScheme.onSecondaryContainer
                        )
                        Spacer(modifier = Modifier.height(4.dp))
                        Text(
                            text = "Explore os projetos que desenvolvi utilizando tecnologias modernas",
                            style = MaterialTheme.typography.bodyMedium,
                            color = MaterialTheme.colorScheme.onSecondaryContainer.copy(alpha = 0.8f)
                        )
                    }
                }
            }


            items(
                items = mockProjects,
                key = { project -> project.id }  // Key única para cada item (importante para performance)
            ) { project ->
                ProjectCard(
                    project = project,
                    onClick = {
                        onProjectClick(project.id)
                    }
                )
            }

            // Item de rodapé da lista
            item {
                Spacer(modifier = Modifier.height(8.dp))
                Text(
                    text = "${mockProjects.size} projetos no total",
                    style = MaterialTheme.typography.bodySmall,
                    color = MaterialTheme.colorScheme.onBackground.copy(alpha = 0.6f),
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(16.dp)
                )
            }
        }
    }
}