APP=$(shell basename $(shell git remote get-url origin))
REGISTRY=teslascat
VERSION=$(shell git describe --tags --abbrev=0)-$(shell git rev-parse --short HEAD)
TARGET_OS=linux
TARGET_ARCH=arm64

format:
	gofmt -s -w ./

lint:
	golint

test:
	go test -v

get:
	go get

build: format get
	CGO_ENABLED=0 GOOS=${TARGET_OS} GOARCH=${TARGET_ARCH} go build -v -o kbot -ldflags "-X="github.com/daria-hrebonkina/kbot/cmd.appVersion=${VERSION}

image:
	docker build . -t ${REGISTRY}/${APP}:${VERSION}-${TARGET_ARCH}

push:
	docker push ${REGISTRY}/${APP}:${VERSION}-${TARGET_ARCH}

clean:
	rm -rf kbot