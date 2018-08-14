#!/bin/sh

aws --endpoint-url=http://localhost:4572 s3api create-bucket --bucket my-example --region eu-west-1
aws --endpoint-url=http://localhost:4572 s3api put-bucket-versioning --bucket my-example --versioning-configuration Status=Enabled
aws --endpoint-url=http://localhost:4572 s3 cp /home/fred/Téléchargements/example s3://my-bucket/example --recursive
aws --endpoint-url=http://localhost:4572 s3 ls s3://my-example/example/
