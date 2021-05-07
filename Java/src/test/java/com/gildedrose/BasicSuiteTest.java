package com.gildedrose;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;

class BasicSuiteTest {
  @Test
  @DisplayName("basic quality cannot be negative")
  void basic_quality_cannot_be_negative() {
    Item[] items = new Item[] {new Item("foo", 0, 0)};
    GildedRose app = new GildedRose(items);
    app.updateQuality();
    assertEquals(0, app.items[0].quality);
  }

  @Test
  @DisplayName("basic quality degrade by 1 daily by expiry")
  void basic_quality_degrade_1_daily_by_expiry() {
    Item[] items = new Item[] {new Item("lel", 1, 50)};
    GildedRose app = new GildedRose(items);
    app.updateQuality();
    assertEquals(49, app.items[0].quality);
  }

  @Test
  @DisplayName("basic quality degrade by 2 daily after expiry")
  void basic_quality_degrade_2_daily_after_expiry() {
    Item[] items = new Item[] {new Item("lel", 0, 50)};
    GildedRose app = new GildedRose(items);
    app.updateQuality();
    assertEquals(48, app.items[0].quality);
  }
}
