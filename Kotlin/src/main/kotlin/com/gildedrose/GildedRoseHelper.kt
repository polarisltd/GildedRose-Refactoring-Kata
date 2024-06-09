package com.gildedrose

object GildedRoseHelper {

    fun resetQualityIf(item: Item, condition: (Item) -> Boolean) {
        if (condition(item)) {
            item.quality = 0
        }
    }

    fun incQualityIf(item: Item, condition: (Item) -> Boolean) {
        if (condition(item)) {
            item.quality++
        }
    }

    fun decQualityIf(item: Item, condition: (Item) -> Boolean) {
        if (condition(item)) {
            item.quality--
        }
    }

    fun incSellin(item: Item) = item.sellIn++
    fun decSellin(item: Item) = item.sellIn--
}
