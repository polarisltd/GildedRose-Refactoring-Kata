package com.gildedrose.model

import com.gildedrose.Item

open class OtherItem(item: Item) : InventoryItem(item) {
    override fun updateQuality() {
        with(item) {
            if (quality > ZERO) quality--
            sellIn--
            if (sellIn < ZERO && quality > ZERO) quality--
        }
    }
}


