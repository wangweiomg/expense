package com.iss.expense.module.user.entity;

import java.math.BigDecimal;

/**
 *	
 * @author wangwei
 * @date 2015年9月6日  下午3:10:10
 * @version	v1.0
 */
public class TicketInfo {

	private String ticketSn;
	private BigDecimal price;
	private String content;
	private String no;
	private String ads;
	
	public static class Builder{
		private final String ticketSn;
		private final BigDecimal price;
		private final String content;
		
		private String no;
		private String ads;
		public Builder(String ticketSn, BigDecimal price, String content){
			this.ticketSn = ticketSn;
			this.price = price;
			this.content = content;
		}
		public Builder no(String val){
			no = val;
			return this;
		}
		public Builder ads(String val){
			ads = val;
			return this;
		}
		public TicketInfo build(){
			return new TicketInfo(this);
		}
	}
	public TicketInfo(Builder builder) {
		this.ticketSn = builder.ticketSn;
		this.price = builder.price;
		this.content = builder.content;
		this.no  = builder.no;
		this.ads = builder.ads;
	}
	public String getTicketSn() {
		return ticketSn;
	}
	public BigDecimal getPrice() {
		return price;
	}
	public String getContent() {
		return content;
	}
	public String getNo() {
		return no;
	}
	public String getAds() {
		return ads;
	}
	
}
