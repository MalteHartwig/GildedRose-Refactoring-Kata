package com.gildedrose;

public class Item {

    final static String ITEM_CONJURED = "Conjured";
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

    public void updateQuality() {
        decreaseQuality(isExpired() ? 2 : 1);
    }

    void decreaseQuality(int amount) {
        quality = Math.max(0, quality - amount);
    }

    void increaseQuality(int amount) {
        quality = Math.min(MAX_QUALITY, quality + amount);
    }

    public void updateSellIn() {
        sellIn--;
    }

    protected boolean isExpired() {
        return sellIn < 0;
    }

    @Override
    public String toString() {
        return this.name + ", " + this.sellIn + ", " + this.quality;
    }
}
