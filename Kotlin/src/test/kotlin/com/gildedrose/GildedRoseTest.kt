package com.gildedrose

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.MethodSource
import java.util.stream.Stream

internal class GildedRoseTest {

    @Test
    fun foo() {
        val items = listOf(Item("foo", 0, 0))
        val app = GildedRose(items)
        app.updateQuality()
        assertEquals("foo", app.items[0].name)

    }


    data class ItemTestCase(val initialItem: Item, val expectedItems: List<Item>)

        companion object {
            @Suppress("LongMethod")
            @JvmStatic
            fun itemTestCases(): Stream<ItemTestCase> {
                return Stream.of(
                    ItemTestCase(
                        initialItem = Item("+5 Dexterity Vest", 10, 20),
                        expectedItems = listOf(
                            Item("+5 Dexterity Vest", 10, 20),
                            Item("+5 Dexterity Vest", 9, 19),
                            Item("+5 Dexterity Vest", 8, 18),
                            Item("+5 Dexterity Vest", 7, 17),
                            Item("+5 Dexterity Vest", 6, 16),
                            Item("+5 Dexterity Vest", 5, 15),
                            Item("+5 Dexterity Vest", 4, 14),
                            Item("+5 Dexterity Vest", 3, 13),
                            Item("+5 Dexterity Vest", 2, 12),
                            Item("+5 Dexterity Vest", 1, 11)
                        )
                    ),
                    ItemTestCase(
                        initialItem = Item("Aged Brie", 2, 0),
                        expectedItems = listOf(
                            Item("Aged Brie", 2, 0),
                            Item("Aged Brie", 1, 1),
                            Item("Aged Brie", 0, 2),
                            Item("Aged Brie", -1, 4),
                            Item("Aged Brie", -2, 6),
                            Item("Aged Brie", -3, 8),
                            Item("Aged Brie", -4, 10),
                            Item("Aged Brie", -5, 12),
                            Item("Aged Brie", -6, 14),
                            Item("Aged Brie", -7, 16),
                            Item("Aged Brie", -8, 18),
                        )),
                        ItemTestCase(
                            initialItem = Item("Elixir of the Mongoose", 5, 7),
                            expectedItems = listOf(
                                Item("Elixir of the Mongoose", 5, 7),
                                Item("Elixir of the Mongoose", 4, 6),
                                Item("Elixir of the Mongoose", 3, 5),
                                Item("Elixir of the Mongoose", 2, 4),
                                Item("Elixir of the Mongoose", 1, 3),
                                Item("Elixir of the Mongoose", 0, 2),
                                Item("Elixir of the Mongoose", -1, 0),
                                Item("Elixir of the Mongoose", -2, 0),
                                Item("Elixir of the Mongoose", -3, 0),
                                Item("Elixir of the Mongoose", -4, 0)
                            )
                        ),
                        ItemTestCase(
                            initialItem = Item("Sulfuras, Hand of Ragnaros", 0, 80),
                            expectedItems =  List(11) { _ -> Item("Sulfuras, Hand of Ragnaros", 0, 80) }
                        ),
                        ItemTestCase(
                            initialItem = Item("Sulfuras, Hand of Ragnaros", -1, 80),
                            expectedItems =  List(11) { _ -> Item("Sulfuras, Hand of Ragnaros", -1, 80) }

                        ),
                        ItemTestCase(
                            initialItem = Item("Backstage passes to a TAFKAL80ETC concert", 15, 20),
                            expectedItems = listOf(
                                Item("Backstage passes to a TAFKAL80ETC concert", 15, 20),
                                Item("Backstage passes to a TAFKAL80ETC concert", 14, 21),
                                Item("Backstage passes to a TAFKAL80ETC concert", 13, 22),
                                Item("Backstage passes to a TAFKAL80ETC concert", 12, 23),
                                Item("Backstage passes to a TAFKAL80ETC concert", 11, 24),
                                Item("Backstage passes to a TAFKAL80ETC concert", 10, 25),
                                Item("Backstage passes to a TAFKAL80ETC concert", 9, 27),
                                Item("Backstage passes to a TAFKAL80ETC concert", 8, 29)
                            )
                        ),
                        ItemTestCase(
                            initialItem = Item("Backstage passes to a TAFKAL80ETC concert", 5, 49),
                            expectedItems = listOf(
                                Item("Backstage passes to a TAFKAL80ETC concert", 5, 49),
                                Item("Backstage passes to a TAFKAL80ETC concert", 4, 50),
                                Item("Backstage passes to a TAFKAL80ETC concert", 3, 50),
                                Item("Backstage passes to a TAFKAL80ETC concert", 2, 50),
                                Item("Backstage passes to a TAFKAL80ETC concert", 1, 50),
                                Item("Backstage passes to a TAFKAL80ETC concert", 0, 50),
                                Item("Backstage passes to a TAFKAL80ETC concert", -1, 0),
                                Item("Backstage passes to a TAFKAL80ETC concert", -2, 0)
                            )
                        ),
                        ItemTestCase(
                            initialItem = Item("Conjured Mana Cake", 3, 6),
                            expectedItems = listOf(
                                Item("Conjured Mana Cake", 3, 6),
                                Item("Conjured Mana Cake", 2, 4),
                                Item("Conjured Mana Cake", 1, 2),
                                Item("Conjured Mana Cake", 0, 0),
                                Item("Conjured Mana Cake", -1, 0),
                                Item("Conjured Mana Cake", -2, 0),
                                Item("Conjured Mana Cake", -3, 0),
                                Item("Conjured Mana Cake", -4, 0),
                                Item("Conjured Mana Cake", -5, 0),
                                Item("Conjured Mana Cake", -6, 0),
                                Item("Conjured Mana Cake", -7, 0)
                            )
                        )
                    )

            }
        }

        @ParameterizedTest
        @MethodSource("itemTestCases")
        fun testUpdateQuality(testCase: ItemTestCase) {
            val app = GildedRose(listOf(testCase.initialItem))
            testCase.expectedItems.forEachIndexed { index, expectedItem ->
                val actualItem = app.items[0]
                println("day ${index} ${actualItem.name} ${actualItem.sellIn} ${actualItem.quality}")
                assertEquals(expectedItem.name, actualItem.name)
                assertEquals(expectedItem.sellIn, actualItem.sellIn)
                assertEquals(expectedItem.quality, actualItem.quality)
                app.updateQuality()
            }
        }
}

