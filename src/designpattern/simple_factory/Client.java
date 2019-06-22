package designpattern.simple_factory;

/**
 * Created by kimvra on 2019-06-22
 */
public class Client {
    public static void main(String[] args) throws Exception{
        OfferFactory.getOffer(AOffer.class).offer();
        OfferFactory.getOffer(BOffer.class).offer();
    }
}
