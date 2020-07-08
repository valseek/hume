package com.yak.eris.odysseus;

import com.yak.eris.odysseus.map.CirceMap;
import com.yak.eris.odysseus.port.CircePort;

public interface Sail {

    CircePort[] availablePort(CirceMap map);

    void sail(CircePort port);

}
