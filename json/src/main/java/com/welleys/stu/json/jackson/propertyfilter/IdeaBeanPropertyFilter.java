package com.welleys.stu.json.jackson.propertyfilter;

import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.SerializerProvider;
import com.fasterxml.jackson.databind.ser.BeanPropertyWriter;
import com.fasterxml.jackson.databind.ser.PropertyWriter;
import com.fasterxml.jackson.databind.ser.impl.SimpleBeanPropertyFilter;

import java.util.ArrayList;
import java.util.List;

/**
 * @author welleys
 */
public class IdeaBeanPropertyFilter extends SimpleBeanPropertyFilter {
    private List<String> includeFirstLevelProp = new ArrayList<>();
    private List<String> includeSecondeLevelProp = new ArrayList<>();
    private List<String> includeThirdLevelProp = new ArrayList<>();

    /**
     * todo 2018/7/29 优化
     */
    @Override
    public void serializeAsField(Object pojo, JsonGenerator jgen, SerializerProvider provider, PropertyWriter writer) throws Exception {
        includeFirstLevelProp.add("desc");
        includeFirstLevelProp.add("ideaModules");

        includeSecondeLevelProp.add("moduleName");
        includeSecondeLevelProp.add("ideaModuleDesc");

        includeThirdLevelProp.add("desc");

        if (writer instanceof BeanPropertyWriter) {
            BeanPropertyWriter beanPropWriter = (BeanPropertyWriter) writer;
            Class<?> clazz = beanPropWriter.getMember().getDeclaringClass();

            String propertyName = beanPropWriter.getName();
//            System.out.println(beanPropWriter.toString());
//            System.out.println(beanPropWriter.getFullName());
            if (includeFirstLevelProp.contains(propertyName) && clazz.equals(IdeaBean.class)) {
                beanPropWriter.serializeAsField(pojo, jgen, provider);
                return;
            } else if (includeSecondeLevelProp.contains(propertyName) && clazz.equals(IdeaModuleBean.class)) {
                beanPropWriter.serializeAsField(pojo, jgen, provider);
            } else if (includeThirdLevelProp.contains(propertyName) && clazz.equals(IdeaModuleDescBean.class)) {
                beanPropWriter.serializeAsField(pojo, jgen, provider);
            } else if (!jgen.canOmitFields()) {
                beanPropWriter.serializeAsOmittedField(pojo, jgen, provider);
            }
        }
    }

}
