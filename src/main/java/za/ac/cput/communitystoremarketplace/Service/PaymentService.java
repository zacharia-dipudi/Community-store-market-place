package za.ac.cput.communitystoremarketplace.Service;

import za.ac.cput.communitystoremarketplace.Domain.Payment;
import za.ac.cput.communitystoremarketplace.Repository.PaymentRepository;

import java.util.List;

public class PaymentService implements IPaymentService {

    private final PaymentRepository paymentRepository;

    public PaymentService(PaymentRepository paymentRepository) {
        this.paymentRepository = paymentRepository;
    }

    @Override
    public List<Payment> getAll() {
        return paymentRepository.findAll();
    }

    @Override
    public Payment create(Payment payment) {
        return paymentRepository.save(payment);
    }

    @Override
    public Payment read(Long paymentId) {
        return paymentRepository.findById(paymentId).orElse(null);
    }

    @Override
    public Payment update(Payment payment) {
        return paymentRepository.save(payment);
    }

    @Override
    public boolean delete(Long paymentId) {
        paymentRepository.deleteById(paymentId);
        return true;
    }
}
