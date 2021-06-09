from flask import jsonify, request 
from flask.app import Flask
from flask.helpers import make_response
import json
import sys
from pandas import DataFrame, Series
# from google.appengine.ext import vendor
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




# dataset dummy

users = [
    {
        'id' : 'U00001',
        'user_name' : 'John',
        'user_email' : 'john@gmail.com',
        'user_password' : '1234567',
        'user_status' : 'user',
        'user_birthdate' : '2000-06-22',
        'created_at' : '2021-05-21',
        'updated_at' : '2021-05-21'
    },

     {
        'id' : 'U00002',
        'user_name' : 'Daisy',
        'user_email' : 'Daisy@gmail.com',
        'user_password' : '1234567',
        'user_status' : 'user',
        'user_birthdate' : '2001-01-12',
        'created_at' : '2021-05-21',
        'updated_at' : '2021-05-21'
    },

     {
        'id' : 'U00003',
        'user_name' : 'Smith',
        'user_email' : 'Smith@gmail.com',
        'user_password' : '1234567',
        'user_status' : 'user',
        'user_birthdate' : '1999-02-01',
        'created_at' : '2021-05-21',
        'updated_at' : '2021-05-21'
    }

]

user_achievements = [

    {
        'id' : 'UA00001',
        'created_at' : '2021-05-21',
        'updated_at' : '2021-05-21',
        'achieved_at' : '2021-05-21',
        'user_id': 'U00001',
        'achivement_id': 'A00001'
    },

    {
        'id' : 'UA00002',
        'created_at' : '2021-05-21',
        'updated_at' : '2021-05-21',
        'achieved_at' : '2021-05-21',
        'user_id': 'U00001',
        'achivement_id': 'A00002'
    },

    {
        'id' : 'UA00003',
        'created_at' : '2021-05-21',
        'updated_at' : '2021-05-21',
        'achieved_at' : '2021-05-21',
        'user_id': 'U00001',
        'achivement_id': 'A00003'
    }
]

achivements = [

    {
        'id' : 'A00001',
        'achivement_description' : 'This achievement is gained after reading 3 encyclopedias',
        'image_url' : 'url',
        'created_at' : '2021-05-21',
        'updated_at' : '2021-05-21'
    },

    {
        'id' : 'A00002',
        'achivement_description' : 'This achievement is gained after reading 4 encyclopedias',
        'image_url' : 'url',
        'created_at' : '2021-05-21',
        'updated_at' : '2021-05-21'
    },

    {
        'id' : 'A00003',
        'achivement_description' : 'This achievement is gained after reading 5 encyclopedias',
        'image_url' : 'url',
        'created_at' : '2021-05-21',
        'updated_at' : '2021-05-21'
    }

]

