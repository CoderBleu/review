package cn.lauy.bean;

import org.apache.catalina.User;

/**
 * @author Lauy
 * @date 2021/3/26
 */
public class Person {
    private long id;

    private char gender;

    private UserInfo userInfo;

    public Person(UserInfo userInfo) {
        this.userInfo = userInfo;
    }

    public Person(long id, char gender) {
        this.id = id;
        this.gender = gender;
    }

    public void setId(long id) {
        this.id = id;
    }
}
