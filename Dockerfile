FROM node:21-slim
LABEL authors="Gabriel Braz"

RUN apt update && apt install -y openssl procps

RUN npm install -g @nestjs/cli@10.3.2

WORKDIR /home/node/app

USER node

CMD tail -f /dev/null