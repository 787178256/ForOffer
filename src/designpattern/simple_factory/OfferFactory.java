package designpattern.simple_factory;

/**
 * Created by kimvra on 2019-06-22
 */
public class OfferFactory {

    public static Offer getOffer(Class clazz) throws ClassNotFoundException, IllegalAccessException, InstantiationException {
        Class c = Class.forName(clazz.getName());
        Offer offer = (Offer)c.newInstance();
        return offer;
    }
}
