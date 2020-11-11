package com.gildedrose;

import org.junit.jupiter.api.Test;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;

class GildedRoseTest {

    @Test
    void foo() {
        Item[] items=new Item[]{
                new Item("+5 Dexterity Vest", 10, 20), //
                new Item("Aged Brie", 2, 0), //
                new Item("Elixir of the Mongoose", 5, 7), //
                new Item("Sulfuras, Hand of Ragnaros", 0, 80), //
                new Item("Sulfuras, Hand of Ragnaros", -1, 80),

                new Item("Backstage passes to a TAFKAL80ETC concert", 15, 20),
                new Item("Backstage passes to a TAFKAL80ETC concert", 10, 49),
                new Item("Backstage passes to a TAFKAL80ETC concert", 5, 49),
                // this conjured item does not work properly yet
                new Item("Conjured Mana Cake", 3, 6),
                new Item("Conjured Mana Cake", -3, 80),
                new Item("Aged Brie", -3, -80),
                new Item("Backstage passes to a TAFKAL80ETC concert", -3, -80)};
        GildedRose app=new GildedRose(items);
        app.updateQuality();
        System.out.println("name, sellIn, quality");
        for(Item item : items) {
            System.out.println(item);
        }
        Integer[] qualityResults = {19,1,6,80,80,21,50,50,5,78,-78,0};
        Integer[] sellInResults = {9,1,4,0,-1,14,9,4,2,-4,-4,-4};

        for(int i=0; i<items.length; i++) {

            assertThat(app.items[i].quality, is( qualityResults[i]));
            assertThat(app.items[i].sellIn, is( sellInResults[i]));
            assertThat(app.items[i].name, is( app.items[i].name));
        }

    }
}