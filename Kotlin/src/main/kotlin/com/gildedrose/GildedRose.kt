package com.gildedrose

class GildedRose(var items: List<Item>) {

    val inventoryManager = InventoryManager(items)

    fun updateQuality() {
        inventoryManager.updateQuality()
    }

}
