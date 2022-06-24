package com.sbz.itemrecommendationwar.Model;

import org.kie.api.definition.type.Duration;
import org.kie.api.definition.type.Expires;
import org.kie.api.definition.type.Role;

@Role(Role.Type.EVENT)
@Expires("1h")
public class BaronEvent {

	private int buffDuration;

	public int getBuffDuration() {
		return buffDuration;
	}

	public void setBuffDuration(int buffDuration) {
		this.buffDuration = buffDuration;
	}

	public BaronEvent(int buffDuration) {
		super();
		this.buffDuration = buffDuration;
	}

	public BaronEvent() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	
	
}
