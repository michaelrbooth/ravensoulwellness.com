package com.bricknbyte.ravenSoul

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication

@SpringBootApplication
class RavenSoulApplication

fun main(args: Array<String>) {
    runApplication<RavenSoulApplication>(*args)
}
/**
gcloud beta run domain-mappings create --service ravensoulwellness --domain ravensoulwellness.com --region us-west1

gcloud run domain-mappings delete --domain ravensoulwellness.com --region us-west2

gcloud run services delete ravensoulwellness --region us-west2

gcloud run deploy comsite --source . --platform managed --region us-west1 --timeout 300 --memory 512Mi --allow-unauthenticated


gcloud run domain-mappings create --service comsite --domain ravensoulwellness.com --region us-west1
gcloud projects add-iam-policy-binding comsite --member="user:michael@ravensoulwellness.net" --role="roles/storage.admin"

gcloud projects add-iam-policy-binding comsite --member="user:michael@ravensoulwellness.net" --role="roles/run.developer"
gcloud projects add-iam-policy-binding comsite --member="user:michael@ravensoulwellness.net" --role="roles/iam.serviceAccountUser"

 **/