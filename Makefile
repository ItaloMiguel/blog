RUN_DOCKERFILE = bash dockerfile/

start-dev:
	@bash scripts/run-dev.sh

psql-dev:
	@bash scripts/psql-dev.sh


start-prod:
	@echo "In production... ;)"

build-dev:
	@docker build dockerfile/nginx/
	@docker build dockerfile/web/

run_application_with-h2:
	@bash scripts/run-h2.sh

stop:
	@bash scripts/stop.sh

chmod:
	@chmod +x scripts/*.sh

help:
	@echo ""
	@echo "Usage: make [COMMAND]"
	@echo ""
	@echo "Command:"
	@echo "	chmod	 	Will give execute permission for .sh. Theses files are inside 'scripts/' folder"
	@echo "	stop		Stop all docker-compose. Be careful."
	@echo "	start-dev 	Start project with profile dev."
	@echo ""
	@echo " psql-dev	Connect to postgres. Password: root"
	@echo "	build 		Build all dockerfile (nginx, spring-boot)... Don't working, sorry."
	@echo ""
	@echo "Thanks for running the project, I appreciate it, hope to see you again :)"
