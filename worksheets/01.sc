/* Function (and Pure Function) example */
def grossMonthlySavings(grossMonthlyIncome: Double, expenses: Double) = grossMonthlyIncome - expenses
grossMonthlySavings(10000.0, 4000.0)

/* Impure Function Example - return value is not same for the same arguments */
var taxRate = 0.33
def netMonthlySavings(grossMonthlyIncome: Double, expenses: Double) = {
  val taxes = grossMonthlyIncome * taxRate
  val netMonthlyIncome = grossMonthlyIncome - taxes
  netMonthlyIncome - expenses
}

netMonthlySavings(10000.0, 4000.0)

/* Government changes the tax Rate */
taxRate = 0.35
netMonthlySavings(10000.0, 4000.0)


/* Impure Function - Evaluation with Side Effects */
var accountsWithBalances: Map[Int, Double] = Map(
  1 -> 23453.23,
  2 -> 345000.1,
  3 -> 10000.00
)

def withdraw(accountId: Int, amount: Double): Double = {
  require(amount <= accountsWithBalances(accountId), "amount should be not be more than you have!")

  val balanceNow = accountsWithBalances(accountId) - amount
  accountsWithBalances = accountsWithBalances.updated(accountId, balanceNow)

  println(s"Balance now? $accountId -> $balanceNow")
  amount
}

withdraw(3, 6000)
withdraw(3, 6000)
