package com.welleys.stu.json.jackson.stdserializer;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.module.SimpleModule;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class StdSerializerMain {
    public static void main(String[] args) throws IOException {

        User user = new User();
        user.setId(1L);
        user.setUname("lier");
        user.setAge(15);
        user.setEmail("lier@lier.com");

        List<Address> addresses = new ArrayList<>();
        Address beijing = new Address();
        beijing.setId(1L);
        beijing.setProvince("beijing");
        beijing.setCity("beijing");

        Address shanghai = new Address();
        shanghai.setId(2L);
        shanghai.setProvince("shanghai");
        shanghai.setCity("shanghai");

        addresses.add(beijing);
        addresses.add(shanghai);

        user.setAddresses(addresses);

        System.out.println(user);

        ObjectMapper mapper = new ObjectMapper();
        SimpleModule module = new SimpleModule();
        module.addSerializer(new MySerilizer(User.class));
        mapper.registerModule(module);
        String s = mapper.writeValueAsString(user);
        System.out.println(s);
    }
}

