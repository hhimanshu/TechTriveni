import java.time.LocalDateTime

/* Immutability - Bank Transaction */
/**
  * 0. Why immutability
  * 1. var bs val
  * 2. val on objects
  * 3. case classes
  */

case class Transaction(date: LocalDateTime, amount: Double, debit: Boolean, description: String)
val t1 = Transaction(LocalDateTime.now, 23.12, debit = true, "Amazon Shopping")
val t2 = Transaction(LocalDateTime.now, 10000.0, debit = false, "Salary Credited")
