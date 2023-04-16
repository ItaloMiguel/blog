start-dev:
	@./utils/run-dev.sh

run_application_with-h2:
	@./utils/run-h2.sh

stop:
	@./utils/stop.sh

chmod:
	@chmod +x utils/*.sh
