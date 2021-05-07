package com.gildedrose;

import static com.gildedrose.SpecialItem.*;

class GildedRose {

  Item[] items;

  public GildedRose(Item[] items) {
    this.items = items;
  }

  public void updateQuality() {
    for (Item item : items) {
      if (SULFURAS_HAND_OF_RAGNAROS.getName().equals(item.name)) {
        continue;
      }
      processQuality(item);

      item.sellIn = item.sellIn - 1;
      processExpirationDate(item);
    }
  }

  private void processExpirationDate(Item item) {
    // Expired Items
    if (item.sellIn < 0) {
      processExpiredItems(item);
    }
  }

  private void processQuality(Item item) {
    if (AGED_BRIE.getName().equals(item.name)
        || BACKSTAGE_PASSES_TO_A_TAFKAL_80_ETC_CONCERT.getName().equals(item.name)) {
      bumpQualityUp(item);
      bumpSpecialCaseForBackStage(item);
    } else {
      bumpQualityDown(item);
    }
  }

  private void bumpSpecialCaseForBackStage(Item item) {
    if (!BACKSTAGE_PASSES_TO_A_TAFKAL_80_ETC_CONCERT.getName().equals(item.name)) {
      return;
    }
    if (item.sellIn < 11) {
      bumpQualityUp(item);
    }
    if (item.sellIn < 6) {
      bumpQualityUp(item);
    }
  }

  private void processExpiredItems(Item item) {
    if (BACKSTAGE_PASSES_TO_A_TAFKAL_80_ETC_CONCERT.getName().equals(item.name)) {
      item.quality = 0;
    } else if (AGED_BRIE.getName().equals(item.name)) {
      bumpQualityUp(item);
    } else {
      bumpQualityDown(item);
    }
  }

  private void bumpQualityDown(Item item) {
    if (item.quality > 0) {
      item.quality = item.quality - 1;
    }
  }

  private void bumpQualityUp(Item item) {
    if (item.quality < 50) {
      item.quality = item.quality + 1;
    }
  }
}
