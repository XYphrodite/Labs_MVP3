//Разработать класс для ЛЮБОЙ выбранной Вами предметной (проблемной) области.
// Класс должен включать: ≥4 строковых поля и ≥3 числовых поля, конструктор,
// методы доступа к закрытым данным класса, ≥5 методов работы с данными класса.
// Создать ≥3 экземпляра класса. Продемонстрировать работу всех методов.

class life_sim(
    private val _happy: Int,
    private val _health: Int,
    private val _age: Double,
    private val _money: Int,
    private val _satiety: Int,
    private val p_name: String,
    private val t_name: String,
    private val _sex: String,
) {
    private var happy: Int = _happy
    private var health: Int = _health
    private var age: Double = _age
    private var money: Int = _money
    private var satiety: Int = _satiety
    private var person_name: String = p_name
    private var town_name: String = t_name
    private var sex: String = _sex
    private var state: String = ""

    fun showInfo() {
        stateIs()
        print("Имя:\t\t${person_name}\n")
        print("Пол:\t\t${sex}\n")
        print("Город:\t\t${town_name}\n")
        print("Состояние:\t${state}\n")
        print("Возраст:\t${age}\n")
        print("Счастье:\t${happy}\n")
        print("Здоровье:\t${health}\n")
        print("Сытость:\t${satiety}\n")
        print("Деньги:\t\t${money}\n")

    }

    fun work() {
        isAlive()
        if (state == "Умер") {
            return
        }
        print("ВОТ И ПОРАБОТАЛИ!!!\n")
        age += 0.1
        money += 100
        satiety -= 20
        happy -= 10
        health -= 10
    }

    fun eat() {
        isAlive()
        if (state == "Умер") {
            return
        }
        print("ВОТ и ПОЕЛИ!!!\n")
        age += 0.02
        money -= 50
        satiety += 30
        happy += 10
        health += 10
    }

    private fun stateIs() {
        isAlive()
        if (state == "Умер") {
            return
        }
        if ((satiety > 50) && (happy > 50) && (health > 50)) {
            state = "Хорошее"
        } else {
            state = "Плохое"
        }
    }

    fun chill() {
        isAlive()
        if (state == "Умер") {
            return
        }
        print("ВОТ И ПОЧИЛИЛИ!!!\n")
        age += 0.05
        money -= 10
        satiety -= 10
        happy += 30
    }

    fun setNewInfo(
        _health: Int,
        _happy: Int,
        _age: Double,
        _money: Int,
        _satiety: Int,
        p_name: String,
        t_name: String,
        _sex: String,
    ) {
        happy = _happy
        health = _health
        age = _age
        money = _money
        satiety = _satiety
        person_name = p_name
        town_name = t_name
        sex = _sex
        isAlive()
    }

    fun heal() {
        isAlive()
        if (state == "Умер") {
            return
        }
        print("ВОТ И ПОРАБОТАЛИ!!!\n")
        age += 0.1
        money -= 500
        satiety -= 20
        health += 30
    }

    fun isAlive(): Boolean {
        if ((satiety <= 0) || (happy <= 0) || (health <= 0) || (age > 75)) {
            state = "Умер"
            print("$person_name У М Е Р\n")
            return false
        }
        state=""
        return true
    }

}

fun main() {
    val dima = life_sim(20, 50, 25.0, 1500, 50, "Дима", "Котовск", "мужчина")
    dima.showInfo()
    dima.work()
    dima.showInfo()
    dima.eat()
    dima.showInfo()
    dima.chill()
    dima.showInfo()
    dima.chill()
    dima.eat()
    dima.showInfo()
    val ded = life_sim(10, 20, 35.0, 2500, 80, "Дед", "Моршанск", "Дед")
    ded.showInfo()
    ded.work()
    ded.work()
    ded.heal()
    ded.setNewInfo(50, 20, 35.0, 2500, 80, "Дед", "Моршанск", "Дед")
    ded.work()
    ded.showInfo()
    val gagarin = life_sim(100, 200, 28.0, 20500, 95, "Юрий", "Москва", "мужской")
    gagarin.showInfo()
    gagarin.chill()
    gagarin.showInfo()
}