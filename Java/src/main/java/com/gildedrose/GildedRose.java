package com.gildedrose;

import com.gildedrose.strategies.*;

import java.util.HashMap;
import java.util.Map;

class GildedRose {

    Item[] items;

    Map<String, UpdateStrategy> itemsWithStrategies = new HashMap<String, UpdateStrategy>() {{
        put("Backstage passes to a TAFKAL80ETC concert", new BackstageUpdateStrategy());
        put("Aged Brie", new BriUpdateStrategy());
        put("Sulfuras, Hand of Ragnaros", new SulfurasUpdateStrategy());
        put("Conjured", new ConjuredUpdateStrategy());
    }};

    public GildedRose(Item[] items) {
        this.items = items;
    }

    public void updateQuality() {

            for (Item item : items) {
                UpdateStrategy updateStrategy = itemsWithStrategies.getOrDefault(item.name, new DefaultUpdateStrategy());

                updateStrategy.updateQuality(item);
            }



    }
}