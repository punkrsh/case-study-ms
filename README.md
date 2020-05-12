# case-study-ms

#############################
######## Case Study #########
#############################

#### Authenticate MS:
POST: http://34.76.8.126:8080/authenticate
'Content-Type: application/json'

{
"username": "puneet",
"password": "dummy"
}

curl -X POST -H 'Content-Type: application/json' -i 'http://34.76.8.126:8080/authenticate' --data '{
"username": "puneet",
"password": "dummy"
}'


#### Order MS:
###Generate Order Token
GET: http://146.148.6.160:8080/order/users/{username}

curl -X GET -H 'Authorization: Bearer eyJhbGciOiJIUzUxMiJ9.eyJzdWIiOiJwdW5lZXQiLCJleHAiOjE1ODk3OTExNDgsImlhdCI6MTU4OTE4NjM0OH0.5mBz_iWZIx4UA_aXo8HzeG4bxY7N-YmRZfGQDNrXmqnnoeT9RQKxUDiStDbxhMMTjldUISPHh9GhO9gz2_Ht4w' -i 'http://146.148.6.160:8080/order/users/puneet'


###Create Order
POST: http://146.148.6.160:8080/order/users/{username}
'Authorization: Bearer eyJhbGciOiJIUzUxMiJ9.eyJzdWIiOiJwdW5lZXQiLCJleHAiOjE1ODk4MTA5OTIsImlhdCI6MTU4OTIwNjE5Mn0.nRWDG7A39DrpRcu-m5HLfaRsmw9CxVJhlgCNJSm6gIZO07t1v--0p9ylswIJrl9RYsd6tMqNF743IASJe88n1w'
'Content-Type: application/json'
{
  "id": 4,
  "username": "puneet",
  "orderToken": "SRASR6TYP712Y1CBPICEZ0U6RZA",
  "orderdesc": "OrderName"
}

curl -X POST -H 'Authorization: Bearer eyJhbGciOiJIUzUxMiJ9.eyJzdWIiOiJwdW5lZXQiLCJleHAiOjE1ODk4MTA5OTIsImlhdCI6MTU4OTIwNjE5Mn0.nRWDG7A39DrpRcu-m5HLfaRsmw9CxVJhlgCNJSm6gIZO07t1v--0p9ylswIJrl9RYsd6tMqNF743IASJe88n1w' -H 'Content-Type: application/json' -i 'http://146.148.6.160:8080/order/users/puneet' --data '{
  "id": 4,
  "username": "puneet",
  "orderToken": "SRASR6TYP712Y1CBPICEZ0U6RZA",
  "orderdesc": "OrderName"
}'
