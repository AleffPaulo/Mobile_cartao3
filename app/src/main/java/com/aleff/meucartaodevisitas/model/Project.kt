package com.aleff.meucartaodevisitas.model

// Uma data class é perfeita para representar dados simples
// O Kotlin automaticamente gera métodos úteis como equals(), hashCode(), toString() e copy()
// Isso significa menos código boilerplate para você escrever
data class Project(
    val id: Int,              // Identificador único do projeto
    val name: String,         // Nome curto e descritivo do projeto
    val description: String,  // Descrição mais detalhada do que o projeto faz
    val technologies: String  // Tecnologias utilizadas no projeto
)

// Esta lista representa dados mockados (falsos) para desenvolvimento
// Em um aplicativo real, esses dados viriam de uma API ou banco de dados
// Usar dados mockados nos permite focar na construção da UI sem nos preocuparmos
// com a conexão à internet ou configuração de backend ainda
val mockProjects = listOf(
    Project(
        id = 1,
        name = "Aplicativo de Receitas Culinárias",
        description = "Um aplicativo completo para gerenciar e descobrir novas receitas. " +
                "Inclui timer de cozimento, conversor de medidas, lista de compras integrada " +
                "e modo passo a passo para acompanhar enquanto cozinha. Os usuários podem " +
                "favoritar receitas e criar coleções personalizadas.",
        technologies = "Kotlin, Jetpack Compose, Room Database, Retrofit"
    ),
    Project(
        id = 2,
        name = "Gerenciador de Finanças Pessoais",
        description = "Controle completo das suas despesas e receitas mensais. Apresenta " +
                "gráficos interativos para visualizar gastos por categoria, permite definir " +
                "orçamentos e recebe alertas quando se aproximar dos limites. Inclui " +
                "categorização automática de transações usando machine learning.",
        technologies = "Kotlin, Compose, MPAndroidChart, Firebase"
    ),
    Project(
        id = 3,
        name = "App de Treinos e Exercícios",
        description = "Planeje seus treinos semanais, acompanhe seu progresso com gráficos " +
                "de evolução e receba sugestões personalizadas de exercícios baseadas nos " +
                "seus objetivos. Inclui vídeos demonstrativos, contador de repetições e " +
                "histórico detalhado de todos os treinos realizados.",
        technologies = "Kotlin, Jetpack Compose, ExoPlayer, Room"
    ),
    Project(
        id = 4,
        name = "Leitor de Notícias Inteligente",
        description = "Agregador de notícias que reúne conteúdo de múltiplas fontes confiáveis. " +
                "Permite personalização por categoria de interesse, salva artigos para leitura " +
                "offline e utiliza algoritmos de recomendação para sugerir conteúdo relevante. " +
                "Interface limpa e focada na experiência de leitura.",
        technologies = "Kotlin, Compose, Retrofit, WorkManager, Room"
    ),
    Project(
        id = 5,
        name = "Aplicativo de Meditação e Mindfulness",
        description = "Sessões guiadas de meditação para diferentes momentos do dia e objetivos " +
                "específicos. Inclui biblioteca de sons relaxantes da natureza, timer " +
                "personalizável, acompanhamento do seu bem-estar mental com journaling e " +
                "lembretes inteligentes para manter a consistência da prática.",
        technologies = "Kotlin, Jetpack Compose, Media3, DataStore"
    ),
    Project(
        id = 6,
        name = "Organizador de Tarefas e Produtividade",
        description = "Gerencie suas tarefas diárias com técnica Pomodoro integrada. " +
                "Permite criar projetos, definir prioridades, estabelecer prazos e visualizar " +
                "seu progresso através de estatísticas detalhadas. Sincronização em nuvem " +
                "permite acesso de múltiplos dispositivos.",
        technologies = "Kotlin, Compose, Firebase, WorkManager"
    )
)