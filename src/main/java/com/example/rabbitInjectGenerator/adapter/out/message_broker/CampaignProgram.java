package com.example.rabbitInjectGenerator.adapter.out.message_broker;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.google.gson.JsonObject;
import com.google.gson.annotations.SerializedName;
import lombok.AllArgsConstructor;
import lombok.Getter;

import java.io.Serializable;

@Getter
@AllArgsConstructor
public class CampaignProgram implements Serializable {
    @JsonProperty("campaign_event")
    @SerializedName("campaign_event")
    private String campaingEvent;

    @JsonProperty("trx_kafka_date")
    @SerializedName("trx_kafka_date")
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd HH:mm:ss")
    private String trxKafkaDate;

    @JsonProperty("bonus")
    @SerializedName("bonus")
    private JsonObject bonus;

    @JsonProperty("main_trigger")
    @SerializedName("main_trigger")
    private JsonObject mainTrigger;

    @JsonProperty("other_param_trigger")
    @SerializedName("other_param_trigger")
    private JsonObject otherParamTrigger;

    @JsonProperty("trx_kafka_id")
    @SerializedName("trx_kafka_id")
    private String trxKafkaId;

    @JsonProperty("counter")
    @SerializedName("counter")
    private Integer counter;

    @JsonProperty("msisdn")
    @SerializedName("msisdn")
    private String msisdn;

    @JsonProperty("incentive_campaign_id")
    @SerializedName("incentive_campaign_id")
    private String incentiveCampaignId;

    @JsonProperty("event_topic_trigger")
    @SerializedName("event_topic_trigger")
    private String eventTopicTrigger;

    @JsonProperty("fulfillment_date")
    @SerializedName("fulfillment_date")
    private String fulfillmentDate;

    @JsonProperty("campaign_program_trigger")
    @SerializedName("campaign_program_trigger")
    private JsonObject campaignProgramTriggger;

}
