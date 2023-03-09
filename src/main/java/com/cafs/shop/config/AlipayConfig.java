package com.cafs.shop.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;

/**
 * 支付宝沙箱支付配置类
 */

@Configuration
public class AlipayConfig {

    /**
     * 应用ID,您的APPID，收款账号既是您的APPID对应支付宝账号
     */
    public static String app_id = "2021000119636184";

    /**
     * 商户私钥，您的PKCS8格式RSA2私钥
     */
    public static String merchant_private_key = "MIIEuwIBADANBgkqhkiG9w0BAQEFAASCBKUwggShAgEAAoIBAQCkoQFXxgeSehIvTHe2NIFvr1/cWApvjgT5eZ/478ZcaaKYLH9oDvfagE2SXgrZHumVyIDK+8Kbal+9/egWtbcHt8isukxNYDHPAvlyYLP+Q2zN/CHRZjIP70ULu9bOfIDQ/7HXf+djV4qkqhtRgQ++FdUCLCEgjZ6qPIHHLE9PCabp/i5tm9qRFyDb94nuTqV2w388DKAZLwtcIpNELXEHay7XecHRY5fmRs2MajPnxyXtT9ai+MClwqJsbfIesSUmQJD/4WbT3MGxtaQo+tkWFY2W48v2Iqji0vCfOy9wOpAIbSKc+yueldUPKl7rCmsnm6/h93wG9J4sOvYK4WOjAgMBAAECgf91CgHqZN79Q8up1LNG1g0vWX7NJ8pDhLQEqHMSh2R+TptJlFj/oaSTsqNza2hK868czW7C4Dl6RCXM7LYTbxywX/hK1Cdq2viOM48jwZw1J7oytw1T0VPGAFUWAnS0V888xouoqUXXWmU2q7jAOQD4Io1M/hKPEh+650lcUCQSC6U4rpvqTBFyjwv6saQOjn3PG3KyJDBA0gykME5azYeuBAbrhP45dXRZxI84bKYs5UGEtQgyhj5vnV4ZYiyK1VwLW8LQ4nhEYNBnhExjWRBvUF4uEJn3/ELbDcQ7vIwlpcFpab0ZU69V3ChtFeFtIj8DokTWCxLCWoVlN4XApHECgYEA4yxTHtdqOIlTRDd4MsravxLZpxv7btrx8Y9sA1QO6cnDh2IEnWZPZArxgi50NFmjC66S2onYwlgbsTn7y3TCPqNM68DutOXP5T2FpQfZQx5fTtZRSElr7g7U2TiYO65FcFCjbcDFNY9Zuh1x52l8+wEhg3jPkNGs8g7L5aP8UY0CgYEAuYTxoQhCiRIi0KIMiLhGHiPGUV6I6lvDtUgokfygGNkE5tiOlU5PuyhiFIbGW4v35DZZv7+6GRWWVt/OmhvbWJ4S3UOqjo01icVN9AKvA/zOb0nPTi1LgWGdkV7lXtKP/HhBDil7MDRyRL1VkusG3agNd7SsRBn0SgGrqcN/he8CgYBnzKP6LqF5Tb3/KH1CcA/9SGatBYsgPuhX4JmQ98KMrkUqQe4r4UibRKjPO9ya4u4t80lkk6G4Qzv8Aat8blAnAMSv4AryGyOf8jlzi5+JHIKd6i1fozSupJY63rIoatuNkzrpdjBl5acw9C1MeJXDtuOSSAxHdpbYT0x5FDHBLQKBgGr3+Mq9FIAscN6TUV7TwbpHLmZkd9WJq8KvJJVocHdjSqxAWZZFXTuxATyMqXrHrdtsaztgtVEZXWIiEeJSBZuHKaFjDsi7Kw+RMG1tzrQh5HXOvTV6cHrdahkT+nU+O797JyefS2R0GR8BfIIF+iN8bqeDCYEK5gx2AiEUlEcJAoGBAKlsETBAS5xhBJPML8v1pjmgl9X9qD5N97Gq/K31J8uGPKVbEQ8s4WHNoHvY1WbWphvMs8hwTMrkJFFKT8TJPRwJB1VZAOTGxu7/RGBf7tXkb1u4nA/fvGZoqSohA7GwY6X+kmgrSOv0n8L5nh4X+spzV4xA2Zg7PzIm+LFDjGd5";

    /**
     * 支付宝公钥,查看地址：https://openhome.alipay.com/platform/keyManage.htm 对应APPID下的支付宝公钥
     */
    public static String alipay_public_key = "MIIBIjANBgkqhkiG9w0BAQEFAAOCAQ8AMIIBCgKCAQEAl2Jc6BXyCSsEtcqdgbkVAHU3BQ45aSUE6VNmJqisl5ZArGjb2FFodqj0rlzZ/sBzGGuURiDspVxV9PsCtBn1okUctj9lk1172ZmyAPoKMjhy/1WUFat458cMeMVvLBhG3y/CVZ5Vh9tEK9l+W05yAVqGQvVZdvXT+y4zvVWqFKVowQcdW39nbNMY0IAn46m/NoLKDfcC6a56fpvVcvVRlwkTyp9QIPEX8ZS/K5TS/i96emY1c2p5TD5/1JU04H1iN5w50BCwxu3+s4L2CzHoaNuGL9SXQGnWBggSRqsq6FORto63DfXcDpVJZ004olrzHL42N3tvNA8tVBBJTseHzQIDAQAB";

    /**
     * 服务器异步通知页面路径  需http://格式的完整路径，不能加?id=123这类自定义参数，必须外网可以正常访问
     */
    //public static String notify_url = "http://z2o7626444.qicp.vip/checkout/returnUrl";

    /**
     * 页面跳转同步通知页面路径 需http://格式的完整路径，不能加?id=123这类自定义参数，必须外网可以正常访问
     */
    public static String return_url = "";

    /**
     * 签名方式
     */
    public static String sign_type = "RSA2";

    /**
     * 字符编码格式
     */
    public static String charset = "utf-8";

    /**
     * 支付宝网关
     */
    public static String gatewayUrl = "https://openapi.alipaydev.com/gateway.do";

    @Value("${app.returnUrl}")
    public void setReturnUrl(String returnUrl) {
        AlipayConfig.return_url = returnUrl;
    }
}

