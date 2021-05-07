package com.gildedrose;

import java.util.ArrayList;
import java.util.List;

class GildedRose {

    Item[] items;

    public GildedRose(Item[] items) {
        this.items = createItems(items);
    }

    private Item[] createItems(Item[] items) {
        List<Item> res = new ArrayList<>();
        for (Item item : items) {
            if (item.name.equals(Item.ITEM_BACKSTAGE_PASS)) {
                res.add(new BackStagePass(item.name, item.sellIn, item.quality));
            } else if (item.name.equals(Item.ITEM_SULFURAS)) {
                res.add(new Surfuras(item.name, item.sellIn, item.quality));
            } else if (item.name.equals(Item.ITEM_AGED_BRIE)) {
                res.add(new AgedBrie(item.name, item.sellIn, item.quality));
            } else {
                res.add(item);
            }
        }
        return res.toArray(new Item[0]);
    }

    public void updateQuality() {
        for (Item item : items) {
            item.updateQuality();
        }
    }
}