# redis-example

Application demonstrating caching with Redis. Spring + Postgres

# Run Redis with Docker

docker run -p 16379:6379 -d redis:6.0 redis-server --requirepass "mypass"
# Application
Application endpoints: \
add student: POST http://localhost:8080/students \
payload: {"name":"", "avgScore":1.0} 

get students: GET http://localhost:8080/students

