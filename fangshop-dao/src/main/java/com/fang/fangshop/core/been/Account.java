package com.fang.fangshop.core.been;

import com.fang.fangshop.core.common.PageModel;

import java.io.Serializable;
import java.util.Date;

public class Account extends PageModel implements Serializable {

	private static final long serialVersionUID = 1L;

	private Integer id;

	private String account;

	private String nickname;

	private String password;

	private String city;

	private String address;

	private String postcode;

	private String cardtype;

	private String cardno;

	private Integer grade;

	private String amount;

	private String tel;

	private String email;

	private String emailisactive;

	private String freeze;

	private Date lastlogintime;

	private String lastloginip;

	private String lastloginarea;

	private String diffarealogin;

	private Date regeistdate;

	private Date freezestartdate;

	private Date freezeenddate;

	private String openid;

	private String accesstoken;

	private String alipayuseid;

	private String sinaweiboid;

	private String sex;

	private String truename;

	private Date birthday;

	private String province;

	private String accounttype;

	private String rank;

	private Integer score;

	private String starttime;
	
	private String endtime;

	
	public Integer getId() {
		return id;
	}


	public void setId(Integer id) {
		this.id = id;
	}


	public String getAccount() {
		return account;
	}


	public void setAccount(String account) {
		this.account = account;
	}


	public String getNickname() {
		return nickname;
	}


	public void setNickname(String nickname) {
		this.nickname = nickname;
	}


	public String getPassword() {
		return password;
	}


	public void setPassword(String password) {
		this.password = password;
	}


	public String getCity() {
		return city;
	}


	public void setCity(String city) {
		this.city = city;
	}


	public String getAddress() {
		return address;
	}


	public void setAddress(String address) {
		this.address = address;
	}


	public String getPostcode() {
		return postcode;
	}


	public void setPostcode(String postcode) {
		this.postcode = postcode;
	}


	public String getCardtype() {
		return cardtype;
	}


	public void setCardtype(String cardtype) {
		this.cardtype = cardtype;
	}


	public String getCardno() {
		return cardno;
	}


	public void setCardno(String cardno) {
		this.cardno = cardno;
	}


	public Integer getGrade() {
		return grade;
	}


	public void setGrade(Integer grade) {
		this.grade = grade;
	}


	public String getAmount() {
		return amount;
	}


	public void setAmount(String amount) {
		this.amount = amount;
	}


	public String getTel() {
		return tel;
	}


	public void setTel(String tel) {
		this.tel = tel;
	}


	public String getEmail() {
		return email;
	}


	public void setEmail(String email) {
		this.email = email;
	}


	public String getEmailisactive() {
		return emailisactive;
	}


	public void setEmailisactive(String emailisactive) {
		this.emailisactive = emailisactive;
	}


	public String getFreeze() {
		return freeze;
	}


	public void setFreeze(String freeze) {
		this.freeze = freeze;
	}


	public Date getLastlogintime() {
		return lastlogintime;
	}


	public void setLastlogintime(Date lastlogintime) {
		this.lastlogintime = lastlogintime;
	}


	public String getLastloginip() {
		return lastloginip;
	}


	public void setLastloginip(String lastloginip) {
		this.lastloginip = lastloginip;
	}


	public String getLastloginarea() {
		return lastloginarea;
	}


	public void setLastloginarea(String lastloginarea) {
		this.lastloginarea = lastloginarea;
	}


	public String getDiffarealogin() {
		return diffarealogin;
	}


	public void setDiffarealogin(String diffarealogin) {
		this.diffarealogin = diffarealogin;
	}


	public Date getRegeistdate() {
		return regeistdate;
	}


	public void setRegeistdate(Date regeistdate) {
		this.regeistdate = regeistdate;
	}


	public Date getFreezestartdate() {
		return freezestartdate;
	}


	public void setFreezestartdate(Date freezestartdate) {
		this.freezestartdate = freezestartdate;
	}


	public Date getFreezeenddate() {
		return freezeenddate;
	}


	public void setFreezeenddate(Date freezeenddate) {
		this.freezeenddate = freezeenddate;
	}


	public String getOpenid() {
		return openid;
	}


	public void setOpenid(String openid) {
		this.openid = openid;
	}


	public String getAccesstoken() {
		return accesstoken;
	}


	public void setAccesstoken(String accesstoken) {
		this.accesstoken = accesstoken;
	}


	public String getAlipayuseid() {
		return alipayuseid;
	}


	public void setAlipayuseid(String alipayuseid) {
		this.alipayuseid = alipayuseid;
	}


	public String getSinaweiboid() {
		return sinaweiboid;
	}


	public void setSinaweiboid(String sinaweiboid) {
		this.sinaweiboid = sinaweiboid;
	}


	public String getSex() {
		return sex;
	}


	public void setSex(String sex) {
		this.sex = sex;
	}


	public String getTruename() {
		return truename;
	}


	public void setTruename(String truename) {
		this.truename = truename;
	}


	public Date getBirthday() {
		return birthday;
	}


	public void setBirthday(Date birthday) {
		this.birthday = birthday;
	}


	public String getProvince() {
		return province;
	}


	public void setProvince(String province) {
		this.province = province;
	}


	public String getAccounttype() {
		return accounttype;
	}


	public void setAccounttype(String accounttype) {
		this.accounttype = accounttype;
	}


	public String getRank() {
		return rank;
	}


	public void setRank(String rank) {
		this.rank = rank;
	}


	public Integer getScore() {
		return score;
	}


	public void setScore(Integer score) {
		this.score = score;
	}


	public String getStarttime() {
		return starttime;
	}


	public void setStarttime(String starttime) {
		this.starttime = starttime;
	}


	public String getEndtime() {
		return endtime;
	}


	public void setEndtime(String endtime) {
		this.endtime = endtime;
	}


	public Account() {
		super();
	}


	public Account(Integer id, String account, String nickname, String password, String city, String address,
			String postcode, String cardtype, String cardno, Integer grade, String amount, String tel, String email,
			String emailisactive, String freeze, Date lastlogintime, String lastloginip, String lastloginarea,
			String diffarealogin, Date regeistdate, Date freezestartdate, Date freezeenddate, String openid,
			String accesstoken, String alipayuseid, String sinaweiboid, String sex, String truename, Date birthday,
			String province, String accounttype, String rank, Integer score, String starttime, String endtime) {
		super();
		this.id = id;
		this.account = account;
		this.nickname = nickname;
		this.password = password;
		this.city = city;
		this.address = address;
		this.postcode = postcode;
		this.cardtype = cardtype;
		this.cardno = cardno;
		this.grade = grade;
		this.amount = amount;
		this.tel = tel;
		this.email = email;
		this.emailisactive = emailisactive;
		this.freeze = freeze;
		this.lastlogintime = lastlogintime;
		this.lastloginip = lastloginip;
		this.lastloginarea = lastloginarea;
		this.diffarealogin = diffarealogin;
		this.regeistdate = regeistdate;
		this.freezestartdate = freezestartdate;
		this.freezeenddate = freezeenddate;
		this.openid = openid;
		this.accesstoken = accesstoken;
		this.alipayuseid = alipayuseid;
		this.sinaweiboid = sinaweiboid;
		this.sex = sex;
		this.truename = truename;
		this.birthday = birthday;
		this.province = province;
		this.accounttype = accounttype;
		this.rank = rank;
		this.score = score;
		this.starttime = starttime;
		this.endtime = endtime;
	}

}