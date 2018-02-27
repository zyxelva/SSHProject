package com.grgbanking.entity;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;


@Entity
@Table(name = "SYS_USER")
public class SysUser extends AbsBaseEntity{
	/**
     *
     */
    private static final long serialVersionUID = -7822127812263874809L;
    private String id;/* 用户ID */
	private String account;/* 帐号 */
	private String name;/* 姓名 */
	private String type;/* 用户类型 */
	private String password;/* 密码 */
	private String description;/* 描述信息 */
	private Date password_changed_date;/* 密码最后一次修改时间 */
	private String account_enabled;/* 帐号是否启用 */
	private String account_locked;/* 帐号是否锁定 */
	private String account_locked_reason;/* 帐号锁定原因 */
	private String sex;/* 性别 */
	private Date birthdate;/* 生日 */
	private String nationality;/* 国籍 */
	private String credentials_type;/* 证件类型 */
	private String credentials_number;/* 证件号码 */
	private String email;/* 邮件地址 */
	private String mobile_telephone;/* 移动电话 */
	private String home_telephone;/* 家庭电话 */
	private String office_telephone;/* 办公电话 */
	private String fax;/* 传真 */
	private String home_address;/* 家庭住址 */
	private String created_by;/* 创建人 */
	private Date creation_date;/* 创建时间 */
	private String last_updated_by;/* 修改人 */
	private Date last_update_date;/* 修改时间 */
	private String active_state;/* 使用状态 */
	private Date deletion_date;/* 删除时间 */
	private String operation_id;/* 操作序号 */
	private String old_operation_id;/* 历史操作序号 */
	private Date account_locked_time;/* 帐号锁定时间 */

	@Id
	@GeneratedValue(generator = "system_uuid")
	@GenericGenerator(name = "system_uuid", strategy = "uuid")
	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getAccount() {
		return account;
	}

	public void setAccount(String account) {
		this.account = account;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public Date getPassword_changed_date() {
		return password_changed_date;
	}

	public void setPassword_changed_date(Date password_changed_date) {
		this.password_changed_date = password_changed_date;
	}

	public String getAccount_enabled() {
		return account_enabled;
	}

	public void setAccount_enabled(String account_enabled) {
		this.account_enabled = account_enabled;
	}

	public String getAccount_locked() {
		return account_locked;
	}

	public void setAccount_locked(String account_locked) {
		this.account_locked = account_locked;
	}

	public String getAccount_locked_reason() {
		return account_locked_reason;
	}

	public void setAccount_locked_reason(String account_locked_reason) {
		this.account_locked_reason = account_locked_reason;
	}

	public String getSex() {
		return sex;
	}

	public void setSex(String sex) {
		this.sex = sex;
	}

	public Date getBirthdate() {
		return birthdate;
	}

	public void setBirthdate(Date birthdate) {
		this.birthdate = birthdate;
	}

	public String getNationality() {
		return nationality;
	}

	public void setNationality(String nationality) {
		this.nationality = nationality;
	}

	public String getCredentials_type() {
		return credentials_type;
	}

	public void setCredentials_type(String credentials_type) {
		this.credentials_type = credentials_type;
	}

	public String getCredentials_number() {
		return credentials_number;
	}

	public void setCredentials_number(String credentials_number) {
		this.credentials_number = credentials_number;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getMobile_telephone() {
		return mobile_telephone;
	}

	public void setMobile_telephone(String mobile_telephone) {
		this.mobile_telephone = mobile_telephone;
	}

	public String getHome_telephone() {
		return home_telephone;
	}

	public void setHome_telephone(String home_telephone) {
		this.home_telephone = home_telephone;
	}

	public String getOffice_telephone() {
		return office_telephone;
	}

	public void setOffice_telephone(String office_telephone) {
		this.office_telephone = office_telephone;
	}

	public String getFax() {
		return fax;
	}

	public void setFax(String fax) {
		this.fax = fax;
	}

	public String getHome_address() {
		return home_address;
	}

	public void setHome_address(String home_address) {
		this.home_address = home_address;
	}

	public String getCreated_by() {
		return created_by;
	}

	public void setCreated_by(String created_by) {
		this.created_by = created_by;
	}

	public Date getCreation_date() {
		return creation_date;
	}

	public void setCreation_date(Date creation_date) {
		this.creation_date = creation_date;
	}

	public String getLast_updated_by() {
		return last_updated_by;
	}

	public void setLast_updated_by(String last_updated_by) {
		this.last_updated_by = last_updated_by;
	}

	public Date getLast_update_date() {
		return last_update_date;
	}

	public void setLast_update_date(Date last_update_date) {
		this.last_update_date = last_update_date;
	}

	public String getActive_state() {
		return active_state;
	}

	public void setActive_state(String active_state) {
		this.active_state = active_state;
	}

	public Date getDeletion_date() {
		return deletion_date;
	}

	public void setDeletion_date(Date deletion_date) {
		this.deletion_date = deletion_date;
	}

	public String getOperation_id() {
		return operation_id;
	}

	public void setOperation_id(String operation_id) {
		this.operation_id = operation_id;
	}

	public String getOld_operation_id() {
		return old_operation_id;
	}

	public void setOld_operation_id(String old_operation_id) {
		this.old_operation_id = old_operation_id;
	}

	public Date getAccount_locked_time() {
		return account_locked_time;
	}

	public void setAccount_locked_time(Date account_locked_time) {
		this.account_locked_time = account_locked_time;
	}

}
