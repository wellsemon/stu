package com.welleys.stu.json.jackson.stdserializer;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.module.SimpleModule;
import com.welleys.stu.json.jackson.jsonview.UserBean;

import java.io.IOException;

public class StdSerializerMain {
    public static void main(String[] args) throws IOException {

        User user = new User();
        user.setId(1L);
        user.setUname("lier");
        user.setAge(15);
        user.setEmail("lier@lier.com");

        Address address = new Address();
        address.setId(1L);
        address.setProvince("beijing");
        address.setCity("beijing");
        user.setAddress(address);

        System.out.println(user);

        ObjectMapper mapper = new ObjectMapper();
        SimpleModule module = new SimpleModule();
        module.addSerializer(UserBean.class, new MySerilizer());
        mapper.registerModule(module);
        String s = mapper.writeValueAsString(user);
        System.out.println(s);
    }
}

