gcloud run deploy ravensoulwellness --source . --platform managed --region us-west2 --timeout 300 --memory 512Mi --allow-unauthenticated
gcloud services enable run.googleapis.com cloudbuild.googleapis.com

gcloud projects add-iam-policy-binding ravensoulwellnesscom --member=serviceAccount:868057836033-compute@developer.gserviceaccount.com --role=roles/run.builder