package designpattern.factory_method;

/**
 * Created by kimvra on 2019-06-22
 */
public class AOfferFactory extends OfferFactory{
    @Override
    Offer getOffer() {
        return new AOffer();
    }
}
