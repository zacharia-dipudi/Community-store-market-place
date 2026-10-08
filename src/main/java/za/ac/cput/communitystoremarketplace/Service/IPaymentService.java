package za.ac.cput.communitystoremarketplace.Service;

import za.ac.cput.communitystoremarketplace.Domain.Payment;

import java.util.List;

public interface IPaymentService {

    List<Payment> getAll();

    Payment create(Payment payment);

    Payment read(Long paymentId);

    Payment update(Payment payment);

    boolean delete(Long paymentId);
}

