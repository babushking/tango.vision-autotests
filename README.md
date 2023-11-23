# 
# Проект по автоматизации тестирования  компании [Tango.vision](https://tango.vision/)
<p  align="center">
<a href="https://dostavka.magnit.ru"><img src="src/test/resources/images/logo/Group 7.png" width="950"></a>
</p>
Tango Vision это облачная платформа для повышения эффективности управления коммерческой недвижимостью.
Цифровизация зданий позволяет значительно повысить уровень услуг, предоставляемых в них.

## **Содержание:**
____

* <a href="#tools">Технологии и инструменты</a>

* <a href="#cases">Примеры автоматизированных тест-кейсов</a>

* <a href="#jenkins">Сборка в Jenkins</a>

* <a href="#console">Запуск из терминала</a>

* <a href="#allure">Allure отчет</a>

* <a href="#allure-testops">Интеграция с Allure TestOps</a>

* <a href="#telegram">Уведомление в Telegram при помощи бота</a>

* <a href="#video">Примеры видео выполнения тестов на Selenoid</a>
____
<a id="tools"></a>
## <a name="Технологии и инструменты">**Технологии и инструменты:**</a>

<p align="center">  
<a href="https://www.jetbrains.com/idea/"><img src="src/test/resources/images/logo/Intelij_IDEA.svg" width="50" height="50"  alt="IDEA"/></a>  
<a href="https://www.java.com/"><img src="src/test/resources/images/logo/Java.svg" width="50" height="50"  alt="Java"/></a>  
<a href="https://github.com/"><img src="src/test/resources/images/logo/Github.svg" width="50" height="50"  alt="Github"/></a>  
<a href="https://junit.org/junit5/"><img src="src/test/resources/images/logo/JUnit5.svg" width="50" height="50"  alt="JUnit 5"/></a>  
<a href="https://gradle.org/"><img src="src/test/resources/images/logo/Gradle.svg" width="50" height="50"  alt="Gradle"/></a>  
<a href="https://selenide.org/"><img src="src/test/resources/images/logo/Selenide.svg" width="50" height="50"  alt="Selenide"/></a>  
<a href="https://aerokube.com/selenoid/"><img src="src/test/resources/images/logo/Selenoid.svg" width="50" height="50"  alt="Selenoid"/></a>  
<a href="ht[images](images)tps://github.com/allure-framework/allure2"><img src="src/test/resources/images/logo/Allure.svg" width="50" height="50"  alt="Allure"/></a> 
<a href="https://qameta.io/"><img src="src/test/resources/images/logo/Allure2.svg" width="50" height="50"  alt="Allure TestOps"/></a>   
<a href="https://www.jenkins.io/"><img src="src/test/resources/images/logo/Jenkins.svg" width="50" height="50"  alt="Jenkins"/></a>  
<a href="https://www.atlassian.com/ru/software/jira/"><img src="src/test/resources/images/logo/Jira.svg" width="50" height="50"  alt="Jira"/></a>  
</p>

____
<a id="cases"></a>
## <a name="Примеры автоматизированных тест-кейсов">**Примеры автоматизированных тест-кейсов:**</a>
____
- ✓ *Проверка авторизации пользователя*
- ✓ *Проверка создания нового здания*
- ✓ *Проверка клонирования здания*
- ✓ *Проверка создания магазина*
- ✓ *Проверка добавления описания магазина*
- ✓ *Проверка создания новой категории*
- ✓ *Проверка добавления порядкового номера каталога*



____
<a id="jenkins"></a>
## <img alt="Jenkins" height="25" src="src/test/resources/images/logo/Jenkins.svg" width="25"/></a><a name="Сборка"></a>Сборка в [Jenkins](https://jenkins.autotests.cloud/job/tango.vision_autotests/)</a>
____
<p align="center">  
<a href="https://jenkins.autotests.cloud/job/tango.vision_autotests/"><img src="src/test/resources/images/screen/allure1.png" alt="Jenkins" width="950"/></a>  
</p>


### **Параметры сборки в Jenkins:**

- *browser (браузер, по умолчанию chrome)*
- *browserVersion (версия браузера, по умолчанию 100.0)*
- *browserSize (размер окна браузера, по умолчанию 1920x1080)*
- *baseUrl (адрес тестируемого веб-сайта)*
- *remoteUrl (логин, пароль и адрес удаленного сервера Selenoid)*

<a id="console"></a>
## Команды для запуска из терминала
___
***Локальный запуск:***
```bash  
gradle clean test
```

***Удалённый запуск через Jenkins:***
```bash  
clean test
"-Dbrowser=${browser}"
"-DbrowserVersion=${browserVersion}"
"-DbrowserSize=${browserSize}"
"-DbaseUrl=${baseUrl}"
"-DremoteUrl=${remoteUrl}"
```
___
<a id="allure"></a>
## <img alt="Allure" height="25" src="src/test/resources/images/logo/Allure.svg" width="25"/></a> <a name="Allure"></a>Allure [отчет](https://jenkins.autotests.cloud/job/tango.vision_autotests/61/allure/#)</a>
___

### *Основная страница отчёта*

<p align="center">  
<img title="Allure Overview Dashboard" src="src/test/resources/images/screen/allure2.png" width="850">  
</p>  

### *Тест-кейсы*

<p align="center">  
<img title="Allure Tests" src="src/test/resources/images/screen/allure behavlors1.png" width="850">  
</p>

### *Графики*

  <p align="center">  
<img title="Allure Graphics" src="src/test/resources/images/screen/allureGraphs1.png" width="850">

<img title="Allure Graphics" src="src/test/resources/images/screen/allureGraphs2.png" width="850">  
</p>

___
<a id="allure-testops"></a>
## <img alt="Allure" height="25" src="src/test/resources/images/logo/Allure2.svg" width="25"/></a>Интеграция с <a target="_blank" href="https://allure.autotests.cloud/project/2197/dashboards">Allure TestOps</a>
____
### *Allure TestOps Dashboard*

<p align="center">  
<img title="Allure TestOps Dashboard" src="src/test/resources/images/screen/allureTestops1.png" width="850">  
</p>  

### *Тест-кейсы*

<p align="center">  
<img title="Allure TestOps Tests" src="src/test/resources/images/screen/allureTestopsAtotests.png" width="850">  
</p>

____
<a id="telegram"></a>
## <img alt="Allure" height="25" src="src/test/resources/images/logo/Telegram.svg" width="25"/></a> Уведомление в Telegram при помощи бота
____
<p align="center">  
<img title="Allure Overview Dashboard" src="src/test/resources/images/screen/telegram notifications.png" width="550">  
</p>

____
<a id="video"></a>
## <img alt="Selenoid" height="25" src="src/test/resources/images/logo/Selenoid.svg" width="25"/></a> Примеры видео выполнения тестов на Selenoid
____
<p align="center">
<img title="Selenoid Video" src="src/test/resources/images/video/videoCreateShop.gif" width="550" height="350"  alt="video">   
</p>

TV_FirstTest