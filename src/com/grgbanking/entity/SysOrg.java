package com.grgbanking.entity;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;


@Entity
@Table(name = "SYS_ORG")
public class SysOrg extends AbsBaseEntity {
	/**
     *
     */
    private static final long serialVersionUID = 3886717693719277967L;
    private String i18_code; //国际码
	private String id; //ID
	private String name; //名称
	private String description; //描述
	private String code; //编码
	private java.util.Date time_begin; //生效时间
	private java.util.Date time_end; //失效时间
	private String is_enabled; //是否启用
	private String fullname; //机构全称
	private String contact_man; //联系人
	private String teletphone; //联系电话
	private String address; //地址
	private String status; //状态
	private String area_id; //区域ID
	private String created_by; //创建人
	private java.util.Date creation_date; //创建时间
	private String last_updated_by; //修改人
	private java.util.Date last_update_date; //修改时间
	private java.util.Date deletion_date; //删除时间
	private String active_state; //使用状态
	private String operation_id; //操作序号
	private String old_operation_id; //历史操作序号

	@Id
	@GeneratedValue(generator = "system_uuid")
	@GenericGenerator(name = "system_uuid", strategy = "uuid")
	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public Date getTime_begin() {
		return time_begin;
	}

	public void setTime_begin(Date time_begin) {
		this.time_begin = time_begin;
	}

	public Date getTime_end() {
		return time_end;
	}

	public void setTime_end(Date time_end) {
		this.time_end = time_end;
	}

	public String getIs_enabled() {
		return is_enabled;
	}

	public void setIs_enabled(String is_enabled) {
		this.is_enabled = is_enabled;
	}

	public String getFullname() {
		return fullname;
	}

	public void setFullname(String fullname) {
		this.fullname = fullname;
	}

	public String getContact_man() {
		return contact_man;
	}

	public void setContact_man(String contact_man) {
		this.contact_man = contact_man;
	}

	public String getTeletphone() {
		return teletphone;
	}

	public void setTeletphone(String teletphone) {
		this.teletphone = teletphone;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public String getArea_id() {
		return area_id;
	}

	public void setArea_id(String area_id) {
		this.area_id = area_id;
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

	public Date getDeletion_date() {
		return deletion_date;
	}

	public void setDeletion_date(Date deletion_date) {
		this.deletion_date = deletion_date;
	}

	public String getActive_state() {
		return active_state;
	}

	public void setActive_state(String active_state) {
		this.active_state = active_state;
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

	public String getI18_code() {
		return i18_code;
	}

	public void setI18_code(String i18_code) {
		this.i18_code = i18_code;
	}

}
