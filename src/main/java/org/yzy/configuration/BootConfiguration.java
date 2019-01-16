package org.yzy.configuration;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Component;

/**
 * Created by yangzhenyu on 2019/1/15.
 */
@Component
@PropertySource("classpath:/config/boot.properties")
@ConfigurationProperties(prefix = "boot")
public class BootConfiguration {
    private String name;

    private String author;

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
