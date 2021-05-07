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
        if (!name.equals(Item.ITEM_AGED_BRIE) && !name.equals(Item.ITEM_BACKSTAGE_PASS)) {
            decreaseQuality();
        } else {
            increaseQuality();
        }

        if (!name.equals(Item.ITEM_SULFURAS)) {
            sellIn = sellIn - 1;
        }

        if (sellIn < 0) {
            if (!name.equals(Item.ITEM_AGED_BRIE)) {
                if (name.equals(Item.ITEM_BACKSTAGE_PASS)) {
                    quality = 0;
                } else {
                    if (quality > 0) {
                        if (!name.equals(Item.ITEM_SULFURAS)) {
                            quality = quality - 1;
                        }
                    }
                }
            } else {
                increaseQuality();
            }
        }
    }
}
