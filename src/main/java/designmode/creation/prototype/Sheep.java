package designmode.creation.prototype;

import java.util.Date;

/**
 * @author hsc
 * @date 2019-11-04 22:43:35
 */
public class Sheep implements Cloneable{
    private String name;
    private Date birthday;



    @Override
    protected Object clone() throws CloneNotSupportedException {
        Object object=super.clone();
        return object;
    }

    public Sheep(String name, Date birthday) {
        this.name = name;
        this.birthday = birthday;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Date getBirthday() {
        return birthday;
    }

    public void setBirthday(Date birthday) {
        this.birthday = birthday;
    }
}
