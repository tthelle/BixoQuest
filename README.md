# BixoQuest

BixoQuest é um simulador de vida acadêmica em formato de RPG desenvolvido em Java utilizando a arquitetura MVC (Model-View-Controller). O jogo coloca o jogador no papel de um estudante de Engenharia de Computação, onde o objetivo é gerir atributos pessoais, frequentar aulas, realizar avaliações e interagir com o campus para concluir o curso com sucesso.

# Funcionalidades

- Gestão de Atributos: Controle de Energia, Saúde, Motivação, Conhecimento, Dinheiro e Desempenho Académico;
- Sistema de Disciplinas: Grade curricular realística com pré-requisitos, controlo de faltas e aulas assistidas;
- Locais do Campus: Visite locais como o Bandejão, Cantina, Biblioteca, Laboratório LESS e Colegiado;
- Eventos Aleatórios: Enfrente situações inesperadas como "Prova Surpresa", "Bug no Código", "Ar-condicionado quebrado" ou encontros com amigos;
- Dinâmicas de Mundo: Sistema de clima (semanas de calor ou frio) que afeta o gasto de energia, além da possibilidade de greves;
- Interação com NPCs: Converse com amigos, professores, animais do campus e com Maeli no colegiado do curso.

# Estrutura do código

O projeto está organizado em:

- model: Contém as classes de dados e entidades (Jogador, Disciplina, Local, NPC, Evento, Mundo);
- repository: Responsável pela inicialização e armazenamento dos dados estruturais, como a grade curricular e os locais do campus;
- service: Contém a lógica do projeto, incluindo o processamento de avaliações, cálculos de notas, gestão de eventos e regras do mundo.
