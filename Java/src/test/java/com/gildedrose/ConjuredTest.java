package com.gildedrose;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class ConjuredTest {

    @Test
    void degradesTwiceAsFast() {
        //- "Conjured" items degrade in Quality twice as fast as normal items
        Item[] items = new Item[]{new Item("Conjured", 10, 10)};
        GildedRose app = new GildedRose(items);
        app.updateQuality();
        assertEquals(8, app.items[0].quality);
    }

    @Test
    void degradesTwiceAsFastExpired() {
        Item[] items = new Item[]{new Item("Conjured", 0, 10)};
        GildedRose app = new GildedRose(items);
        app.updateQuality();
        assertEquals(6, app.items[0].quality);
    }
}