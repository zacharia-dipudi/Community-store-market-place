package za.ac.cput.communitystoremarketplace.Controller;

import org.springframework.web.bind.annotation.*;
import za.ac.cput.communitystoremarketplace.Domain.Payment;
import za.ac.cput.communitystoremarketplace.Service.PaymentService;

import java.util.List;

public class PaymentController {

    private final PaymentService paymentService;

    PaymentController(PaymentService paymentService) {
        this.paymentService = paymentService;
    }

    @PostMapping("/create")
    public Payment create(@RequestBody Payment payment) {
        return paymentService.create(payment);
    }

    @GetMapping("/read")
    public Payment read(@RequestParam Long paymentId) {
        return paymentService.read(paymentId);
    }

    @PutMapping("/update")
    public Payment update(@RequestBody Payment payment) {
        return paymentService.update(payment);
    }

    @DeleteMapping("/delete")
    public boolean delete(@RequestParam Long paymentId) {
        paymentService.delete(paymentId);
        return true;
    }

    List<Payment> getAll() {
        return paymentService.getAll();
    }
}

