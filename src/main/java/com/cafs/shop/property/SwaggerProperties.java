package com.cafs.shop.property;

import lombok.Data;
import org.springframework.context.annotation.Configuration;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

@Configuration
@Data
public class SwaggerProperties {

    private List<String> basePackages = new ArrayList(Collections.singletonList("com.cafs.shop"));
    private List<String> basePath = new ArrayList();
    private List<String> excludePath = new ArrayList();
    private String title = "淘好物 接口文档系统";
    private String description = "淘好物 接口文档系统";
    private String version = "";
    private String license = "";
    private String licenseUrl = "";
    private String termsOfServiceUrl = "";
    private String host = "";
    private Contact contact = new Contact();
    private Authorization authorization = new Authorization();

    @Data
    public static class AuthorizationScope {
        private String scope = "";
        private String description = "";
    }

    @Data
    public static class Authorization {
        private String name = "";
        private String authRegex = "^.*$";
        private List<AuthorizationScope> authorizationScopeList = new ArrayList<>();
        private List<String> tokenUrlList = new ArrayList<>();
    }

    @Data
    public static class Contact {
        private String name = "";
        private String url = "";
        private String email = "";
    }
}
