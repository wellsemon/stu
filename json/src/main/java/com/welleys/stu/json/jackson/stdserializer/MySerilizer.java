package com.welleys.stu.json.jackson.stdserializer;

import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.SerializerProvider;
import com.fasterxml.jackson.databind.ser.std.StdSerializer;

import java.io.IOException;
import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.List;

/**
 * @author welleys
 * @// TODO: 2018/7/29   与具体对象解耦
 */
class MySerilizer extends StdSerializer<User> {
    public MySerilizer() {
        this(null);
    }

    protected MySerilizer(Class t) {
        super(t);
    }

    @Override
    public Class<User> handledType() {
        return super.handledType();
    }

    @Override
    public void serialize(User user, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) throws
            IOException {
        jsonGenerator.writeStartObject();

//        classField(o, jsonGenerator);

        jsonGenerator.writeNumberField("id", user.getId());

        List<Address> addressesNew = new ArrayList<>();
        List<Address> addresses = user.getAddresses();
        for (Address tmpAddress :
                addresses) {
            String tmpProvince = tmpAddress.getProvince();
            if ("beijing".equalsIgnoreCase(tmpProvince)) {
                addressesNew.add(tmpAddress);
            }
        }
        jsonGenerator.writeObjectField("addresses", addressesNew);

        jsonGenerator.writeEndObject();
    }

    private void classField(Object o, JsonGenerator jsonGenerator) {
        Field[] declaredFields = o.getClass().getDeclaredFields();
        try {
            for (Field field : declaredFields
                    ) {
                field.setAccessible(true);
                Object fieldObj = field.get(o);
                if (fieldObj instanceof Address) {
                    String province = ((Address) fieldObj).getProvince();
                    if ("beijing".equalsIgnoreCase(province)) {
                        System.out.println("test");
                        continue;
                    }
                }

                jsonGenerator.writeStringField(field.getName(), String.valueOf(field.get(o)));

            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
