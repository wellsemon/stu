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
    private static List<String> includeFirstLevelProp = new ArrayList<>();
    private static List<String> includeSecondeLevelProp = new ArrayList<>();
    private static List<String> includeThirdLevelProp = new ArrayList<>();

    static {
        includeFirstLevelProp.add("desc");
        includeFirstLevelProp.add("ideaModules");

        includeSecondeLevelProp.add("moduleName");
        includeSecondeLevelProp.add("ideaModuleDesc");

        includeThirdLevelProp.add("desc");
    }

    /**
     * todo 2018/7/29 优化
     */
    @Override
    public void serializeAsField(Object pojo, JsonGenerator jgen, SerializerProvider provider, PropertyWriter writer) throws Exception {

        if (writer instanceof BeanPropertyWriter) {
            BeanPropertyWriter beanPropWriter = (BeanPropertyWriter) writer;
            Class<?> clazz = pojo.getClass();

            String propertyName = beanPropWriter.getName();
//            System.out.println(beanPropWriter.toString());
//            System.out.println(beanPropWriter.getFullName());
            if (includeFirstLevelProp.contains(propertyName) && clazz.equals(IdeaBean.class)) {
                beanPropWriter.serializeAsField(pojo, jgen, provider);
            } else if (includeSecondeLevelProp.contains(propertyName) && clazz.equals(IdeaModuleBean.class)) {
                if (null != pojo) {
                    IdeaModuleBean moduleBean = (IdeaModuleBean) pojo;
                    String desc = moduleBean.getIdeaModuleDesc().getDesc();
                    if (desc.equalsIgnoreCase("project-desc")) {
                        beanPropWriter.serializeAsField(pojo, jgen, provider);
                        return;
                    }
                }
            } else if (includeThirdLevelProp.contains(propertyName) && clazz.equals(IdeaModuleDescBean.class)) {
                beanPropWriter.serializeAsField(pojo, jgen, provider);
            } else if (!jgen.canOmitFields()) {
                beanPropWriter.serializeAsOmittedField(pojo, jgen, provider);
            }
        }
    }

}
