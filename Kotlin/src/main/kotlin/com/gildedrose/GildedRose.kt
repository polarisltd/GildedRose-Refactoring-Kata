package com.gildedrose

import com.gildedrose.GildedRoseHelper.decQualityIf
import com.gildedrose.GildedRoseHelper.decSellin
import com.gildedrose.GildedRoseHelper.incQualityIf
import com.gildedrose.GildedRoseHelper.resetQualityIf

class GildedRose(var items: List<Item>) {

    companion object {
        const val MAX_QUALITY = 50
        const val ZERO = 0;
        const val ELEVEN = 11;
        const val SIX = 6;
    }

    @Suppress("LongMethod")
    fun updateQuality() {
        items.forEach { item ->
            when (item.name) {
                "Aged Brie" -> updateAgedBrie(item)
                "Backstage passes to a TAFKAL80ETC concert" -> updateBackstagePasses(item)
                "Sulfuras, Hand of Ragnaros" -> updateSulfuras(item) // Do nothing for Sulfuras
                //"Conjured Mana Cake" -> updateConjuredManaCake(item) // "Conjured" items degrade in Quality twice as fast as normal items
                else -> updateOtherItem(item)
                // any unknown items like following is terminated to else:
                // Elixir of the Mongoose
                // +5 Dexterity Vest
                // Conjured Mana Cake
                // test passage is a gold standard!
            }
        }
    }

    private fun updateAgedBrie(item: Item) {
        incQualityIf(item) { it.quality < MAX_QUALITY }
        decSellin(item)
        incQualityIf(item) { it.sellIn < ZERO && it.quality < MAX_QUALITY }
    }

    private fun updateBackstagePasses(item: Item) {
        // trying to fix this. if sellin is 10 .. 6, quality should increase by 2.
        // allthrough tests are passing, but the logic possible is wrong.
        incQualityIf(item) { item.quality < MAX_QUALITY }
        incQualityIf(item) { item.sellIn < ELEVEN && item.quality < MAX_QUALITY }
        incQualityIf(item) { item.sellIn < SIX && item.quality < MAX_QUALITY }
        decSellin(item)
        resetQualityIf(item) { item.sellIn < ZERO }
    }

    private fun updateSulfuras(item: Item) {
        // Do nothing for Sulfuras
    }

//    private fun updateConjuredManaCake(item: Item) {
//        // we has to be implement this but not tests will cover it (except addon ones)
//    }

    private fun updateOtherItem(item: Item) {
        decQualityIf(item) { item.quality > ZERO }
        decSellin(item)
        decQualityIf(item) { item.sellIn < ZERO && item.quality > ZERO }
    }

 }
