package com.gildedrose;

class GildedRose {
    Item[] items;

    public GildedRose(Item[] items) {
        this.items = items;
    }

    public void updateQuality() {
        for(Item item : items) {
            if(item.name.equals("Aged Brie")){
                IncrementItemQuality(item);
            }
            else if(item.name.equals("Backstage passes to a TAFKAL80ETC concert")){
                if(item.quality<50){
                    item.quality+=1;

                    if(item.sellIn<11){
                        IncrementItemQuality(item);
                    }

                    if(item.sellIn<6){
                        IncrementItemQuality(item);
                    }
                }
            }

            else {

                if(!item.name.equals("Sulfuras, Hand of Ragnaros")){
                    DecrementItemQuality(item);
                }
            }

            if(item.name.equals("Sulfuras, Hand of Ragnaros")){
            }else {
                item.sellIn-=1;
            }

            if(item.sellIn<0){
                if(item.name.equals("Aged Brie")){
                    IncrementItemQuality(item);
                }else {
                    if(item.name.equals("Backstage passes to a TAFKAL80ETC concert")){
                        item.quality=0;
                    }else {

                        if(item.name.equals("Sulfuras, Hand of Ragnaros")){
                            continue;
                        }
                        DecrementItemQuality(item);
                    }
                }
            }
        }
    }

    private void DecrementItemQuality(Item item) {
        if(item.quality>0){
            item.quality-=1;
        }
    }

    private void IncrementItemQuality(Item item) {
        if(item.quality<50){
            item.quality+=1;

        }
    }
}
