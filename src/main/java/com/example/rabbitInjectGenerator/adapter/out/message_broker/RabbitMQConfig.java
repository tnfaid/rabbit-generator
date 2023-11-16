package com.example.rabbitInjectGenerator.adapter.out.message_broker;

import com.example.rabbitInjectGenerator.domain.util.Util;
import org.springframework.amqp.AmqpException;
import org.springframework.amqp.core.*;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.nio.charset.StandardCharsets;

@Configuration
public class RabbitMQConfig {

    @Value("${rabbitmq.routing.key.nama}")
    private String routingKey;

    @Value("${rabbitmq.exchange.name}")
    private String exchangeName;


    @Value("${fulfillment.interval}")
    private int intervalPublish;

    @Value("${rabbitmq.queue.name0.adhoc}")
    private String queueAdhoc0;
    @Value("${rabbitmq.queue.name1.adhoc}")
    private String queueAdhoc1;
    @Value("${rabbitmq.queue.name2.adhoc}")
    private String queueAdhoc2;
    @Value("${rabbitmq.queue.name3.adhoc}")
    private String queueAdhoc3;
    @Value("${rabbitmq.queue.name4.adhoc}")
    private String queueAdhoc4;
    @Value("${rabbitmq.queue.name5.adhoc}")
    private String queueAdhoc5;
    @Value("${rabbitmq.queue.name6.adhoc}")
    private String queueAdhoc6;
    @Value("${rabbitmq.queue.name7.adhoc}")
    private String queueAdhoc7;
    @Value("${rabbitmq.queue.name8.adhoc}")
    private String queueAdhoc8;
    @Value("${rabbitmq.queue.name9.adhoc}")
    private String queueAdhoc9;

    @Value("${rabbitmq.queue.name0.regular}")
    private String queueRegular0;
    @Value("${rabbitmq.queue.name1.regular}")
    private String queueRegular1;
    @Value("${rabbitmq.queue.name2.regular}")
    private String queueRegular2;
    @Value("${rabbitmq.queue.name3.regular}")
    private String queueRegular3;
    @Value("${rabbitmq.queue.name4.regular}")
    private String queueRegular4;
    @Value("${rabbitmq.queue.name5.regular}")
    private String queueRegular5;
    @Value("${rabbitmq.queue.name6.regular}")
    private String queueRegular6;
    @Value("${rabbitmq.queue.name7.regular}")
    private String queueRegular7;
    @Value("${rabbitmq.queue.name8.regular}")
    private String queueRegular8;
    @Value("${rabbitmq.queue.name9.regular}")
    private String queueRegular9;

    @Value("${rabbitmq.queue.name0.international}")
    private String queueInternational0;
    @Value("${rabbitmq.queue.name1.international}")
    private String queueInternational1;
    @Value("${rabbitmq.queue.name2.international}")
    private String queueInternational2;
    @Value("${rabbitmq.queue.name3.international}")
    private String queueInternational3;
    @Value("${rabbitmq.queue.name4.international}")
    private String queueInternational4;
    @Value("${rabbitmq.queue.name5.international}")
    private String queueInternational5;
    @Value("${rabbitmq.queue.name6.international}")
    private String queueInternational6;
    @Value("${rabbitmq.queue.name7.international}")
    private String queueInternational7;
    @Value("${rabbitmq.queue.name8.international}")
    private String queueInternational8;
    @Value("${rabbitmq.queue.name9.international}")
    private String queueInternational9;

    @Value("${rabbitmq.queue.name0.sb}")
    private String queueSmsBanking0;
    @Value("${rabbitmq.queue.name1.sb}")
    private String queueSmsBanking1;
    @Value("${rabbitmq.queue.name2.sb}")
    private String queueSmsBanking2;
    @Value("${rabbitmq.queue.name3.sb}")
    private String queueSmsBanking3;
    @Value("${rabbitmq.queue.name4.sb}")
    private String queueSmsBanking4;
    @Value("${rabbitmq.queue.name5.sb}")
    private String queueSmsBanking5;
    @Value("${rabbitmq.queue.name6.sb}")
    private String queueSmsBanking6;
    @Value("${rabbitmq.queue.name7.sb}")
    private String queueSmsBanking7;
    @Value("${rabbitmq.queue.name8.sb}")
    private String queueSmsBanking8;
    @Value("${rabbitmq.queue.name9.sb}")
    private String queueSmsBanking9;

