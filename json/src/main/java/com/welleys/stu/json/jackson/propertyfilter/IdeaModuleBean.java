package com.welleys.stu.json.jackson.propertyfilter;

import java.io.Serializable;

/**
 * @author welleys
 */
//@JsonFilter("myFilter")
public class IdeaModuleBean implements Serializable {
    private static final long serialVersionUID = 1542645505978384241L;

    private Long id;
    private String moduleName;
    private IdeaModuleDescBean ideaModuleDesc;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getModuleName() {
        return moduleName;
    }

    public void setModuleName(String moduleName) {
        this.moduleName = moduleName;
    }

    public IdeaModuleDescBean getIdeaModuleDesc() {
        return ideaModuleDesc;
    }

    public void setIdeaModuleDesc(IdeaModuleDescBean ideaModuleDesc) {
        this.ideaModuleDesc = ideaModuleDesc;
    }
}
