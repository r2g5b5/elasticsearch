package com.example.elasticsearch.elasticsearch.util;

import co.elastic.clients.elasticsearch._types.query_dsl.MatchAllQuery;
import co.elastic.clients.elasticsearch._types.query_dsl.MatchQuery;
import co.elastic.clients.elasticsearch._types.query_dsl.Query;

import java.util.function.Supplier;

public class ElasticSearchUtil {

    public static Supplier<Query> supplier(){
        Supplier<Query> supplier = ()->Query.of(q->q.matchAll(matchAllQuery()));
        return supplier;
    }

    public static MatchAllQuery matchAllQuery(){
        var  matchAllQuery = new MatchAllQuery.Builder();
        return matchAllQuery.build();
    }

    public static Supplier<Query> supplierWithNameField(String fieldValue){
        Supplier<Query> supplier = ()->Query.of(q->q.match(matchQueryWithNameField(fieldValue)));
        return supplier;
    }

    public static MatchQuery matchQueryWithNameField(String fieldValue){
        var  matchQuery = new MatchQuery.Builder();
        return matchQuery.field("name").query(fieldValue).build();
    }


}
