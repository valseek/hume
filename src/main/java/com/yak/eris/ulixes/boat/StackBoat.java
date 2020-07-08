package com.yak.eris.ulixes.boat;

import com.fasterxml.jackson.databind.JsonNode;
import com.yak.eris.ulixes.port.UlixesPort;
import com.yak.eris.ulixes.boat.component.GoodsContainer;

import java.util.Stack;

public class StackBoat implements UlixesBoat {

    JsonNode goods;

    Stack<GoodsContainer> runStack;

    @Override
    public JsonNode getGoods() {
        return goods;
    }

    @Override
    public void setGoods(JsonNode goods) {

    }

    @Override
    public UlixesBoat reload(UlixesPort port) {
        return this;
    }

    @Override
    public void dock(UlixesPort map) {

    }
}
