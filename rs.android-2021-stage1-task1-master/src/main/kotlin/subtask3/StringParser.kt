package subtask3

class StringParser {

    fun getResult(inputString: String): Array<String> {
        if (inputString.isBlank() || !inputString.contains("""[<(\[]""".toRegex())) return emptyArray()
        val result = mutableListOf<String>()
        mapOf(
            inputString.indexOf('<') to inputString.lastIndexOf('>'),
            inputString.indexOf('(') to inputString.lastIndexOf(')'),
            inputString.indexOf('[') to inputString.lastIndexOf(']'),
        ).filter {
            it.key in 0 until it.value
        }.minByOrNull {
            it.key
        }?.let { entry ->
            val s = inputString.substringBracket(inputString[entry.key], inputString[entry.value])
            result.add(s)
            if (entry.value < inputString.length) {
                val sNext = inputString.substring(entry.key + 1)
                result.addAll(getResult(sNext))
            }
        }
        return result.toTypedArray()
    }

    fun String.substringBracket(bracketStart: Char, bracketEnd: Char): String {
        var result = ""
        var bracketStartIndex = this.indexOf(bracketStart)
        if (bracketStartIndex < 0) return result
        var bracketEndIndex = bracketStartIndex
        var bracketEndCount = 0
        do {
            bracketEndIndex = this.indexOf(bracketEnd, bracketEndIndex + 1)
            if (bracketEndIndex > 0) {
                result = this.substring(bracketStartIndex + 1, bracketEndIndex)
                bracketEndCount++
            }
        } while (bracketEndIndex > 0 && result.count { it == bracketStart } + 1 > bracketEndCount)
        return result
    }
}
