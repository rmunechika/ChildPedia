# ChildPedia
An Encyclopedia for Children

This is an app that children can use to make their own encyclopedia and share it to the other user.


## Machine Learning Documentation
Childpedia using Machine Learning for categorizing the article. Also using python and tensorflow-keras for the machine learning. The dataset we use we get from kaggle and we preprocessing the dataset to create our own dataset. Our project using Image Classification and CNN architecture, unfortunately because our knowlage and some problem in our team we can't finish the last step for deploying the machine learning to our app using TFLite.

Make sure you already install tensorflow using

  ```
   pip install tensorflow
  ```

* Prepare the Dataset
  
  First, pick the dataset and cek are all dataset successfully called
  <img src="https://github.com/rmunechika/ChildPedia/blob/master/screenshot/pick.png">

  Then, split the dataset into test, train, and validation data.
  <img src="https://github.com/rmunechika/ChildPedia/blob/master/screenshot/split.png">

  After that save split dataset into new folder dataset

* Create the model

  Create CNN Structure
  <img src="https://github.com/rmunechika/ChildPedia/blob/master/screenshot/cnn.png">

  Train Model
  <img src="https://github.com/rmunechika/ChildPedia/blob/master/screenshot/cnn.png">

  and then save the model
  <img src="https://github.com/rmunechika/ChildPedia/blob/master/screenshot/Model.png">

## Cloud Computing Documentation
  For this path, we use these references in our codes and methods related to this path:
  
  [1] (https://cloud.google.com/bigquery/docs/reference/libraries#installing_the_client_library)
  
  [2] (https://www.youtube.com/watch?v=HA6qCQnXk3I)
  
  [3] (https://github.com/googleapis/python-bigquery/blob/35627d145a41d57768f19d4392ef235928e00f72/samples/client_query_w_positional_params.py)
  
  [4] (https://rudderstack.com/blog/how-to-access-and-query-your-bigquery-data-using-python-and-r)
  
  [5] (https://programminghistorian.org/en/lessons/creating-apis-with-python-and-flask)
  

* Note

  Inside the Childpedia_Endpoint folder, it contains the endpoint code using Python language and flask. The endpoint is used to connect the application to Bigquery and Cloud       Storage on GCP (Google Cloud Platform). Because some of our members are also busy with other works unrelated to Capstone Project, unfortunately we don't have time to properly   integrate the endpoint with the Childpedia App. As the result, the Childpedia app cannot connect to Bigquery and Cloud Storage. 


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
    $env:GOOGLE_APPLICATION_CREDENTIALS="bangkitproject-314115-ae5001a2c667.json"
  ```

## Android Development Documentation
* Point 1
* Point 2
* Point 3



**Screenshot:**<br><br>
<img width="150" src="https://github.com/rmunechika/ChildPedia/blob/master/screenshot/Screenshot_2021-06-03-07-51-53-48.png">
<img width="150" src="https://github.com/rmunechika/ChildPedia/blob/master/screenshot/Screenshot_2021-06-03-07-51-57-80.png">
<img width="150" src="https://github.com/rmunechika/ChildPedia/blob/master/screenshot/Screenshot_2021-06-03-07-52-02-60.png">
<img width="150" src="https://github.com/rmunechika/ChildPedia/blob/master/screenshot/Screenshot_2021-06-03-07-52-07-67.png">
<img width="150" src="https://github.com/rmunechika/ChildPedia/blob/master/screenshot/Screenshot_2021-06-03-07-52-12-39.png">
