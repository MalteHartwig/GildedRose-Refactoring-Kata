package com.gildedrose;

public class Surfuras extends Item{
    public Surfuras(String name, int sellIn, int quality) {
        super(name, sellIn, quality);
    }

    @Override
    public void increaseQuality() {
        super.increaseQuality();
    }

    @Override
    public void updateQuality() {
        decreaseQuality();
    }
}
