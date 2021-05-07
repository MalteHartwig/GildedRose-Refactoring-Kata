package com.gildedrose;

class GildedRose {

    Item[] items;

    public GildedRose(Item[] items) {
        this.items = items;
    }

    public void updateQuality() {
        for (Item item : items) {
            if (!item.name.equals(Item.ITEM_AGED_BRIE) && !item.name.equals(Item.ITEM_BACKSTAGE_PASS)) {
                item.decreaseQuality();
            } else {
                item.increaseQuality();
                if (item.name.equals(Item.ITEM_BACKSTAGE_PASS)) {
                    if (item.sellIn < 11) {
                        item.increaseQuality();
                    }

                    if (item.sellIn < 6) {
                        item.increaseQuality();
                    }
                }
            }

            if (!item.name.equals(Item.ITEM_SULFURAS)) {
                item.sellIn = item.sellIn - 1;
            }

            if (item.sellIn < 0) {
                if (!item.name.equals(Item.ITEM_AGED_BRIE)) {
                    if (!item.name.equals(Item.ITEM_BACKSTAGE_PASS)) {
                        if (item.quality > 0) {
                            if (!item.name.equals(Item.ITEM_SULFURAS)) {
                                item.quality = item.quality - 1;
                            }
                        }
                    } else {
                        item.quality = 0;
                    }
                } else {
                    item.increaseQuality();
                }
            }
        }
    }
}