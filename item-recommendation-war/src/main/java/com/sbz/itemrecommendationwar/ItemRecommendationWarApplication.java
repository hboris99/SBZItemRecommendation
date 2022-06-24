package com.sbz.itemrecommendationwar;

import java.util.HashMap;
import java.util.Map;

import org.drools.core.ClockType;
import org.kie.api.KieBase;
import org.kie.api.KieBaseConfiguration;
import org.kie.api.KieServices;
import org.kie.api.builder.KieScanner;
import org.kie.api.conf.EventProcessingOption;
import org.kie.api.runtime.KieContainer;
import org.kie.api.runtime.KieSession;
import org.kie.api.runtime.KieSessionConfiguration;
import org.kie.api.runtime.conf.ClockTypeOption;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class ItemRecommendationWarApplication {

	public static void main(String[] args) {
		SpringApplication.run(ItemRecommendationWarApplication.class, args);
	}
	
	@Bean
	public KieSession kieSession() {
		KieServices ks = KieServices.Factory.get();
		KieContainer kContainer = ks.newKieContainer(ks.newReleaseId("com.sbz", "item-recommendation-kjar", "0.0.1-SNAPSHOT"));
		KieScanner kieScanner = ks.newKieScanner(kContainer);
		kieScanner.start(10_000);
		KieBaseConfiguration kbconf = ks.newKieBaseConfiguration();
		kbconf.setOption(EventProcessingOption.STREAM);
		KieBase kbase = kContainer.newKieBase(kbconf);

		KieSessionConfiguration ksconf = ks.newKieSessionConfiguration();
		ksconf.setOption(ClockTypeOption.get(ClockType.REALTIME_CLOCK.getId()));

		KieSession session = kbase.newKieSession(ksconf, null);
		Map<Integer,String> num = new HashMap<Integer,String>();
		session.setGlobal("frequency", num);
		
		return session;
	}
	
	@Bean
	public KieContainer kieContainer() {
		KieServices ks = KieServices.Factory.get();
		KieContainer kContainer = ks.newKieContainer(ks.newReleaseId("com.sbz", "item-recommendation-kjar", "0.0.1-SNAPSHOT"));
		KieScanner kieScanner = ks.newKieScanner(kContainer);
		kieScanner.start(10_000);
		return kContainer;
	}

}
