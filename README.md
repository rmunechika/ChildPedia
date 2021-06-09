# ChildPedia
An Encyclopedia for Children

This is an app that children can use to make their own encyclopedia and share it to the other user.


## Cloud Computing Documentation
* Making a Service Account
  
  First, I create a service account that can accessed both Bigquery and Cloud Storage later.
  <img src="https://github.com/rmunechika/ChildPedia/blob/master/screenshot/service account.png">
  
  And then, I create a service key from the service account so my python code can access it. After that, I download the key and save it in
  the Childpedia_Endpoint folder along with the Python code.
  <img src="https://github.com/rmunechika/ChildPedia/blob/master/screenshot/key.png">
  
* Creating an endpoint
  
  With service account created, I make an endpoint using Python language and flask. 
  before that I need to do a few setup. With pip installed I need to download libraries below:
  
  ```
   pip install --upgrade google-cloud-bigquery
   pip install --upgrade google-cloud-storage
  ```
  
  Before running the python code, you need to run this command below in the terminal. This allows the code
  to set the credential with the key I downloaded.
  
   ```
    $env:GOOGLE_APPLICATION_CREDENTIALS="projects\api\bangkitproject-314115-ae5001a2c667.json"
  ```
  
Inside the Childpedia_Endpoint folder, it contains the endpoint code using Python language and flask. The endpoint is used to connect the application to Bigquery and Cloud Storage on GCP (Google Cloud Platform). Because some of our members are also busy with other works unrelated to Capstone Project, unfortunately we don't have time to properly integrate the endpoint with the Childpedia App. As the result, the Childpedia app cannot connect to Bigquery and Cloud Storage. 

Childpedia using Machine Learning for categorizing the article. Also using python and tensorflow-keras for the machine learning. The dataset we use we get from kaggle and we preprocessing the dataset to create our own dataset. Our project using Image Classification and CNN architecture, unfortunately because our knowlage and some problem in our team we can't finish the last step for deploying the machine learning to our app using TFLite.

**Screenshot:**<br><br>
<img width="150" src="https://github.com/rmunechika/ChildPedia/blob/master/screenshot/Screenshot_2021-06-03-07-51-53-48.png">
<img width="150" src="https://github.com/rmunechika/ChildPedia/blob/master/screenshot/Screenshot_2021-06-03-07-51-57-80.png">
<img width="150" src="https://github.com/rmunechika/ChildPedia/blob/master/screenshot/Screenshot_2021-06-03-07-52-02-60.png">
<img width="150" src="https://github.com/rmunechika/ChildPedia/blob/master/screenshot/Screenshot_2021-06-03-07-52-07-67.png">
<img width="150" src="https://github.com/rmunechika/ChildPedia/blob/master/screenshot/Screenshot_2021-06-03-07-52-12-39.png">
