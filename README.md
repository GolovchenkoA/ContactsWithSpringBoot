# Contacts (With Spring Boot)
[![Build Status](https://travis-ci.org/GolovchenkoA/ContactsWithSpringBoot.svg?branch=master)](https://travis-ci.org/GolovchenkoA/ContactsWithSpringBoot)
[![codecov](https://codecov.io/gh/GolovchenkoA/ContactsWithSpringBoot/branch/master/graph/badge.svg)](https://codecov.io/gh/GolovchenkoA/ContactsWithSpringBoot)
### Настройка перед запуском программы

1. Создать пустую базу данных
2. Необходимо внести изменения в файл src/main/resources/application.properties

Значения следующих параметров необходимо заменить:

* **Путь к базе данных**<br />
###### _spring.datasource.url=jdbc:postgresql://localhost:5432/contacts2_

* **Пользователь у которого есть право на подключение и чтение базы данных**<br />
###### _spring.datasource.username=postgres_

* **Пароль пользователя базы данных**<br />
###### _spring.datasource.password=password_
<br />
3. Сборка проекта</br>

```sh
mvnw clean package 
```
</br>
Сборка проекта с использованием кэширующего сервера Hazelcast<br />

```sh
mvnw clean package -P hazelcast
```
4. Запуск программы
```sh
java -jar .\ContactsWithSpringBoot-[current_version].jar
```

* **блок _[current_version]_ необходимо заменить на текущую версию программы**
* **команду необходимо выполнять из папки project\target**

</br>
</br>
</br>
</br>

## Запуск тестов

#### Выполнение только unit-тестов
```sh
mvnw clean test
```
#### Выполнение всех тестов
```sh
mvnw clean verify -Phazelcast
```