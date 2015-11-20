package com.iss.expense.module.record.entity;

import java.math.BigDecimal;
import java.util.Date;

/**
 * 消费记录实体类
 * 
 * @author wangwei
 * @date 2015年8月11日 下午4:13:43
 * @version v1.0
 */
public class ExpenseRecord {

	private Integer tid; // 主键
	private Integer userId; // 用户ID
	private Date createTime;
	private Double breakfast; // 早餐
	private Double lunch; // 午餐
	private Double dinner; // 晚餐
	private Double snack; // 零食烟酒
	private Double clothes; // 衣服
	private Double rent; // 房租
	private Double waterGasFee; // 水电天然气
	private Double dailySuppliles; // 日常用品
	private Double homeFurnishing; // 家居用品
	private Double homeRepair; // 家居维护
	private Double traffic; // 交通费
	private Double telecom; // 电信费
	private Double post; // 邮寄费
	private Double learn; // 个人学习消费
	private Double personalDigital; // 个人数码产品消费
	private Double havaFun; // 个人娱乐
	private Double medical; // 医药费
	private Double fitness; // 健身费
	private Double communitation; // 交际费
	private Double financeInsurance; // 个人金融保险消费
	private Double other; // 其他消费
	private String remark;	// 备注

	public Integer getTid() {
		return tid;
	}

	public void setTid(Integer tid) {
		this.tid = tid;
	}

	public Integer getUserId() {
		return userId;
	}

	public void setUserId(Integer userId) {
		this.userId = userId;
	}

	public Date getCreateTime() {
		return createTime;
	}

	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}

	public Double getBreakfast() {
		return breakfast;
	}

	public void setBreakfast(Double breakfast) {
		this.breakfast = breakfast;
	}

	public Double getLunch() {
		return lunch;
	}

	public void setLunch(Double lunch) {
		this.lunch = lunch;
	}

	public Double getDinner() {
		return dinner;
	}

	public void setDinner(Double dinner) {
		this.dinner = dinner;
	}

	public Double getSnack() {
		return snack;
	}

	public void setSnack(Double snack) {
		this.snack = snack;
	}

	public Double getClothes() {
		return clothes;
	}

	public void setClothes(Double clothes) {
		this.clothes = clothes;
	}

	public Double getRent() {
		return rent;
	}

	public void setRent(Double rent) {
		this.rent = rent;
	}

	public Double getWaterGasFee() {
		return waterGasFee;
	}

	public void setWaterGasFee(Double waterGasFee) {
		this.waterGasFee = waterGasFee;
	}

	public Double getDailySuppliles() {
		return dailySuppliles;
	}

	public void setDailySuppliles(Double dailySuppliles) {
		this.dailySuppliles = dailySuppliles;
	}

	public Double getHomeFurnishing() {
		return homeFurnishing;
	}

	public void setHomeFurnishing(Double homeFurnishing) {
		this.homeFurnishing = homeFurnishing;
	}

	public Double getHomeRepair() {
		return homeRepair;
	}

	public void setHomeRepair(Double homeRepair) {
		this.homeRepair = homeRepair;
	}

	public Double getTraffic() {
		return traffic;
	}

	public void setTraffic(Double traffic) {
		this.traffic = traffic;
	}

	public Double getTelecom() {
		return telecom;
	}

	public void setTelecom(Double telecom) {
		this.telecom = telecom;
	}

	public Double getPost() {
		return post;
	}

	public void setPost(Double post) {
		this.post = post;
	}

	public Double getLearn() {
		return learn;
	}

	public void setLearn(Double learn) {
		this.learn = learn;
	}

	public Double getPersonalDigital() {
		return personalDigital;
	}

	public void setPersonalDigital(Double personalDigital) {
		this.personalDigital = personalDigital;
	}

	public Double getHavaFun() {
		return havaFun;
	}

	public void setHavaFun(Double havaFun) {
		this.havaFun = havaFun;
	}

	public Double getMedical() {
		return medical;
	}

	public void setMedical(Double medical) {
		this.medical = medical;
	}

	public Double getFitness() {
		return fitness;
	}

	public void setFitness(Double fitness) {
		this.fitness = fitness;
	}

	public Double getCommunitation() {
		return communitation;
	}

	public void setCommunitation(Double communitation) {
		this.communitation = communitation;
	}

	public Double getFinanceInsurance() {
		return financeInsurance;
	}

	public void setFinanceInsurance(Double financeInsurance) {
		this.financeInsurance = financeInsurance;
	}

	public Double getOther() {
		return other;
	}

	public void setOther(Double other) {
		this.other = other;
	}
	
	public String getRemark(){
		return remark;
	}
	
	public void setRemark(String remark){
		this.remark = remark;
	}
}
