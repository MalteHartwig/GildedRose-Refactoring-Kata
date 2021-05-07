package com.gildedrose.strategies;

import com.gildedrose.Item;
import com.gildedrose.UpdateStrategy;

public class DefaultUpdateStrategy implements UpdateStrategy {

    @Override
    public void updateQuality(Item item) {
        item.sellIn = item.sellIn - 1;
        if (item.sellIn < 0) {
            item.quality = item.quality - 2;
        } else {
            item.quality = item.quality - 1;
        }
        if (item.quality <= 0) {
            item.quality = 0;
        }

    }
}
