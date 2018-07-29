package com.welleys.stu.json.jackson.stdserializer;

import com.fasterxml.jackson.annotation.JsonView;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;

import java.io.Serializable;

@JsonSerialize(using = MySerilizer.class)
public class User implements Serializable {
    public interface All extends Info, Other {
    }

    public interface Name {
    }

    public interface Info {
    }

    public interface Other {
    }

    private Long id;
    private String uname;
    private Integer age;
    private String email;
    @JsonView(User.Info.class)
    private Address address;

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

    @JsonView({Other.class, Info.class})
    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    @JsonView({Other.class, Info.class})
    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }


    public Address getAddress() {
        return address;
    }

    public void setAddress(Address address) {
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
