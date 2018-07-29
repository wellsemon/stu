package com.welleys.stu.json.jackson.propertyfilter;

import java.io.Serializable;

/**
 * @author welleys
 */
//@JsonFilter("myFilter")
public class IdeaModuleDescBean implements Serializable {
    private static final long serialVersionUID = 8977603868328491706L;

    private Long id;
    private String desc;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }
}
