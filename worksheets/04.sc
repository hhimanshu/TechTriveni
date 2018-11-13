import java.time.LocalDateTime

/* Referential Transparency */
case class Transaction(date: LocalDateTime, amount: Double, debit: Boolean, description: String)

var sum = 0.0
def getTotalExpenses(ts: List[Transaction]): Double = {
  //var sum = 0.0
  for (i <- ts.indices) {
    if (ts(i).debit) sum += ts(i).amount
  }
  sum
}


val t1 = Transaction(LocalDateTime.now, 23.12, debit = true, "Amazon Shopping")
val t2 = Transaction(LocalDateTime.now, 10000.0, debit = false, "Salary Credited")
val ts = List(t1, t2)
assert(getTotalExpenses(ts) == getTotalExpenses(ts), "The function is not referentially transparent")