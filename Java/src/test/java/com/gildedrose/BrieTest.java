package com.gildedrose;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class BrieTest {
    @Test
    void increasesQualityAndDecreasesSellIn() {
        Item[] items = new Item[]{new Item("Aged Brie", 10, 10)};
        GildedRose app = new GildedRose(items);
        app.updateQuality();
        assertEquals(9, app.items[0].sellIn);
        assertEquals(11, app.items[0].quality);
    }

    @Test
    void shouldNotIncreaseQualityAfterMaximum() {
        Item[] items = new Item[]{new Item("Aged Brie", 1, 50)};
        GildedRose app = new GildedRose(items);
        app.updateQuality();
        assertEquals(0, app.items[0].sellIn);
        assertEquals(50, app.items[0].quality);
    }

    @Test
    void sellinIsBelowZeroQualityInreasesDouble() {
        Item[] items = new Item[]{new Item("Aged Brie", 0, 0)};
        GildedRose app = new GildedRose(items);
        app.updateQuality();
        assertEquals(-1, app.items[0].sellIn);
        assertEquals(2, app.items[0].quality);
    }

    @Test
    void sellinIsBelowZeroQualityInreasesDoubleTillFifty() {
        Item[] items = new Item[]{new Item("Aged Brie", -5, 49)};
        GildedRose app = new GildedRose(items);
        app.updateQuality();
        assertEquals(-6, app.items[0].sellIn);
        assertEquals(50, app.items[0].quality);
    }

    @Test
    void updateFourtimesQualityimproves() {
        Item[] items = new Item[]{new Item("Aged Brie", 1, 0)};
        GildedRose app = new GildedRose(items);
        app.updateQuality();
        app.updateQuality();
        app.updateQuality();
        app.updateQuality();
        assertEquals(-3, app.items[0].sellIn);
        assertEquals(7, app.items[0].quality);
    }
}