fun menuGameAndCalculator(): Int {
    println("<> === GAME AND CALCULATOR === <>")
    println("<> 1. Rock-Paper-Scissors      <>")
    println("<> 2. Arithmetic Calculator    <>")
    println("<> 3. Exit                     <>")
    println("===============================<>")

    print("Choose: ")
    return readLine()!!.toInt()
}

fun rockAndScissors(yourInput: String) {
    val options = listOf("rock", "scissor", "paper")
    val res = options.random()
    println("Computer choose: $res")
    when (res) {
        "scissor" -> when (yourInput) {
            "paper" -> println("haha, kasihan kalah haha")
            "scissor" -> println("haha, draw!")
            "rock" -> println("Selamat! Kamu menang!")
            else -> println("Input tidak valid.")
        }
        "paper" -> when (yourInput) {
            "rock" -> println("haha, kasihan kalah haha")
            "paper" -> println("hahh, draw!")
            "scissor" -> println("Selamat! Kamu menang!")
            else -> println("Input tidak valid.")
        }
        "rock" -> when (yourInput) {
            "scissor" -> println("haha, kasihan kalah haha")
            "rock" -> println("haha, draw!")
            "paper" -> println("selamat! kamu menang!")
            else -> println("Input tidak valid.")
        }
    }
}

fun arithmetic(a: Int, b: Int, op: String) {
    var res= when (op) {
        "+" -> (a + b)
        "-" -> (a - b)
        "*" -> (a * b)
        "/" -> a.toDouble() / b.toDouble()
        else -> {
            println("Invalid operation: $op")
            return
        }
    }
    println("Result: $res")
}

fun main() {
    while (true) {
        val choose = menuGameAndCalculator()
        when (choose) {
            1 -> {
                println("Enter rock, paper, or scissor: ")
                val yourInput = readLine().toString()
                if (!yourInput.all { it.isLowerCase() }) {
                    var convert=yourInput.lowercase()
                    rockAndScissors(convert)
                    println()
                }else{
                    rockAndScissors(yourInput)
                    println()
                }


            }
            2 -> {
                println("Enter first number: ")
                val a = readLine()!!.toInt()
                println("Enter second number: ")
                val b = readLine()!!.toInt()
                println("Enter operation (+, -, *, /): ")
                val op = readLine().toString()
                if (b == 0 && op == "/") {
                    println("Result: Undefined")
                    println()
                } else {
                    arithmetic(a, b, op)
                    println()
                }
            }
            3 -> {
                break
            }
            else -> println("invalid choice,try again.")
        }
    }
}
