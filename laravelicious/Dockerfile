FROM debian:jessie
RUN echo 'deb http://deb.debian.org/debian jessie-backports main' > /etc/apt/sources.list.d/backports.list
#copying all required project files
COPY . /var/www/html/
WORKDIR /var/www/html

#installing LAMP
RUN apt-get update && \
    #apt-get install apache2 -y  && \
    #apt-get install mysql-client -y && \
    apt-get install php5 php5-common php5-cgi php5-cli php5-curl php5-json php5-gd php5-mysql php5-xmlrpc php5-mcrypt curl git -y

#installing composer
RUN curl -sS https://getcomposer.org/installer | php -- --install-dir=/usr/local/bin --filename=composer

#run composer
RUN cd /var/www/html &&\
    composer install &&\
    php artisan key:generate &&\
    php artisan config:clear

#start application
CMD php artisan serve --host=0.0.0.0      


