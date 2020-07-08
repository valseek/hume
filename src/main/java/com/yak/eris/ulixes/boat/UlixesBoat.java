package com.yak.eris.ulixes.boat;


import com.fasterxml.jackson.databind.JsonNode;
import com.yak.eris.ulixes.port.UlixesPort;

public interface UlixesBoat {

    JsonNode getGoods();

    void setGoods(JsonNode goods);

    UlixesBoat reload(UlixesPort port);

    void dock(UlixesPort port);

}
