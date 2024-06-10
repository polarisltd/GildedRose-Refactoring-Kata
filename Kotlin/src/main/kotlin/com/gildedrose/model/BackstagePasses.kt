package com.gildedrose.model

import com.gildedrose.Item

class BackstagePasses(item: Item) : InventoryItem(item) {
    override fun updateQuality() {
        // trying to fix this. if sellin is 10 .. 6, quality should increase by 2.
        // allthrough tests are passing, but the logic possible is wrong.
        incQualityIf(item) { item.quality < MAX_QUALITY }
        incQualityIf(item) { item.sellIn < ELEVEN && item.quality < MAX_QUALITY }
        incQualityIf(item) { item.sellIn < SIX && item.quality < MAX_QUALITY }
        decSellin(item)
        resetQualityIf(item) { item.sellIn < ZERO }
    }
}

