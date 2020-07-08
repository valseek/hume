package com.yak.eris.ulixes.port;

import com.yak.eris.ulixes.method.UlixesMethod;

public class AbstractUlixesPort implements UlixesPort {

    protected String name;

    protected UlixesMethod method;

    @Override
    public UlixesMethod getMethod() {
        return method;
    }

    @Override
    public String getName() {
        return null;
    }


}
