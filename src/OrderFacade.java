public class OrderFacade {
    private InventorySystem inventorySystem;
    private PaymentProcessor paymentProcessor;

    public OrderFacade() {
        this.inventorySystem = new InventorySystem();
        this.paymentProcessor = new PaymentProcessor();
    }

    public void placeOrder(String productId, int amount, String deliveryType){
        System.out.println("Memulai Proses pemesanan");

        if (!inventorySystem.checkStock(productId)) {
            System.out.println("Gagal: Stok produk tidak tersedia.");
            return;
        } else {
            System.out.println("Produk tersedia");
        }

        if (!paymentProcessor.processPayment(amount)) {
            System.out.println("Gagal: Pembayaran tidak berhasil.");
            return;
        } else {
            System.out.println("Pembayaran Berhasil");
        }

        DeliveryService delivery = DeliveryServiceFactory.getDeliveryServiceFactory(deliveryType);
        if (delivery != null) {
            int deliveryCost = delivery.calculateCost();
            System.out.println("Pesanan berhasil terkirim");
        }
        System.out.println("Selesai");
    }
}