    @Value("${rabbitmq.queue.name0.fulfillment}")
    private String queueFulfillment0;
    @Value("${rabbitmq.queue.name1.fulfillment}")
    private String queueFulfillment1;
    @Value("${rabbitmq.queue.name2.fulfillment}")
    private String queueFulfillment2;
    @Value("${rabbitmq.queue.name3.fulfillment}")
    private String queueFulfillment3;
    @Value("${rabbitmq.queue.name4.fulfillment}")
    private String queueFulfillment4;
    @Value("${rabbitmq.queue.name5.fulfillment}")
    private String queueFulfillment5;
    @Value("${rabbitmq.queue.name6.fulfillment}")
    private String queueFulfillment6;
    @Value("${rabbitmq.queue.name7.fulfillment}")
    private String queueFulfillment7;
    @Value("${rabbitmq.queue.name8.fulfillment}")
    private String queueFulfillment8;
    @Value("${rabbitmq.queue.name9.fulfillment}")
    private String queueFulfillment9;
    @Value("${rabbitmq.queue.name.campaign.program}")
    private String queueCampaignProgram;

    @Bean
    public DirectExchange exchange() {
        // Create a DirectExchange (you can use other exchange types if needed)
        return new DirectExchange(rabbitTemplate.getExchange());
    }

    @Bean
    public Binding bindingFulfillment(Queue queueFulfillment0, DirectExchange exchange) {
        // Create a binding between the queue and the exchange using the binding key
        return BindingBuilder.bind(queueFulfillment0).to(exchange).with("");
    }

    @Bean public Queue queueCampaignProgram(){ return new Queue(queueCampaignProgram);}
    @Bean public Queue queueFulfillment0(){ return new Queue(queueFulfillment0);}
    @Bean public Queue queueFulfillment1(){ return new Queue(queueFulfillment1);}
    @Bean public Queue queueFulfillment2(){ return new Queue(queueFulfillment2);}
    @Bean public Queue queueFulfillment3(){ return new Queue(queueFulfillment3);}
    @Bean public Queue queueFulfillment4(){ return new Queue(queueFulfillment4);}
    @Bean public Queue queueFulfillment5(){ return new Queue(queueFulfillment5);}
    @Bean public Queue queueFulfillment6(){ return new Queue(queueFulfillment6);}
    @Bean public Queue queueFulfillment7(){ return new Queue(queueFulfillment7);}
    @Bean public Queue queueFulfillment8(){ return new Queue(queueFulfillment8);}
    @Bean public Queue queueFulfillment9(){ return new Queue(queueFulfillment9);}
    @Bean public Queue queueSmsBanking0(){
        return new Queue(queueSmsBanking0);
    }
    @Bean public Queue queueSmsBanking1(){
        return new Queue(queueSmsBanking1);
    }
    @Bean public Queue queueSmsBanking2(){
        return new Queue(queueSmsBanking2);
    }
    @Bean public Queue queueSmsBanking3(){
        return new Queue(queueSmsBanking3);
    }
    @Bean public Queue queueSmsBanking4(){
        return new Queue(queueSmsBanking4);
    }
    @Bean public Queue queueSmsBanking5(){
        return new Queue(queueSmsBanking5);
    }
    @Bean public Queue queueSmsBanking6(){
        return new Queue(queueSmsBanking6);
    }
    @Bean public Queue queueSmsBanking7(){
        return new Queue(queueSmsBanking7);
    }
    @Bean public Queue queueSmsBanking8(){
        return new Queue(queueSmsBanking8);
    }
    @Bean public Queue queueSmsBanking9(){
        return new Queue(queueSmsBanking9);
    }
    @Bean public Queue queueAdhoc0(){
        return new Queue(queueAdhoc0);
    }
    @Bean public Queue queueAdhoc1(){
        return new Queue(queueAdhoc1);
    }
    @Bean public Queue queueAdhoc2(){
        return new Queue(queueAdhoc2);
    }
    @Bean public Queue queueAdhoc3(){
        return new Queue(queueAdhoc3);
    }
    @Bean public Queue queue4Adhoc(){
        return new Queue(queueAdhoc4);
    }
    @Bean public Queue queueAdhoc5(){
        return new Queue(queueAdhoc5);
    }
    @Bean public Queue queueAdhoc6(){
        return new Queue(queueAdhoc6);
    }
    @Bean public Queue queueAdhoc7(){
        return new Queue(queueAdhoc7);
    }
    @Bean public Queue queueAdhoc8(){
        return new Queue(queueAdhoc8);
    }
    @Bean public Queue queueAdhoc9(){
        return new Queue(queueAdhoc9);
    }

