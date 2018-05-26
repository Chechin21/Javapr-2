package classes;

import java.sql.SQLException;
import java.util.Collection;

import tables.Payment;



public interface PaymentDAO{
	public void addPayment(Payment Payment) throws SQLException;
	public void updatePayment(Long Payment_id, Payment Payment) throws SQLException;
	public Payment getPaymentById(Long Payment_id) throws SQLException;
	public Collection<Payment> getAllPayments() throws SQLException;
	public void deletePayment(Payment Payment) throws SQLException;
	public Collection<Payment> getPaymentByFeature(Payment Payment) throws SQLException;
}
