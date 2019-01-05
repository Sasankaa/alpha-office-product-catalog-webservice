# alpha-office-product-catalog-webservice
Alpha Office Catalog Webservice 

####  To test this webservice using Netbeans Environment.

1. Clone this repository into your local drive.

2. Open this project as a Netbeans project.

3. Change your ATP database instance property file according to your instance configurations.

4. Test this project using Postman.

5. GET all product catalogs

![alt text](https://github.com/Sasankaa/Misc/blob/master/get_all.png)

6. GET specific product catalogs

![alt text](https://github.com/Sasankaa/Misc/blob/master/get.png)

7. POST operation for product catalogs

![alt text](https://github.com/Sasankaa/Misc/blob/master/post.png)

####  To test this webservice without using Netbeans Environment.

1. Download war file

2. Unzip war file and change dbconfig.properties file according to your ATP instance configurations.

  jar -cvf AlphaProductsRestService.war *  

3. Zip war file again to test war file and host in Docker/Weblogic environment.

  jar -xvf AlphaProductsRestService.war  

4. Use Postman again to test this webservice
