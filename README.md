# Лабораторная работа #2
### На основе базового класса Pokemon написать свои классы для заданных видов покемонов. Каждый вид покемона должен иметь один или два типа и стандартные базовые характеристики:

> - очки здоровья (HP)
> - атака (attack)
> - защита (defense)
> - специальная атака (special attack)
> - специальная защита (special defense)
> - скорость (speed)
### Классы покемонов должны наследоваться в соответствии с цепочкой эволюции покемонов. На основе базовых классов PhysicalMove, SpecialMove и StatusMove реализовать свои классы для заданных видов атак. Все разработанные классы, не имеющие наследников, должны быть реализованы таким образом, чтобы от них нельзя было наследоваться.

### Атака должна иметь стандартные тип, силу (power) и точность (accuracy). Должны быть реализованы стандартные эффекты атаки. Назначить каждому виду покемонов атаки в соответствии с вариантом. Уровень покемона выбирается минимально необходимым для всех реализованных атак.

### Используя класс симуляции боя Battle, создать 2 команды покемонов (каждый покемон должен иметь имя) и запустить бой.

### Базовые классы и симулятор сражения находятся в jar-архиве (обновлен 9.10.2018, исправлен баг с добавлением атак и кодировкой). Документация в формате javadoc - здесь.

### Информацию о покемонах, цепочках эволюции и атаках можно найти на сайтах http://poke-universe.ru, http://pokemondb.net, http://veekun.com/dex/pokemon
---
# Комментарии
### Цель работы:
#### На простом примере разобраться с основными концепциями ООП и научиться использовать их в программах.

### Что надо сделать (краткое описание)

> - Ознакомиться с документацией, обращая особое внимание на классы Pokemon и Move. При дальнейшем выполнении лабораторной работы читать документацию еще несколько раз.
> - Скачать файл Pokemon.jar. Его необходимо будет использовать как для компиляции, так и для запуска программы. Распаковывать его не надо! Нужно научиться подключать внешние jar-файлы к своей программе.
> - Написать минимально работающую программу и посмотреть как она работает.
```java
Battle b = new Battle();
Pokemon p1 = new Pokemon("Чужой", 1);
Pokemon p2 = new Pokemon("Хищник", 1);
b.addAlly(p1);
b.addFoe(p2);
b.go();
```
> - Создать один из классов покемонов для своего варианта. Класс должен наследоваться от базового класса Pokemon. В конструкторе нужно будет задать типы покемона и его базовые характеристики. После этого попробуйте добавить покемона в сражение.
> - Создать один из классов атак для своего варианта (лучше всего начать с физической или специальной атаки). Класс должен наследоваться от класса PhysicalMove или SpecialMove. В конструкторе нужно будет задать тип атаки, ее силу и точность. После этого добавить атаку покемону и проверить ее действие в сражении. Не забудьте переопределить метод describe, чтобы выводилось нужное сообщение.
> - Если действие атаки отличается от стандартного, например, покемон не промахивается, либо атакующий покемон также получает повреждение, то в классе атаки нужно дополнительно переопределить соответствующие методы (см. документацию). При реализации атак, которые меняют статус покемона (наследники StatusMove), скорее всего придется разобраться с классом Effect. Он позволяет на один или несколько ходов изменить состояние покемона или модификатор его базовых характеристик.
> - Доделать все необходимые атаки и всех покемонов, распределить покемонов по командам, запустить сражение.
---
## Покемоны:

<image src="./lab2/optional_files/photos/pokemons.png" alt="Покемоны">

---
> ### Точка входа - Main.java
> ### При необходимости код можно скомпилировать в jar архив, с помощью [compile.sh](./lab2/compile.sh) скрипта в ```./lab2/optional_files```
> ### Также в этой директории находится [uml.png](./lab2/optional_files/uml.png), в котором графически отображено дерево классов и объектов:
### Uml-диаграмма:
<image src="./lab2/optional_files/uml.png" alt="Диаграмма">

