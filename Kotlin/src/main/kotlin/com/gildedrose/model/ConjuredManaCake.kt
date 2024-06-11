package com.gildedrose.model

import com.gildedrose.Item

class ConjuredManaCake(item: Item) : InventoryItem(item) {
    override fun updateQuality() {
        with(item) {
            if (quality > ZERO) quality -= 2
            sellIn--
            if (sellIn < ZERO && quality > ZERO) quality -= 2
        }
    }
}
