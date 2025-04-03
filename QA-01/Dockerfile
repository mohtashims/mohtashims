FROM nginx:1.19-alpine

RUN apk update && apk upgrade --no-cache

#RUN apk add --no-cache tini-0.19.0-r3
RUN apk add --no-cache tini=0.19.0-r0 && tini --version && which tini && \
    chmod +x /sbin/tini



#RUN addgroup -S newnginx || true && getent passwd newnginx || adduser -S newnginx -G newnginx
RUN getent group newnginx || addgroup -S -g 1003 newnginx; getent passwd newnginx || adduser -S -u 1003 -G newnginx newnginx

# This adds the capability to bind to low ports (ports below 1024)
RUN apk add --no-cache libcap && setcap 'cap_net_bind_service=+ep' /usr/sbin/nginx




RUN mkdir -p  /var/log/nginx /var/cache/nginx/proxy_temp /var/cache/nginx/client_temp /usr/share/nginx/html && \
    chown -R newnginx:newnginx  /var/log/nginx /var/cache/nginx /usr/share/nginx

RUN echo "<html><body><h1>Hello from Nginx!</h1></body></html>" > /usr/share/nginx/html/index.html


RUN chmod 775 /usr/share/nginx/html/index.html



RUN sed -i -e '/^user /d' -e 's/^pid /# pid /g' /etc/nginx/nginx.conf



USER newnginx

EXPOSE 80
EXPOSE 443

ENTRYPOINT ["/sbin/tini", "--"]

CMD ["nginx", "-g", "pid /tmp/nginx.pid; daemon off;"]
