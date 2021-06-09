from flask import jsonify, request 
from flask.app import Flask
from flask.helpers import make_response
import json
import sys
from pandas import DataFrame, Series
from google.cloud import bigquery,storage

 
#note/setup
####################
#before running this code
#run in terminal: 
# command prompt:
# 1. pip install --upgrade google-cloud-bigquery
# 2. pip install --upgrade google-cloud-storage
# terminal:
# 3. '$env:GOOGLE_APPLICATION_CREDENTIALS="bangkitproject-314115-ae5001a2c667.json"'
####################


#optional way to get API:

#steps on getting the api
#####################################################################################
# 1. go to this link: https://developers.google.com/oauthplayground/
# 2. on step one find "BigQuery API v2" and check all of it, click Authorize APIs
# 3. copy the access token on step 2
# go to the link below, replacing each parameter with table that want to access
#####################################################################################


#get api
#https://bigquery.googleapis.com/bigquery/v2/projects/{projectId}/datasets/{datasetId}/tables/{tableId}/data?access_token={access token lo td}#
#example using ^
#https://bigquery.googleapis.com/bigquery/v2/projects/bangkitproject-314115/datasets/Childpedia/tables/user/data?access_token={access token lo td}#
#project id above is our project id

app = Flask(__name__)
app.config["DEBUG"] = True



project_id = "bangkitproject-314115"




#google cloud setup
client = bigquery.Client()
storage_client = storage.Client()
bucket =  storage_client.get_bucket('childpedia_storage')

#upload file with dummy photo
# image_upload = bucket.blob('images/Untitled1.png')
# image_upload.upload_from_filename(filename='test_upload.png')

#download file from bucket with dummy photo
# image_download = bucket.blob('images/adios.jpg')
# image_download.download_to_filename(filename='test_download.png')





#home
@app.route('/', methods=['GET'])
def home():
    return "<h1>Childpedia</h1><p>This site is a prototype API for reading ecnyclopedias.</p>"


#login and signup screen
@app.route('/login', methods = ['POST','GET'])
def login():
    if request.method == 'POST':
        username = request.form['username']
        email = request.form['email']
        password = request.form['password']


        query = """
                SELECT user_email, user_password  
                FROM `bangkitproject-314115.Childpedia.user`  
                WHERE username = %s AND password = %s 

                """

        return jsonify({ 'email': email, 'password': password, 'username':username})




@app.route('/signup', methods=['POST'])
def signup():
    return 'Signup'

@app.route('/logout')
def logout():
    return 'Logout'

# A route to return all of the available encyclopedias
@app.route('/api/v1/resources/encyclopedias', methods=['GET'])
def api_all():
    
    #simpan sql ke variabel
    query =  """
            
            SELECT e.id, e.ency_name, e.ency_genre, e.ency_description, i.image_url  
            FROM `bangkitproject-314115.Childpedia.encyclopedias` e
            JOIN  `bangkitproject-314115.Childpedia.images` i ON e.id = i.encyclopedia_id

            """


    #di run query terus dimasukkin ke variabel 
    queryJob = client.query(query)
    
    #ubah hasil jdi per row di dalam variabel baru
    records = [dict(row) for row in queryJob]

    #diubah row jdi json
    jsonObject = json.dumps(str(records))

   
    return jsonObject  
 



#route to return a specific encyclopedia
@app.route('/api/v1/resources/encyclopedias/<id>', methods=['GET'])
def api_encyclopedia_id(id):
    
    
    query = """
            SELECT e.id, e.ency_name, e.ency_genre, e.ency_description, i.image_url  
            FROM `bangkitproject-314115.Childpedia.encyclopedias` e
            JOIN  `bangkitproject-314115.Childpedia.images` i ON e.id = i.encyclopedia_id
             
            """


    
    job_config = bigquery.QueryJobConfig(
        query_parameters=[
        bigquery.ScalarQueryParameter("encyclopedia_id", "STRING", id)
       
        ]
    )

    queryJob = client.query(query, job_config=job_config)


    records = [dict(row) for row in queryJob]
    jsonObject = json.dumps(str(records))
    
    

    length = len(records)

    # if encyclopedia id does not match
    if length == 0:
        message = jsonify({
            
            'error' : 'user_not_found',
            'message' : 'User is not found'
        })
        return make_response(message, 404)


    return jsonObject


    



#route to return a specific user
@app.route('/api/v1/resources/users/<id>', methods=['GET'])

def api_user_id(id):
     
    query = """
            SELECT *
            FROM `bangkitproject-314115.Childpedia.user`
            WHERE id = @user_id
             
            """
    job_config = bigquery.QueryJobConfig(
        query_parameters=[
        bigquery.ScalarQueryParameter("user_id", "STRING", id)
       
        ]
    )

    queryJob = client.query(query, job_config=job_config)
    records = [dict(row) for row in queryJob]
    jsonObject = json.dumps(str(records))

    length = len(records)

    # if encyclopedia id does not match
    if length == 0:
        message = jsonify({
            
            'error' : 'user_not_found',
            'message' : 'User is not found'
        })
        return make_response(message, 404)


    return jsonObject


if __name__ == '__main__':
     app.run(host='0.0.0.0', port=10533)
