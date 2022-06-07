### Exchange Rate

Репозиторий содержит сервис, который обращается к сервису курсов валют, и отображает в зависимости от увеличения или уменьшения курса рандомную гифку c тегом "rich" или "broke".

АPI:
• REST API курсов валют - https://docs.openexchangerates.org

• REST API гифок - https://developers.giphy.com

Функционал

Кнопка "сравнить" для сравнения текущего курса выбранной валюты с предыдущим рабочим днём, также можно вернуться назад для выбора другой валюты с помощью кнопки "назад".

Стек:
Spring Boot 2, Gradle, Java, API (Feign), Thymeleaf.
