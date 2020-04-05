# transaction-acquiring-server

## Installation guide
- `git clone https://github.com/DorofeevMark/transaction-acquiring-server.git`
- `mvn install`
- `sudo mysql --password`
- `create database db_example;`
- `create user 'springuser'@'%' identified by 'ThePassword';`
- `grant all on db_example.* to 'springuser'@'%';`
- `./mvnw spring-boot:run`
- Run https://github.com/DorofeevMark/transaction-acquiring-client
