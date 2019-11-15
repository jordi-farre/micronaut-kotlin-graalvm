package example.micronaut.kotlin

import java.math.BigDecimal
import java.util.*
import javax.inject.Singleton

@Singleton
class PaymentService {

    fun save(payment: Payment): TransactionId {
        return withLogging(payment) {
            TransactionId(UUID.randomUUID().toString())
        }
    }

    fun withLogging(payment: Payment, f: () -> TransactionId): TransactionId {
        println("creating payment $payment")
        return f()
    }

}

data class Payment(val amount: Amount)

data class Amount(val value: BigDecimal)

data class TransactionId(val value: String)
