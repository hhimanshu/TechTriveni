import java.time.LocalDateTime

import scala.annotation.tailrec

/* Recursion */
case class Transaction(date: LocalDateTime, amount: Double, debit: Boolean, description: String)

/* Non-Recursive way */
def getTotalExpenses(ts: List[Transaction]): Double = {
  var sum = 0.0
  for (i <- ts.indices) {
    if (ts(i).debit) sum += ts(i).amount
  }
  sum
}

/* Recursive way */
def getTotalExpensesR(ts: List[Transaction]): Double = {
  if (ts.isEmpty) 0.0
  else {
    ts.head.amount + getTotalExpensesR(ts.tail)
  }
}


/* Tail-Recursive way */
def getTotalExpensesTR(ts: List[Transaction]) = {
  @tailrec
  def go(totalSoFar: Double, transactions: List[Transaction]): Double = {
    if (transactions.isEmpty) totalSoFar
    else {
      go(totalSoFar + transactions.head.amount, transactions.tail)
    }
  }

  go(0.0, ts)
}