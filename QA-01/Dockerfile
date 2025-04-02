FROM nginx:1.19-alpine

RUN apk update && apk upgrade --no-cache

#RUN apk add --no-cache tini-0.19.0-r3
RUN apk add --no-cache tini=0.19.0-r0 && tini --version && which tini && \
    chmod +x /sbin/tini



RUN addgroup -S newnginx || true && getent passwd newnginx || adduser -S newnginx -G newnginx

# This adds the capability to bind to low ports (ports below 1024)
#RUN apk add --no-cache libcap && setcap cap_net_bind_service=+ep /usr/sbin/nginx

RUN mkdir -p  /var/log/nginx /var/cache/nginx/proxy_temp /var/cache/nginx/client_temp && \
    chown -R newnginx:newnginx  /var/log/nginx /var/cache/nginx



RUN sed -i 's/^pid /# pid /g' /etc/nginx/nginx.conf


USER newnginx

EXPOSE 80
EXPOSE 443

ENTRYPOINT ["/sbin/tini", "--"]

CMD ["nginx", "-g", "pid /tmp/nginx.pid; daemon off;"]
