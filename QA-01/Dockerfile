#FROM nginx:1.26.3-alpine
FROM nginx:1.19-alpine

#RUN wget -O /usr/local/bin/tini https://github.com/krallin/tini/releases/latest/download/tini && \
#RUN wget -O /usr/local/bin/tini https://github.com/krallin/tini/releases/download/v0.19.0/tini && \
#RUN wget -O /usr/local/bin/tini https://github.com/krallin/tini/releases/download/v0.19.0/tini && \
#    chmod +x /usr/local/bin/tini && \
#    ls -ltr /usr/local/bin/tini && \
#    ldd /usr/local/bin/tini
#    #chmod +x /usr/local/bin/tini

RUN apk update && apk upgrade --no-cache

#RUN apk add --no-cache tini-0.19.0-r3
RUN apk add --no-cache tini=0.19.0-r0 && tini --version && which tini && \
    chmod +x /sbin/tini


#RUN apk add --no-cache tini && tini --version


RUN addgroup -S newnginx || true && getent passwd newnginx || adduser -S newnginx -G newnginx

# This adds the capability to bind to low ports (ports below 1024)
RUN apk add --no-cache libcap && setcap cap_net_bind_service=+ep /usr/sbin/nginx

USER newnginx

EXPOSE 80
EXPOSE 443

#ENTRYPOINT ["/sbin/tini", "--"]
ENTRYPOINT ["/sbin/tini", "--"]

CMD ["nginx", "-g", "daemon off;"]
