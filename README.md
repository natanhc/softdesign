# softdesign

Esse projeto foi desenvolvido como parte de um teste, que propôs desenvolver um sistema back-end para gerir as sessões de uma votação.

# O QUE É NECESSÁRIO PARA EXECUTÁ-LO?

1 Para que as informações não sejam perdidas após encerramento da aplicação, os dados são salvos em um banco de dados MySQL. É necessário que uma
instância esteja ativa com um banco de dados chamado "voto", e a partir daí a aplicação irá criar os esquemas necessários via JPA.

2 As chamados serão utilizadas via métodos REST, que podem ser encontradas no link https://www.getpostman.com/collections/1ed1c5c10259cb65c9cc

3 Os métodos utilizados foram escolhidos por serem de uso muito comum na rotina de programação do autor e na tentativa de tornar o código mais simples e compacto.

4 Procurou-se segmentar o máximo possível a lógica em métodos específicos e menores, para permitir, em casos hipotéticos, a manutenibilidade de alguma função.

5 Para testar a validade de alguns métodos, optou-se por utilizar o JUnit

# OBSERVAÇÕES

1 O serviço externo de validação de CPF (a API https://user-info.herokuapp.com/users/{cpf}), não retorna sempre ABLE para um CPF válido, às vezes retornando UNABLE para um mesmo CPF que foi validado por ela anteriormente.

2 Como não foi desenvolvido um front-end, o encerramento de um sessão após determinado tempo foi criado como um serviço que pode ser consumido externamente.
