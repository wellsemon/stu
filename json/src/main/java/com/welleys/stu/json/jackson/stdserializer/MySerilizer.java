package com.welleys.stu.json.jackson.stdserializer;

import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.SerializerProvider;
import com.fasterxml.jackson.databind.ser.std.StdSerializer;

import java.io.IOException;
import java.lang.reflect.Field;

/**
 * @author welleys
 * @// TODO: 2018/7/29   与具体对象解耦
 */
class MySerilizer extends StdSerializer {
    public MySerilizer() {
        this(null);
    }

    protected MySerilizer(Class t) {
        super(t);
    }

    @Override
    public void serialize(Object o, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) throws
            IOException {
        jsonGenerator.writeStartObject();

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

        jsonGenerator.writeEndObject();
    }
}
