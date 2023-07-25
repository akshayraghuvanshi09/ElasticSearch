package com.sea.config;

import org.elasticsearch.node.NodeBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.elasticsearch.core.ElasticsearchOperations;
import org.springframework.data.elasticsearch.core.ElasticsearchTemplate;
import org.springframework.data.elasticsearch.repository.config.EnableElasticsearchRepositories;

@Configuration
@EnableElasticsearchRepositories(basePackages = " com.sea.repository" )
public class EsConfig {
	
	@Bean
	public NodeBuilder builder() {
		return new NodeBuilder();
	}

	@Bean
	public ElasticsearchOperations elastisarchTemplate() {
		return new ElasticsearchTemplate(builder().local(true).node().client());
	}
}
