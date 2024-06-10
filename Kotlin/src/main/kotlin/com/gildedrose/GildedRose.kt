package com.gildedrose

class GildedRose(var items: List<Item>) {

    private val inventoryManager = InventoryManager(items)

    fun updateQuality() {
        inventoryManager.updateQuality()
    }
}
