package com.redbird.lesson10.components;

import com.redbird.lesson10.interfaces.Programmer;
import org.springframework.stereotype.Component;

@Component
public class Junior implements Programmer {
    @Override
    public String doCoding() {
        return "Junior creating mess";
    }
}
