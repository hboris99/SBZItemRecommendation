package com.sbz.itemrecommendationwar.Model;

import org.kie.api.definition.type.Expires;
import org.kie.api.definition.type.Role;

@Role(Role.Type.EVENT)
@Expires("3m")
public class ItemBuyEvent {
	private String buyerName;
	private String allyName;
	public String getBuyerName() {
		return buyerName;
	}
	public void setBuyerName(String buyerName) {
		this.buyerName = buyerName;
	}
	public String getAllyName() {
		return allyName;
	}
	public void setAllyName(String allyName) {
		this.allyName = allyName;
	}
	public ItemBuyEvent(String buyerName, String allyName) {
		super();
		this.buyerName = buyerName;
		this.allyName = allyName;
	}
	public ItemBuyEvent() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	
}
