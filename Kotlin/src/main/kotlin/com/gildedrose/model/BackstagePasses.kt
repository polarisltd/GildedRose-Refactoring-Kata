package com.gildedrose.model

import com.gildedrose.Item

class BackstagePasses(item: Item) : InventoryItem(item) {
    override fun updateQuality() {
        incQualityIf(item) { item.quality < MAX_QUALITY }
        incQualityIf(item) { item.sellIn < ELEVEN && item.quality < MAX_QUALITY }
        incQualityIf(item) { item.sellIn < SIX && item.quality < MAX_QUALITY }
        decSellin(item)
        resetQualityIf(item) { item.sellIn < ZERO }
    }
}

