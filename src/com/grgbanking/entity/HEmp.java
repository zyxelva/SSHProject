package com.grgbanking.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;

@Entity
@Table(name = "EMP")
public class HEmp {
    private String id;/**/
    private String ename;/**/
    private String age;/**/

    @Id
    @GeneratedValue(generator = "system_uuid")
    @GenericGenerator(name = "system_uuid", strategy = "uuid")
	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

    public String getEname() {
        return ename;
    }

    public void setEname(String ename) {
        this.ename = ename;
    }

    public String getAge() {
		return age;
	}

	public void setAge(String age) {
		this.age = age;
	}

	public HEmp(){}

    /**
     * @param ename
     * @param age
     */
    public HEmp(String ename, String age) {
        super();
        this.ename = ename;
        this.age = age;
    }

    public HEmp(String id, String ename, String age) {
        this(ename,age);
        this.id=id;

    }


}
