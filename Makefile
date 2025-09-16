# Phony targets
.PHONY: all build check clean teamcity-check

# Default target
all: build

# Target: dummy
build:
	@echo "make build"

# Target: dummy
check:
	@echo "make check"

# Target: dummy
clean:
	@echo "make clean"

teamcity-check:
	cd .teamcity && mvn teamcity-configs:generate
