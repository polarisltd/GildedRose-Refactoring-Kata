package com.gildedrose.model

import com.gildedrose.Item

class OtherItem(item: Item) : InventoryItem(item) {
    override fun updateQuality() {
            decQualityIf(item) { item.quality > ZERO }
            decSellin(item)
            decQualityIf(item) { item.sellIn < ZERO && item.quality > ZERO }
        }
}


