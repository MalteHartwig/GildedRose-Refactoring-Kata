package com.gildedrose;

public enum SpecialItem {
  AGED_BRIE("Aged Brie"),
  BACKSTAGE_PASSES_TO_A_TAFKAL_80_ETC_CONCERT("Backstage passes to a TAFKAL80ETC concert"),
  SULFURAS_HAND_OF_RAGNAROS("Sulfuras, Hand of Ragnaros");

  private final String name;

  SpecialItem(String name) {
    this.name = name;
  }

  public String getName() {
    return name;
  }
}
