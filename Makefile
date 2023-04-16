RUN_DOCKERFILE = bash dockerfile/

start-dev:
	@bash utils/run-dev.sh

start-prod:
	@echo "In production... ;)"

build:
	@docker build dockerfile/nginx/
	@docker build dockerfile/web/

run_application_with-h2:
	@bash utils/run-h2.sh

stop:
	@bash utils/stop.sh

chmod:
	@chmod +x utils/*.sh

help:
	@echo ""
	@echo "Usage: make [COMMAND]"
	@echo ""
	@echo "Command:"
	@echo "	chmod	 	Will give execute permission for .sh. Theses files are inside utils/ folder"
	@echo "	stop		Stop all docker-compose. Be careful."
	@echo "	start-dev 	Start project with profile dev."
	@echo "	build 		Build all dockerfile (nginx, spring-boot)... Don't working, sorry."
	@echo ""
	@echo "Thanks for running the project, I appreciate it, hope to see you again :)"
