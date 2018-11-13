import java.time.LocalDateTime

sealed trait Category
case object Food extends Category
case object Utilities extends Category
case object Rent extends Category
case object Entertainment extends Category
case object Transportation extends Category
case object Income extends Category

case class Transaction(amount: Double,
                       debit: Boolean,
                       category: Category,
                       description: String,
                       date: LocalDateTime = LocalDateTime.now())

val t1 = Transaction(1000.0, debit = true, Rent, "Home Rent")
val t2 = Transaction(45.0, debit = true, Food, "Dining with Matt")
val t3 = Transaction(145.0, debit = true, Transportation, "Metro Pass")
val t4 = Transaction(25.0, debit = true, Transportation, "Uber")
val t5 = Transaction(12.0, debit = true, Entertainment, "Movie Tickets")
val t6 = Transaction(112.0, debit = true, Utilities, "Phone Bill")
val t7 = Transaction(120.0, debit = true, Utilities, "Electricity")
val t8 = Transaction(100.0, debit = true, Utilities, "Internet")
val t9 = Transaction(15.0, debit = true, Food, "Snacking!")
val t10 = Transaction(15.0, debit = true, Food, "Drinks with Denis!")
val t11 = Transaction(9.0, debit = true, Food, "Coffee!")
val t12 = Transaction(12000.0, debit = false, Income, "Salary")
val t13 = Transaction(2000.0, debit = false, Income, "Royalties")

val transactions = List(t1, t2, t3, t4, t5, t6, t7, t8, t9, t10, t11, t12, t13)

def getFoodExpenses(ts: List[Transaction]): Double = {
  val amounts = for (i <- ts.indices if ts(i).category == Food) yield ts(i).amount
  amounts.sum
}

def getTransportExpenses(ts: List[Transaction]): Double = {
  val amounts = for (i <- ts.indices if ts(i).category == Transportation) yield ts(i).amount
  amounts.sum
}

def getUtilitiesExpenses(ts: List[Transaction]): Double = {
  val amounts = for (i <- ts.indices if ts(i).category == Utilities) yield ts(i).amount
  amounts.sum
}

getFoodExpenses(transactions)
getTransportExpenses(transactions)
getUtilitiesExpenses(transactions)

/* Higher-Order Functions */
def getExpenses(ts: List[Transaction], pred: Transaction => Boolean): Double = {
  val amounts = for (i <- ts.indices if pred(ts(i))) yield ts(i).amount
  amounts.sum
}

/* Talk about function Literal */
val foodExpenses = getExpenses(transactions, (t: Transaction) => t.category == Food)
val transportExpenses = getExpenses(transactions, (t: Transaction) => t.category == Transportation)
val UtilitiesExpenses = getExpenses(transactions, (t: Transaction) => t.category == Utilities)

val totalIncome = getExpenses(transactions, (t: Transaction) => !t.debit)
val totalExpenses = getExpenses(transactions, (t: Transaction) => t.debit)

/* map and filter */
val foodExpensesMF = transactions.filter(t => t.category == Food).map(t => t.amount).sum
val transportExpensesMF = transactions.filter(t => t.category == Transportation).map(t => t.amount).sum
val UtilitiesExpensesMF = transactions.filter(t => t.category == Utilities).map(t => t.amount).sum
val totalIncomeMF = transactions.filter(t => !t.debit).map(t => t.amount).sum
val totalExpensesMF = transactions.filter(t => t.debit).map(t => t.amount).sum