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
public class QueueFulfillment implements Serializable {
    @JsonProperty("id")
    @SerializedName("id")
    private String id;

    @JsonProperty("msisdn")
    @SerializedName("msisdn")
    private String msisdn;

    @JsonProperty("main_trigger")
    @SerializedName("main_trigger")
    private JsonObject mainTrigger;

    @JsonProperty("bonus")
    @SerializedName("bonus")
    private JsonObject bonus;

    @JsonProperty("incentive_state")
    @SerializedName("incentive_state")
    private String incentiveState;

    @JsonProperty("incentive_campaign_id")
    @SerializedName("incentive_campaign_id")
    private String incentiveCampaignId;

    @JsonProperty("incentive_tracking_id")
    @SerializedName("incentive_tracking_id")
    private String incentiveTrackingId;

    @JsonProperty("channel")
    @SerializedName("channel")
    private String channel;

    @JsonProperty("counter")
    @SerializedName("counter")
    private Integer counter;

    @JsonProperty("created_at")
    @SerializedName("created_at")
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd HH:mm:ss")
    private String createdAt;

    @JsonProperty("campaign_event")
    @SerializedName("campaign_event")
    private String campaignEvent;

}

