package com.sea.service;

import java.util.List;

import org.elasticsearch.index.query.MultiMatchQueryBuilder;
import org.elasticsearch.index.query.QueryBuilder;
import org.elasticsearch.index.query.QueryBuilders;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.elasticsearch.core.ElasticsearchTemplate;
import org.springframework.data.elasticsearch.core.query.NativeSearchQuery;
import org.springframework.data.elasticsearch.core.query.NativeSearchQueryBuilder;
import org.springframework.data.elasticsearch.core.query.SearchQuery;
import org.springframework.stereotype.Service;

import com.sea.model.Employee;

@Service
public class QueryDSLService {

	@Autowired
	private ElasticsearchTemplate template;
	
	public List<Employee> searchMultiField(String firstname,int age){
		QueryBuilder query  =QueryBuilders.boolQuery().must(QueryBuilders.matchQuery("firstname", firstname))
				.must(QueryBuilders.matchQuery("age", age));
		NativeSearchQuery nativeSearchQuery = new NativeSearchQueryBuilder().withQuery(query).build();
		 List<Employee> employees = template.queryForList(nativeSearchQuery, Employee.class);
		 return employees;
	}
	
	public List<Employee> getEmployeeSearchData(String input){
		String search =".*"+input+".*";
		SearchQuery searchQuery = new NativeSearchQueryBuilder().withFilter(QueryBuilders.regexpQuery("firstname", search)).build();
		 List<Employee> employees = template.queryForList(searchQuery, Employee.class);
		 return employees;
	}
	
	public List<Employee> multiMatchQuery(String input){
		SearchQuery searchQuery = new NativeSearchQueryBuilder().withQuery(QueryBuilders.multiMatchQuery(input)
				.field("firstname").field("lastname").type(MultiMatchQueryBuilder.Type.BEST_FIELDS)).build();
		 List<Employee> employees = template.queryForList(searchQuery, Employee.class);
		 return employees;
	}
}
