package com.example.rabbitInjectGenerator.adapter.helper;

import lombok.Getter;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;

@Configuration
@Getter
public class FullfilmentConfiguration {
    @Value("${incentive.rules.timeout}")
    private int incentiveRulesTimeout;

    @Value("${fulfillment.incentiveState}")
    private String incentiveState;

    @Value("${fulfillment.incentiveCampaignId}")
    private String incentiveCampaignId;

    @Value("${fulfillment.incentiveTrackingId}")
    private String incentiveTrackingId;

    @Value("${fulfillment.channel}")
    private String channel;

    @Value("${rabbitmq.queue.name.fulfillment}")
    private String queueName;

    @Value("${fulfillment.campaign.event}")
    private String eventName;

}
