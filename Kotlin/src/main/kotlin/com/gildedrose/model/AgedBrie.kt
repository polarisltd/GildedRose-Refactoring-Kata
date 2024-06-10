package com.gildedrose.model

import com.gildedrose.Item

class AgedBrie(item: Item) : InventoryItem(item) {
    override fun updateQuality() {
        incQualityIf(item) { it.quality < MAX_QUALITY }
        decSellin(item)
        incQualityIf(item) { it.sellIn < ZERO && it.quality < MAX_QUALITY }
    }

}
