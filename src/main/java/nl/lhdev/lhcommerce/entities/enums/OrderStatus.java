package nl.lhdev.lhcommerce.entities.enums;

public enum OrderStatus {
    WAITING_PAYMENT,  // aguardando pagamento 0
    PAID,             // pago 1 
    SHIPPED,          // enviado 2
    DELIVERED,        // entregue 3
    CANCELED;         // cancelado 4
}
