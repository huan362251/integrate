package com.self.factory.configFactory;

import com.self.factory.configFactory.factory.MartialArtFactory;
import com.self.factory.configFactory.product.AttackProduct;

public class Client {

    public static void main(String[] args) {
        MartialArtFactory artFactory = new MartialArtFactory();
        AttackProduct fist = artFactory.createProduct("fist");
        fist.attack();
        AttackProduct palm = artFactory.createProduct("palm");
        palm.attack();
    }

}
