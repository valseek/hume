package com.yak.eris.ulixes.port;

import com.yak.eris.ulixes.boat.UlixesBoat;
import com.yak.eris.ulixes.method.UlixesMethod;

public interface UlixesPort {

    UlixesMethod getMethod();

    String getName();

    boolean inspection(UlixesBoat boat);


}
