package com.example.rabbitInjectGenerator.adapter.helper;

import lombok.Getter;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;

@Configuration
@Getter
public class GeneralConfig {

    @Value("${rabbitmq.queue.inject.status.adhoc}")
    private String injectAdhoc;

    @Value("${rabbitmq.queue.inject.status.campaign.tracking}")
    private String injectCampaignTracking;

    @Value("${rabbitmq.queue.inject.status.regular}")
    private String injectRegular;

    @Value("${rabbitmq.queue.inject.status.smsbanking}")
    private String injectSb;

    @Value("${rabbitmq.queue.inject.status.international}")
    private String injectIr;

    @Value("${rabbitmq.queue.inject.status.fulfillment.esb}")
    private String injectFulfillmentEsb;

    @Value("${rabbitmq.queue.name.fulfillment}")
    private String fulfillmentQueue;

    @Value("${rabbitmq.queue.name.adhoc}")
    private String adhocQueue;

    @Value("${rabbitmq.queue.name.regular}")
    private String regularQueue;

    @Value("${rabbitmq.queue.name.international}")
    private String internationalQueue;
    @Value("${rabbitmq.queue.name.campaign.program}")
    private String campaignProgramQueue;

    @Value("${rabbitmq.queue.name.sb}")
    private String sbQueue;

    @Value("${blastStatus}")
    private String blastStatus;

    @Value("${json.campaign.program}")
    private String jsonCampaignProgram;



}
