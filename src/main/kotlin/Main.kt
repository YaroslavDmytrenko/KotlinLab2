import java.lang.Exception

class PasswordMismatchException(message: String) : Exception(message)

fun main() {
    println("Введіть логін:")
    var login = readLine()
    println("Введіть пароль:")
    var password1 = readLine()
    println("Повторіть пароль:")
    var password2 = readLine()

    if (login.isNullOrBlank()) login = "guest"
    if (password1.isNullOrBlank()) password1 = "123456"
    if (password2.isNullOrBlank()) password2 = "123456"D

    try {
        if (password1 != password2) {
            throw PasswordMismatchException("Паролі не співпадають!")
        }

        if (!isPasswordStrong(password1)) {
            println("Пароль занадто простий! Має бути мінімум 8 символів, 1 цифра і 1 велика літера.")
            return
        }

        println("Користувача зареєстровано. Логін: $login")

    } catch (e: PasswordMismatchException) {
        println("Помилка реєстрації: ${e.message}")
    }
}

fun isPasswordStrong(password: String): Boolean {
    val lengthRequirement = password.length >= 8
    val digitRequirement = password.contains(Regex("\\d"))
    val uppercaseRequirement = password.contains(Regex("[A-Z]"))
    return lengthRequirement && digitRequirement && uppercaseRequirement
}