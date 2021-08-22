# Sistema de Recepção de Hotel

## Equipe

### EQUIPE: G12

- 496640 Pedro Igor Azevedo Lásaro
- 495090 José Cleomon da Silva Junior
- 497500 Isabelly de Lima Gonçalves
- 494023 Josué Ferreira Cruz Araújo
- 496357 Jonathan Davi Sampaio Faria

## Descrição do projeto

O projeto é um aplicativo que permite a criação de reservas e o gerenciamento de um sistema simples de hotel, onde um usuário poderia realizar um auto-atendimento e reservar um quarto nas datas de entrada e saída de sua preferência, um usuário pode realizar o checkout de sua reserva e um administrador pode gerenciar os quartos e reservas registradas no sistema. As listas de quartos e Reservas são quardadas em disco usando arquivos.

## Estrutura do projeto

O projeto segue a estrutura MVC (Model View Controller)

1. Model: É a parte lógica da aplicação que gerencia os dados através de regras de negócios, lógica e funções.
2. View: São as telas do aplicativo, usando JavaFX é possível utilizar fxml (um arquivo xml) para construir as interfaces gráficas, e css para definir a aparência dos componentes.
3. Controller: São classes responsáveis por conectar a camada de Model e a camada de View, Cada controller é responsável por gerênciar uma view diferente e conectá-las com os Models necessários.

## Instruções de execução

### Compilação

#### Windows

```shell
./build
```

### Execução

#### Windows/Linux

```shell
./run
```

## Instruções de desenvolvimento

Clone o repositório com o código abaixo:

```shell
git clone https://github.com/jonathandsf/recepcao-hotel.git
```
