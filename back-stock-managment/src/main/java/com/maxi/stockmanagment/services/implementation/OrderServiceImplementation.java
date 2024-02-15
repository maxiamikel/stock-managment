package com.maxi.stockmanagment.services.implementation;

import java.time.LocalDate;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.maxi.stockmanagment.domains.Order;
import com.maxi.stockmanagment.domains.OrderItem;
import com.maxi.stockmanagment.domains.Product;
import com.maxi.stockmanagment.repositories.OrderRepository;
import com.maxi.stockmanagment.services.OrderService;

import jakarta.transaction.Transactional;

@Service
public class OrderServiceImplementation implements OrderService {

    @Autowired
    private OrderRepository orderRepository;

    @Autowired
    private ProductServiceImplementation productService;

    @Autowired
    private OrderItemServiceImplementation orderItemServiceImplementation;

    @Override
    public List<Order> getAll() {
        return orderRepository.findAll();
    }

    @Override
    public Order getById(Long idOrder) {
        return orderRepository.findById(idOrder).orElse(null);
    }

    @Override
    @Transactional()
    public Order save(Order order) {

        LocalDate orderDate = LocalDate.now();

        order.setDate(orderDate);
        order.setTotal(
                order.getOrderItems()
                        .stream()
                        .mapToDouble(item -> {
                            Product product = productService.getById(item.getProduct().getId());
                            item.setPrice(product.getPrice());
                            item.setTotal(product.getPrice() * item.getQuantity());
                            return item.getQuantity();
                        }).sum());

        for (OrderItem item : order.getOrderItems()) {
            // Verificar se o stock esta maior ao valor da orden do produto
            if (productService.veriryStockBeforeEffectuateAnOrder(item.getProduct().getId(),
                    item.getQuantity()) == true) {
                productService.updateStock(item.getProduct().getId(), item.getQuantity());
                // Desactivar o produto se o stock = 0 ou activa-lo caso contrario
                if (productService.findByQuantity(item.getProduct().getId()) == 0) {
                    productService.desactivateProduct(item.getProduct().getId());
                }
            } else {
                throw new RuntimeException("Stock is not available");
            }
        }

        orderRepository.save(order);

        order.getOrderItems().forEach(itemDetail -> {
            itemDetail.setOrder(order);
            orderItemServiceImplementation.save(itemDetail);
        });
        return order;
    }

}
