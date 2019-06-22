package designpattern.factory_method;

/**
 * Created by kimvra on 2019-06-22
 *
 */
public class Client {
    public static void main(String[] args) {
        OfferFactory offerFactory = new AOfferFactory();
        offerFactory.getOffer().offer();
        OfferFactory offerFactory1 = new BOfferFactory();
        offerFactory1.getOffer().offer();
    }
}
