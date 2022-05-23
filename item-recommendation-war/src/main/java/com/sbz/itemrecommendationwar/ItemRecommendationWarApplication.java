package com.sbz.itemrecommendationwar;

import org.kie.api.KieServices;
import org.kie.api.builder.KieScanner;
import org.kie.api.runtime.KieContainer;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class ItemRecommendationWarApplication {

	public static void main(String[] args) {
		SpringApplication.run(ItemRecommendationWarApplication.class, args);
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
