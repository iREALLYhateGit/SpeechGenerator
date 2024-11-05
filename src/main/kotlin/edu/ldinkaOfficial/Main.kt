package edu.ldinkaOfficial

// Everything after this is in red
const val textColor = "\u001b[36m"

// Resets previous color codes
const val resetTextColor = "\u001b[0m"

fun main() {

    println("Hello Kotlin World! That is the Speech generator.")
    println("First of all, you need to type in the quantity of sentences you want to acquire. \n" +
            "After that the desired speech would be displayed ended by \"<Finish!\" script. " +
            "The last thing to notice: program would call back for your answer whether you want to" +
            "get started again or not.")

    val phraseGenerator = PhraseGenerator()

    var again: Boolean?
    var correctInput = false
    do {
        run(phraseGenerator)
        println("$textColor>Again? Type in \"true\" or \"false\".$resetTextColor")
        do{
            again = readln().toBooleanStrictOrNull()
            if(again != null)
                correctInput = true
            else
                println("$textColor>Type in \"true\" or \"false\".$resetTextColor")
        } while (!correctInput)

    } while (again == true)

    val text = """
    >Tell me and I forget.
    >Teach me and I remember.
    >Involve me and I learn.
    >(Benjamin Franklin)
    """.trimMargin(">")
    println(text)
}

private fun run(phraseGenerator: PhraseGenerator)
{
    println("$textColor>Please, type in the quantity of generative sentences.$resetTextColor")
    var sentenceQuantity:Int
    var correctInput = false
    do {
        sentenceQuantity = readln().toIntOrNull() ?: 0
        if(sentenceQuantity > 0)
            correctInput = true
        else
            println("$textColor>Type the number that is greater than 0.$resetTextColor")
    } while (!correctInput)

    for (i in sentenceQuantity downTo 1)
    {
        println(phraseGenerator.getPhrase())
    }
    println("$textColor<Finish!$resetTextColor")
}
