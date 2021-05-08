package com.gildedrose;

public class Conjured extends Item {
    public Conjured(String name, int sellIn, int quality) {
        super(name, sellIn, quality);
    }

    @Override
    public void updateQuality() {
        decreaseQuality(isExpired() ? 4 : 2);
    }
}