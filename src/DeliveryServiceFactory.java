public class DeliveryServiceFactory {
    public static DeliveryService getDeliveryServiceFactory(String serviceType){
        if (serviceType.equalsIgnoreCase("JNE"))
            return new JneDelivery();
        else if (serviceType.equalsIgnoreCase("JNT"))
            return new JntDelivery();
        else if (serviceType.equalsIgnoreCase("Sicepat"))
            return new SicepatDelivery();
        else
            return null;
    }
}