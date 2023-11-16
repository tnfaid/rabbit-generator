package com.example.rabbitInjectGenerator;

import com.example.rabbitInjectGenerator.adapter.helper.GeneralConfig;
import com.example.rabbitInjectGenerator.adapter.out.message_broker.CampaignProgram;
import com.example.rabbitInjectGenerator.adapter.out.message_broker.OfferPush;
import com.example.rabbitInjectGenerator.adapter.out.message_broker.QueueFulfillment;
import com.example.rabbitInjectGenerator.adapter.helper.FullfilmentConfiguration;
import com.example.rabbitInjectGenerator.domain.util.Util;
import com.example.rabbitInjectGenerator.adapter.out.message_broker.RabbitMQConfig;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.*;

@SpringBootApplication
public class RabbitInjectGeneratorApplication implements CommandLineRunner {
	@Autowired
	RabbitMQConfig rabbitMQProducer;

	@Autowired
	FullfilmentConfiguration fullfilmentConfiguration;

	@Autowired
	GeneralConfig generalConfig;

	public static void main(String[] args) {
		SpringApplication.run(RabbitInjectGeneratorApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		if (generalConfig.getBlastStatus().equalsIgnoreCase("YES")){
			for (int i = 0; i <= fullfilmentConfiguration.getIncentiveRulesTimeout(); i++){
				sendMessageAll(i);

			}
		}else if (generalConfig.getBlastStatus().equalsIgnoreCase("LOOP")){
			long end=System.currentTimeMillis()+fullfilmentConfiguration.getIncentiveRulesTimeout();
			int i=0;
			while (System.currentTimeMillis() < end){
				sendMessageAll(i);
				i++;
			}
		}else {
			for (int i=0; i < 10; i++){
				sendMessageAll(i);
			}
		}

		Util.tdrLogger.info("");
	}

	void sendMessageAll(int i){
		String lastIteration= Integer.toString(i).substring(Integer.toString(i).length()-1);
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");


		Util.debugLogger.debug("Send Message ke {}", i);
		if (generalConfig.getInjectIr().equalsIgnoreCase("ON")){
			rabbitMQProducer.sendMessagePushOffer(mappingMessageInternational(formatter), generalConfig.getInternationalQueue()+lastIteration);
		}
		if (generalConfig.getInjectSb().equalsIgnoreCase("ON")){
			rabbitMQProducer.sendMessagePushOffer(mappingMessageSmsBanking(formatter), generalConfig.getSbQueue()+lastIteration);
		}
		if (generalConfig.getInjectAdhoc().equalsIgnoreCase("ON")){
			rabbitMQProducer.sendMessagePushOffer(mappingMessageAdhoc(formatter), generalConfig.getAdhocQueue()+lastIteration);
		}
		if (generalConfig.getInjectRegular().equalsIgnoreCase("ON")){
			rabbitMQProducer.sendMessagePushOffer(mappingMessageRegular(formatter), generalConfig.getRegularQueue()+lastIteration);
		}
		if (generalConfig.getInjectFulfillmentEsb().equalsIgnoreCase("ON")){
			rabbitMQProducer.sendMessageFulfillment(mappingMessageEsbFulfillment(Integer.parseInt(lastIteration), i, formatter), generalConfig.getFulfillmentQueue()+lastIteration);
//			rabbitMQProducer.sendMessageFulfillment(mappingMessageEsbFulfillment(Integer.parseInt(lastIteration), i, formatter), generalConfig.getFulfillmentQueue());
		}
		if (generalConfig.getInjectCampaignTracking().equalsIgnoreCase("ON")){
			rabbitMQProducer.sendMessageCampaignProgram(mappingMessageCampaignProgram(i), generalConfig.getCampaignProgramQueue());
		}
	}
	QueueFulfillment mappingMessageEsbFulfillment(int lastIteration, int i, DateTimeFormatter formatter ){
		Map<String,ArrayList> bonusMap = new HashMap<>();
		ArrayList<String> bonusArray = new ArrayList<>();
		bonusArray.add("00054648");
		bonusMap.put("business_id",bonusArray);

		JsonObject mainTrigger = new JsonObject();
		mainTrigger.addProperty("main_trigger","{\"business_id\":\"00054648\"}");

		QueueFulfillment queueFulfillment = new QueueFulfillment(
				Util.generateID(),
				"628120000"+lastIteration,
				mainTrigger,
				new Util().mapToJson(bonusMap),
				fullfilmentConfiguration.getIncentiveState(),
				fullfilmentConfiguration.getIncentiveCampaignId()+i,
				fullfilmentConfiguration.getIncentiveTrackingId()+i,
				fullfilmentConfiguration.getChannel(),
				0,
				LocalDateTime.now().format(formatter).toString(),
				fullfilmentConfiguration.getEventName()
		);

		return queueFulfillment;
	}

	OfferPush mappingMessageAdhoc(DateTimeFormatter formatter){
		OfferPush queueAdhocMessage = new OfferPush(
				"a0e40363-88ff-4a9c-a791-053a5fa668fc",
				"628127970115",
				"ADHOC",
				"AdhocEvent",
				"",
				"[\"h0\", \"i1n\", \"i1i\", \"fi\"]",
				"adhoc_offer",
				"general",
				"",
				LocalDateTime.now().format(formatter).toString()
		);

		return queueAdhocMessage;
	}

	OfferPush mappingMessageInternational(DateTimeFormatter formatter){
		OfferPush queueInternationalMessage = new OfferPush(
				"d3398b08-eb92-44c1-8530-9e249e077888",
				"628127970115",
				"int_roaming",
				"KafkaEvent",
				"00043159",
				"",
				"int_roaming",
				"",
				"invalidChannelTransaction",
				LocalDateTime.now().format(formatter).toString()
		);

		return queueInternationalMessage;
	}

	OfferPush mappingMessageRegular(DateTimeFormatter formatter){
		OfferPush queueInternationalMessage = new OfferPush(
				"82cbb867-4c44-4a8a-9751-2c774890b87b",
				"628127970115",
				"regular",
				"KafkaEvent",
				"82cbb867-4c44-4a8a-9751-2c774890b87b",
				"",
				"OVRDRFTLOWQUOTA_DATA_0MB",
				"",
				"OVRDRFTLOWQUOTA_DATA_0MB",
				LocalDateTime.now().format(formatter).toString()
		);

		return queueInternationalMessage;
	}

	OfferPush mappingMessageSmsBanking(DateTimeFormatter formatter){
		OfferPush queueInternationalMessage = new OfferPush(
				"a0e40363-88ff-4a9c-a791-053a5fa668fc",
				"628127970115",
				"sms_banking",
				"KafkaEvent",
				"2023011015364815670123550",
				"",
				"sms_banking",
				"",
				"sms_banking_not_enough_balance",
				LocalDateTime.now().format(formatter).toString()
		);

		return queueInternationalMessage;
	}

	CampaignProgram mappingMessageCampaignProgram(int i){
		JSONObject jsonMessageCampaignProgram = new JSONObject(generalConfig.getJsonCampaignProgram().toString());
		String msisdnString = "62812";
		String msisdnResultIncrement = incrementMsisdn(msisdnString, i);


		CampaignProgram campaignProgram = new CampaignProgram(
				jsonMessageCampaignProgram.get("campaign_event").toString(),
				jsonMessageCampaignProgram.get("trx_kafka_date").toString(),
				JsonParser.parseString(jsonMessageCampaignProgram.get("bonus").toString()).getAsJsonObject(),
				JsonParser.parseString(jsonMessageCampaignProgram.get("main_trigger").toString()).getAsJsonObject(),
				JsonParser.parseString(jsonMessageCampaignProgram.get("other_param_trigger").toString()).getAsJsonObject(),
				jsonMessageCampaignProgram.get("trx_kafka_id").toString(),
				new Integer(jsonMessageCampaignProgram.get("counter").toString()),
				msisdnResultIncrement,
				jsonMessageCampaignProgram.get("incentive_campaign_id").toString(),
				jsonMessageCampaignProgram.get("event_topic_trigger").toString(),
				jsonMessageCampaignProgram.get("fulfillment_date").toString(),
				JsonParser.parseString(jsonMessageCampaignProgram.get("campaign_program_trigger").toString()).getAsJsonObject()
		);

		return campaignProgram;
	}

	public static String incrementMsisdn(String msisdn, int i) {
		try {
			// Convert the msisdn to an integer
			Long msisdnInt = Long.parseLong(msisdn+i);
			System.out.println("valid  msisdn format: " + msisdnInt);

			// Convert it back to a string
			return Long.toString(msisdnInt);
		} catch (NumberFormatException e) {
			// Handle the case where msisdn is not a valid integer
			System.out.println("\n\n\n----------------------------------------" +
					"\nInvalid msisdn format: " + msisdn);
			return null;
		}
	}


}
