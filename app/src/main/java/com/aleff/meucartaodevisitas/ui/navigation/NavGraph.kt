package com.aleff.meucartaodevisitas.ui.navigation


import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.navArgument
import com.aleff.meucartaodevisitas.ui.screens.ProfileScreen
import com.aleff.meucartaodevisitas.ui.screens.ProjectDetailScreen
import com.aleff.meucartaodevisitas.ui.screens.ProjectListScreen

// Object para centralizar todas as rotas do aplicativo
// Usar constantes evita erros de digitação e facilita manutenção
object NavRoutes {
    const val PROFILE = "profile"
    const val PROJECT_LIST = "project_list"
    // O {projectId} entre chaves indica um argumento dinâmico na rota
    const val PROJECT_DETAIL = "project_detail/{projectId}"

    // Função auxiliar para criar a rota de detalhes com um ID específico
    // Em vez de concatenar strings manualmente, usamos esta função
    fun projectDetail(projectId: Int) = "project_detail/$projectId"
}

// Esta função configura o sistema de navegação do aplicativo
// É como um mapa que mostra todas as telas e como navegar entre elas
@Composable
fun AppNavGraph(
    navController: NavHostController,
    startDestination: String = NavRoutes.PROFILE  // Tela inicial padrão
) {
    // NavHost é o container que gerencia a navegação
    // Ele mantém uma pilha de telas e controla transições
    NavHost(
        navController = navController,
        startDestination = startDestination
    ) {
        // ROTA 1: Tela de Perfil (tela inicial)
        // Esta é a primeira tela que o usuário vê ao abrir o app
        composable(route = NavRoutes.PROFILE) {
            ProfileScreen(
                onNavigateToProjects = {
                    // Quando o botão "Ver Meus Projetos" for clicado,
                    // navega para a tela de lista de projetos
                    // navigate() adiciona a nova tela no topo da pilha
                    navController.navigate(NavRoutes.PROJECT_LIST)
                }
            )
        }

        // ROTA 2: Tela de Lista de Projetos
        composable(route = NavRoutes.PROJECT_LIST) {
            ProjectListScreen(
                onNavigateBack = {
                    // popBackStack() remove a tela atual da pilha
                    // voltando para a tela anterior (ProfileScreen)
                    // É como pressionar o botão "voltar" do Android
                    navController.popBackStack()
                },
                onProjectClick = { projectId ->
                    // Quando um projeto é clicado, navega para os detalhes
                    // passando o ID do projeto como argumento na URL
                    navController.navigate(NavRoutes.projectDetail(projectId))
                }
            )
        }

        // ROTA 3: Tela de Detalhes do Projeto
        // Esta rota é especial porque aceita um argumento
        composable(
            route = NavRoutes.PROJECT_DETAIL,
            // Define que esta rota aceita um argumento chamado 'projectId'
            arguments = listOf(
                navArgument("projectId") {
                    type = NavType.IntType  // O argumento é um número inteiro
                    defaultValue = 0  // Valor padrão caso algo dê errado
                }
            )
        ) { backStackEntry ->
            // Recupera o argumento da rota
            // backStackEntry contém informações sobre a navegação atual
            // arguments?.getInt() busca o argumento por nome
            val projectId = backStackEntry.arguments?.getInt("projectId") ?: 0

            ProjectDetailScreen(
                projectId = projectId,
                onNavigateBack = {
                    navController.popBackStack()
                }
            )
        }
    }
}