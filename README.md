## Trabalho Prático — Microsserviços + DevOps

Este projeto implementa uma arquitetura de microsserviços baseada em Spring Boot, integrando novos serviços a um ecossistema existente, utilizando Docker para orquestração, API Gateway para roteamento e GitHub Actions para CI (Integração Contínua).

---

## 🏗️ Arquitetura do Sistema

O sistema é composto por 5 containers Docker rodando simultaneamente:

1.  **Naming Server (Eureka) `[Porta 8761]`**: Servidor de descoberta onde todos os serviços se registram.
2.  **API Gateway `[Porta 8765]`**: Ponto único de entrada. Redireciona chamadas externas para os microsserviços internos.
3.  **Currency Exchange `[Porta 8000]`**: Serviço legado conectado ao banco de dados (H2).
4.  **Currency Report `[Porta 8200]` (Novo)**: Consome o *Exchange* via **Feign Client** e retorna uma cotação consolidada com timestamp.
5.  **Currency History `[Porta 8300]` (Novo)**: Retorna um histórico de valores fictícios (mockados).

---

## 🚀 Como Executar

**Pré-requisitos:** Docker e Docker Compose instalados.

1.  **Subir o ambiente:**
    Na raiz do projeto, execute o comando para compilar e iniciar os containers:
    ```bash
    docker compose up -d --build
    ```

2.  **Aguardar Inicialização:**
    Aguarde cerca de **1 a 2 minutos** para que todos os serviços Java iniciem e se registrem no Naming Server.

3.  **Verificar Status:**
    ```bash
    docker compose ps
    ```
    *Certifique-se de que os containers `currency-report`, `currency-history`, `api-gateway` e `naming-server` estão com status "Up".*

---

## 🧪 Como Testar (Endpoints)

Todas as requisições devem ser enviadas para o **API Gateway** na porta **8765**.

### 1. Testar Microsserviço A (Report)
*Integração Síncrona entre Microserviços.*

* **Comando:**
    ```bash
    curl "http://localhost:8765/quote?from=USD&to=INR"
    ```
* **Retorno Esperado (JSON):**
    ```json
    {
      "from": "USD",
      "to": "INR",
      "price": 65.0,
      "timestamp": "2025-11-26T10:30:15..."
    }
    ```

### 2. Testar Microsserviço B (History)
*Dados Mockados.*

* **Comando:**
    ```bash
    curl "http://localhost:8765/history?from=USD&to=BRL"
    ```
* **Retorno Esperado (JSON):**
    ```json
    {
      "from": "USD",
      "to": "BRL",
      "values": [
          { "price": 5.85, "timestamp": "..." },
          { "price": 5.19, "timestamp": "..." }
      ]
    }
    ```

---

