package subtask1

class HappyArray {

    fun convertToHappy(sadArray: IntArray): IntArray {
        return if (sadArray.size < 3) {
            sadArray
        } else {
            val result = sadArray.toMutableList()
            var change: Boolean
            var i: Int
            do {
                change = false
                i = 1
                while (i < result.lastIndex) {
                    if (result[i - 1] + result[i + 1] < result[i]) {
                        result.removeAt(i)
                        change = true
                        continue
                    }
                    i++
                }
            } while (change)
            result.toIntArray()
        }
    }
}
