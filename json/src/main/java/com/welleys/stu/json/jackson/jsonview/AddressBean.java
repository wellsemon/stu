package com.welleys.stu.json.jackson.jsonview;

import com.fasterxml.jackson.annotation.JsonView;

import java.io.Serializable;

public class AddressBean implements Serializable {
    public interface Other{}

    private static final long serialVersionUID = -8539904875616130846L;
    @JsonView(Other.class)
    private Long id;
    @JsonView(UserBean.Info.class)
    private String province;
    @JsonView(UserBean.Info.class)
    private String city;

    public static long getSerialVersionUID() {
        return serialVersionUID;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getProvince() {
        return province;
    }

    public void setProvince(String province) {
        this.province = province;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }
    @Override
    public String toString() {
        return "AddressBean{" +
                "id=" + id +
                ", province='" + province + '\'' +
                ", city='" + city + '\'' +
                '}';
    }

}
