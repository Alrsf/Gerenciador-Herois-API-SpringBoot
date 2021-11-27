package com.digitalinnovationone.heroesapi.config;

import com.amazonaws.AmazonClientException;
import com.amazonaws.auth.AWSCredentials;
import com.amazonaws.auth.BasicAWSCredentials;
import com.amazonaws.client.builder.AwsClientBuilder;
import com.amazonaws.services.dynamodbv2.AmazonDynamoDB;
import com.amazonaws.services.dynamodbv2.AmazonDynamoDBClient;
import com.amazonaws.services.dynamodbv2.AmazonDynamoDBClientBuilder;
import org.socialsignin.spring.data.dynamodb.repository.config.EnableDynamoDBRepositories;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.util.StringUtils;
import com.amazonaws.services.dynamodbv2.model.ScalarAttributeType;
import com.amazonaws.services.dynamodbv2.model.ProvisionedThroughput;
import com.amazonaws.services.dynamodbv2.model.KeyType;
import com.amazonaws.services.dynamodbv2.model.KeySchemaElement;
import com.amazonaws.services.dynamodbv2.model.AttributeDefinition;
import com.amazonaws.services.dynamodbv2.document.DynamoDB;
import com.amazonaws.services.dynamodbv2.document.Table;
import com.amazonaws.services.dynamodbv2.document.Item;
import com.amazonaws.services.dynamodbv2.document.PutItemOutcome;
import com.amazonaws.services.dynamodbv2.document.PutItemOutcome;
import static com.digitalinnovationone.heroesapi.constans.HeroesConstant.HEROES_ENDPOINT_LOCAL;
import static com.digitalinnovationone.heroesapi.constans.HeroesConstant.REGION_DYNAMO;
import static com.digitalinnovationone.heroesapi.constans.HeroesConstant.ENDPOINT_DYNAMO;


public class HeroesData {
    public static void main (String [] args) throws Exception{
        AmazonDynamoDB client = AmazonDynamoDBClientBuilder.standard()
                .withEndpointConfiguration(new AwsClientBuilder.EndpointConfiguration(ENDPOINT_DYNAMO,REGION_DYNAMO))
                .build();
        DynamoDB dynamoDB = new DynamoDB(client);

        Table table = dynamoDB.getTable("Heroes_Table");
        Item hero = new Item()
                .withPrimaryKey("id",  1)
                .withString("name", " Mulher Maravilha")
                .withString("universe", "DC Comics")
                .withNumber("films", 2);
        Item hero2 = new Item()
                .withPrimaryKey("id",  2)
                .withString("name", " Superman")
                .withString("universe", "DC Comics")
                .withNumber("films", 2);
        Item hero3 = new Item()
                .withPrimaryKey("id",  3)
                .withString("name", " Batman")
                .withString("universe", "DC Comics")
                .withNumber("films", 1);
        Item hero4 = new Item()
                .withPrimaryKey("id",  4)
                .withString("name", " Homem de Ferro")
                .withString("universe", "Marvel")
                .withNumber("films", 3);
        Item hero5 = new Item()
                .withPrimaryKey("id",  5)
                .withString("name", " Capitão América")
                .withString("universe", "Marvel")
                .withNumber("films", 3);
        Item hero6 = new Item()
                .withPrimaryKey("id",  6)
                .withString("name", " Thor")
                .withString("universe", "Marvel")
                .withNumber("films", 3);

        PutItemOutcome outcome = table.putItem(hero);
        PutItemOutcome outcome1 = table.putItem(hero2);
        PutItemOutcome outcome2 = table.putItem(hero3);
        PutItemOutcome outcome3 = table.putItem(hero4);
        PutItemOutcome outcome4 = table.putItem(hero5);
        PutItemOutcome outcome5 = table.putItem(hero6);
    }
}
