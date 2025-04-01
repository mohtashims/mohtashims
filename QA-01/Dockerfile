FROM nginx:1.26.3-alpine

#RUN wget -O /usr/local/bin/tini https://github.com/krallin/tini/releases/latest/download/tini && \
#RUN wget -O /usr/local/bin/tini https://github.com/krallin/tini/releases/download/v0.19.0/tini && \
RUN wget -O /tmp/tini https://github.com/krallin/tini/releases/download/v0.19.0/tini && \
    chmod +x /tmp/tini
    #chmod +x /usr/local/bin/tini

#RUN apk add --no-cache tini-0.19.0-r3

RUN apk update && apk upgrade --no-cache

RUN addgroup -S newnginx || true && getent passwd newnginx || adduser -S newnginx -G newnginx

USER newnginx

EXPOSE 443

#ENTRYPOINT ["/sbin/tini", "--"]
ENTRYPOINT ["/tmp/tini", "--"]

CMD ["nginx", "-g", "daemon off;"]
