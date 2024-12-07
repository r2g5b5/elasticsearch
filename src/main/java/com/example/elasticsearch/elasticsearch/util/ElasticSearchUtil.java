package com.example.elasticsearch.elasticsearch.util;

import co.elastic.clients.elasticsearch._types.query_dsl.MatchAllQuery;
import co.elastic.clients.elasticsearch._types.query_dsl.Query;
import org.springframework.stereotype.Service;

import java.util.function.Supplier;

public class ElasticSearchUtil {

    public static Supplier<Query> supplier() {
        Supplier<Query> supplier = () -> Query.of(q -> q.matchAll(createMatchAllQuery()));
        return supplier;
    }

    public static MatchAllQuery createMatchAllQuery() {
        var matchAllQuery = new MatchAllQuery.Builder();
        return matchAllQuery.build();
    }


}