---
# Пример вывода моего кода:
```
Pichu Мелочь Пузатая из команды полосатых вступает в бой!
Fearow Гигачад из команды синих вступает в бой!
Fearow Гигачад наносит урон с повышенным коэффициентом критического удара DrillRun. 
Pichu Мелочь Пузатая теряет 1 здоровья.

Pichu Мелочь Пузатая промахивается

Fearow Гигачад наносит урон с повышенным коэффициентом критического удара DrillRun. 
Pichu Мелочь Пузатая теряет 1 здоровья.

Pichu Мелочь Пузатая промахивается

Fearow Гигачад наносит урон с повышенным коэффициентом критического удара DrillRun. 
Pichu Мелочь Пузатая теряет 2 здоровья.

Pichu Мелочь Пузатая делает Swagger. 
Fearow Гигачад увеличивает атаку.

Fearow Гигачад растерянно попадает по себе. 
Fearow Гигачад теряет 7 здоровья.

Pichu Мелочь Пузатая делает Swagger. 
Fearow Гигачад увеличивает атаку.

Fearow Гигачад растерянно попадает по себе. 
Fearow Гигачад теряет 4 здоровья.

Pichu Мелочь Пузатая промахивается

Fearow Гигачад растерянно попадает по себе. 
Fearow Гигачад теряет 5 здоровья.
Fearow Гигачад теряет сознание.
Pikachu Мышь из команды синих вступает в бой!
Pikachu Мышь атакует. 
Pichu Мелочь Пузатая теряет 4 здоровья.
Pichu Мелочь Пузатая производит атаку Spark

Pichu Мелочь Пузатая промахивается

Pikachu Мышь атакует. 
Pichu Мелочь Пузатая теряет 4 здоровья.
Pichu Мелочь Пузатая производит атаку Spark
Pichu Мелочь Пузатая теряет сознание.
Raichu Ноунейм из команды полосатых вступает в бой!
Raichu Ноунейм делает TailWhip и понижает защиту на 1 ступень. 
Pikachu Мышь увеличивает защиту.

Pikachu Мышь атакует. 
Raichu Ноунейм теряет 3 здоровья.
Raichu Ноунейм производит атаку Spark

Raichu Ноунейм делает TailWhip и понижает защиту на 1 ступень. 
Pikachu Мышь увеличивает защиту.

Pikachu Мышь атакует. 
Raichu Ноунейм теряет 3 здоровья.
Raichu Ноунейм производит атаку Spark

Raichu Ноунейм делает TailWhip и понижает защиту на 1 ступень. 
Pikachu Мышь увеличивает защиту.

Pikachu Мышь атакует. 
Raichu Ноунейм теряет 4 здоровья.
Raichu Ноунейм производит атаку Spark

Raichu Ноунейм делает TailWhip и понижает защиту на 1 ступень. 
Pikachu Мышь увеличивает защиту.

Pikachu Мышь атакует. 
Raichu Ноунейм теряет 3 здоровья.
Raichu Ноунейм производит атаку Spark
Raichu Ноунейм теряет сознание.
Victini Инопланетянин из команды полосатых вступает в бой!
Victini Инопланетянин делает Thunder и имеет 30% шанс парализовать цель. 
Pikachu Мышь теряет 4 здоровья.

Pikachu Мышь атакует. 
Victini Инопланетянин теряет 5 здоровья.
Victini Инопланетянин производит атаку Spark

Victini Инопланетянин делает WillOWisp и обжигает цель. 
Pikachu Мышь воспламеняется
Pikachu Мышь теряет 10 здоровья.
Pikachu Мышь увеличивает атаку.
Pikachu Мышь теряет сознание.
Spearow Сигма из команды синих вступает в бой!
Victini Инопланетянин делает Thunder и имеет 30% шанс парализовать цель. 
Spearow Сигма теряет 9 здоровья.

Spearow Сигма промахивается

Victini Инопланетянин атакует. 
Spearow Сигма теряет 8 здоровья.
Spearow Сигма теряет сознание.
В команде синих не осталось покемонов.
Команда полосатых побеждает в этом бою!
```
# Вывод
### Я разобрался с основными концепциями ООП в Java и научился применять их при написании программ.