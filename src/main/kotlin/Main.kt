import java.lang.Exception
import kotlin.math.abs
import kotlin.math.sqrt

fun main() {
    println("Перевод секунд в формат часы:минуты:секунды")
    val sec = intValidate("Введите количество секунд: ")
    secondsToTime(sec)
    println()

    println("Расчёт растояния двух точек на координатной плоскости")
    val x1 = intValidate("Введите координату первой точки (x): ")
    val y1 = intValidate("Введите координату первой точки (y): ")
    val x2 = intValidate("Введите координату второй точки (x): ")
    val y2 = intValidate("Введите координату второй точки (y): ")
    pointsDistance(Pair(x1, y1), Pair(x2, y2))
    println()

    println("Нахождение НОД и НОК\nДля ввода используйте только положительные числа!")
    val firstNum = intValidateAboveZero("Введите первое число: ")
    val secondNum = intValidateAboveZero("Введите первое число: ")
    println("НОД = ${nodAndNok(Pair(firstNum,secondNum)).first}, НОК = ${nodAndNok(Pair(firstNum,secondNum)).second}")
    println()
}

fun intValidate(message: String): Int {
    val int: Int
    print(message)
    try {
        int = readln().toInt()
    }
    catch(e: Exception){
        println("Ошибка ввода!\nДля корректного ввода используйте цифры!")
        return intValidate(message)
    }
    return int
}
fun intValidateAboveZero(message: String): UInt {
    val int: UInt
    print(message)
    try {
        int = readln().toUInt()
    }
    catch(e: Exception){
        println("Ошибка ввода!\nДля корректной работы введите число > 0!")
        return intValidateAboveZero(message)
    }
    return int
}

// Пример использования Triple
fun secondsToTime(sec: Int){
    val (hours, minutes, seconds) = Triple(sec/3600, sec%3600/60, sec%3600%60)
    println("$sec секунд = $hours часов : $minutes минут : $seconds секунд")
}

// Растояние между двумя точка (одна точка это пара координат на плоскости)
fun pointsDistance(firstPoint: Pair<Int, Int>,secondPoint: Pair<Int,Int>){
    val xAbs = abs(firstPoint.first - secondPoint.first)
    val yAbs = abs(firstPoint.second - secondPoint.second)
    val distance = sqrt((xAbs*xAbs + yAbs*yAbs).toDouble())
    println("Растояние между двумя точками = $distance у.е.")
}

// Нахождение наибольшего общего делителя (НОД) и наименьшего общего кратного (НОК). Данные возвращаются в виде пары значенний
fun nodAndNok(numbs: Pair<UInt,UInt>): Pair<UInt, UInt>{
    var nok: UInt
    var nod: UInt = numbs.first
    if(numbs.first > numbs.second){
        nok = numbs.first
        for (i: UInt in numbs.second downTo 0u){
            if(numbs.first % i == 0u && numbs.second % i == 0u){
                nod = i
                break
            }
        }
    }
    else {
        nok = numbs.second
        for (i: UInt in numbs.first downTo 0u){
            if(numbs.first % i == 0u && numbs.second % i == 0u){
                nod = i
                break
            }
        }
    }
    while (true){
        if (nok % numbs.first == 0u && nok % numbs.second == 0u){
            break
        }
        nok++
    }
    return Pair(nod, nok)
}