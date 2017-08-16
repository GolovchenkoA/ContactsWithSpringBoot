# Contacts (With Spring Boot)
[![Build Status](https://travis-ci.org/GolovchenkoA/ContactsWithSpringBoot.svg?branch=master)](https://travis-ci.org/GolovchenkoA/ContactsWithSpringBoot)
### Настройка пеерд запуском программы

1. Создать пустую базу данных
2. Необходимо внести изменения в файл src/main/resources/application.properties

Значения следующих параметров необходимо заменить:

**Путь к базе данных**<br />
spring.datasource.url=jdbc:postgresql://localhost:5432/contacts2

**Пользователь у которого есть право на подключение и чтение базы данных**<br />
spring.datasource.username=postgres

**Пароль пользователя базы данных**<br />
spring.datasource.password=password

