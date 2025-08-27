public class Main {
    public static void main(String[] args) {
        OrderFacade orderFacade = new OrderFacade();
        String deliveryType = "sicepat";
        int totalAmount = 30000;
        String productId = "kemeja1";

        orderFacade.placeOrder(productId,totalAmount,deliveryType);
    }
}