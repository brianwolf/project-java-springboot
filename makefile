VERSION:=local

build b:
	docker build . -t docker.io/brianwolf/java-springboot:$(VERSION)

push p:
	docker push docker.io/brianwolf/java-springboot:$(VERSION)

run r:
	docker run -it --rm -p 8080:8080 docker.io/brianwolf/java-springboot:$(VERSION)

sonar:
	docker run -it --rm -v $(shell pwd):/usr/src sonarsource/sonar-scanner-cli \
		sonar-scanner \
			-Dsonar.projectKey=java-springboot \
			-Dsonar.sources=. \
			-Dsonar.host.url=https://sonar.lobo.theworkpc.com/ \
			-Dsonar.token=sqa_3b62f9eb881fcb6cbfff0f86571c9af010326534 \
			-Dsonar.java.binaries=target/*
