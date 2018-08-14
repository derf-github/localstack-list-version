package com.example.demo;

import com.amazonaws.auth.AWSStaticCredentialsProvider;
import com.amazonaws.auth.BasicAWSCredentials;
import com.amazonaws.client.builder.AwsClientBuilder.EndpointConfiguration;
import com.amazonaws.services.s3.AmazonS3;
import com.amazonaws.services.s3.AmazonS3ClientBuilder;

import static com.amazonaws.regions.Regions.EU_WEST_1;

public class DemoApplication {

    public static void main(String[] args) {
        final AmazonS3 amazonS3 = AmazonS3ClientBuilder.standard()
                .withEndpointConfiguration(new EndpointConfiguration("http://localhost:4572", EU_WEST_1.getName()))
                .withCredentials(new AWSStaticCredentialsProvider(new BasicAWSCredentials("foobar", "foobar")))
                .withPathStyleAccessEnabled(true)
                .build();

        System.err.println(amazonS3.listBuckets());
        System.err.println(amazonS3.getBucketVersioningConfiguration("my-example").getStatus());
        System.err.println(amazonS3.listVersions("my-example", "example/example0.txt").getVersionSummaries().size());
    }

}
