docker stop $(docker ps -aq)

pwd

docker-compose -f cursinho-dev.yaml up --build
