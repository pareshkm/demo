This is a Spring Boot Application.
This application can be started locally by running DemoApplication.java as a Java Application.

For the HTTP GET requests, the valid product IDs are the ones that are given in the Case Study document, 
which are 15117729, 16483589, 16696652, 16752456, 15643793 and 13860428.
So basically the below URLs are supposed to yield the desired output.
http://localhost:8080/products/15117729
http://localhost:8080/products/16483589
http://localhost:8080/products/16696652
http://localhost:8080/products/16752456
http://localhost:8080/products/15643793
http://localhost:8080/products/13860428


The data for the above example IDs are loaded into H2 embedded database on the application load.
So the above GET URLs are supposed to work right out of the box.

To retrieve the product name, this application makes the Rest call to the below URL:
http://redsky.target.com/v1/pdp/tcin/13860428?excludes=taxonomy,price,promotion,bulk_ship,rating_and_review_reviews,rating_and_review_statistics,question_answer_statistics

However, as the above URL didn't work for any other example product IDs except for 13860428, so the product ID# 13860428 is hard-coded when making this Rest call.
What that means is, for all the above HTTP GET calls, it will retrieve the product name for the product ID# 13860428, 
however other things like ID, Currency etc are dynamic and displayed as per the product ID supplied.

This application uses H2 embedded database.