package com.gildedrose;

import java.util.Arrays;

class GildedRose {

    Item[] items;

    public GildedRose(Item[] items) {
        this.items = createItems(items);
    }

    private Item[] createItems(Item[] items) {
        return Arrays.stream(items).map(this::createItem).toArray(Item[]::new);
    }

    private Item createItem(Item item) {
        switch (item.name) {
            case Item.ITEM_BACKSTAGE_PASS:
                return new BackStagePass(item.name, item.sellIn, item.quality);
            case Item.ITEM_SULFURAS:
                return new Sulfuras(item.name, item.sellIn, item.quality);
            case Item.ITEM_AGED_BRIE:
                return new AgedBrie(item.name, item.sellIn, item.quality);
            case Item.ITEM_CONJURED:
                return new Conjured(item.name, item.sellIn, item.quality);
            default:
                return item;
        }
    }

    public void updateQuality() {
        Arrays.stream(items).forEach(item -> {
            item.updateSellIn();
            item.updateQuality();
        });
    }
}