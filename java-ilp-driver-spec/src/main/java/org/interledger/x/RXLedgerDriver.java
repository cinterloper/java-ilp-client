package org.interledger.x;

import io.vertx.core.AsyncResult;
import io.vertx.core.Handler;
import io.vertx.core.json.JsonObject;
import org.interledger.cryptoconditions.Fulfillment;
import rx.Observable;

import java.net.URI;
import java.util.Map;

/**
 * Created by g on 11/17/16.
 */
public interface RXLedgerDriver {
    Observable connect();
    Observable disconnect();
    Observable getInfo();
    Observable getPrefix();
    Observable getAccount();
    Observable getBalance();

    Observable sendMessage(JsonObject message);

    Observable sendTransfer(JsonObject transfer);


    Observable fufillCondition(String transferId, Fulfillment f);

    Observable getFufillment(String transferId);

    Observable rejectIncomingTransfer(String transferId, String rejectionMessage);

    Handler getMessageNotificationHandler();

    Handler getTransferNotificationHandler();

    String accountUriToName(URI accountURI);

    JsonObject parseAddress(String address);

    Map<String,String> parseAndValidateLedgerUrls(Map<String,String> metadataUrls);

}
