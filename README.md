## Arquivo Java para Busca de CEP

Este arquivo Java cria uma interface gráfica para buscar informações relacionadas a um CEP (Código de Endereçamento Postal) utilizando a API do site República Virtual.

### Funcionalidades Principais:

1. **Interface Gráfica:**
   - Cria uma janela com campos para inserir o CEP e exibir informações como logradouro, bairro, cidade e UF (Unidade Federativa).

2. **Busca de CEP:**
   - Ao inserir um CEP válido e clicar no botão "Buscar", o programa faz uma requisição à API da República Virtual para obter informações do endereço associado ao CEP.
   - A API utilizada é a do site República Virtual (http://cep.republicavirtual.com.br), que fornece dados de endereçamento postal para CEPs brasileiros.

3. **Limpar Campos:**
   - O botão "Limpar" permite limpar todos os campos da interface para realizar uma nova busca.

4. **Sobre:**
   - Ao clicar no ícone de informação, abre uma janela com informações sobre o programa.

### Observações:
- O arquivo também inclui importações de classes necessárias para a construção da interface gráfica e manipulação de eventos, como `javax.swing`, `java.awt`, entre outras.
- O método `buscarCep()` é responsável por fazer a requisição à API e processar os dados retornados para preencher os campos na interface.

Para mais informações sobre a API da República Virtual, consulte a documentação oficial em http://cep.republicavirtual.com.br/web_cep.php.

Autor: [kelvynnS](https://github.com/kelvynS)