    @Bean public Queue queueRegular0(){
        return new Queue(queueRegular0);
    }
    @Bean public Queue queueRegular1(){
        return new Queue(queueRegular1);
    }
    @Bean public Queue queueRegular2(){
        return new Queue(queueRegular2);
    }
    @Bean public Queue queueRegular3(){
        return new Queue(queueRegular3);
    }
    @Bean public Queue queueRegular4(){
        return new Queue(queueRegular4);
    }
    @Bean public Queue queueRegular5(){
        return new Queue(queueRegular5);
    }
    @Bean public Queue queueRegular6(){
        return new Queue(queueRegular6);
    }
    @Bean public Queue queueRegular7(){
        return new Queue(queueRegular7);
    }
    @Bean public Queue queueRegular8(){
        return new Queue(queueRegular8);
    }
    @Bean public Queue queueRegular9(){
        return new Queue(queueRegular9);
    }
    @Bean
    public Queue queueInternational0(){
        return new Queue(queueInternational0);
    }
    @Bean public Queue queueInternational1(){
        return new Queue(queueInternational1);
    }
    @Bean public Queue queueInternational2(){
        return new Queue(queueInternational2);
    }
    @Bean public Queue queueInternational3(){
        return new Queue(queueInternational3);
    }
    @Bean public Queue queueInternational4(){
        return new Queue(queueInternational4);
    }
    @Bean public Queue queueInternational5(){
        return new Queue(queueInternational5);
    }
    @Bean public Queue queueInternational6(){
        return new Queue(queueInternational6);
    }
    @Bean public Queue queueInternational7(){
        return new Queue(queueInternational7);
    }
    @Bean public Queue queueInternational8(){
        return new Queue(queueInternational8);
    }
    @Bean public Queue queueInternational9(){
        return new Queue(queueInternational9);
    }

    private RabbitTemplate rabbitTemplate;

    public void sendMessageCampaignProgram(CampaignProgram campaignProgram, String queue){
        Util.debugLogger.debug("Message sent -> {} to Queue: {}", campaignProgram,queue);
        if (isQueueExistCampaignProgram(queue)){
            String message=new Util().esbFulfillmentToJSONObject(campaignProgram).toString();

            String exchange = exchangeName;
            try {
//                rabbitTemplate.convertAndSend(exchange, "", message.getBytes(StandardCharsets.UTF_8));
            rabbitTemplate.convertAndSend(queue,message.getBytes(StandardCharsets.UTF_8));
                Util.debugLogger.debug("Message sent to Exchange: {}", exchange);
            } catch (AmqpException ex) {
                Util.errorLogger.error("Error sending message to Exchange: {}", exchange, ex);
            }
////            rabbitTemplate.convertAndSend(exchange, "", message, msg -> {
////                msg.getMessageProperties().setDelay(1000);
////                return msg;
////            });
        }

    }

    public RabbitMQConfig(RabbitTemplate rabbitTemplate) {
        this.rabbitTemplate = rabbitTemplate;
    }

    public void sendMessageFulfillment(QueueFulfillment queueFulfillment, String queue){
        Util.debugLogger.debug("Message sent -> {} to Queue: {}", queueFulfillment,queue);
        if (isQueueExistFulfillment(queue)){
            String message=new Util().esbFulfillmentToJSONObject(queueFulfillment).toString();

            for (int i = 0; i < 10; i++) {
                String exchange = exchangeName + i;
                try {
                    rabbitTemplate.convertAndSend(exchange, "", message, msg -> {
                        msg.getMessageProperties().setDelay(1000);
                        return msg;
                    });
                    Util.debugLogger.debug("Message sent to Exchange: {}", exchange);
                } catch (AmqpException ex) {
                    Util.errorLogger.error("Error sending message to Exchange: {}", exchange, ex);
                }
            }


        }

    }

