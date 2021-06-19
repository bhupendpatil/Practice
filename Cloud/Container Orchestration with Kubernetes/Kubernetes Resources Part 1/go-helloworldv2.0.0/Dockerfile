FROM golang:alpine
LABEL maintainer="Bhupend Patil"
COPY . /go/src/app
WORKDIR /go/src/app
RUN go mod init
RUN go build -o main
EXPOSE 6112
CMD ["./main"]