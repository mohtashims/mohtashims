FROM nginx:1.19-alpine

RUN apk add --no-cache tini=0.19.0-r0

RUN addgroup -S newnginx || true && getent passwd newnginx || adduser -S newnginx -G newnginx

USER newnginx

EXPOSE 443

ENTRYPOINT ["/sbin/tini", "--"]

CMD ["nginx", "-g", "daemon off;"]
