# TicketFlow API

API REST para gerenciar e automatizar o acompanhamento de chamados de suporte técnico,
aplicando na prática 10 anos de experiência em Service Desk.

## Tecnologias

- Java 17
- Spring Boot 3
- Spring Data JPA
- H2 Database
- Maven

## Como rodar localmente

1. Clone o repositório
2. Abra a pasta no IntelliJ
3. Rode a classe `TicketflowApplication`
4. A API fica disponível em `http://localhost:8080`

## Endpoints

| Método | URL             | Descrição                    |
|--------|-----------------|-------------------------------|
| GET    | /tickets        | Lista todos os tickets        |
| GET    | /tickets/{id}   | Busca um ticket específico    |
| POST   | /tickets        | Cria um novo ticket           |
| PUT    | /tickets/{id}   | Atualiza status e prioridade  |
| DELETE | /tickets/{id}   | Remove um ticket              |
| GET    | /tickets/status | Verifica se a API está no ar  |

## Exemplo de requisição (POST)

\`\`\`json
{
"titulo": "Impressora não liga",
"descricao": "Setor financeiro, 3º andar",
"prioridade": "MEDIA"
}
\`\`\`

## O que aprendi

Durante o desenvolvimento, pratiquei um aprendizado por tentativa e erro, usando IA
como apoio para entender cada decisão de código — não para copiar soluções prontas
sem contexto, mas para construir lógica própria com confiança.

## Próximos passos

- Adicionar mais funcionalidades (filtros, atribuição de técnico responsável)
- Migrar para um banco de dados persistente (PostgreSQL)
- Escrever testes automatizados para tornar a API mais robusta