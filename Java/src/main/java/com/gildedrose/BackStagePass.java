package com.gildedrose;

public class BackStagePass extends Item {
    public BackStagePass(String name, int sellIn, int quality) {
        super(name, sellIn, quality);
    }

    @Override
    public void updateQuality() {
        if (isExpired()) {
            quality = 0;
            return;
        }
        if (sellIn < 6) {
            increaseQuality(3);
            return;
        }
        if (sellIn < 11) {
            increaseQuality(2);
            return;
        }
        increaseQuality(1);
    }
}
