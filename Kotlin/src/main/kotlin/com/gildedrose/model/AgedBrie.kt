package com.gildedrose.model

import com.gildedrose.Item

class AgedBrie(item: Item) : InventoryItem(item) {
    override fun updateQuality() {
        with(item) {
            if (quality < MAX_QUALITY) quality++
            sellIn--
            if (sellIn < ZERO && quality < MAX_QUALITY) quality++
        }
    }
}
