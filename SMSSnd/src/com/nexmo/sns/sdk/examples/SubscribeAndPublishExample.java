package com.nexmo.sns.sdk.examples;

import com.nexmo.sns.sdk.NexmoSnsClient;
import com.nexmo.sns.sdk.request.SubscribeRequest;
import com.nexmo.sns.sdk.request.PublishRequest;
import com.nexmo.sns.sdk.response.PublishResult;
import com.nexmo.sns.sdk.response.SubscribeResult;

/**
 * SubscribeAndPublishExample.java<br><br>
 *
 * An example of using the nexmo sns api to subscribe a user, then broadcast a message ...<br><br>
 *
 * Created on 5 January 2011, 17:34
 *
 * @author  Paul Cook
 * @version 1.0
 */
public class SubscribeAndPublishExample {

    public static final String API_KEY = "f1e96710";
    public static final String API_SECRET = "2ad8d871";

    public static final String SMS_FROM = "5143222869";
    public static final String SMS_TO = "5149192869";
    public static final String SMS_TEXT = "Hello World!";

    // -- TODO -- fill in your own topic ARN from your amazon SNS console
    public static final String TOPIC_ARN = "arn:aws:sns:us-east-1:475338436304:paul";

    public static void main(String[] args) {

        // Create a client for submitting to Nexmo

        NexmoSnsClient client = null;
        try {
            client = new NexmoSnsClient(API_KEY, API_SECRET);
        } catch (Exception e) {
            System.err.println("Failed to instanciate a Nexmo Client");
            e.printStackTrace();
            throw new RuntimeException("Failed to instanciate a Nexmo Client");
        }

        // Create a Request to subscribe a phone number to the SNS service

        SubscribeRequest subscribeRequest = null;
        try {
            subscribeRequest = new SubscribeRequest(TOPIC_ARN, SMS_TO);
        } catch (Exception e) {
            System.err.println("Failed to construct a SubscriptionRequest");
            e.printStackTrace();
            throw new RuntimeException("Failed to construct a SubscriptionRequest");
        }

        // Use the Nexmo client to submit this subscription

        SubscribeResult subscribeResult = null;
        try {
            subscribeResult = client.submit(subscribeRequest);
        } catch (Exception e) {
            System.err.println("Failed to perform subscription");
            e.printStackTrace();
            throw new RuntimeException("Failed to perform subscription");
        }

        // Evaluate the subscription response .....

        System.out.println("RESULT OF SUBSCRIPTION REQUEST ....");
        System.out.println("Command: " + subscribeResult.getCommand());
        System.out.println("Result: " + subscribeResult.getResultCode() + " - " + subscribeResult.getResultMessage());
        System.out.println("Subscriber ARN: " + subscribeResult.getSubscriberArn());

        // Create a request to publish a message to all subscribers

        PublishRequest publishRequest = null;
        try {
            publishRequest = new PublishRequest(TOPIC_ARN, SMS_FROM, SMS_TEXT);
        } catch (Exception e) {
            System.err.println("Failed to construct a PublishRequest");
            e.printStackTrace();
            throw new RuntimeException("Failed to construct a PublishRequest");
        }

        // Use the Nexmo client to submit this subscription

        PublishResult publishResult = null;
        try {
            publishResult = client.submit(publishRequest);
        } catch (Exception e) {
            System.err.println("Failed to perform publish");
            e.printStackTrace();
            throw new RuntimeException("Failed to perform publish");
        }

        // Evaluate the publish response .....

        System.out.println("RESULT OF SUBSCRIPTION REQUEST ....");
        System.out.println("Command: " + publishResult.getCommand());
        System.out.println("Result: " + publishResult.getResultCode() + " - " + publishResult.getResultMessage());
        System.out.println("Transaction ID: " + publishResult.getTransactionId());
    }

}
