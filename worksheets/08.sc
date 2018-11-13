import scala.concurrent.Future
import scala.concurrent.ExecutionContext.Implicits.global


def getExchangeRate(from: String, to: String): Future[Double] = {
  // assume API call is made to get the result and it too 10 seconds
  Future { Thread.sleep(2000); 72.43d }
}

val rates: Future[Double] = getExchangeRate("USD", "INR")

new java.util.Date()
rates.isCompleted

// to avoid program to exit
Thread.sleep(3000)
println("-" * 50)

new java.util.Date()
rates.isCompleted
rates.value