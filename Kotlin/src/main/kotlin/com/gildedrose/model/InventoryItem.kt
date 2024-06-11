package com.gildedrose.model

import com.gildedrose.Item

abstract class InventoryItem(val item: Item) {
    abstract fun updateQuality()

    companion object {

        fun create(item: Item): InventoryItem {
            return when (item.name) {
                AGED_BRIE -> AgedBrie(item)
                BACKSTAGE_PASSES -> BackstagePasses(item)
                SULFURAS -> Sulfuras(item)
                PLUS_FIVE_DEXTERITY_VEST -> PlusFiveDexterityVest(item)
                ELIXIR_OF_MONGOOSE -> ElixirOtMongoose(item)
                CONJURED_MANA_CAKE -> ConjuredManaCake(item)
                // Add other cases here for other item types
                else -> OtherItem(item)
            }
        }

        private const val AGED_BRIE = "Aged Brie"
        private const val BACKSTAGE_PASSES = "Backstage passes to a TAFKAL80ETC concert"
        private const val SULFURAS = "Sulfuras, Hand of Ragnaros"
        private const val PLUS_FIVE_DEXTERITY_VEST = "+5 Dexterity Vest"
        private const val ELIXIR_OF_MONGOOSE = "Elixir of the Mongoose"
        private const val CONJURED_MANA_CAKE = "Conjured Mana Cake"

        const val MAX_QUALITY = 50
        const val ZERO = 0
        const val ELEVEN = 11
        const val SIX = 6
    }
}