    public void sendMessagePushOffer(OfferPush offerPush, String queue){
        Util.debugLogger.debug("Message sent -> {} to Queue: {}", offerPush,queue);
        if (queue.contains("adhoc")){
            if (isQueueExistAdhoc(queue)){
                String message=new Util().esbFulfillmentToJSONObject(offerPush).toString();
                rabbitTemplate.convertAndSend(queue,message.getBytes(StandardCharsets.UTF_8));
                rabbitTemplate.destroy();
            }
        }else if (queue.contains("reg")){
            if (isQueueExistRegular(queue)){
                String message=new Util().esbFulfillmentToJSONObject(offerPush).toString();
                rabbitTemplate.convertAndSend(queue,message.getBytes(StandardCharsets.UTF_8));
                rabbitTemplate.destroy();
            }
        }else if (queue.contains("ir")){
            if (isQueueExistInternational(queue)){
                String message=new Util().esbFulfillmentToJSONObject(offerPush).toString();
                rabbitTemplate.convertAndSend(queue,message.getBytes(StandardCharsets.UTF_8));
                rabbitTemplate.destroy();
            }
        }else if (queue.contains("sb")){
            if (isQueueExistSmsBanking(queue)){
                String message=new Util().esbFulfillmentToJSONObject(offerPush).toString();
                rabbitTemplate.convertAndSend(queue,message.getBytes(StandardCharsets.UTF_8));
                rabbitTemplate.destroy();
            }
        }else {
            System.out.println("No Registered Queue -> " + queue);
        }
    }

    private boolean isQueueExistCampaignProgram(String queue){
        switch (queue){
            case "queue_campaign_program":return  true;
        }
        return false;
    }
    private boolean isQueueExistFulfillment(String queue){
        switch (queue) {
            case "queue_fulfillment":
                return true;
            case "queue_fulfillment0":
                return true;
            case "queue_fulfillment1":
                return true;
            case "queue_fulfillment2":
                return true;
            case "queue_fulfillment3":
                return true;
            case "queue_fulfillment4":
                return true;
            case "queue_fulfillment5":
                return true;
            case "queue_fulfillment6":
                return true;
            case "queue_fulfillment7":
                return true;
            case "queue_fulfillment8":
                return true;
            case "queue_fulfillment9":
                return true;
            default: return false;
        }
    }

    private boolean isQueueExistAdhoc(String queue){
        switch (queue) {
            case "mb_offer_adhoc":
                return true;
            case "mb_offer_adhoc0":
                return true;
            case "mb_offer_adhoc1":
                return true;
            case "mb_offer_adhoc2":
                return true;
            case "mb_offer_adhoc3":
                return true;
            case "mb_offer_adhoc4":
                return true;
            case "mb_offer_adhoc5":
                return true;
            case "mb_offer_adhoc6":
                return true;
            case "mb_offer_adhoc7":
                return true;
            case "mb_offer_adhoc8":
                return true;
            case "mb_offer_adhoc9":
                return true;
            default: return false;
        }
    }
    private boolean isQueueExistRegular(String queue){
        switch (queue) {
            case "mb_offer_reg":
                return true;
            case "mb_offer_reg0":
                return true;
            case "mb_offer_reg1":
                return true;
            case "mb_offer_reg2":
                return true;
            case "mb_offer_reg3":
                return true;
            case "mb_offer_reg4":
                return true;
            case "mb_offer_reg5":
                return true;
            case "mb_offer_reg6":
                return true;
            case "mb_offer_reg7":
                return true;
            case "mb_offer_reg8":
                return true;
            case "mb_offer_reg9":
                return true;
            default: return false;
        }
    }
    private boolean isQueueExistInternational(String queue){
        switch (queue) {
            case "mb_offer_ir":
                return true;
            case "mb_offer_ir0":
                return true;
            case "mb_offer_ir1":
                return true;
            case "mb_offer_ir2":
                return true;
            case "mb_offer_ir3":
                return true;
            case "mb_offer_ir4":
                return true;
            case "mb_offer_ir5":
                return true;
            case "mb_offer_ir6":
                return true;
            case "mb_offer_ir7":
                return true;
            case "mb_offer_ir8":
                return true;
            case "mb_offer_ir9":
                return true;
            default: return false;
        }
    }
    private boolean isQueueExistSmsBanking(String queue){
        switch (queue) {
            case "mb_offer_sb":
                return true;
            case "mb_offer_sb0":
                return true;
            case "mb_offer_sb1":
                return true;
            case "mb_offer_sb2":
                return true;
            case "mb_offer_sb3":
                return true;
            case "mb_offer_sb4":
                return true;
            case "mb_offer_sb5":
                return true;
            case "mb_offer_sb6":
                return true;
            case "mb_offer_sb7":
                return true;
            case "mb_offer_sb8":
                return true;
            case "mb_offer_sb9":
                return true;
            default: return false;
        }
    }
}