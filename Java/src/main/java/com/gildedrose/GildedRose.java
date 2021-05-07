package com.gildedrose;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.function.Function;

class GildedRose {
    Item[] items;

    private static final Map<String, Function<Item, DepreciatingItem>> mapper = new HashMap<>();

    static {
        mapper.put("Aged Brie", Brie::new);
        mapper.put("Backstage passes to a TAFKAL80ETC concert", BackstagePass::new);
        mapper.put("Sulfuras, Hand of Ragnaros", Sulfuras::new);
    }

    public GildedRose(Item[] items) {
        this.items = items;
    }

    public void updateQuality() {
        Arrays.stream(items)
                .map(item -> mapper.getOrDefault(item.name, GildedRose.DepreciatingItem::new).apply(item))
                .forEach(DepreciatingItem::updateQuality);
    }

    static class DepreciatingItem {
        final Item item;

        DepreciatingItem(Item item) {
            this.item = item;
        }

        void updateQuality() {
            ageByOneDay();

            decreaseShelfLife();

            if (this.item.sellIn < 0) {
                atTheEndOfShelfLife();
            }
        }

        protected void atTheEndOfShelfLife() {
            decreaseQuality();
        }

        protected void ageByOneDay() {
            decreaseQuality();
        }

        protected void decreaseShelfLife() {
            this.item.sellIn = this.item.sellIn - 1;
        }

        protected void decreaseQuality() {
            if (this.item.quality > 0) {
                this.item.quality = this.item.quality - 1;
            }
        }

        protected void increaseQuality() {
            if (this.item.quality < 50) {
                this.item.quality = this.item.quality + 1;
            }
        }
    }

    static class Brie extends DepreciatingItem {
        Brie(Item item) {
            super(item);
        }

        protected void atTheEndOfShelfLife() {
            increaseQuality();
        }

        protected void ageByOneDay() {
            increaseQuality();
        }
    }

    static class Sulfuras extends DepreciatingItem {
        Sulfuras(Item item) {
            super(item);
        }

        @Override
        protected void ageByOneDay() {
            return;
        }

        @Override
        protected void decreaseShelfLife() {
            return;
        }

        @Override
        protected void atTheEndOfShelfLife() {
            return;
        }
    }

    static class BackstagePass extends DepreciatingItem {
        BackstagePass(Item item) {
            super(item);
        }

        @Override
        protected void ageByOneDay() {
            if (this.item.name.equals("Backstage passes to a TAFKAL80ETC concert")) {
                increaseQuality();

                if (this.item.sellIn < 11) {
                    increaseQuality();
                }

                if (this.item.sellIn < 6) {
                    increaseQuality();
                }
                return;
            }
        }

        @Override
        protected void atTheEndOfShelfLife() {
            if (this.item.name.equals("Backstage passes to a TAFKAL80ETC concert")) {
                this.item.quality = this.item.quality - this.item.quality;
                return;
            }
        }
    }
}