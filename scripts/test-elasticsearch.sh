#!/bin/bash

curl -XPUT 'http://10.1.70.5:9200/sentiment/doc/4'  -H 'Content-Type: application/json' -d '{
    "user" : "jdoe",
    "post_date" : "2009-11-15T14:12:12",
    "message" : "trying out Elasticsearch"
}'
