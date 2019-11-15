package example.micronaut.kotlin

import io.micronaut.http.annotation.Controller
import io.micronaut.http.annotation.Post
import java.math.BigDecimal

@Controller
class PaymentController(private val paymentService: PaymentService) {

    @Post("/payments")
    fun save(paymentDTO: PaymentDTO): PaymentResponse {
        val transactionId = paymentService.save(Payment(Amount(paymentDTO.amount)))
        return PaymentResponse(transactionId.value)
    }

}

data class PaymentResponse(val transactionId: String)

class PaymentDTO(val amount: BigDecimal)
