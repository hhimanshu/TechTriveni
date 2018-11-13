/* Expressions */
def netWorth(netSavings: Double, debt: Double, recurringAnnualCosts: Double) = {
  netSavings - debt - recurringAnnualCosts
}

/* Statements */
type PdfDocument
def downloadBankStatement(accountId: Int, month: Int, year: Int): PdfDocument = {
  val url = s"https://mybank.com/$accountId/statements/$year/$month"

  // go get the PDF resource and return
  // API call, reading from the file system
  ???
}
