
Usuário pré-existente para autenticação:
```
Login: admin
Senha: 123456 
```
ou se preferir usar o header `"Authorization": "Basic YWRtaW46MTIzNDU2"`

Comando docker para baixar imagem e rodar a aplicação: 
```
docker run -p 5000:5000 rnldfll/softplan
```
A aplicação irá rodar na porta `5000`.
Para acessar a interface de teste de API (Swagger) o link é: <http://localhost:5000/swagger-ui.html>
Para acessar o banco de dados de teste da aplicação: 
<http://localhost:5000/h2-console> ao entrar digitar no campo JDBC URL: `jdbc:h2:file:~/softplan/softplan_test`
O front-end requer as dependências: *nodejs, grunt e bower*.
Caso queira rodar o front-end localmente será necessário rodar dentro da pasta client os comandos:
```
npm install
bower install
grunt serve
```
A aplicação front-end também está rodando na AWS pelo link: <http://ec2-18-231-36-134.sa-east-1.compute.amazonaws.com:9000>
