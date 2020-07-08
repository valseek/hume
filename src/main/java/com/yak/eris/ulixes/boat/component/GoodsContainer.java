package com.yak.eris.ulixes.boat.component;

import com.fasterxml.jackson.databind.JsonNode;

public class GoodsContainer implements UlixesBoatContainer {

    JsonNode originData;

    @Override
    @SuppressWarnings("unchecked")
    public <T> T getGoods(Class<T> type) {

        return null;
    }

}
