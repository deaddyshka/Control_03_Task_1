fun minutesAgoText(minutes: Int): String {
    return when {
        minutes % 10 == 1 && minutes != 11 -> "$minutes минуту назад"
        minutes % 10 in 2..4 && (minutes < 10 || minutes > 20) -> "$minutes минуты назад"
        else -> "$minutes минут назад"
    }
}

fun hoursAgoText(hours: Int): String {
    return when {
        hours == 1 || hours == 21 -> "$hours час назад"
        hours in 2..4 || hours in 22..24 -> "$hours часа назад"
        else -> "$hours часов назад"
    }
}

fun agoToText(seconds: Int) {
    when {
        seconds in 0..60 -> println("был(а) только что")
        seconds in 61..3600 -> {
            val minutes = seconds / 60
            println("был(а) ${minutesAgoText(minutes)}")
        }
        seconds in 3601..86400 -> {
            val hours = seconds / 3600
            println("был(а) ${hoursAgoText(hours)}")
        }
        seconds in 86401..172800 -> println("был(а) вчера")
        seconds in 172801..259200 -> println("был(а) позавчера")
        else -> println("был(а) давно")
    }
}

fun main() {
    agoToText(150)
}
