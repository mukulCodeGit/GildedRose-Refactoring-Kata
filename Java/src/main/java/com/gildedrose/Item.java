package com.gildedrose;

public class Item {

    public String name;

    public int sellIn;

    public int quality;

    public Item(String name, int sellIn, int quality) {
        this.name = name;
        this.sellIn = sellIn;
        this.quality = quality;
    }

   @Override
   public String toString() {
        return this.name + ", " + this.sellIn + ", " + this.quality;
    }

   public void updateItems() {
       boolean isAgedBrie = name.equals("Aged Brie");
       boolean isBackStage = name.equals("Backstage passes to a TAFKAL80ETC concert");
       boolean isSulfuras = name.equals("Sulfuras, Hand of Ragnaros");

       if (!isAgedBrie && !isBackStage) {
           if (quality > 0) {
               if (!isSulfuras) {
                   quality = quality - 1;
               }
           }
       } else {
           if (quality < 50) {
               quality = quality + 1;

               if (isBackStage) {
                   if (sellIn < 11) {
                       if (quality < 50) {
                           quality = quality + 1;
                       }
                   }

                   if (sellIn < 6) {
                       if (quality < 50) {
                           quality = quality + 1;
                       }
                   }
               }
           }
       }

       if (!isSulfuras) {
           sellIn = sellIn - 1;
       }

       if (sellIn < 0) {
           if (!isAgedBrie) {
               if (!isBackStage) {
                   if (quality > 0) {
                       if (!isSulfuras) {
                           quality = quality - 1;
                       }
                   }
               } else {
                   quality = quality - quality;
               }
           } else {
               if (quality < 50) {
                   quality = quality + 1;
               }
           }
       }
   }
}
