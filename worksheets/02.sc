import java.time.LocalDateTime

/* Mutability */
class TransactionM(var date: LocalDateTime, var amount: Double, var debit: Boolean, var description: String)
val t1 = new TransactionM(LocalDateTime.now, 23.12, debit = true, "Amazon Shopping")
val t2 = new TransactionM(LocalDateTime.now, 10000.0, debit = false, "Salary Credited")
// t1 = t2 // works just fine

t1.amount = 123.12
t1.amount

/* Immutability - Bank Transaction */
case class Transaction(date: LocalDateTime, amount: Double, debit: Boolean, description: String)

var t3 = Transaction(LocalDateTime.now, 23.12, debit = true, "Amazon Shopping")
var t4 = Transaction(LocalDateTime.now, 10000.0, debit = false, "Salary Credited")
// t3.amount = 123.12 // compilation error


