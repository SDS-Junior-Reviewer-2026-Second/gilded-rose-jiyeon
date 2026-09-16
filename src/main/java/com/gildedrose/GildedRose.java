package com.gildedrose;

class GildedRose {

    private static final String AGED_BRIE = "Aged Brie";
    private static final String BACKSTAGE_PASSES = "Backstage passes to a TAFKAL80ETC concert";
    private static final String SULFURAS = "Sulfuras, Hand of Ragnaros";

    Item[] items;

    public GildedRose(Item[] items) {
        this.items = items;
    }

    public void updateQualityForAgedBrie(Item item) {
        if (item.sellIn > 0) item.quality += 1;
        else item.quality += 2;
        if (item.quality >= 50) item.quality = 50;
    }

    public void updateQualityForBackstagePasses(Item item) {
        if (item.sellIn > 10) item.quality += 1;
        else if (item.sellIn > 5) item.quality += 2;
        else if (item.sellIn > 0) item.quality += 3;
        else item.quality = 0;
    }

    public void updateQualityForNormalItem(Item item) {
        if (item.sellIn > 0) item.quality -= 1;
        else item.quality -= 2;
        if (item.quality < 0) item.quality = 0;
    }

    public void updateQualityForSulfuras(Item item) {

    }

    public void updateQuality() {

        for (int i = 0; i < items.length; i++) {

            Item item = items[i];

            if (item.name.equals(SULFURAS)) {
                updateQualityForSulfuras(item);
                continue;
            }

            if (item.name.equals(AGED_BRIE)) updateQualityForAgedBrie(item);
            else if (item.name.equals(BACKSTAGE_PASSES)) updateQualityForBackstagePasses(item);
            else updateQualityForNormalItem(item);

            item.sellIn -= 1;

        }
    }
}
