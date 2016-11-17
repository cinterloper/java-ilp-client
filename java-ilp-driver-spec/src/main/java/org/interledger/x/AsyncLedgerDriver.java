package org.interledger.x;

import io.vertx.core.AsyncResult;
import io.vertx.core.Handler;
import io.vertx.core.json.JsonObject;
import org.interledger.cryptoconditions.Fulfillment;
import org.interledger.cryptoconditions.Condition;

import java.net.URI;
import java.net.URL;
import java.util.Map;

/**
 * Created by g on 11/17/16.
 */
public interface AsyncLedgerDriver {
    void connect(Handler<AsyncResult> handler);
    void disconnect(Handler<AsyncResult> handler);
    void getInfo(Handler<AsyncResult> handler);
    void getPrefix(Handler<AsyncResult> handler);
    void getAccount(Handler<AsyncResult> handler);
    void getBalance(Handler<AsyncResult> handler);

    void sendMessage(JsonObject message, Handler<AsyncResult> handler);

    void sendTransfer(JsonObject transfer, Handler<AsyncResult> handler);


    void fufillCondition(String transferId, Fulfillment f, Handler<AsyncResult> handler);

    void getFufillment(String transferId, Handler<AsyncResult> handler);

    void rejectIncomingTransfer(String transferId, String rejectionMessage, Handler<AsyncResult> handler);

    Handler getMessageNotificationHandler();

    Handler getTransferNotificationHandler();

    String accountUriToName(URI accountURI);

    JsonObject parseAddress(String address);

    Map<String,String> parseAndValidateLedgerUrls(Map<String,String> metadataUrls);




}
