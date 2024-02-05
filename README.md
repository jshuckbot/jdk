# jdk

## Урок 1. Графические интерфейсы

1. Клиентское приложение должно отправлять сообщения из текстового поля сообщения в серверное приложение по нажатию кнопки или по нажатию клавиши Enter на поле ввода сообщения;
2. Продублировать импровизированный лог (историю) чата в файле;
3. При запуске клиента чата заполнять поле истории из файла, если он существует. Обратите внимание, что чаще всего история сообщений хранится на сервере и заполнение истории чата лучше делать при соединении с сервером, а не при открытии окна клиента. [Решение](lesson_1/src/main/java/ru/gb/)

## Урок 2. Программные интерфейсы

1. Переписать клиент-серверное приложение из первой домашки с учетом знаний о интерфейсах. Разделить классы на отдельные классы: "мозг", "визуальная часть", "репозиторий", (возможны еще классы по желанию, их мы обсуждали на семинаре). Для связи между классами использовать интерфейсы в соответствии с пятым принципом солид. Можно работать со своим проектом, который вы сдавали в первой домашке, а можно работать с моим проектом (ссылка в материалах к уроку)[Решение](lesson_2/src/main/java/ru/gb/)


## Урок 3. Обобщенное программирование

1. Написать класс Калькулятор (необобщенный), который содержит обобщенные статические методы: sum(), multiply(), divide(), subtract(). Параметры этих методов – два числа разного типа, над которыми должна быть произведена операция.
2. Напишите обобщенный метод compareArrays(), который принимает два массива и возвращает true, если они одинаковые, и false в противном случае. Массивы могут быть любого типа данных, но должны иметь одинаковую длину и содержать элементы одного типа по парно.
3. Напишите обобщенный класс Pair, который представляет собой пару значений разного типа. Класс должен иметь методы getFirst(), getSecond() для получения значений каждого из составляющих пары, а также переопределение метода toString(), возвращающее строковое представление пары. Работу сдать в виде ссылки на гит репозиторий. [Решение](lesson_3/src/main/java/ru/gb/)

Урок 4. Коллекции

Создать справочник сотрудников
Необходимо:
1. Создать класс справочник сотрудников, который содержит внутри коллекцию сотрудников - каждый сотрудник должен иметь следующие атрибуты:
- Табельный номер
- Номер телефона
- Имя
 -Стаж
2. Добавить метод, который ищет сотрудника по стажу (может быть список)
3. Добавить метод, который возвращает номер телефона сотрудника по имени (может быть список)
4. Добавить метод, который ищет сотрудника по табельному номеру
5. Добавить метод добавление нового сотрудника в справочник. [Решение](lesson_4/src/main/java/ru/gb/)

## Урок 5. Многопоточность

1. Пять безмолвных философов сидят вокруг круглого стола, перед каждым философом стоит тарелка спагетти.
- Вилки лежат на столе между каждой парой ближайших философов.
- Каждый философ может либо есть, либо размышлять.
- Философ может есть только тогда, когда держит две вилки — взятую справа и слева.
- Философ не может есть два раза подряд, не прервавшись на размышления (можно не учитывать)
- Описать в виде кода такую ситуацию. Каждый философ должен поесть три раза. [Решение](lesson_5/src/main/java/ru/gb/)

## Урок 6. Управление проектом: сборщики проектов

1. В качестве задачи предлагаю вам реализовать код для демонстрации парадокса Монти Холла и наглядно убедиться в верности парадокса (запустить игру в цикле на 1000 и вывести итоговый счет).
Необходимо:
- Создать свой Java Maven или Gradle проект;
- Самостоятельно реализовать прикладную задачу;
- Сохранить результат в HashMap<шаг теста, результат>
Вывести на экран статистику по победам и поражениям. [Решение](lesson_6/src/main/java/ru/gb/)