encyclopedias = [
    {
        'id' : 'E00001' ,
        'ency_name': 'Jagung' ,
        'ency_genre' : 'Flora' ,
        'ency_desc' :  'Jagung (Zea mays ssp. mays) adalah salah satu tanaman pangan penghasil karbohidrat yang terpenting di dunia, selain gandum dan padi. Bagi penduduk Amerika Tengah dan Selatan, bulir jagung adalah pangan pokok, sebagaimana bagi sebagian penduduk Afrika dan beberapa daerah di Indonesia. Pada masa kini, jagung juga sudah menjadi komponen penting pakan ternak. Penggunaan lainnya adalah sebagai sumber minyak pangan dan bahan dasar tepung maizena. Berbagai produk turunan hasil jagung menjadi bahan baku berbagai produk industri farmasi, kosmetika, dan kimia. Jagung merupakan tanaman model yang menarik, khususnya di bidang biologi dan pertanian. Sejak awal abad ke-20, tanaman ini menjadi objek penelitian genetika yang intensif, dan membantu terbentuknya teknologi kultivar hibrida yang revolusioner. Dari sisi fisiologi, tanaman ini tergolong tanaman C4 sehingga sangat efisien memanfaatkan sinar matahari. Dalam kajian agronomi, tanggapan jagung yang dramatis dan khas terhadap kekurangan atau keracunan unsur-unsur hara penting menjadikan jagung sebagai tanaman percobaan fisiologi pemupukan yang disukai',
        'published_at' : '2021-05-21',
        'created_at' : '2021-05-21',
        'updated_at' : '2021-05-21',
        'user_id' : 'U00001'
         
    },

    {
        'id' : 'E00002' ,
        'ency_name': 'Kelinci' ,
        'ency_genre' : 'Fauna' ,
        'ency_desc' : 'Kelinci adalah hewan mamalia dari famili Leporidae, yang dapat ditemukan di banyak bagian bumi. Kelinci berkembangbiak dengan cara beranak yang disebut vivipar. Dulunya, hewan ini adalah hewan liar yang hidup di Afrika hingga ke daratan Eropa. Pada perkembangannya, tahun 1912, kelinci diklasifikasikan dalam ordo Lagomorpha. Ordo ini dibedakan menjadi dua famili, yakni Ochtonidae (jenis pika yang pandai bersiul) dan Leporidae (termasuk di dalamnya jenis kelinci dan terwelu). Asal kata kelinci berasal dari bahasa Belanda, yaitu konijntje yang berarti "anak kelinci". Hal ini menunjukkan bahwa masyarakat Nusantara mulai mengenali kelinci saat masa kolonial, padahal di Pulau Sumatra ada satu spesies asli kelinci sumatera (Nesolagus netscheri) yang baru ditemukan pada tahun 1972. Saat ini sejumlah jenis kelinci menjadi hewan peliharaan dan hewan pedaging. Beberapa jenis kelinci sebagai hewan pedaging juga ada yang dijadikan hewan peliharaan. Jenis kelinci terbesar di dunia, yaitu Continental Giant biasanya dijadikan hewan pedaging, tetapi ada juga yang memeliharanya dan secara resmi telah menjadi kelinci terbesar di dunia dengan tinggi/panjang 4 feet + 4 inci (132 sentimeter) dan berat 3,5 stones (22,2 kilogram).',
        'published_at' : '2021-05-21',
        'created_at' : '2021-05-21',
        'updated_at' : '2021-05-21',
        'user_id' : 'U00001'
    },

    {
        'id' : 'E00003' ,
        'ency_name': 'Kuda' ,
        'ency_genre' : 'Fauna' ,
        'ency_desc' : 'Kuda (Equus caballus atau Equus ferus caballus) adalah salah satu dari sepuluh spesies modern mamalia dari genus Equus. Hewan ini telah lama merupakan salah satu hewan peliharaan yang penting secara ekonomis dan historis, dan telah memegang peranan penting dalam pengangkutan orang dan barang selama ribuan tahun. Kuda dapat ditunggangi oleh manusia dengan menggunakan sadel dan dapat pula digunakan untuk menarik sesuatu, seperti kendaraan beroda, atau bajak. Pada beberapa daerah, kuda juga digunakan sebagai sumber makanan. Walaupun peternakan kuda diperkirakan telah dimulai sejak tahun 4500 SM, bukti-bukti penggunaan kuda untuk keperluan manusia baru ditemukan terjadi sejak 2000 SM.',
        'published_at' : '2021-05-21',
        'created_at' : '2021-05-21',
        'updated_at' : '2021-05-21',
        'user_id' : 'U00001'
    },
]

images = [

    {
        'id' : 'I00001',
        'image_url' : 'url',
        'created_at' : '2021-05-21',
        'updated_at' : '2021-05-21'

    },

     {
        'id' : 'I00002',
        'image_url' : 'url',
        'created_at' : '2021-05-21',
        'updated_at' : '2021-05-21'

    },

     {
        'id' : 'I00003',
        'image_url' : 'url',
        'created_at' : '2021-05-21',
        'updated_at' : '2021-05-21'

    }

]

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
