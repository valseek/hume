package com.yak.eris.odysseus.boat.component;

import com.fasterxml.jackson.databind.JsonNode;

public class GoodsContainer implements CirceBoatContainer{

    JsonNode originData;

    @Override
    @SuppressWarnings("unchecked")
    public <T> T getGoods(Class<T> type) {

        return null;
    }

}
