package com.gildedrose;

public class Item {

    final static String ITEM_AGED_BRIE = "Aged Brie";
    final static String ITEM_SULFURAS = "Sulfuras, Hand of Ragnaros";
    final static String ITEM_BACKSTAGE_PASS = "Backstage passes to a TAFKAL80ETC concert";
    private static final int MAX_QUALITY = 50;

    public String name;

    public int sellIn;

    public int quality;

    public Item(String name, int sellIn, int quality) {
        this.name = name;
        this.sellIn = sellIn;
        this.quality = quality;
    }

   @Override
   public String toString() {
        return this.name + ", " + this.sellIn + ", " + this.quality;
    }

    public void increaseQuality() {
        if (quality < MAX_QUALITY) {
            quality++;
        }
    }

    public void decreaseQuality() {
        if (quality > 0) {
            if (!name.equals(ITEM_SULFURAS)) {
                quality--;
            }
        }
    }
}
