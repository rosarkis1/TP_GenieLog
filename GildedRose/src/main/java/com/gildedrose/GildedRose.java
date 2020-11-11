package com.gildedrose;

class GildedRose {
    Item[] items;

    public GildedRose(Item[] items) {
        this.items = items;
    }

    public void updateQuality() {
        for(Item item : items) {

            if(!item.name.equals("Sulfuras, Hand of Ragnaros")){ // si le nom de l'item est different de Sulfuras, Hand of Ragnaros
                item.sellIn-=1;
                //La qualité d'un produit ne peut jamais être négative
                if(item.quality<0){
                    item.quality=0;
                }
                //La qualité d'un produit n'est jamais de plus de 50
                if(item.quality>50){
                    item.quality=50;
                }
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

                    if(item.sellIn<6 ){
                        IncrementItemQuality(item);
                    }

                    if(item.sellIn<=0){
                        item.quality=0;
                    }
                    break;

                case "Conjured Mana Cake":
                    DecrementItemQuality(item);
                    DecrementItemQuality(item);
                    if(item.sellIn < 0)
                    {
                        DecrementItemQuality(item);
                        DecrementItemQuality(item);
                    }
                    break;

                case "Sulfuras, Hand of Ragnaros":
                    item.quality=80;
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