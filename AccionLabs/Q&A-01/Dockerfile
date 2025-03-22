FROM nginx:1.19-alpine

RUN apk add --no-cache tini

RUN addgroup -S newnginx || true && getent passwd newnginx || adduser -S newnginx -G newnginx

USER newnginx

EXPOSE 443

 COPY securenginx.conf /etc/nginx/nginx.conf
ENTRYPOINT ["/sbin/tini", "--"]

CMD ["nginx", "-g", "daemon off;"]
