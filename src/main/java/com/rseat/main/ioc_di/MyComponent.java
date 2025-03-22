package com.rseat.main.ioc_di;

import org.springframework.stereotype.Service;

@Service
public class MyComponent {

    public String getComponentName() {
        return "MyComponent teste da rota";
    }
}
