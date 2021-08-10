# Sistema de Recepção de Hotel

## Equipe

# EQUIPE: G12

- 496640 Pedro Igor Azevedo Lásaro
- 495090 José Cleomon da Silva Junior
- 497500 Isabelly de Lima Gonçalves
- 494023 Josué Ferreira Cruz Araújo
- 496357 Jonathan Davi Sampaio Faria

## Estrutura do projeto

O projeto segue a estrutura MVC (Model View Controller)

1. Model: São as classes que foram definidas anteriormente.
2. View: São as telas do aplicativo.
3. Controller: São classes responsáveis por conectar a camada de Model e a camada de View.

## Instruções de desenvolvimento

Para começar clone o repositório com o código abaixo (considerando que já tem o git instalado, caso não [clique aqui](https://git-scm.com/book/pt-br/v2/Come%C3%A7ando-Instalando-o-Git) para saber como):

```shell
git clone https://github.com/jonathandsf/recepcao-hotel.git
```

[Aqui](https://rogerdudler.github.io/git-guide/index.pt_BR.html) tem um guia básico de git.

Nós vamos trabalhar sempre em galhos diferentes do git, quem for trabalhar nas classes A, B e C cria um branch novo e faz as modificações nele, quem for trabalhar nas classes X, Y e Z cria outro branch e faz as modificações nele. Quando as modificações estiverem prontas você faz um push para o repositório do github e caso não haja nenhum conflito a gente junta com o branch principal.

## Observações

1. Utilizar o seguinte argumento aou iniciar o app com o comando java

```shell
--module-path ./lib/javafx-sdk-11.0.2/lib --add-modules javafx.controls,javafx.fxml
```
