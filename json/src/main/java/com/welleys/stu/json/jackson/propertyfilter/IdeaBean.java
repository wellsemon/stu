package com.welleys.stu.json.jackson.propertyfilter;

import java.io.Serializable;
import java.util.List;

/**
 * @author welleys
 */
//@JsonFilter("myFilter")
public class IdeaBean implements Serializable {
    private static final long serialVersionUID = 1345882216437626047L;
    private Long id;
    private List<IdeaModuleBean> ideaModules;
    private String desc;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public List<IdeaModuleBean> getIdeaModules() {
        return ideaModules;
    }

    public void setIdeaModules(List<IdeaModuleBean> ideaModules) {
        this.ideaModules = ideaModules;
    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }
}
