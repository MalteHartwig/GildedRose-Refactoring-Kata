package com.gildedrose;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class BrieTest {

    private final int MAX_QUALITY = 50;
    private final String ITEM_AGED_BRIE = "Aged Brie";

    @Test
    void increasesQualityAndDecreasesSellIn() {
        Item[] items = new Item[]{new Item(ITEM_AGED_BRIE, 10, 10)};
        GildedRose app = new GildedRose(items);
        app.updateQuality();
        assertEquals(9, app.items[0].sellIn);
        assertEquals(11, app.items[0].quality);
    }

    @Test
    void shouldNotIncreaseQualityAfterMaximumIsReached() {
        Item[] items = new Item[]{new Item(ITEM_AGED_BRIE, 1, MAX_QUALITY)};
        GildedRose app = new GildedRose(items);
        app.updateQuality();
        assertEquals(0, app.items[0].sellIn);
        assertEquals(MAX_QUALITY, app.items[0].quality);
    }

    @Test
    void sellInIsBelowZeroQualityIncreasesDouble() {
        Item[] items = new Item[]{new Item(ITEM_AGED_BRIE, 0, 0)};
        GildedRose app = new GildedRose(items);
        app.updateQuality();
        assertEquals(-1, app.items[0].sellIn);
        assertEquals(2, app.items[0].quality);
    }

    @Test
    void sellInIsBelowZeroQualityIncreasesDoubleTillMaximumQuality() {
        Item[] items = new Item[]{new Item(ITEM_AGED_BRIE, -5, MAX_QUALITY - 1)};
        GildedRose app = new GildedRose(items);
        app.updateQuality();
        assertEquals(-6, app.items[0].sellIn);
        assertEquals(MAX_QUALITY, app.items[0].quality);
    }

    @Test
    void updateFourTimesQualityImproves() {
        Item[] items = new Item[]{new Item(ITEM_AGED_BRIE, 1, 0)};
        GildedRose app = new GildedRose(items);
        app.updateQuality();
        app.updateQuality();
        app.updateQuality();
        app.updateQuality();
        assertEquals(-3, app.items[0].sellIn);
        assertEquals(7, app.items[0].quality);
    }
}