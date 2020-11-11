package com.gildedrose;

class GildedRose {
    Item[] items;

    public GildedRose(Item[] items) {
        this.items = items;
    }

    public void updateQuality() {
        for(Item item : items) {

            if(item.name.equals("Sulfuras, Hand of Ragnaros"))
            {
            }
            else
            {
                item.sellIn-=1;
            }

            switch (item.name) {

                case "Aged Brie":
                    IncrementItemQuality(item);
                    if(item.sellIn<0)
                        IncrementItemQuality(item);
                    break;

                case "Backstage passes to a TAFKAL80ETC concert":
                    IncrementItemQuality(item);

                    if(item.sellIn<11){
                        IncrementItemQuality(item);
                    }

                    if(item.sellIn<6){
                        IncrementItemQuality(item);
                    }

                    if(item.sellIn<0)
                        item.quality=0;

                    break;

                case "Sulfuras, Hand of Ragnaros":
                    break;

                default:
                    DecrementItemQuality(item);
                    if(item.sellIn<0)
                        DecrementItemQuality(item);

                    break;
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