package com.welleys.stu.json.jackson.jsonview;

import com.fasterxml.jackson.annotation.JsonFilter;
import com.fasterxml.jackson.annotation.JsonView;

import java.io.Serializable;
public class UserBean implements Serializable {
    public interface All extends Info, Other{}
    public interface Name{}
    public interface Info {}
    public interface Other{}

    private static final long serialVersionUID = -157524808027618449L;
    private Long id;
    private String uname;
    private Integer age;
    private String email;
    @JsonView(UserBean.Info.class)
    private AddressBean address;

    @JsonView({Other.class})
    public Long getId() {
        return id;
    }
    public void setId(Long id) {
        this.id = id;
    }
    @JsonView(Info.class)
    public String getUname() {
        return uname;
    }
    @JsonView({Name.class})
    public void setUname(String uname) {
        this.uname = uname;
    }
    @JsonView({Other.class,Info.class})
    public Integer getAge() {
        return age;
    }
    public void setAge(Integer age) {
        this.age = age;
    }
    @JsonView({Other.class,Info.class})
    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public static long getSerialVersionUID() {
        return serialVersionUID;
    }

    public AddressBean getAddress() {
        return address;
    }

    public void setAddress(AddressBean address) {
        this.address = address;
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", uname='" + uname + '\'' +
                ", age=" + age +
                ", email='" + email + '\'' +
                ", address=" + address +
                '}';
    }
}
