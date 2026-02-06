#  CONVERSOR HTML TO PDF

## 🛠️ Como Funciona (Arquitetura)


1.  **Camada de Template (Resources/Templates):** Define a estrutura visual da guia (presumi que fosse para impressão de guias no prosefa) usando HTML5 e CSS3. Utilizamos o motor **Thymeleaf** para permitir que dados futuros sejam injetados no documento.
2.  **Camada de Serviço (PdfService):** Atua como o motor de conversão. Ele utiliza a biblioteca **OpenHTMLtoPDF** para renderizar o código HTML e transformá-lo em um fluxo de bytes (`byte[]`) compatível com o padrão PDF/A.
3.  **Camada de Controle (GuiaController):** Gere o protocolo HTTP. Quando o endpoint é acionado, ele solicita o PDF ao serviço e configura os **Cabeçalhos (Headers)** de resposta para forçar o download automático no computador do utilizador.

## 🚀 Como Implementar e Testar

### 1. Requisitos Prévios
* Java JDK 21 ou superior instalado.
* Gradle (incluído no projeto via Wrapper).

### 2. Configuração e Execução
1.  Abra o projeto no IntelliJ IDEA ou VS Code.
2.  Sincronize as dependências do Gradle (o projeto baixará automaticamente o `openhtmltopdf`).
3.  Execute a aplicação:
    ```bash
    ./gradlew bootRun
    ```
4.  A API estará disponível em: `http://localhost:8080`

### 3. Gerar o PDF
Aceda ao seguinte endereço no navegador para iniciar o download automático do PDF gerado:
`http://localhost:8080/guias/baixar`
