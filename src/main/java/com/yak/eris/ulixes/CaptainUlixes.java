package com.yak.eris.ulixes;

import com.yak.eris.ulixes.boat.UlixesBoat;
import com.yak.eris.ulixes.map.UlixesMap;
import com.yak.eris.ulixes.port.UlixesPort;

public class CaptainUlixes implements Sail{

    UlixesMap map;

    UlixesBoat boat;

    @Override
    public UlixesPort[] availablePort(UlixesMap map) {
        return new UlixesPort[0];
    }

    @Override
    public void sail(UlixesPort port) {

    }

    public void travel(){

    }


}
