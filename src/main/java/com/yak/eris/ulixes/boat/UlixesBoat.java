package com.yak.eris.odysseus.boat;


import com.fasterxml.jackson.databind.JsonNode;
import com.yak.eris.odysseus.port.CircePort;

public interface CirceBoat {

    JsonNode getGoods();

    CirceBoat reload(CircePort port);

    void dock(CircePort port);

}
