package be.adrienhelin.project.service.orders;

public class OrderDto {

    private Integer orderId;
    private Integer customerId;

    public OrderDto(Integer customerId) {
        this.customerId = customerId;
    }

    public OrderDto(Integer orderId, Integer customerId) {
        this.orderId = orderId;
        this.customerId = customerId;
    }

    public Integer getOrderId() {
        return orderId;
    }

    public Integer getCustomerId() {
        return customerId;
    }
}
