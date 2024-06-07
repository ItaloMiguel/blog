# Use a imagem oficial do Nginx como base
FROM nginx:latest

# Copie o arquivo de configuração principal para o contêiner
COPY nginx.conf /etc/nginx/nginx.conf

# Copie o arquivo de configuração do servidor virtual para o contêiner
COPY default.conf /etc/nginx/conf.d/default.conf

# Expor a porta 80 para acesso externo
EXPOSE 80
