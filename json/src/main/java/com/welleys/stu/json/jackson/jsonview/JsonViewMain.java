package com.welleys.stu.json.jackson.jsonview;

import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.ByteArrayOutputStream;
import java.io.IOException;

public class JsonViewMain {
    public static void main(String[] args) throws IOException {

        UserBean userBean = new UserBean();
        userBean.setId(1L);
        userBean.setUname("lier");
        userBean.setAge(15);
        userBean.setEmail("lier@lier.com");

        AddressBean addressBean = new AddressBean();
        addressBean.setId(1L);
        addressBean.setProvince("beijing");
        addressBean.setCity("beijing");
        userBean.setAddress(addressBean);

        System.out.println(userBean);

        ObjectMapper objectMapper = new ObjectMapper();
        objectMapper.configure(JsonParser.Feature.ALLOW_COMMENTS, true);
        objectMapper.configure(JsonParser.Feature.ALLOW_UNQUOTED_FIELD_NAMES, true);
        objectMapper.configure(JsonParser.Feature.ALLOW_SINGLE_QUOTES, true);
        objectMapper.configure(JsonParser.Feature.ALLOW_UNQUOTED_CONTROL_CHARS, true);

        ByteArrayOutputStream bos = new ByteArrayOutputStream();

        objectMapper.writerWithView(UserBean.Name.class).writeValue(bos, userBean);
        System.out.println(bos.toString());

        bos.reset();
        objectMapper.writerWithView(UserBean.Info.class).writeValue(bos, userBean);
        System.out.println(bos.toString());

        String src = "{'id':'1', 'uname':'lier', 'age':'15', 'email':'lier@lier.com', 'address':{'province':'beijing', 'city': 'beijing'}}";
        Object o = objectMapper.readerWithView(UserBean.Name.class).forType(UserBean.class).readValue(src);
        System.out.println(o);

        Object o1 = objectMapper.readerWithView(UserBean.Info.class).forType(UserBean.class).readValue(src);
        System.out.println(o1);

    }
}
