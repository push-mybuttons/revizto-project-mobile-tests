# 📱 Revizto Mobile Tests - Дипломный проект

Автоматизированное тестирование мобильной версии сайта [Revizto](https://revizto.com) с использованием Selenide, JUnit 5 и Allure Reports.

![Java](https://img.shields.io/badge/Java-17-orange)
![Selenide](https://img.shields.io/badge/Selenide-6.19.1-green)
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
- **Selenide 6.19.1** - фреймворк для автоматизации UI тестов
- **JUnit 5** - фреймворк для запуска тестов
- **Gradle 8.10** - система сборки
- **Allure Reports 2.21.0** - система отчетности
- **Owner 1.0.12** - библиотека для работы с конфигурацией
- **WebDriverManager 5.3.2** - автоматическое управление драйверами
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

## 📊 Allure отчет

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


<img width="1510" height="866" alt="image" src="https://github.com/user-attachments/assets/d3465a17-ee05-4608-819b-7dc45790aaf6"/>


### Пример отчета с группировкой:

- **Epic**: Мобильное тестирование Revizto
  - **Feature**: Лендинг страница
    - **Story**: Проверка основных элементов лендинга
    - **Story**: Проверка навигации
    - **Story**: Проверка интерактивных элементов


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

**MariiaP**  
Дипломный проект по автоматизации тестирования

---


