package com.gildedrose

import com.gildedrose.model.InventoryItem

class InventoryManager(items: List<Item>) {
    val inventoryItems: List<InventoryItem> = items.map { InventoryItem.create(it) }

    fun updateQuality() {
        inventoryItems.forEach { it.updateQuality() }
    }
}