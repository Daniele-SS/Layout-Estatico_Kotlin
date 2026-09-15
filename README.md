# Arcade Layout Estático (Jetpack Compose)

Este projeto consiste no desenvolvimento do layout estático de um jogo clássico de estilo *arcade* (inspirado em Space Invaders). O objetivo principal do projeto foi estabelecer o primeiro contato prático com o ecossistema de desenvolvimento mobile **Android**, utilizando a linguagem **Kotlin** e o framework moderno **Jetpack Compose**.

---

## 🛠️ Tecnologias e Ferramentas

* **Linguagem Principal:** Kotlin (versão focada em desenvolvimento moderno)
* **Framework de Interface:** Jetpack Compose (UI declarativa)
* **Design System:** Material Design 3
* **Ambiente de Desenvolvimento:** Android Studio

---

## 📌 Conceitos Praticados e Explicados

O desenvolvimento do projeto envolveu a aplicação de conceitos fundamentais da construção de telas nativas no Android:

### 1. Estrutura e Ciclo de Vida Nativo
* **`ComponentActivity` & `onCreate`:** Configuração da porta de entrada da aplicação, onde o ciclo de vida da tela é iniciado.
* **`enableEdgeToEdge()`:** Implementação que permite ao layout do jogo ocupar toda a extensão da tela do dispositivo, estendendo-se por baixo das barras de status e de navegação para maior imersão.
* **`Scaffold`:** Componente de estrutura que gerencia o ciclo de renderização e provê o preenchimento correto (`innerPadding`), evitando que elementos da interface colidam com recortes de câmera ou barras do sistema.

### 2. Organização e Alinhamento de Componentes (Layout)
* **`Column`:** Utilizada para empilhar os blocos principais verticalmente (Painel Superior -> Fileira de Inimigos -> Área de Jogo).
* **`Row`:** Aplicada para posicionar elementos lado a lado na horizontal, como a organização do Placar de pontuação junto com os corações/ícones de vida, além do alinhamento dos inimigos em formatos de fileira.
* **`Spacer` com `Modifier.weight()`:** Uso de propriedades de peso dinâmico para atuar como espaçadores flexíveis. Esse mecanismo empurra os componentes para as extremidades da tela de forma proporcional, garantindo estabilidade visual em diferentes resoluções de tela.

### 3. Componentização e Otimização de Recursos
* **Reutilização com `@Composable`:** Criação da função customizada `AndroidEnemy`. Em vez de duplicar linhas de código para cada inimigo na tela, a lógica de renderização foi isolada em um componente único e parametrizado.
* **Filtros de Cor Dinâmicos (`ColorFilter.tint`):** Técnica para reaproveitar o mesmo recurso gráfico vetorizado (`ic_launcher_foreground`). Modificando apenas a propriedade de cor em tempo de execução, foi possível gerar inimigos de cores distintas (Verde, Vermelho, Azul, Amarelo) sem inflar o tamanho final do instalador do aplicativo com múltiplos arquivos de imagem.

---

## 🚀 Como Executar o Projeto

### Pré-requisitos
* **Android Studio** (versão Ladybug ou superior recomendada).
* **SDK do Android** configurada (**API 27** ou superior).

### Passo a Passo
1. **Clonar o Repositório:**
   ```bash
   git clone https://github.com
   ```
2. **Abrir no Android Studio:**
   * Abra o Android Studio.
   * Selecione a opção **Open** e navegue até a pasta do projeto clonado.
   * Aguarde a indexação e a sincronização dos arquivos do Gradle (pode levar alguns minutos na primeira execução).
3. **Execução:**
   * Conecte um dispositivo físico via Depuração USB ou utilize um Emulador (Virtual Device).
   * Clique no botão **Run** (ícone de play verde) na barra superior ou utilize o atalho `Shift + F10`.
