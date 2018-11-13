import java.util.UUID

/*  Currying */
type PassportNumber = String
type Money = Double
type AccountId = String

def openAccount(passportNumber: PassportNumber, money: Money): AccountId = {
  /* Some work here */
  UUID.randomUUID().toString
}

val a1 = openAccount("P1", 100.0)


def openAccountCurried(passportNumber: PassportNumber)(money: Money): AccountId = {
  /* Some work here */
  UUID.randomUUID().toString
}

// partially-applied function
val partialProcessToken = openAccountCurried("P2")(_: Money)

/* After some time, when it's your turn */
val a2 = partialProcessToken(200.0)
