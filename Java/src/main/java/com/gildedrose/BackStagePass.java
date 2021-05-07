package com.gildedrose;

public class BackStagePass extends Item{
    public BackStagePass(String name, int sellIn, int quality) {
        super(name, sellIn, quality);
    }

    @Override
    public void increaseQuality() {
        super.increaseQuality();
        if (sellIn < 11) {
            super.increaseQuality();
        }

        if (sellIn < 6) {
            super.increaseQuality();
        }
    }
}
