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


object NavRoutes {
    const val PROFILE = "profile"
    const val PROJECT_LIST = "project_list"
    // O {projectId} entre chaves indica um argumento dinâmico na rota
    const val PROJECT_DETAIL = "project_detail/{projectId}"


    fun projectDetail(projectId: Int) = "project_detail/$projectId"
}


@Composable
fun AppNavGraph(
    navController: NavHostController,
    startDestination: String = NavRoutes.PROFILE  // Tela inicial padrão
) {


    NavHost(
        navController = navController,
        startDestination = startDestination
    ) {
        // ROTA 1: Tela de Perfil (tela inicial)
        composable(route = NavRoutes.PROFILE) {
            ProfileScreen(
                onNavigateToProjects = {

                    navController.navigate(NavRoutes.PROJECT_LIST)
                }
            )
        }

        // ROTA 2: Tela de Lista de Projetos
        composable(route = NavRoutes.PROJECT_LIST) {
            ProjectListScreen(
                onNavigateBack = {

                    navController.popBackStack()
                },
                onProjectClick = { projectId ->

                    navController.navigate(NavRoutes.projectDetail(projectId))
                }
            )
        }

        // ROTA 3: Tela de Detalhes do Projeto

        composable(
            route = NavRoutes.PROJECT_DETAIL,

            arguments = listOf(
                navArgument("projectId") {
                    type = NavType.IntType  // O argumento é um número inteiro
                    defaultValue = 0  // Valor padrão caso algo dê errado
                }
            )
        ) { backStackEntry ->

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