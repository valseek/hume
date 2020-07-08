package com.yak.eris.ulixes.port;

import com.yak.eris.ulixes.method.CirceMethod;

public class AbstractCircePort implements CircePort {

    protected CirceMethod method;

    @Override
    public CirceMethod getMethod() {
        return method;
    }





}
