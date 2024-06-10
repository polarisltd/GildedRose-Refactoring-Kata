package com.gildedrose.model

import com.gildedrose.Item

abstract class InventoryItem(val item: Item) {
    abstract fun updateQuality()

    companion object {

        fun create(item: Item): InventoryItem {
            return when (item.name) {
                AGED_BRIE -> AgedBrie(item)
                BACKSTAGE_PASSES -> BackstagePasses(item)
                SULFURAS -> Sulfuras(item)
                // Add other cases here for other item types
                else -> OtherItem(item)
            }
        }

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

        //fun incSellin(item: Item) = item.sellIn++
        fun decSellin(item: Item) = item.sellIn--

        private const val AGED_BRIE = "Aged Brie"
        private const val BACKSTAGE_PASSES = "Backstage passes to a TAFKAL80ETC concert"
        private const val SULFURAS = "Sulfuras, Hand of Ragnaros"

        const val MAX_QUALITY = 50
        const val ZERO = 0
        const val ELEVEN = 11
        const val SIX = 6
    }
}




