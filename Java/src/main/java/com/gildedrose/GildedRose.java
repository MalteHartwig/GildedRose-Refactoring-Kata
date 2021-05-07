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
            } else {
                res.add(item);
            }
        }
        return res.toArray(new Item[0]);
    }

    public void updateQuality() {
        for (Item item : items) {
            if (!item.name.equals(Item.ITEM_AGED_BRIE) && !item.name.equals(Item.ITEM_BACKSTAGE_PASS)) {
                item.decreaseQuality();
            } else {
                item.increaseQuality();
            }

            if (!item.name.equals(Item.ITEM_SULFURAS)) {
                item.sellIn = item.sellIn - 1;
            }

            if (item.sellIn < 0) {
                if (!item.name.equals(Item.ITEM_AGED_BRIE)) {
                    if (item.name.equals(Item.ITEM_BACKSTAGE_PASS)) {
                        item.quality = 0;
                    } else {
                        if (item.quality > 0) {
                            if (!item.name.equals(Item.ITEM_SULFURAS)) {
                                item.quality = item.quality - 1;
                            }
                        }
                    }
                } else {
                    item.increaseQuality();
                }
            }
        }
    }
}