# ProductServer
REST API сервер (Sring Web, Spring Data JPA, PostgreSQL Driver)

Сервер для работы с базой данных продуктов. 🍌

## Установка
Для запуска необходима база данных PostgreSQL. В [конфигурационном файле](https://github.com/Zera57/ServerJPA/blob/master/src/main/resources/application.properties) для подключения к БД прописать:
* Url;
* Username;
* Password;

Hibernate создаст таблицу и генератор последовательности сам.

## Использование
У сервера есть 4 метода:
* GET {URL}/api/v1/product - выдает все продукты;
* POST {URL}/api/v1/product - добавляет продукт

```
Content-Type: application/json
{
	"name": "Pringles Extra Cheese",
	"description": "Snack",
	"cost": 99,
	"count": 11
};
```
* DELETE {URL}/api/v1/product/{productId} - удаляет продукт по id
* PUT {URL}/api/v1/product/{productId}?{parameter=value}&{parameter=value}... -изменяет параметтры продукта. Можно использовать с одним или несколькими параметрами сразу.
