package com.gildedrose.strategies;

import com.gildedrose.Item;
import com.gildedrose.UpdateStrategy;

public class BackstageUpdateStrategy implements UpdateStrategy {

    @Override
    public void updateQuality(Item item) {
        item.sellIn = item.sellIn - 1;

        int originalQuality = item.quality;
        item.quality = item.quality + 1;

        if (item.sellIn < 11) {
            item.quality = item.quality + 1;
        }

        if (item.sellIn < 6) {
            item.quality = item.quality + 1;
        }

        if (item.sellIn < 0) {
            item.quality = 0;
        }

        if (item.quality > 50) {
            item.quality = originalQuality;
        }

    }
}
