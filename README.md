# 📱 Revizto Mobile Tests - Дипломный проект

Автоматизированное тестирование мобильной версии сайта [Revizto](https://revizto.com) с использованием Selenide, JUnit 5 и Allure Reports.

![Java](https://img.shields.io/badge/Java-17-orange)
![Selenide](https://github.com/push-mybuttons/resources/blob/main/icons/Selenide.svg)
![JUnit5](https://img.shields.io/badge/JUnit-5.9.3-blue)
![Gradle](https://img.shields.io/badge/Gradle-8.10-yellow)

---

## 📋 Содержание

- [Технологии и инструменты](#-технологии-и-инструменты)
- [Покрытый функционал](#-покрытый-функционал)
- [Структура проекта](#-структура-проекта)
- [Запуск тестов](#-запуск-тестов)
- [Jenkins Integration](#-jenkins-integration)
- [Allure отчет](#-allure-отчет)
- [Особенности реализации](#-особенности-реализации)

---

## 🛠 Технологии и инструменты

<p>
<img src="https://github.com/devicons/devicon/blob/master/icons/java/java-original.svg" title="Java" alt="Java" width="40" height="40"/>&nbsp;
<img src="https://github.com/selenide/selenide-logo/raw/main/logo/selenide-logo-128x128.png" title="Selenide" alt="Selenide" width="40" height="40"/>&nbsp;
<img src="https://github.com/devicons/devicon/blob/master/icons/gradle/gradle-original.svg" title="Gradle" alt="Gradle" width="40" height="40"/>&nbsp;
<img src="https://github.com/devicons/devicon/blob/master/icons/junit/junit-original.svg" title="JUnit5" alt="JUnit5" width="40" height="40"/>&nbsp;
<img src="https://avatars.githubusercontent.com/u/5879127?s=200&v=4" title="Allure Report" alt="Allure Report" width="40" height="40"/>&nbsp;
<img src="https://avatars.githubusercontent.com/u/1119453?s=200&v=4" title="Browserstack" alt="Browserstack" width="40" height="40"/>&nbsp;
<img src="https://github.com/devicons/devicon/blob/master/icons/jenkins/jenkins-original.svg" title="Jenkins" alt="Jenkins" width="40" height="40"/>&nbsp;
</p>

### Основной стек:

- **Java 17** - язык программирования
- **Selenide** - фреймворк для автоматизации UI тестов
- **JUnit 5** - фреймворк для запуска тестов
- **Gradle** - система сборки
- **Allure Reports** - система отчетности
- **Owner** - библиотека для работы с конфигурацией
- **WebDriverManager** - автоматическое управление драйверами
- **Browserstack** - облачная платформа для удаленного запуска тестов
- **Jenkins** - CI/CD для автоматического запуска тестов

---

## ✅ Покрытый функционал

Проект содержит автоматизированные тесты для мобильной версии сайта Revizto:

### 🏠 Landing Page Tests (`ReviztoLandingTest`)

1. **Проверка основных элементов лендинга** 🔴 CRITICAL
   - Проверка заголовка "Unifying BIM Intelligence across 2D and 3D"
   - Проверка слогана "Integrated Collaboration Platform"
   - Проверка кнопки "Request a Demo" и ссылки на форму

2. **Проверка навигации и интерфейса** 🔴 CRITICAL
   - Проверка мобильного меню (кнопка и открытие меню)
   - Проверка наличия и корректности логотипа
   - Проверка кнопки "Sign in" и ссылки на страницу входа

3. **Проверка интерактивных элементов** 🟡 NORMAL
   - Проверка выпадающего меню "Solutions"
   - Проверка подпунктов: Architects, Engineers, Contractors, Owners
   - Проверка открытия/закрытия меню по клику

### 📊 Покрытие:
- ✅ **3 тестовых сценария**
- ✅ **Локальный и удаленный запуск** (Browserstack)
- ✅ **Конфигурация через Owner**
- ✅ **Allure Steps** для детального логирования
- ✅ **Attachments**: скриншоты и видео

---

## 📁 Структура проекта

```
revizto-project-mobile-tests/
├── src/test/java/
│   ├── config/
│   │   ├── BrowserstackConfig.java    # Конфигурация для Browserstack
│   │   └── MobileConfig.java          # Общая конфигурация проекта
│   ├── drivers/
│   │   ├── BrowserstackMobileDriver.java  # Драйвер для удаленного запуска
│   │   └── LocalMobileDriver.java         # Драйвер для локального запуска
│   ├── helpers/
│   │   └── Attachments.java           # Вспомогательный класс для Allure
│   └── tests/
│       ├── BaseTest.java              # Базовый класс с конфигурацией
│       └── ReviztoLandingTest.java    # Тесты главной страницы
├── src/test/resources/
│   ├── browserstack.properties        # Настройки Browserstack
│   ├── local.properties               # Настройки локального запуска
│   └── remote.properties              # Настройки удаленного запуска
├── build.gradle                       # Конфигурация сборки
└── README.md
```

---

## 🚀 Запуск тестов

### Локальный запуск (мобильная эмуляция Chrome)

```bash
./gradlew localTest
```

### Удаленный запуск на Browserstack

```bash
./gradlew remoteTest
```

### Запуск с параметрами

```bash
./gradlew test -Denvironment=local
./gradlew test -Denvironment=remote
```

### Генерация и открытие Allure отчета

```bash
./gradlew allureReport
./gradlew openAllureReport
```

### Очистка старых результатов

```bash
./gradlew cleanAllure
```

---

## 🔄 Jenkins Integration

Проект полностью готов к интеграции с Jenkins для автоматического запуска тестов в CI/CD pipeline.

[![Jenkins](https://img.shields.io/badge/Jenkins-Job-blue?logo=jenkins)](https://jenkins.autotests.cloud/job/035-mariia_p-mobile/)
[![Allure Report](https://img.shields.io/badge/Allure-Report-yellow?logo=qameta)](https://jenkins.autotests.cloud/job/035-mariia_p-mobile/allure/)

### 🔗 Jenkins Job

**Ссылка на активную Jenkins Job:** [035-mariia_p-mobile](https://jenkins.autotests.cloud/job/035-mariia_p-mobile/)


### 🚀 Быстрый старт

1. Создайте новый **Pipeline Job** в Jenkins
2. Укажите репозиторий: `https://github.com/push-mybuttons/revizto-project-mobile-tests.git`
3. Script Path: `Jenkinsfile`
4. Сохраните и запустите с параметрами

### ⚙️ Параметры запуска

| Параметр | Значения | Описание |
|----------|----------|----------|
| `ENVIRONMENT` | `local`, `remote` | Окружение для запуска тестов |
| `TASK` | `test`, `clean test` | Gradle задача |
| `DEVICE_NAME` | Строка (опционально) | Имя устройства |
| `PLATFORM_VERSION` | Строка (опционально) | Версия платформы |

### 📊 Возможности Pipeline

- ✅ Автоматическая сборка и запуск тестов
- ✅ Генерация Allure отчетов
- ✅ Архивирование артефактов
- ✅ Публикация JUnit результатов
- ✅ Параметризованный запуск
- ✅ Поддержка локального и Browserstack окружений

### 📖 Подробная документация

Полное руководство по настройке Jenkins доступно в **[JENKINS_SETUP.md](JENKINS_SETUP.md)**, включая:

- Установку необходимых плагинов
- Настройку credentials для Browserstack
- Конфигурацию Allure Commandline
- Настройку уведомлений (Email, Slack)
- Troubleshooting типичных проблем
- Best practices для CI/CD

### 🔗 Пример использования

**Запуск на Browserstack:**
```bash
ENVIRONMENT: remote
TASK: clean test
DEVICE_NAME: Samsung Galaxy S23
PLATFORM_VERSION: 13.0
```

**Локальный запуск:**
```bash
ENVIRONMENT: local
TASK: test
DEVICE_NAME: (оставить пустым)
PLATFORM_VERSION: (оставить пустым)
```

### 📸 Скриншот Jenkins Job:

```
[Вставьте скриншот вашего Jenkins Job]
```

---

## 📊 Allure отчет

### Примеры отчетов:

**🔗 Ссылка на Allure Report в Jenkins:** [View Allure Report](https://jenkins.autotests.cloud/job/035-mariia_p-mobile/allure/)

### Содержание отчета:

- ✅ **Overview** - общая статистика прохождения тестов
- ✅ **Suites** - группировка тестов по классам
- ✅ **Behaviors** - группировка по Epic/Feature/Story
- ✅ **Timeline** - временная шкала выполнения тестов
- ✅ **Attachments** - скриншоты и видео для каждого теста

### Attachments в отчете:

1. **Скриншот** - для каждого теста
2. **Видео** - для удаленного запуска (Browserstack)
3. **Page Source** - HTML код страницы (опционально)
4. **Логи браузера** - консольные логи (опционально)

### 📸 Скриншот Allure Report:

```
[Вставьте скриншот Allure отчета с результатами тестов]
```

### Пример отчета с группировкой:

- **Epic**: Мобильное тестирование Revizto
  - **Feature**: Лендинг страница
    - **Story**: Проверка основных элементов лендинга
    - **Story**: Проверка навигации
    - **Story**: Проверка интерактивных элементов

---

## 🎯 Особенности реализации

### 1. Конфигурация через Owner

Используется библиотека **Owner** для удобного управления конфигурацией:

```java
@Config.Sources({"classpath:remote.properties", "classpath:local.properties"})
public interface MobileConfig extends Config {
    @Key("baseUrl")
    @DefaultValue("https://revizto.com")
    String baseUrl();
}
```

### 2. Два драйвера для разных окружений

- **LocalMobileDriver** - Chrome с мобильной эмуляцией (iPhone 12 Pro)
- **BrowserstackMobileDriver** - реальные устройства в облаке

### 3. BaseTest с автоматической конфигурацией

```java
@BeforeAll
public static void setUp() {
    // Автоматический выбор драйвера на основе environment
    if (isRemoteRun) {
        Configuration.browser = BrowserstackMobileDriver.class.getName();
    } else {
        Configuration.browser = LocalMobileDriver.class.getName();
    }
}

@AfterEach
public void tearDown() {
    // Добавление Allure Attachments
    // Закрытие браузера после каждого теста
    closeWebDriver();
}
```

### 4. Allure Steps для читаемости

```java
step("Проверяем заголовок с BIM", () -> {
    $("h1").shouldHave(text("Unifying BIM Intelligence across 2D and 3D"));
});
```

### 5. Автоматические Attachments

- Скриншот добавляется автоматически после каждого теста
- Видео добавляется только для Browserstack
- Пауза 3 секунды для обработки видео на сервере

---

## 📝 Требования

- **Java 17+**
- **Gradle 8.0+**
- **Chrome Browser** (для локального запуска)
- **Browserstack аккаунт** (для удаленного запуска)

### Настройка Browserstack credentials:

Добавьте в `src/test/resources/browserstack.properties`:

```properties
browserstack.user=your_username
browserstack.key=your_access_key
```

---

## 👨‍💻 Автор

**Mariia Pupkova**  
Дипломный проект по автоматизации тестирования

---

## 📞 Контакты и ссылки

- **Jenkins Job:** [035-mariia_p-mobile](https://jenkins.autotests.cloud/job/035-mariia_p-mobile/)
- **Allure Report:** [View Allure Report](https://jenkins.autotests.cloud/job/035-mariia_p-mobile/allure/)
- **Browserstack Dashboard:** https://automate.browserstack.com/dashboard
- **Revizto Website:** https://revizto.com

---

## 📈 Статистика проекта

- Классов с тестами: **1**
- Тестовых методов: **3**
- Строк кода: **~300**
- Покрытие функционала: **Landing Page Mobile**

---
