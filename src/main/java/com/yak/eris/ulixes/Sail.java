package com.yak.eris.ulixes;

import com.yak.eris.ulixes.map.UlixesMap;
import com.yak.eris.ulixes.port.UlixesPort;

public interface Sail {

    UlixesPort[] availablePort(UlixesMap map);

    void sail(UlixesPort port);

}
