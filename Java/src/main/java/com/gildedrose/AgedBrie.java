package com.gildedrose;

public class AgedBrie extends Item {
    public AgedBrie(String name, int sellIn, int quality) {
        super(name, sellIn, quality);
    }

    @Override
    public void increaseQuality() {
        super.increaseQuality();
    }

    @Override
    public void updateQuality() {
        increaseQuality();
        sellIn = sellIn - 1;
        if (sellIn < 0) {
            increaseQuality();
        }
    }
}
