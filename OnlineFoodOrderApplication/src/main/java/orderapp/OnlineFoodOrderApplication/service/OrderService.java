package orderapp.OnlineFoodOrderApplication.service;

import orderapp.OnlineFoodOrderApplication.dto.BillResponse;
import orderapp.OnlineFoodOrderApplication.dto.OrderRequest;
import orderapp.OnlineFoodOrderApplication.dto.PaymentDto;
import orderapp.OnlineFoodOrderApplication.entity.Order;
import orderapp.OnlineFoodOrderApplication.entity.OrderStatus;

public interface OrderService {
	
	BillResponse generateBill(OrderRequest orderRequest);
	
	String payAndPlaceOrder(PaymentDto payment);
	
	void deleteOrder(Integer id);
	
	Order getOrder(Integer id);
	
	Order updateStatusByAdmin(OrderStatus status,Integer id);
	
	String cancelOrder(Integer id);
}