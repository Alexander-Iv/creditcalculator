### Запуск приложения
1. docker-compose -f ./creditcalculator/docker-compose.yml up -d --build database
2. задать переменные окружения:
    - APP_HOST=localhost:5432
    - APP_DB=creditcalculatordb
    - APP_USER=creditcalculator
    - APP_PASSWORD=yZnaaX4ZeIeVdahDedQQ
3. выполнить ./gradlew clean build в для ./creditcalculator/backend
4. docker-compose -f ./creditcalculator/docker-compose.yml up -d backend
5. docker-compose -f ./creditcalculator/docker-compose.yml up -d frontend

Примечение:
1. backend разворачивается на 8080;
2. frontend разворачнивается на 8081;
3. не реализованы валидаторы;
4. не доделано взаимодействие frontend -> backend
