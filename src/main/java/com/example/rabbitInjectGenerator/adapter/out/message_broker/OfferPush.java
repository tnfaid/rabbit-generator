package com.example.rabbitInjectGenerator.adapter.out.message_broker;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.google.gson.annotations.SerializedName;
import lombok.AllArgsConstructor;
import lombok.Getter;

import java.io.Serializable;

@Getter
@AllArgsConstructor
public class OfferPush implements Serializable {

    @JsonProperty("id")
    @SerializedName("id")
    private String id;

    @JsonProperty("msisdn")
    @SerializedName("msisdn")
    private String msisdn;

    @JsonProperty("source")
    @SerializedName("source")
    private String source;

    @JsonProperty("event_name")
    @SerializedName("event_name")
    private String eventName;

    @JsonProperty("id_trigger")
    @SerializedName("id_trigger")
    private String idTrigger;

    @JsonProperty("channels")
    @SerializedName("channels")
    private String channels;

    @JsonProperty("journey_type")
    @SerializedName("journey_type")
    private String journeyType;

    @JsonProperty("event_trigger")
    @SerializedName("event_trigger")
    private String eventTrigger;

    @JsonProperty("status_message")
    @SerializedName("status_message")
    private String statusMessage;

    @JsonProperty("created_at")
    @SerializedName("created_at")
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd HH:mm:ss")
    private String createdAt;
}
