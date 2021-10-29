package me.xiaoyan.pay;

import com.google.gson.Gson;
import me.xiaoyan.pay.util.Assert;
import me.xiaoyan.pay.util.RSAUtils;
import me.xiaoyan.pay.vo.Order;
import me.xiaoyan.pay.vo.OrderResult;
import me.xiaoyan.pay.vo.PayRecord;
import me.xiaoyan.pay.vo.QueryOrder;
import org.apache.http.NameValuePair;
import org.apache.http.message.BasicNameValuePair;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class PayClient {
    private static final SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
    private Logger logger = LoggerFactory.getLogger(PayClient.class);
    private String API_URL = "http://localhost:8088/gateway.do";
    private static final String charset = "UTF-8";
    private Gson gson = new Gson();

    private String secretKey;
    private String merchantId;
    private static PayClient client;

    public String getSecretKey() {
        return secretKey;
    }

    private PayClient(String merchantId, String secretKey, String apiUrl) {
        this(merchantId, secretKey);
        this.API_URL = apiUrl + "/gateway.do";
    }

    private PayClient(String merchantId, String secretKey) {
        logger.info("开始初始化客户端 商户:" + merchantId);
        this.merchantId = merchantId;
        this.secretKey = secretKey;
    }


    /**
     * 实例化支付客户端
     *
     * @param merchantId 商户编号
     * @param secretKey  安全密钥
     * @return
     */
    public static PayClient getClient(String merchantId, String secretKey) {
        Assert.notNull(secretKey, Messages.PRI_KEY_MUST_NOT_BE_NULL);
        if (null == client) client = new PayClient(merchantId, secretKey);
        return client;
    }

    private List<NameValuePair> createReqParams(String method, String postParam) {
        List<NameValuePair> pairs = new ArrayList<>();
        String timestamp = df.format(new Date());
        // 计算签名
        String sign = RSAUtils.sign(postParam + timestamp, secretKey, charset);
        pairs.add(new BasicNameValuePair("method", method));
        pairs.add(new BasicNameValuePair("mch_id", this.merchantId));
        pairs.add(new BasicNameValuePair("sign_type", "RSA2"));
        pairs.add(new BasicNameValuePair("sign", sign));
        pairs.add(new BasicNameValuePair("timestamp", timestamp));
        pairs.add(new BasicNameValuePair("charset", charset));
        return pairs;
    }

    private <T> T request(String method, String param, Class clazz) {
//        StringBuilder sb = new StringBuilder();
//        sb.append("method")
        ApiResponse<T> apiResponse = ApiRequest.post(API_URL, createReqParams(method, param), param, clazz);
        return (T) apiResponse.getData();
    }

    //
    public void test() {
        String message = request("pay.order.test", "{}", String.class);
        System.out.println(message);
    }

    public OrderResult create(Order order) {
        return request("pay.order.create", gson.toJson(order), OrderResult.class);
    }

    public PayRecord query(QueryOrder queryOrder) {
        return request("pay.order.query", gson.toJson(queryOrder), PayRecord.class);
    }

}
