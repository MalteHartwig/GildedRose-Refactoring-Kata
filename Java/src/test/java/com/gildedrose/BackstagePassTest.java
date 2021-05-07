package com.gildedrose;

import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class BackstagePassTest {

    @Test
    void quality_ShouldNotIncrease_WhenMaxQuality() {
        Item[] items = new Item[] { new Item("Backstage passes to a TAFKAL80ETC concert", 15, 50) };
        GildedRose app = new GildedRose(items);
        app.updateQuality();
        assertEquals(50, app.items[0].quality);
        assertEquals(14, app.items[0].sellIn);
    }

    @Test
    void quality_ShouldBeZero_WhenSellin_LessThanZero() {
        Item[] items = new Item[] { new Item("Backstage passes to a TAFKAL80ETC concert", -1, 50) };
        GildedRose app = new GildedRose(items);
        app.updateQuality();
        assertEquals(0, app.items[0].quality);
        assertEquals(-2, app.items[0].sellIn);
    }

    @Test
    void quality_ShouldBeZero_WhenSellin_EqualsZero() {
        Item[] items = new Item[] { new Item("Backstage passes to a TAFKAL80ETC concert", 0, 50) };
        GildedRose app = new GildedRose(items);
        app.updateQuality();
        assertEquals(0, app.items[0].quality);
        assertEquals(-1, app.items[0].sellIn);
    }

    @Test
    void quality_ShouldIncreaseByOne_WhenSellin_MoreThan10() {
        Item[] items = new Item[] { new Item("Backstage passes to a TAFKAL80ETC concert", 15, 49) };
        GildedRose app = new GildedRose(items);
        app.updateQuality();
        assertEquals(50, app.items[0].quality);
        assertEquals(14, app.items[0].sellIn);
    }

    @Test
    void quality_ShouldIncreaseByTwo_WhenSellin_LessThan10_MoreThan5() {
        Item[] items = new Item[] { new Item("Backstage passes to a TAFKAL80ETC concert", 10, 48) };
        GildedRose app = new GildedRose(items);
        app.updateQuality();
        assertEquals(50, app.items[0].quality);
        assertEquals(9, app.items[0].sellIn);
    }

    @Test
    void quality_ShouldIncreaseByThree_WhenSellin_LessThanEqual5() {
        Item[] items = new Item[] { new Item("Backstage passes to a TAFKAL80ETC concert", 5, 47) };
        GildedRose app = new GildedRose(items);
        app.updateQuality();
        assertEquals(50, app.items[0].quality);
        assertEquals(4, app.items[0].sellIn);
    }

    @Test
    void quality_ShouldUpdateQuality_WhenMultipleItems() {
        Item[] items = new Item[] { new Item("Backstage passes to a TAFKAL80ETC concert", 5, 47),
                new Item("Backstage passes to a TAFKAL80ETC concert", -1, 20)};
        GildedRose app = new GildedRose(items);
        app.updateQuality();
        assertEquals(50, app.items[0].quality);
        assertEquals(4, app.items[0].sellIn);
        assertEquals(0, app.items[1].quality);
        assertEquals(-2, app.items[1].sellIn);

    }

    @Disabled
    @Test
    void quality_ShouldThrowException_WhenQualityLessThanZero() {
        Item[] items = new Item[] { new Item("Backstage passes to a TAFKAL80ETC concert", 5, -1)};
        GildedRose app = new GildedRose(items);
        app.updateQuality();
        assertEquals(2, app.items[0].quality);
        assertEquals(4, app.items[0].sellIn);

    }

    @Test
    void quality_ShouldNotThrowException_WhenEmptyItemList() {
        Item[] items = new Item[]{};
        GildedRose app = new GildedRose(items);
        app.updateQuality();

    }


    @Disabled
    @Test
    void quality_ShouldNotThrowException_WhenItemListContainsNull() {
        Item[] items = new Item[]{null};
        GildedRose app = new GildedRose(items);
        app.updateQuality();

    }

}
