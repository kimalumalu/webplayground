FROM debian:jessie
RUN echo 'deb http://deb.debian.org/debian jessie-backports main' > /etc/apt/sources.list.d/backports.list
#copying all required project files
COPY . /var/www/html/
RUN cp /var/www/html/.env.example /var/www/html/.env

#installing php and dependencies
RUN apt-get update && \
    apt-get install php5 php5-common php5-cgi php5-cli php5-curl php5-json php5-gd php5-mysql php5-xmlrpc php5-mcrypt curl git -y

#installing composer
RUN curl -s https://getcomposer.org/installer | php -- --install-dir=/usr/local/bin --filename=composer

#expose port
EXPOSE 8000

#configure and launch laravel
WORKDIR /var/www/html
RUN composer install &&\
    php artisan key:generate &&\
    php artisan config:clear

ENTRYPOINT ["php", "artisan", "serve", "--host=0.0.0.0"]




