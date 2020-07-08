package com.yak.eris.circe;

import org.junit.jupiter.api.Test;

public class TestNoArgCall {

    public void noarg(Object ...objects){
        System.out.println(objects.length);
        nnarg(objects);
    }

    public void nnarg(Object ...objects){
        System.out.println(objects.length);
    }


    @Test
    public void test(){
        noarg();
    }

}
