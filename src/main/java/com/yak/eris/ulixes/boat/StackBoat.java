package com.yak.eris.odysseus.boat;

import com.fasterxml.jackson.databind.JsonNode;
import com.yak.eris.odysseus.port.CircePort;
import com.yak.eris.odysseus.boat.component.GoodsContainer;

import java.util.Stack;

public class StackBoat implements CirceBoat {

    JsonNode goods;

    Stack<GoodsContainer> runStack;

    @Override
    public JsonNode getGoods() {
        return goods;
    }

    @Override
    public CirceBoat reload(CircePort port) {
        return this;
    }

    @Override
    public void dock(CircePort map) {

    }
}
