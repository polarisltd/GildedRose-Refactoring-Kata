package com.gildedrose.model

import com.gildedrose.Item

class BackstagePasses(item: Item) : InventoryItem(item) {
    override fun updateQuality() {
        with(item) {
            if (quality < MAX_QUALITY) quality++
            if(sellIn < ELEVEN && quality < MAX_QUALITY) quality++
            if(sellIn < SIX && quality < MAX_QUALITY) quality++
            sellIn--
            if (sellIn < ZERO) quality = 0
        }
    }
}

