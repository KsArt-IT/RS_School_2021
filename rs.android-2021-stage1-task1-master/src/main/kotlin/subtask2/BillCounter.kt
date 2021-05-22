package subtask2

class BillCounter {

    // The output could be "Bon Appetit" or the string with number(e.g "10")
    fun calculateFairlySplit(bill: IntArray, k: Int, b: Int): String {
        val anna = (bill.sum() - bill[k]) / 2
        return if (anna == b) "bon appetit" else (b - anna).toString()
    }
}
