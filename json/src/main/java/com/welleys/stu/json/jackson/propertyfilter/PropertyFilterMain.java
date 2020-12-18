package com.welleys.stu.json.jackson.propertyfilter;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.ser.FilterProvider;
import com.fasterxml.jackson.databind.ser.impl.SimpleFilterProvider;

import java.util.ArrayList;
import java.util.List;

/**
 * @author welleys
 */
public class PropertyFilterMain {
    public static void main(String[] args) throws JsonProcessingException {
        IdeaModuleDescBean editorDescBean = new IdeaModuleDescBean();
        editorDescBean.setId(1L);
        editorDescBean.setDesc("editor-desc");

        IdeaModuleDescBean projectDescBean = new IdeaModuleDescBean();
        projectDescBean.setId(2L);
        projectDescBean.setDesc("project-desc");

        IdeaModuleBean editorModuleBean = new IdeaModuleBean();
        editorModuleBean.setId(1L);
        editorModuleBean.setModuleName("editor");
        editorModuleBean.setIdeaModuleDesc(editorDescBean);

        IdeaModuleBean projectModuleBean = new IdeaModuleBean();
        projectModuleBean.setId(2L);
        projectModuleBean.setModuleName("project");
        projectModuleBean.setIdeaModuleDesc(projectDescBean);

        List<IdeaModuleBean> moduleBeans = new ArrayList<>();
        moduleBeans.add(editorModuleBean);
        moduleBeans.add(projectModuleBean);

        IdeaBean ideaBean = new IdeaBean();
        ideaBean.setId(1L);
        ideaBean.setIdeaModules(moduleBeans);
        ideaBean.setDesc("ide");

        ObjectMapper objectMapper = new ObjectMapper();
        objectMapper.addMixIn(IdeaBean.class, IdeaFilter.class).addMixIn(IdeaModuleBean.class, IdeaFilter.class).addMixIn
                (IdeaModuleDescBean.class, IdeaFilter.class);
        FilterProvider filterProvider = new SimpleFilterProvider().addFilter("myFilter", new IdeaBeanPropertyFilter
                ());

        String s = objectMapper.writer(filterProvider).writeValueAsString(ideaBean);
        System.out.println(s);

    }
}
